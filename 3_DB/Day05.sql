-- 생성된 테이블에 제약조건 추가하기
-- 테이블 수정한다
-- DDL의 'ALTER' 이용하여 추가

-- [사용형식]
-- ALTER TABLE 테이블명 수정할 내용

-- ALTER TABLE 테이블명 ADD PRIMARY KEY(컬럼명)
-- ALTER TABLE 테이블명 ADD FOREIGN KEY(컬럼명) REFERENCES 참조할테이블명(컬럼명)
-- ALTER TABLE 테이블명 ADD UNIQUE(컬럼명)
-- ALTER TABLE 테이블명 ADD CHECK(조건식)
-- ALTER TABLE 테이블명 MODIFY 컬럼명 NOT NULL 

SELECT * FROM EMPLOYEE;

-- EMPLOYEE 테이블에 제약조건 추가
ALTER TABLE EMPLOYEE ADD FOREIGN KEY(DEPT_CODE) REFERENCES DEPARTMENT;

ALTER TABLE EMPLOYEE ADD FOREIGN KEY(JOB_CODE) REFERENCES JOB;

ALTER TABLE EMPLOYEE ADD FOREIGN KEY(SAL_LEVEL) REFERENCES SAL_GRADE;

ALTER TABLE EMPLOYEE ADD CHECK(ENT_YN IN ('Y', 'N'));
ALTER TABLE EMPLOYEE ADD CHECK(SALARY > 0);

ALTER TABLE EMPLOYEE ADD UNIQUE(EMP_NO);

ALTER TABLE DEPARTMENT ADD FOREIGN KEY(LOCATION_ID) REFERENCES LOCATION;

ALTER TABLE LOCATION ADD FOREIGN KEY(NATIONAL_CODE) REFERENCES NATIONAL;

SELECT C1.TABLE_NAME, C1.CONSTRAINT_NAME, COLUMN_NAME, SEARCH_CONDITION 
FROM USER_CONSTRAINTS C1
JOIN USER_CONS_COLUMNS C2 ON(C1.TABLE_NAME = C2.TABLE_NAME 
							AND C1.CONSTRAINT_NAME = C2.CONSTRAINT_NAME)
WHERE C1.TABLE_NAME IN ('EMPLOYEE', 'DEPARTMENT', 'LOCATION')
ORDER BY 1;

-- 제약조건 삭제
-- ALTER TABLE 테이블명 DROP CONTRAINT 제약조건명 

-- DML (데이터조작언어)
-- INSERT, UPDATE, DELETE, SELECT(DQL)
-- [CURD]
-- C(CREATE) : INSERT/데이터 추가
-- R(READ) : SELECT/데이터 조회
-- U(UPDATE) : UPDATE/데이터 수정 
-- D(DELETE) : DELETE/데이터 삭제

-- INSERT : 새로운 행을 특정 테이블에 추가하는 명령어
-- [사용형식]
-- 1. 특정 컬럼에만 값을 추가
-- INSERT INTO 테이블명(컬럼명, 컬럼명 ...) VALUES(값, 값...)
-- 2. 모든 컬럼에 값을 추가 
-- INSERT INTO 테이블명 VALUES(값, 값 ...)

SELECT * FROM EMPLOYEE;

INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, EMAIL, PHONE, DEPT_CODE, JOB_CODE, SAL_LEVEL, SALARY,
					 BONUS, MANAGER_ID, HIRE_DATE, ENT_DATE, ENT_YN)
VALUES(500, '이창진', '990101-1234567', 'lee@multi.com', '01012345678', 'D1', 'J7', 'S4', 3100000,
	   0.1, '200', SYSDATE, NULL, DEFAULT);

-- INSERT시 컬럼 생략하고 데이터추가
INSERT INTO EMPLOYEE 
VALUES(900, '김창진', '880101-1234567', 'KIM@multi.com', '01022223333', 'D1', 'J7', 'S3', 4300000,
		0.2, '200', SYSDATE, NULL, DEFAULT);

