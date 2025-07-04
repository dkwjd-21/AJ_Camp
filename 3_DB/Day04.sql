-- SUBQUERY -- 
-- 메인 쿼리 안에 또 다른 쿼리를 추가하는 작업 

-- EX) 최소 급여 받는 사원의 정보 조회

-- 최소 급여 확인
SELECT MIN(SALARY)
FROM EMPLOYEE;
-- 1380000

-- 사원 정보 조회
SELECT *
FROM EMPLOYEE
WHERE SALARY = 1380000;

-- 단일형 서브쿼리 : 결과값 1개 
SELECT * 
FROM EMPLOYEE
WHERE SALARY = (SELECT MIN(SALARY) FROM EMPLOYEE);

-- 다중행 서브쿼리 : 결과값 여러 개
-- EX) 각 직급별 최소 급여 받는 사람
SELECT MIN(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE;

SELECT *
FROM EMPLOYEE
WHERE SALARY IN (SELECT MIN(SALARY)
				FROM EMPLOYEE
				GROUP BY JOB_CODE);

-- 다중행 다중열 서브쿼리

SELECT JOB_CODE, MIN(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE;

SELECT *
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (SELECT JOB_CODE, MIN(SALARY)
							 FROM EMPLOYEE
							 GROUP BY JOB_CODE);
							
-- 서브쿼리 사용 위치
-- SELECT, FROM, WHERE, GROUP BY, HAVING, ORDER BY, JOIN 
-- DML : INSERT, UPDATE, DELETE 
-- DDL : CREATE TABLE, CREATE VIEW

-- FROM 위치에 사용되는 서브쿼리 
-- 인라인뷰 (INLINE VIEW)
-- 테이블 명으로 직접 조회하는 대신 서브쿼리의 결과(RESULT SET)를 활용해 조회

SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
JOIN JOB USING(JOB_CODE);

SELECT * 
FROM (SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
	  FROM EMPLOYEE
	  JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
	  JOIN JOB USING(JOB_CODE));

--
SELECT ROWNUM, EMP_NAME, SALARY
FROM EMPLOYEE;

SELECT ROWNUM, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE ROWNUM < 6;

-- 급여 기준으로 가장 높은 급여를 받는 사람 
-- 상위 5명 조회
-- 사번, 사원명, 급여
SELECT ROWNUM, A.*
FROM (SELECT EMP_ID, EMP_NAME, SALARY
	  FROM EMPLOYEE 
	  ORDER BY SALARY DESC) A
WHERE ROWNUM < 6;

-- 급여 평균 상위 3개 부서 조회
SELECT AVG(SALARY)
FROM EMPLOYEE 
GROUP BY DEPT_CODE
ORDER BY AVG(SALARY) DESC;

SELECT ROWNUM "NO", A.*
FROM (SELECT DEPT_CODE 부서코드, DEPT_TITLE 부서명, TRUNC(AVG(SALARY), -3) "평균"
	  FROM EMPLOYEE 
	  JOIN DEPARTMENT ON(DEPT_CODE=DEPT_ID)
	  GROUP BY DEPT_CODE, DEPT_TITLE
	  ORDER BY AVG(SALARY) DESC ) A
WHERE ROWNUM < 4;

-- RANK() 함수, DENSE_RANK() 함수
-- RANK() : 동일 순번 있을 경우 이후 순번에 영향 O
-- 1
-- 2
-- 2
-- 4 
SELECT EMP_NAME, SALARY,
	   RANK() OVER(ORDER BY SALARY DESC) 순위
FROM EMPLOYEE;	 

SELECT *
FROM (SELECT EMP_NAME, SALARY,
	   DENSE_RANK() OVER(ORDER BY SALARY DESC) 순위
	   FROM EMPLOYEE)
WHERE 순위 < 4;	  

-- DENSE_RANK() : 동일 순번이 있을 경우 이후 순번에 영향x 
-- 1
-- 2
-- 2
-- 3 

-- 문제 1
-- 부서별 급여 합계가 전체 부서 급여 총합의 20% 보다 많이 받는 부서의
-- 부서명, 부서급여합계 조회
-- HINT : HAVING, 전체급여 합계의 20% 조회하는 서브쿼리 
SELECT DEPT_TITLE, SUM(SALARY) "부서급여합계"
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) > (SELECT SUM(SALARY)*0.2
					  FROM EMPLOYEE);

SELECT SUM(SALARY)*0.2
FROM EMPLOYEE;

-- 2) 
-- 인라인뷰 
SELECT *
FROM (
		SELECT DEPT_TITLE, SUM(SALARY) "부서급여합계"
		FROM EMPLOYEE
		JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
		GROUP BY DEPT_TITLE
		ORDER BY 2 DESC
	  ) D