SELECT * FROM EMPLOYEE WHERE EMP_ID IN(500, 900);
-- 지금까지 변경된 내용을 DM에 반영(저장)하겠다.
COMMIT;

--  INSERT + SUBQUERY 
CREATE TABLE EMP_01(
	EMP_ID NUMBER,
	EMP_NAME VARCHAR2(20),
	DEPT_TITLE VARCHAR2(40)
);

-- 기본 
INSERT INTO EMP_01 VALUES(300, '박길동', '총무부');

SELECT * FROM EMP_01;

-- SUBQUERY 활용
SELECT EMP_ID, EMP_NAME, DEPT_TITLE
FROM EMPLOYEE 
LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID);

INSERT INTO EMP_01 (SELECT EMP_ID, EMP_NAME, DEPT_TITLE
					FROM EMPLOYEE 
					LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID));

SELECT * FROM EMP_01;

DELETE FROM EMP_01;

-- 
CREATE TABLE EMP_DEPT_D1 
AS SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
	FROM EMPLOYEE 
	WHERE 1=2;

SELECT * FROM EMP_DEPT_D1;

-- EMPLOYEE 테이블에서 D1부서에 근무하는 직원들의
-- 사번, 이름, 부서코드, 입사일을 조회하여
-- EMP_DEPT_D1 테이블에 추가(INSERT)
INSERT INTO EMP_DEPT_D1 (SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
						 FROM EMPLOYEE
						 WHERE DEPT_CODE = 'D1');

SELECT * FROM EMP_DEPT_D1;

-- UPDATE : 해당 테이블의 데이터를 수정하는 명령어 
-- [사용형식]
-- UPDATE 테이블명 SET 컬럼명 = 변경값
-- [WHERE 조건]

--SELECT * FROM EMPLOYEE; 

CREATE TABLE DEPT_COPY
AS SELECT * FROM DEPARTMENT; 

SELECT * FROM DEPT_COPY;

-- 총무부 -> 전략기획부
UPDATE DEPT_COPY SET DEPT_TITLE = '총무부'
WHERE DEPT_ID = 'D9';

-- WHERE 없으면 
UPDATE DEPT_COPY SET DEPT_TITLE = '총무부';

-- EMPLOYEE 테이블에서 주민번호가 잘못 표기되어 있는 사원 수정하기 
-- '621230', '631126', '850707' 변경하는 UPDATE구문 3개 작성 
SELECT EMP_ID, EMP_NO
FROM EMPLOYEE E; 

CREATE TABLE EMP_COPY4 
AS SELECT * FROM EMPLOYEE;

UPDATE EMPLOYEE SET EMP_NO = '621230'||SUBSTR(EMP_NO , 7)
WHERE EMP_ID = 200;

UPDATE EMPLOYEE SET EMP_NO = '631126'||SUBSTR(EMP_NO, 7)
WHERE EMP_ID = 201;

UPDATE EMPLOYEE SET EMP_NO = '850707'||SUBSTR(EMP_NO, 7)
WHERE EMP_ID = 214;

SELECT EMP_ID, EMP_NO
FROM EMPLOYEE
WHERE EMP_ID IN(200, 201, 214);

COMMIT;

UPDATE EMP_COPY4 SET DEPT_CODE = 'D3'
WHERE JOB_CODE = 'J4';

-- UPDATE + SUBQUERY 
-- 여러 행을 변경하거나, 여러 컬럼값을 변경하고자 할 때 서쿼리 활용
-- UPDATE 테이블명 SET 컬럼명 = (서브쿼리)

CREATE TABLE EMP_SALARY
AS SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY, BONUS FROM EMPLOYEE;

SELECT * FROM EMP_SALARY; 

-- 사번 214인 사원의 보너스, 급여를 
-- 사번 204인 사원의 보너스, 급여 값으로 변경
UPDATE EMP_SALARY
SET SALARY = (SELECT SALARY FROM EMP_SALARY WHERE EMP_ID=204), 
	BONUS = (SELECT BONUS FROM EMP_SALARY WHERE EMP_ID=204) 
WHERE EMP_ID = 214; 

SELECT * FROM EMP_SALARY 
WHERE EMP_ID IN(204, 214);

-- 202, 205, 211, 213 사원들의 급여, 보너스도 
-- 204 사원과 동일하게 변경

UPDATE EMP_SALARY
SET SALARY = (SELECT SALARY FROM EMP_SALARY WHERE EMP_ID=204), 
	BONUS = (SELECT BONUS FROM EMP_SALARY WHERE EMP_ID=204) 
WHERE EMP_ID IN (202, 205, 211, 213); 

SELECT * FROM EMP_SALARY;


-- UPDATE시 컬럼의 제약조건을 위배하지 않아야 한다.
-- SQL Error [2291] [23000]: ORA-02291: 
-- 무결성 제약조건(MULTI.SYS_C007591)이 위배되었습니다- 부모 키가 없습니다
UPDATE EMPLOYEE 
SET DEPT_CODE = 'D0'
WHERE DEPT_CODE = 'D6';

-- SQL Error [1407] [72000]: ORA-01407: 
-- NULL로 ("MULTI"."EMPLOYEE"."EMP_ID")을 업데이트할 수 없습니다
UPDATE EMPLOYEE 
SET EMP_ID = NULL 
WHERE EMP_ID = 200;

SELECT * FROM EMPLOYEE WHERE ENT_YN = 'Y';

-- 222
UPDATE EMPLOYEE 
SET ENT_YN = DEFAULT 
WHERE EMP_ID = 222;

-- DELETE --
-- 테이블의 행(ROW)을 삭제하는 명령어
-- [사용형식]
-- DELETE FROM 테이블명 
-- [WHERE 조건]
-- WHERE가 없으면 테이블의 모든 데이터가 삭제. 

-- DROP TABLE EMP;  --> 테이블 자체가 삭제됨
-- DELETE FROM EMP; --> 테이블의 데이터만 삭제됨 

CREATE TABLE TEST_DELETE 
AS SELECT * FROM EMPLOYEE;

SELECT * FROM TEST_DELETE;


-- SQL Error [2292] [23000]: ORA-02292: 
-- 무결성 제약조건(MULTI.SYS_C007591)이 위배되었습니다- 자식 레코드가 발견되었습니다
DELETE FROM DEPARTMENT 
WHERE DEPT_ID = 'D1';

-- 제약조건 비활성화
-- ALTER TABLE EMPLOYEE DISABLE CONSTRAINT 제약조건명; 
-- 제약조건 활성화
-- ALTER TABLE 테이블명 ENABLE CONSTRAINT 제약조건명;

-- TRUNCATE 활용하여 전체 데이터 삭제 
TRUNCATE TABLE TEST_DELETE; 

-- DELETE와 차이 : TRUNCATE는 ROLLBACK 불가능 
DELETE FROM TEST_DELETE;

-- SQL Error [2292] [23000]: ORA-02292: 
-- 무결성 제약조건(MULTI.SYS_C007591)이 위배되었습니다- 자식 레코드가 발견되었습니다
DELETE FROM DEPARTMENT 
WHERE DEPT_ID = 'D1';

SELECT * FROM TEST_DELETE;

-- 급여가 200이하로 받는 사원 삭제 
DELETE FROM TEST_DELETE 
WHERE SALARY <= 2000000;

-- COMMIT, ROLLBACK 
-- 트랜잭션을 제어하는 명령어 
-- 트랜잭션 : 데이터 처리하는 작업을 나눈 최소단위 
-- 하나의 트랜잭션으로 이루어진 작업은 반드시 모두 성공 OR 모두 실패 
-- 모두성공 -> COMMIT;
-- 하나라도 실패 -> ROLLBACK;