WHERE D.부서급여합계 > (SELECT SUM(SALARY)*0.2
						 FROM EMPLOYEE); 	  

-- 상호연관쿼리 (상관쿼리)
-- 메인쿼리의 컬럼을 서브쿼리에서도 적용하여 사용하는 서브쿼리 
-- 사원의 직급에 따른 급여 평균보다 많이 받는 사원의 정보를 조회
SELECT JOB_CODE, AVG(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE;

SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE E1
WHERE SALARY > (
					SELECT AVG(SALARY)
					FROM EMPLOYEE E2
					WHERE E1.JOB_CODE = E2.JOB_CODE
				);

-- 모든 사원의 사번, 사원명, 관리자 사번, 관리자명을 조회
-- 단, 관리자가 없을 경우 '없음'이라고 표시
SELECT EMP_ID, 
	   EMP_NAME, 
	   MANAGER_ID, 
	   NVL( (SELECT EMP_NAME FROM EMPLOYEE E2 WHERE E1.MANAGER_ID = E2.EMP_ID), "없음") "관리자 이름"
FROM EMPLOYEE E1;

-- 자신이 속한 직급의 평균 급여보다 많이 받는 사원
-- 이름, 직급명, 급여정보 조회 
SELECT EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE E1
JOIN JOB J ON(E1.JOB_CODE = J.JOB_CODE)
WHERE SALARY > (
				SELECT AVG(SALARY)
				FROM EMPLOYEE E2
				WHERE E1.JOB_CODE = E2.JOB_CODE
				);

-- DDL - CREATE --
/*
 * CREATE : 데이터베이스에서 객체를 생성하는 DDL
 * 
 * CREATE 객체 종류 객체명 (생성시 관련내용) 
 * 
 * -- 계정만든다
 * CREATE USER MULTI ...
 * 
 * -- 테이블만든다
 * CREEATE TABLE TEST ...
 *
 * CREATE TABLE 테이블명 (
 * 		테이블에 데이터를 저장하고자 할 때 지켜야할 규칙, 제약 
 * )
 * 
 * [제약조건] 테이블에 데이터를 저장하고자 할 때 지켜야할 규칙 
 * - NOT NULL	: NULL 값 허용하지 않는다. (필수 입력 사항)
 * - UNIQUE 	: 중복값 허용하지 않는다.
 * - CHECK		: 지정한 입력값 외에는 저장하지 못하게 막는 조건 
 * - PRIMARY KEY : (NOT NULL + UNIQUE) 기본 키
 * 					테이블 내에서 행을(데이터, 로우)를 구분할 수 있는 고유값
 * 					테이블에서 하나의 컬럼에만 선언 가능.
 * - FOREIGN KEY : 외래 키 
 * 					다른 테이블에서 저장된 값을 연결지어 참조로 가져오는 데이터에 지정하는 제약조건 
 *  
 * */

-- 테이블 생성 
CREATE TABLE MEMBER(
	MEMBER_NO NUMBER,
	MEBER_ID VARCHAR2(20),
	MEMBER_PWD VARCHAR2(20),
	MEMBER_NAME VARCHAR2(20)
);

SELECT * FROM MEMBER;

-- 현재 접속한 사용자(USER, 계정)이 보유한 테이블 목록
-- 데이터 사전
SELECT * FROM USER_TABLES;

SELECT * FROM USER_TAB_COLUMNS
WHERE TABLE_NAME = 'MEMBER';

SELECT * FROM USER_CONSTRAINTS;

-- 제약조건(CONSTRAINTS) --
-- 테이블 생성시 각 컬럼에 값을 저장하는 것에 대한 제약사항을 설정할 때 사용하는 조건들
-- 데이터 묵결성(데이터가 정확하고, 일관되고, 유효하다) 보장 

-- NOT NULL
-- '널 값을 허용하지 않는다'
-- 반드시 값을 저장해야 하는 컬럼인 경우 제약조건 추가

CREATE TABLE USER_NONCONS(
	NO NUMBER,
	ID VARCHAR(20),
	PW VARCHAR(20),
	NAME VARCHAR2(20),
	GENDER VARCHAR(3)
);

SELECT * FROM USER_NONCONS;

-- 테이블에 값 추가, DML에서 INSERT 
INSERT INTO USER_NONCONS(NO, ID, PW, NAME, GENDER)
VALUES(1, 'USER01', 'PASS01', '홍길동', 'SKA');

-- 데이터 추가 후 조회
SELECT * FROM USER_NONCONS;

INSERT INTO USER_NONCONS
VALUES(2, NULL, NULL, NULL, '여');

-- NOT NULL 제약조건 추가하여 확인
CREATE TABLE USER_NOT_NULL(
	NO NUMBER NOT NULL, 
	ID VARCHAR(20) NOT NULL,
	PW VARCHAR(20) NOT NULL,
	NAME VARCHAR2(20) NOT NULL,
	GENDER VARCHAR(3)
);

SELECT * FROM USER_NOT_NULL;

SELECT * 
FROM USER_CONSTRAINTS C1
JOIN USER_CONSTRAINTS C2 ON(C1.CONSTRAINT_NAME = C2.CONSTRAINT_NAME)
WHERE C1.TABLE_NAME = 'USER_NOT_NULL';

-- 데이터 추가
INSERT INTO USER_NOT_NULL
VALUES(1, 'USER1', 'PASS1', '홍길동', '남');

SELECT * FROM USER_NOT_NULL;

-- SQL Error [1400] [23000]: 
-- ORA-01400: NULL을 ("MULTI"."USER_NOT_NULL"."ID") 안에 삽입할 수 없습니다
INSERT INTO USER_NOT_NULL
VALUES(2, NULL, NULL, NULL, '여');

-- SQL Error [1400] [23000]: 
-- ORA-01400: NULL을 ("MULTI"."USER_NOT_NULL"."PW") 안에 삽입할 수 없습니다
INSERT INTO USER_NOT_NULL(NO, ID)
VALUES(3, 'UESR2');

INSERT INTO USER_NOT_NULL
VALUES(4, 'USER4', 'PW1', '홍길동', NULL);

-- UNIQUE 제약조건 
-- 중복값을 허용하지 않는 제약조건 
INSERT INTO USER_NONCONS(NO, ID, PW, NAME, GENDER)
VALUES(1, 'USER01', 'PASS01', '홍길동', '남');

SELECT * FROM USER_NONCONS;

CREATE TABLE USER_UNIQUE(
	NO NUMBER,
	ID VARCHAR2(20) UNIQUE,
	PW VARCHAR2(20),
	NAME VARCHAR2(20),
	GENDER VARCHAR2(3)
);

INSERT INTO USER_UNIQUE
VALUES(1, 'USER01', 'PASS01', '홍길동', '여');

SELECT * FROM USER_UNIQUE;

-- SQL Error [1] [23000]: ORA-00001: 무결성 제약 조건(MULTI.SYS_C007529)에 위배됩니다
INSERT INTO USER_UNIQUE
VALUES(1, 'USER01', 'PASS01', '홍길동', '남');

SELECT * 
FROM USER_CONSTRAINTS C1
JOIN USER_CONSTRAINTS C2 ON(C1.CONSTRAINT_NAME = C2.CONSTRAINT_NAME)
WHERE C1.TABLE_NAME = 'USER_UNIQUE';

-- CONSTRAINT-TYPE
-- P : PRIMARY KEY
-- F : FOREIGN KEY
-- U : UNIQUE
-- C : CHECK(NOT NULL)

-- 객체 삭제 (DROP)
DROP TABLE USER_UNIQUE;

-- 테이블 레벨에서 제약조건 설정
-- 컬럼이 모두 작성된 후 별도로 제약조건들을 작성 
CREATE TABLE USER_UNIQUE(
	NO NUMBER,
	ID VARCHAR2(20),
	PW VARCHAR2(20),
	NAME VARCHAR2(20),
	GENDER VARCHAR2(3),
	UNIQUE(ID)
);

-- UNIQUE 제약조건 여러개 컬럼에 적용 
-- 두 개 이상의 컬럼을 제약조건으로 묶어 적용, 반드시 테이블레벨에서 조건 선언 
-- NO	ID 
-- 1	U1
-- 1 	U2
-- 2 	U1

DROP TABLE USER_UNIQUE;

CREATE TABLE USER_UNIQUE(
	NO NUMBER,
	ID VARCHAR2(20),
	PW VARCHAR2(30),
	NAME VARCHAR2(30),
	UNIQUE(NO, ID)
);

SELECT * FROM USER_UNIQUE;

INSERT INTO USER_UNIQUE VALUES(1, 'U01', 'P01', 'LEE');
INSERT INTO USER_UNIQUE VALUES(1, 'U02', 'P02', 'LEE');
INSERT INTO USER_UNIQUE VALUES(2, 'U01', 'P03', 'PARK');

-- SQL Error [1] [23000]: ORA-00001: 무결성 제약 조건(MULTI.SYS_C007531)에 위배됩니다
INSERT INTO USER_UNIQUE VALUES(2, 'U01', 'P03', 'CHOI');

-- 제약조건 이름 설정하기
CREATE TABLE CONS_NAME(
	DATA1 NUMBER CONSTRAINT NN_CONSNAME_DATA1 NOT NULL,
	DATA2 NUMBER CONSTRAINT U_CONSNAME_DATA2 UNIQUE,
	DATA3 NUMBER,
	CONSTRAINT U_CONSNAME_DATA3 UNIQUE(DATA3)
);

-- CHECK 제약조건
-- 컬럼에 값을 저장할 때 지정한 값 이외에는 값이 기록되지 않게 범위를 제한하는 조건 
-- CHECK(컬럼명 비교연산자 값)
-- CHECK(GENDER IN ('남', '여'))
-- CHECK(USER_ID IS NOT NULL)

CREATE TABLE USER_CHECK(
	NO NUMBER,
	ID VARCHAR2(20),
	PW VARCHAR2(20),
	NAME VARCHAR2(20),
	GENDER CHAR(3) CHECK(GENDER IN ('남', '여'))
);

INSERT INTO USER_CHECK VALUES(1, 'USER01', 'PASS01', '홍길동', '여');

-- SQL Error [12899] [72000]: ORA-12899: 
-- "MULTI"."USER_CHECK"."GENDER" 열에 대한 값이 너무 큼(실제: 6, 최대값: 3)
INSERT INTO USER_CHECK VALUES(1, 'USER01', 'PASS01', '홍길동', '남자');

-- SQL Error [2290] [23000]: ORA-02290: 체크 제약조건(MULTI.SYS_C007532)이 위배되었습니다
INSERT INTO USER_CHECK VALUES(1, 'USER01', 'PASS01', '홍길동', 'M');
INSERT INTO USER_CHECK VALUES(1, 'USER01', 'PASS01', '홍길동', '남');

-- CHECK 제약조건 부등호활용
CREATE TABLE USER_CHECK2(
	DATA NUMBER,
	CONSTRAINT CK_USER_DATE CHECK(DATA>0)
);

INSERT INTO USER_CHECK2 VALUES(10);

SELECT * FROM USER_CHECK2;

-- SQL Error [2290] [23000]: ORA-02290: 체크 제약조건(MULTI.CK_USER_DATE)이 위배되었습니다
INSERT INTO USER_CHECK2 VALUES(-10);

CREATE TABLE USER_CHECK3(
	PRICE NUMBER,
	U_DATE DATE,
	QUAL CHAR(1),
	CONSTRAINT CK_PRICE CHECK(PRICE BETWEEN 1 AND 99999),
	CONSTRAINT CK_UDATE CHECK(U_DATE>= TO_DATE('2020/01/01', 'YYYY/MM/DD')),
--	CONSTRAINT CK_QUAL CHECK(QUAL IN ('A', 'B', 'C', 'D'))
	CONSTRAINT CK_QUAL CHECK(QUAL >= 'A' AND QUAL m= 'D')
);

-- 하나의 컬럼에 NOT NULL, UNIQUE 제약 조건 둘다 설정하고 싶다. 
CREATE TABLE TEST_CONS(
	DATA NUMBER NOT NULL UNIQUE,
	CONSTRAINT CK CHECK(DATA > 0)
);

-- PRIMARY KEY 제약조건
-- 기본키 제약조건
-- 테이블 내의 행을 식별하기 위해 고유값을 가지는 컬럼에 설정하는 제약조건
-- NOT NULL + UNIQUE 
-- 해당 컬럼에는 반드시 값이 들어가고, 중복이 X
-- 기본키제약조건은 테이블에 하나만 설정 할 수 있다. 
-- 한 컬럼에도 적용 가는ㅇ하고, 여러 컬럼을 묶어서 적용도 가능하다 

CREATE TABLE USER_PK_TABLE(
	NO NUMBER CONSTRAINT PK_USER_NO PRIMARY KEY,
	ID VARCHAR2(30) UNIQUE NOT NULL, 
	PW VARCHAR2(30) NOT NULL, 
	NAME VARCHAR2(30) NOT NULL,
	GENDER CHAR(3) CHECK(GENDER IN ('남', '여'))
);

SELECT * FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'USER_PK_TABLE';

SELECT * FROM USER_PK_TABLE;

INSERT INTO USER_PK_TABLE
VALUES(1, 'USER01', 'PASS01', '홍길동', '여');

INSERT INTO USER_PK_TABLE 
VALUES(2, 'USER02', 'PASS02', '김길동', '남');

-- 유니크 제약조건 위배
-- SQL Error [1] [23000]: ORA-00001: 무결성 제약 조건(MULTI.PK_USER_NO)에 위배됩니다
INSERT INTO USER_PK_TABLE
VALUES(1, 'USER03', 'PAASS03', '박길동', '남');

-- NOT NULL 제약조건 위배 
-- SQL Error [1400] [23000]: ORA-01400: NULL을 ("MULTI"."USER_PK_TABLE"."NO") 안에 삽입할 수 없습니다
INSERT INTO USER_PK_TABLE
VALUES(NULL, 'USER03', 'PAASS03', '박길동', '남');

-- 기본기 제약조건을 여러 컬럼에 적용하기 
-- 1 USER01 -> 성공
-- 2 USER02 -> 성공
-- 1 USER03 -> 성공
-- 2 USER01 -> 성공 

DROP TABLE USER_PK_TABLE;

CREATE TABLE USER_PK_TABLE(
	NO NUMBER,
	ID VARCHAR2(30) UNIQUE NOT NULL, 
	PW VARCHAR2(30) NOT NULL, 
	NAME VARCHAR2(30) NOT NULL,
	GENDER CHAR(3) CHECK(GENDER IN ('남', '여')),
	CONSTRAINT PK_USER PRIMARY KEY(NO, ID)
);

INSERT INTO USER_PK_TABLE
VALUES(1, 'USER01', 'PASS01', '홍길동', '남');

INSERT INTO USER_PK_TABLE
VALUES(2, 'USER02', 'PASS01', '김길동', '남');

SELECT * FROM USER_PK_TABLE;

-- UNIQUE 제약조건 위배 
-- SQL Error [1] [23000]: ORA-00001: 무결성 제약 조건(MULTI.SYS_C007548)에 위배됩니다
INSERT INTO USER_PK_TABLE
VALUES(1, 'USER02', 'PASS01', '최길동', '남');
-- PK로는 문제없는 데이터 INSERT 이지만
-- ID 컬럼에 단독으로 UNIQUE 제약조건이 설정되어 있어 USER02 아이디가 중복 

INSERT INTO USER_PK_TABLE
VALUES(1, 'USER03', 'PASS01', '최길동', '남');

-- 문제 2
-- MEMBER 테이블 생성
-- 사용자 정보를 저장하는 테이블 MEMEBER를 생성하는데
-- 회원번호는 NUMBER 타입으로 기본키 설정,
-- 회원아이디는 중복불가, 필수입력사항으로 설정 ,
-- 회원비밀번호는 필수입력사항으로 설정,
-- 회원 이름,
-- 성별 ('F', 'M'),
-- 회원 전화번호, 생년월일 
-- 을 저장할 수 있는 컬럼을 가진 테이블 생성하기. 
-- 타입, 컬럼명, 크기는 직접 판단.
-- 회원 정보 5개 이상 INSERT 후 SELECT로 확인

DROP TABLE MEMBER;
CREATE TABLE MEMBER(
	NO NUMBER CONSTRAINT USER_KEY PRIMARY KEY,
	ID VARCHAR2(20) UNIQUE NOT NULL,
	PW VARCHAR2(20) NOT NULL,
	NAME VARCHAR2(20),
	GENDER CHAR(3) CHECK(GENDER IN ('F', 'M')),
	TEL VARCHAR2(30),
	BDAY DATE 
);

INSERT INTO MEMBER 
VALUES(1, 'USER01', 'PASS01', '최유리', 'F', '010-1234-1234', '2002/11/29');
INSERT INTO MEMBER 
VALUES(2, 'USER02', 'PASS02', '이유리', 'F', '010-1234-1234', '2003/11/29');
INSERT INTO MEMBER 
VALUES(3, 'USER03', 'PASS03', '강유리', 'M', '010-1234-1234', '2004/11/29');
INSERT INTO MEMBER 
VALUES(4, 'USER04', 'PASS04', '박유리', 'M', '010-1234-1234', '2005/11/29');
INSERT INTO MEMBER 
VALUES(5, 'USER05', 'PASS05', '김유리', 'F', '010-1234-1234', '2006/11/29');


SELECT * FROM MEMBER;

-- FOREIGN KEY 
-- 외래키, 외부키, 참조키
-- 다른 테이블의 컬럼값을 참조 (REFERENCE),
-- FOREIGN KEY 제약조건을 통해 다른 테이블과의 
-- 관계(RELATIONSHIP)가 형성된다.
-- 참조하는 테이블의 값만 허용한다. 

-- 컬럼레벨
-- [CONSTRAINT 제약조건명] REFERENCES 참조할 테이블명[(참조할 컬럼)] [삭제옵션]

-- 테이블레벨 
-- [CONSTRAINT 제약조건명] FOREIGN KEY(적용할 컬럼) REFERENCES 참조할테이블명[(참조할컬럼)] [삭제옵션]
 
CREATE TABLE USER_GRADE(
	GRADE_CODE NUMBER PRIMARY KEY,
	GRADE_NAME VARCHAR2(20) NOT NULL
);

INSERT INTO USER_GRADE VALUES(1, '일반 회원');
INSERT INTO USER_GRADE VALUES(2, '우수 회원');
INSERT INTO USER_GRADE VALUES(3, 'VIP');
INSERT INTO USER_GRADE VALUES(4, 'VVIP');

SELECT * FROM USER_GRADE;

CREATE TABLE USER_FOREIGN_KEY(
	NO NUMBER PRIMARY KEY,
	ID VARCHAR2(20),
	PW VARCHAR2(20),
	NAME VARCHAR2(15),
	GENDER CHAR(1) CHECK(GENDER IN('F', 'M')),
	GRADE_CODE NUMBER,
	CONSTRAINT FK_GRADECODE FOREIGN KEY(GRADE_CODE)
	REFERENCES USER_GRADE(GRADE_CODE)
);

INSERT INTO USER_FOREIGN_KEY 
VALUES(1, '123', '321', '홍길동', 'F', 2);

INSERT INTO USER_FOREIGN_KEY 
VALUES(2, 'ABC', 'ABC1', '박길동', 'F', 4);

INSERT INTO USER_FOREIGN_KEY 
VALUES(3, '456', '456', '최길동', 'F', 1);

INSERT INTO USER_FOREIGN_KEY 
VALUES(4, 'DEF', 'DEF1', '김길동', 'M', 3);

INSERT INTO USER_FOREIGN_KEY 
VALUES(5, 'QWE', 'QWE1', '이길동', 'M',1);

SELECT * FROM USER_FOREIGN_KEY;

-- SQL Error [2291] [23000]: ORA-02291: 무결성 제약조건(MULTI.FK_GRADECODE)이 위배되었습니다- 부모 키가 없습니다
INSERT INTO USER_FOREIGN_KEY 
VALUES(6, '123', '321', '홍길동', 'F', 10);

SELECT * FROM USER_FOREIGN_KEY 
LEFT JOIN USER_GRADE USING(GRADE_CODE);

-- 데이터 삭제
SELECT * FROM USER_FOREIGN_KEY;
SELECT * FROM USER_GRADE;

-- DML : DELETE 
-- SQL Error [2292] [23000]: ORA-02292: 
-- 무결성 제약조건(MULTI.FK_GRADECODE)이 위배되었습니다- 자식 레코드가 발견되었습니다
DELETE FROM USER_GRADE
WHERE GRADE_CODE = 4;
-- 참조해서 쓰고 있기 때문에 바로 삭제할 수 없음 

-- 삭제옵션
-- 참조당하고 있는 원본 테이블의 컬럼 삭제 될 떄
-- 참조한 값을 어떻게 처리할 것인지 설정하는 옵션
DROP TABLE USER_FOREIGN_KEY;

-- 1. 부모 컬럼이 삭제될 때 자식을 NULL로 변경하기
-- ON DELETE SET NULL 
CREATE TABLE USER_FOREIGN_KEY(
	NO NUMBER PRIMARY KEY,
	ID VARCHAR2(20),
	PW VARCHAR2(20),
	NAME VARCHAR2(15),
	GENDER CHAR(1) CHECK(GENDER IN('F', 'M')),
	GRADE_CODE NUMBER,
	CONSTRAINT FK_GRADECODE FOREIGN KEY(GRADE_CODE)
	REFERENCES USER_GRADE(GRADE_CODE) ON DELETE SET NULL
);

INSERT INTO USER_FOREIGN_KEY 
VALUES(1, '123', '321', '홍길동', 'F', 2);

INSERT INTO USER_FOREIGN_KEY 
VALUES(2, 'ABC', 'ABC1', '박길동', 'F', 4);

INSERT INTO USER_FOREIGN_KEY 
VALUES(3, '456', '456', '최길동', 'F', 1);

INSERT INTO USER_FOREIGN_KEY 
VALUES(4, 'DEF', 'DEF1', '김길동', 'M', 3);

INSERT INTO USER_FOREIGN_KEY 
VALUES(5, 'QWE', 'QWE1', '이길동', 'M',1);

SELECT * FROM USER_FOREIGN_KEY;

-- 삭제 
DELETE FROM USER_GRADE
WHERE GRADE_CODE = 4;
-- 삭제 성공! 

SELECT * FROM USER_FOREIGN_KEY;
-- GRADE_CODE 4가 저장되어 참조하던 데이터가 NULL로 변경 
SELECT * FROM USER_GRADE;

-- 2. 부모 컬럼을 삭제할 때 관련된 자식도 함께 삭제
-- ON DELETE CASCADE 
DROP TABLE USER_FOREIGN_KEY;

CREATE TABLE USER_FOREIGN_KEY(
	NO NUMBER PRIMARY KEY,
	ID VARCHAR2(20),
	PW VARCHAR2(20),
	NAME VARCHAR2(15),
	GENDER CHAR(1) CHECK(GENDER IN('F', 'M')),
	GRADE_CODE NUMBER,
	CONSTRAINT FK_GRADECODE FOREIGN KEY(GRADE_CODE)
	REFERENCES USER_GRADE(GRADE_CODE) ON DELETE CASCADE
);

INSERT INTO USER_FOREIGN_KEY 
VALUES(1, '123', '321', '홍길동', 'F', 2);

INSERT INTO USER_FOREIGN_KEY 
VALUES(2, 'ABC', 'ABC1', '박길동', 'F', 4);

INSERT INTO USER_FOREIGN_KEY 
VALUES(3, '456', '456', '최길동', 'F', 1);

INSERT INTO USER_FOREIGN_KEY 
VALUES(4, 'DEF', 'DEF1', '김길동', 'M', 3);

INSERT INTO USER_FOREIGN_KEY 
VALUES(5, 'QWE', 'QWE1', '이길동', 'M',1);

SELECT * FROM USER_FOREIGN_KEY;

-- 삭제
DELETE FROM USER_GRADE
WHERE GRADE_CODE = 1;

SELECT * FROM USER_FOREIGN_KEY;

-- SQL Error [2449] [72000]: ORA-02449: 
-- 외래 키에 의해 참조되는 고유/기본 키가 테이블에 있습니다
DROP TABLE USER_GRADE;
DROP TABLE USER_FOREIGN_KEY;

-- SUBQUERY 활용해서 테이블 만들기 
-- 서브쿼리를 통해 테이블 생성할 경우
-- 컬럼명, 타입, 값, NOT NULL 복사 가능하다
-- 제약 조건은 복사되지 않는다.

-- 일반적인 테이블 생성 
-- CREATE TABLE EMP_COPY (컬럼 설정);

-- 서브쿼리 이용하여 테이블 생성
CREATE TABLE EMP_COPY
AS SELECT * FROM EMPLOYEE; 

SELECT * FROM EMP_COPY;

-- 테이블의 형식만 복사하기
-- 값을 제외한 형식 복사
CREATE TABLE EMP_COPY2
AS SELECT * FROM EMPLOYEE WHERE 1=2;

SELECT * FROM EMP_COPY2;

-- 특정 컬럼만 복사하기 
CREATE TABLE EMP_COPY3 
AS SELECT EMP_ID, EMP_NAME "NAME", SALARY "급여" FROM EMPLOYEE;

SELECT * FROM EMP_COPY3;

-- 컬럼에 기본값 설정 
CREATE TABLE DEFAULT_TABLE(
	COL1 VARCHAR2(30) DEFAULT '없다',
	COL2 DATE DEFAULT SYSDATE
);

-- COL1 기본값 : '없다', COL2 기본값 : 오늘날짜
-- INSERT INTO DEFAULT_TABLE('없다', SYSDATE);

INSERT INTO DEFAULT_TABLE 
VALUES('1', DEFAULT);

SELECT * FROM DEFAULT_TABLE;