-- TCL(TRANSACTION CONTROL LANGUAGE)

/*
 * COMMIT : 정상 종료 되었다면 변경된 사항을 영구적으로 DB에 반영
 * ROLLBACK : 트랜잭션 작업 중 문제가 발생한 경우 작업한 내역을 취소 
 * 			  가장 최근에 COMMIT 한 사항으로 되돌아간다. 
 * */

CREATE TABLE USER_TBL(
	NO NUMBER UNIQUE,
	ID VARCHAR2(20) NOT NULL UNIQUE,
	PW VARCHAR2(30) NOT NULL
);

INSERT INTO USER_TBL VALUES(1, 'TEST01', 'PASS01');
INSERT INTO USER_TBL VALUES(2, 'TEST02', 'PASS02');

SELECT * FROM USER_TBL;

COMMIT;

INSERT INTO USER_TBL VALUES(3, 'TEST03', 'PASS03');

SELECT * FROM USER_TBL;

DROP TABLE USER_TBL;
-- 잘못 입력했다 ...
ROLLBACK; 
-- 가장 최근에 COMMIT한 구간(상태)으로 돌아간다.

UPDATE USER_TBL SET ID = 'TEST1' WHERE NO=1;

---- DELETE 문제 발생 ...

COMMIT;
INSERT INTO USER_TBL VALUES(3, 'TEST03', 'PASS03');
SAVEPOINT SP1;

INSERT INTO USER_TBL VALUES(4, 'TEST04', 'PASS04');

SELECT * FROM USER_TBL;

-- 해당 세이브포인트로 상태를 되돌린다. 
ROLLBACK TO SP1;


----------------------------------
-- DDL(CREATE, ALTER, DROP)
DROP TABLE DEPT_COPY; 

CREATE TABLE DEPT_COPY 
AS SELECT * FROM DEPARTMENT;

SELECT * FROM DEPT_COPY;


-- 컬럼 추가
ALTER TABLE DEPT_COPY 
ADD( LNAME VARCHAR(20));

SELECT * FROM DEPT_COPY;

-- 컬럼 삭제
ALTER TABLE DEPT_COPY 
DROP COLUMN LNAME;

SELECT * FROM DEPT_COPY;

-- 기본값 적용하여 컬럼 추가 
ALTER TABLE DEPT_COPY
ADD(LNAME VARCHAR(30) DEFAULT '한국');

SELECT * FROM DEPT_COPY; 

CREATE TABLE DEPT_COPY2 
AS SELECT * FROM DEPT_COPY;

SELECT * FROM DEPT_COPY2;

-- DEPT_COPY2 테이블에서
-- DEPT_ID에 기본키제약조건
-- DEPT_TITLE에  고유값
-- LNAME에 필수입력사항 
-- 제약조건 추가 

ALTER TABLE DEPT_COPY2
ADD CONSTRAINT PK_DEPT_CP2 PRIMARY KEY(DEPT_ID);
ALTER TABLE DEPT_COPY2 
ADD CONSTRAINT UK_DEPT_TITLE UNIQUE(DEPT_TITLE);

ALTER TABLE DEPT_COPY2 
MODIFY LNAME CONSTRAINT NN_DEPT_LNAME NOT NULL; 

SELECT * FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'DEPT_COPY2';

-- 컬럼의 자료형 수정
ALTER TABLE DEPT_COPY2 
MODIFY DEPT_ID CHAR(3);

ALTER TABLE DEPT_COPY2 
MODIFY DEPT_TITLE VARCHAR2(50);

ALTER TABLE DEPT_COPY2
MODIFY LOCATION_ID VARCHAR2(2)
MODIFY LNAME CHAR(20);

ALTER TABLE DEPT_COPY2 
MODIFY DEPT_TITLE VARCHAR2(5);

-- 컬럼의 이름 변경 
ALTER TABLE DEPT_COPY2 
RENAME COLUMN DEPT_TITLE TO DEPT_NAME;

SELECT * FROM DEPT_COPY2;

-- 테이블의 이름 변경
ALTER TABLE DEPT_COPY2 
RENAME TO DEPT_COPY_TWO;

SELECT * FROM DEPT_COPY_TWO;

-- SQL Error [942] [42000]: ORA-00942: 테이블 또는 뷰가 존재하지 않습니다
SELECT * FROM DEPT_COPY2;

-- 제약조건 이름 변경
ALTER TABLE DEPT_COPY_TWO 
RENAME CONSTRAINT PK_DEPT_CP2 TO PK_DEPT_ID; 

SELECT * FROM USER_CONSTRAINTS 
WHERE TABLE_NAME = 'DEPT_COPY_TWO';

ALTER TABLE DEPT_COPY_TWO 
RENAME CONSTRAINT SYS_C007623 TO NN_LOC_ID; 

RENAME DEPT_COPY_TWO TO DEPT_COPY2;

SELECT * FROM DEPT_COPY_TWO;
SELECT * FROM DEPT_COPY2;

-- 제약조건 삭제 
ALTER TABLE DEPT_COPY2 
DROP CONSTRAINT NN_DEPT_LNAME; 

SELECT * FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'DEPT_COPY2';

COMMIT;

SELECT * FROM DEPT_COPY2;

ALTER TABLE DEPT_COPY2 
DROP COLUMN LNAME;

ROLLBACK;

-- DDL은 트랜잭션개념이 아니다.
-- COMMIT/ROLLBACK 불가.
-- 이전에 DML 실행 후 DDL 실행하게 되면
-- 이전까지 데이터 조작내용이 자동으로 COMMIT 처리 

ALTER TABLE DEPT_COPY2 
DROP COLUMN LOCATION_ID; 

ALTER TABLE DEPT_COPY2 
DROP COLUMN DEPT_NAME;

-- SQL Error [12983] [72000]: ORA-12983: 테이블에 모든 열들을 삭제할 수 없습니다
ALTER TABLE DEPT_COPY2 
DROP COLUMN DEPT_ID;

-- DROP
-- 객체 자체를 제거하거나 / DROP 객체 종류 객체명
-- 			TABLE, VIEW, USER ...
-- 객체의 특정요소를 제거하는 명령어 / ALTER 객체종류 객체명 DROP ~~
-- 			제약조건, 컬럼

-- 테이블 삭제
DROP TROP DEPT_COPY2; 
-- DROP VIEW 뷰이름;
-- DORP USER 계정명;

-- 오라클 객체 --
-- VIEW(뷰)
-- SELECT를 실행한 결과 화면을 담는 객체.
-- SELECT 문장 자체를 저장. 

-- [생성]
-- CREATE [OR REPLACE] VIEW 뷰 이름
-- AS 서브쿼리 (뷰를 통해 확인할 SELECT 쿼리문)


-- SQL Error [1031] [42000]: ORA-01031: 권한이 불충분합니다
CREATE VIEW V_EMP
AS SELECT EMP_ID, EMP_NAME, DEPT_CODE FROM EMPLOYEE;

SELECT * FROM V_EMP;


-- 생성한 뷰의 정보
SELECT * FROM USER_VIEWS;

-- SQL Error [955] [42000]: ORA-00955: 기존의 객체가 이름을 사용하고 있습니다.
-- OR REPLACE : 이미 생성된 뷰가 있어도, 새로 생성이 가능하다.
CREATE OR REPLACE VIEW V_EMP(사번, 이름, 부서, 직급)
AS SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE FROM EMPLOYEE;

SELECT * FROM V_EMP;

-- 문제 1.
-- 사번, 이름, 직급명, 부서명, 근무지역 조회하는 쿼리문이 저장된
-- V_RESULTTEST_EMP 라는 이름의 뷰를 만들고
-- 해당 뷰를 통해서 결과 조회하여 확인

-- 1) 서브쿼리 준비
SELECT * FROM EMPLOYEE;
SELECT * FROM DEPARTMENT; 
SELECT * FROM LOCATION;
SELECT * FROM JOB;

SELECT EMP_NO, EMP_NAME, JOB_NAME, DEPT_TITLE, LOCAL_CODE 
FROM EMPLOYEE
JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE)
JOIN LOCATION ON(LOCAL_CODE = LOCATION_ID)
JOIN JOB USING(JOB_CODE);

-- 2) 뷰 생성
CREATE VIEW V_RESULTTEST_EMP(사번, 이름, 직급명, 부서명, 근무지역)
AS SELECT EMP_NO, EMP_NAME, JOB_NAME, DEPT_TITLE, LOCAL_CODE 
			FROM EMPLOYEE
			JOIN DEPARTMENT ON(DEPT_ID = DEPT_CODE)
			JOIN LOCATION ON(LOCAL_CODE = LOCATION_ID)
			JOIN JOB USING(JOB_CODE);

-- 3) 뷰 호출하여 확인
SELECT * FROM V_RESULTTEST_EMP;

SELECT * FROM V_RESULTTEST_EMP 
WHERE 사번 = 215;

-- VIEW SELECT 쿼리문을 저장하고 있기 때문
-- 원본테이블의 값이 변경되면 뷰를 통해 확인하는 값들도 변경되어야 한다.

UPDATE EMPLOYEE 
SET EMP_NAME = '강찬'
WHERE EMP_ID = 215;

-- 뷰 삭제 
DROP VIEW V_RESULTTEST_EMP;

SELECT * FROM USER_VIEWS; 

-- 뷰 생성, 연산 결과를 뷰를 통해 확인 

-- 서브쿼리 작성
SELECT  EMP_ID, EMP_NAME, 
		DECODE(SUBSTR(EMP_NO, 8, 1), 2, '여성', '남성'), 
		EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE)
FROM EMPLOYEE;

-- 뷰 생성
CREATE OR REPLACE VIEW V_EMP(사번, 사원명, 성별, 근무년수)
AS
SELECT  EMP_ID, EMP_NAME, 
		DECODE(SUBSTR(EMP_NO, 8, 1), 2, '여성', '남성'), 
		EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE)
FROM EMPLOYEE;

SELECT * FROM V_EMP;

-- 뷰에 데이터 삽입, 수정, 삭제
CREATE OR REPLACE VIEW V_JOB 
AS 
SELECT * FROM JOB;

SELECT * FROM V_JOB;

-- 추가
INSERT INTO V_JOB 
VALUES('J8', '인턴');

SELECT * FROM V_JOB;
SELECT * FROM JOB;

-- 수정 
UPDATE V_JOB
SET JOB_NAME = '아르바이트'
WHERE JOB_CODE = 'J8';

-- 삭제
DELETE FROM V_JOB 
WHERE JOB_CODE = 'J8';

SELECT * FROM V_JOB;
SELECT * FROM JOB;

-- 불가능할 경우
-- 1. 뷰에 정의되지 않은 컬럼 수정 
--		뷰를 통해 확인 할 수 없는 컬럼
-- 2. 산술 연산이 적용된 컬럼일 경우 
-- 3. JOIN을 통해 여러 테이블을 참조할 경우 
-- 4. 그룹함수, GROUP BY 구문 사용할 경우 

CREATE OR REPLACE VIEW V_EMP_SAL 
AS
SELECT EMP_ID, EMP_NAME, SALARY, (SALARY*12) 연봉 
FROM EMPLOYEE;

SELECT * FROM V_EMP_SAL;

-- SQL Error [1733] [42000]: ORA-01733: 가상 열은 사용할 수 없습니다
INSERT INTO V_EMP_SAL 
VALUES(900, '강창진', 3000000, 12000000);

CREATE OR REPLACE VIEW V_JOB 
AS 
SELECT JOB_CODE FROM JOB; 

SELECT * FROM V_JOB;

-- SQL Error [913] [42000]: ORA-00913: 값의 수가 너무 많습니다
INSERT INTO V_JOB VALUES('J8', '인턴');

INSERT INTO V_JOB VALUES('J8');

SELECT * FROM JOB; 

DELETE FROM JOB WHERE JOB_CODE='J8';

-- VIEW 생성시 설정 가능 옵션들 
-- OR REPLACE : 기존에 있던 동일한 이름의 뷰가 있을 땐 덮어씌어 생성, 없다면 새로 생성.
-- FORCE / NO FORCE : 서브쿼리에 사용된 테이블 없어도 뷰를 강제로 생성할 것인지를 설정
-- WITH CHECK / READ ONLY :
--		CHECK : 옵션을 설정한 컬럼의 값을 바꾸지 못하게 하는 설정
--		READ ONLY : 뷰어 사용된 어떠한 컬럼도 뷰를 통해 변경하지 못하게 막는 설정 

-- FORCE 
CREATE OR REPLACE VIEW V_EMP 
AS
SELECT T_CODE, T_NAME, T_CONTENT 
FROM TEST_TABLE; 

SELECT * FROM V_EMP; 

-- NO FORCE
-- 기본값 NOFORCE  
CREATE OR REPLACE /*NOFORCE*/ VIEW V_EMP 
AS
SELECT T_CODE, T_NAME, T_CONTENT 
FROM TEST_TABLE; 

SELECT * FROM V_EMP; 

-- WITH CHECK : 뷰에 존재하는 컬럼을 통해 추가나 수정작업을 하지 못하게 막는 옵션
CREATE OR REPLACE VIEW V_EMP 
AS 
SELECT * FROM EMPLOYEE 
WITH CHECK OPTION;

SELECT * FROM V_EMP;

-- SQL Error [32575] [99999]: ORA-32575: 뷰를 수정하는데 명시적 열 기본값이 지원되지 않음
INSERT INTO V_EMP 
VALUES(800, '강찬', '101010-1234567', 'CHAN@MULTI.COM', '01012345678', 'D1', 'J7', 
		'S1', 8000000, 0.2, 201, SYSDATE, NULL, DEFAULT);


INSERT INTO EMPLOYEE 
VALUES(800, '강찬', '101010-1234567', 'CHAN@MULTI.COM', '01012345678', 'D1', 'J7', 
		'S1', 8000000, 0.2, 201, SYSDATE, NULL, DEFAULT);

-- DELETE 기능
DELETE FROM V_EMP 
WHERE EMP_ID = 800;

SELECT * FROM V_EMP;

-- WITH READ ONLY : 입력 
CREATE OR REPLACE VIEW V_EMP 
AS 
SELECT * FROM EMPLOYEE 
WITH READ ONLY;

-- SQL Error [32575] [99999]: ORA-32575: 뷰를 수정하는데 명시적 열 기본값이 지원되지 않음
INSERT INTO V_EMP 
VALUES(800, '강찬', '101010-1234567', 'CHAN@MULTI.COM', '01012345678', 'D1', 'J7', 
		'S1', 8000000, 0.2, 201, SYSDATE, NULL, DEFAULT);

-- SQL Error [42399] [99999]: ORA-42399: 읽기 전용 뷰에서는 DML 작업을 수행할 수 없습니다.
DELETE FROM V_EMP 
WHERE EMP_ID = 900;

-- SEQUENCE 시퀀스 
-- 1, 2, 3, 4, 5 ... 의 형식으로 숫자데이터를 자동으로 카운트 하는 객체 

-- CREATE SEQUENCE 시퀀스명 
-- [INCREMENT BY 숫자] : 다음 값에 대한 증감 수치
--					5 : 5씩 증가
--				   -5 : 5씩 감소 
-- [START WITH 숫자] : 시작값 
-- [MAXVALUE 숫자] : 발생시킬 최대값 설정
-- [MINVALUE 숫자] : 발생시킬 최소값 설정
-- [CYCLE | NOCYCLE] : 값의 순환 여부
-- [CACHE 바이트크기 | NOCACHE] : 값을 미리 구하여 놓고 다음 값을 반영할 때 활용하는 설정 

CREATE SEQUENCE SEQ_EMPID
START WITH 300 
INCREMENT BY 5 
MAXVALUE 310 
NOCYCLE 
NOCACHE;

-- SQL Error [8004] [72000]: ORA-08004: 
-- 시퀀스 SEQ_EMPID.NEXTVAL exceeds MAXVALUE은 사례로 될 수 없습니다
-- 300, 305, 310 값을 실행할때마다 확인. 310을 넘어가게 되면 MAXVALUE를 넘어가므로 에러 발생
SELECT SEQ_EMPID.NEXTVAL FROM DUAL;
SELECT SEQ_EMPID.CURRVAL FROM DUAL;

-- 시퀀스 수정 
ALTER SEQUENCE SEQ_EMPID 
INCREMENT BY 10
MAXVALUE 400 
NOCYCLE 
NOCACHE;

SELECT SEQ_EMPID.NEXTVAL FROM DUAL;

SELECT * FROM USER_SEQUENCES;

-- SELECT, INSERT, UPDATE 등에서 사용 가능
-- 단, 서브쿼리의 SELECT문, VIEW, DISTINCT 사용한 컬럼 등과는 함께 사용 불가
-- GROUP BY, HAVING, ORDER BY 에서도 사용 불가
-- CREATE TABLE시, ALTER TABLE시 컬럼의 기본값 선언에 사용할 수 없다  

-- 삭제하기
DROP SEQUENCE SEQ_EMPID;

-- 시퀀스를 이용하여 데이터 추가 
CREATE SEQUENCE SEQ_EID 
START WITH 300 
MAXVALUE 10000 
NOCYCLE 
NOCACHE;

SELECT * FROM SEQ_EID;

-- 데이터 추가 
INSERT INTO EMPLOYEE 
VALUES(SEQ_EID.NEXTVAL, '비타민', '121203-1234567', 'VTM@MULTI', '01044443334', 
		'D2', 'J7', 'S1', 5000000, 0.2, 201, SYSDATE, NULL, DEFAULT);

SELECT * FROM EMPLOYEE WHERE EMP_NAME = '비타민';

-- D9 부서의 J7 직급 사원 4명을 
-- 시퀀스 활용하여 임의로 추가해보자.
ALTER SEQUENCE SEQ_EID
INCREMENT BY 1;

SELECT SEQ_EID.NEXTVAL FROM DUAL;

INSERT INTO EMPLOYEE 
VALUES(SEQ_EID.NEXTVAL, '김유리', '121203-2345678', 'KIM@MULTI', '01055553334', 
		'D9', 'J7', 'S1', 5000000, 0.2, 201, SYSDATE, NULL, DEFAULT);

INSERT INTO EMPLOYEE 
VALUES(SEQ_EID.NEXTVAL, '최유리', '121203-2222222', 'KIM@MULTI', '01055553334', 
		'D9', 'J7', 'S1', 5000000, 0.2, 201, SYSDATE, NULL, DEFAULT);

INSERT INTO EMPLOYEE 
VALUES(SEQ_EID.NEXTVAL, '이유리', '121203-3333333', 'KIM@MULTI', '01055553334', 
		'D9', 'J7', 'S1', 5000000, 0.2, 201, SYSDATE, NULL, DEFAULT);

INSERT INTO EMPLOYEE 
VALUES(SEQ_EID.NEXTVAL, '김유리', '121203-4444444', 'KIM@MULTI', '01055553334', 
		'D9', 'J7', 'S1', 5000000, 0.2, 201, SYSDATE, NULL, DEFAULT);

SELECT * FROM EMPLOYEE WHERE EMP_NAME IN('김유리', '최유리', '이유리');
