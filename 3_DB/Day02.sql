-- 실행 : CTRL + ENTER
SELECT * FROM EMPLOYEE;

-- 테이블행 블록치고 F4

-- 데이터 기본 사항 처리 로직 
-- 데이터 베이스에서 실행하고자 하는 명령 종류 
-- [CRUD]
-- CREATE 	: 데이터 추가 / INSERT
-- READ 	: 데이터 조회 / SELECT 
-- UPDATE	: 데이터 수정 / UPDATE
-- DELETE	: 데이터 삭제 / DELETE

-- SELECT : 조회용 SQL 명령어
-- SELECT 조회용컬럼	: 조회하고자 하는 내용
-- FROM 테이블명		: 조회하고자 하는 테이블명 
-- WHERE 조건		: 특정 조건 
-- ODER BY 컬럼 		: 정렬 
-- ;

-- 부서코드가 'D6'인 부서의
-- 직원 정보를 모두 조회하자
SELECT * 
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6';


-- DAY 2
-- 컬럼명에 별칭 달기


-- 1. AS 표현
SELECT EMP_ID AS "사원번호",
	   EMP_NAME AS "사원명"
FROM EMPLOYEE;

-- 2. AS 생략
SELECT EMP_ID "사원번호",
	   EMP_NAME 사원명
FROM EMPLOYEE;	   
-- ""으로 별칭 작성
-- "" 생략도 가능하다

-- 단, 별칭에 공백이 들어갈 경우 생략 불가
SELECT EMP_ID "사원 번호",
       EMP_NAME 사원명
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 부서가 'D2'이거나 'D1'인 
-- 사원들의 사원명, 입사일, 연락처를 조회
-- 단, 조회하는 컬럼명에 별칭 부여
SELECT EMP_NAME 사원명,
	   HIRE_DATE 입사일,
	   PHONE 연락처
FROM EMPLOYEE	   
WHERE DEPT_CODE = 'D2' OR DEPT_CODE = 'D1';

-- SELECT에 연산이 들어갈 수 있다.
-- 컬럼값이 NULL이라면 어떤 연산 처리가 되어도
-- 결과 값은 누조건 NULL이다. 
SELECT EMP_NAME 사원명,
	   SALARY 급여,
	   (SALARY*12) 연봉,
	   BONUS  보너스,
	   (SALARY + (SALARY*BONUS))*12 연봉총합
FROM EMPLOYEE;

-- NVL() : 현재 조회된 값이 NULL일 경우 별도로 지정한 값으로 변경
SELECT BONUS, NVL(BONUS, 0)
FROM EMPLOYEE;

SELECT EMP_NAME 사원명,
	   SALARY 급여,
	   (SALARY*12) 연봉,
	   BONUS  보너스,
	   (SALARY + (SALARY*NVL(BONUS, 0)))*12 연봉총합
FROM EMPLOYEE;

-- DISTINCT
-- 해당하는 값이 컬럼에 여러개 존재할 경우 중복 제거하고 한개만 조회. (NULL도 포함)
SELECT DEPT_CODE 
FROM EMPLOYEE;

SELECT DISTINCT DEPT_CODE
FROM EMPLOYEE;

-- DEPARTMENT 테이블을 참고하여
-- 부서가 '해외영업2부'인 부서의 부서코드를 찾고 
-- EMPLOYEE 테이블에서 해당 부서의 사원들 중 급여가 200만원보다 많이 받는 직원의
-- 사원, 사원명, 급여 조회
-- 1) '해외영업2부' 부서의 부서코드 확인 'D2'?
SELECT * 
FROM EMPLOYEE;
--WHERE DEPT_TITLE = '해외영업2부';

-- 2) 해당 부서의 정보를 EMPLOYEE에서 정회
SELECT EMP_ID 사원, EMP_NAME 사원명, SALARY 급여
FROM EMPLOYEE
WHERE SALARY > 2000000 
	AND (SELECT DEPT_ID FROM DEPARTMENTBONUS 
		 WHERE DEPT_TITLE = '해외영업2부');
		

-- 연산자
-- 연결 연산자 '||'
-- 여러 컬럼의 결과나 리터럴(값)을 하나의 컬럼으로 묶을때 사용하는 연산자
SELECT EMP_ID || 
	   '을 가진 사람의 이름은 ' ||
	   EMP_NAME || 
	   '입니다.'
FROM EMPLOYEE;	  

-- 비교 연산자
-- <, >, <=, >= : 크기를 비교하는 부등호
-- = : 같다 
-- != : 같지 않다. 
SELECT * FROM EMPLOYEE
--WHERE DEPT_CODE = 'D9';
--WHERE DEPT_CODE ^= 'D9';
WHERE DEPT_CODE <> 'D9';

-- EMPLOYEE 테이블에서 
-- 급여가 350만원 이상 550만원 이하인
-- 직원의 사번, 사원명, 부서코드, 직급코드, 급여를 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3500000 AND SALARY <= 5500000;

-- 방금 작성한 코드를 
-- BETWEEN A AND B 
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 5500000;

-- 350미만, 550초과인 직원 정보 조회할 경우 
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY NOT BETWEEN 3500000 AND 5500000;

-- LIKE
-- 입력한 숫자, 문자 포함된 정보를 조회할 때 
-- '_' : 임의의 한 문자
-- '%' : 몇자리 문자건 관계없이

-- EMPLOYEE 에서
-- 사원의 이름 가운데 '중'이 들어가는 사원 정보 조회
-- _중_
SELECT *
FROM EMPLOYEE
WHERE EMP_NAME LIKE '_중_';

-- EMPLOYY에서
-- 주민등록번호 깆군 여성인 사원 정보만 기재
SELECT *
FROM EMPLOYEE
WHERE EMP_NO LIKE '%-2%';

-- 사원의 이메일 아이디가 5글자 초과하는 사원의 
-- 사원명, 사번, 이메일 정보 조회
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '______%@%';

-- 사원 중에 이메일 4번째 자리가 '_'인 사원의 정보 조회하기
-- ESCAPE문자를 선언 
-- 특수문자가 아닌 일바눔자로 선언하여 사용할 수 있다. 
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '___#_%@%' ESCAPE '#';

-- EMPLOYEE 테이블에서 성이 '이'인 사원 정보 조회
SELECT * FROM EMPLOYEE
WHERE EMP_NAME LIKE '이%';

-- IN 연산자
-- IN(값1, 값2, 값3, ...)
-- 괄호 안에 있는 값들 중에 하나라도 일치하는 경우
-- 해당 값 조회하는 연산자

-- 부서코드가 D1 이거나 D6인 직원의 정보 조회
SELECT * FROM EMPLOYEE
WHERE DEPT_CODE IN('D1', 'D6');

-- D1도 D6도 아닌 부서의 직원 조회
-- WHERE DEPT_CODE != 'D1' AND DEPT_CODE != 'D6';
SELECT * FROM EMPLOYEE
WHERE DEPT_CODE NOT IN('D1', 'D6');

-- 함수 (FUNCTION)
-- LENGTH() : 문자열의 길이를 계산하는 함수
-- LENGTHB() : 문자열의 길이를 바이트 크기로 계산하는 함수
-- *오라클에서 한글은 3BYTE이다. 
SELECT LENGTH('HELLO'), LENGTHB('HELLO'),
	   LENGTH('최유리'), LENGTHB('최유리')
FROM DUAL;

-- DUAL : 임시테이블, 가상테이블, 테스트용
--		  리터럴을 활용한 계산식 등을 테스트하고자 할 때 사용되는 임시테이블
SELECT EMP_NAME, EMAIL, LENGTH(EMAIL)
FROM EMPLOYEE;

-- INSTR : 주어진 값에서 원하는 문자가 몇번째인지 찾아 반환
SELECT INSTR('ABCDE', 'A'),
	   INSTR('ABCDE', 'C'),
	   INSTR('ABCDE', 'BC'),
	   INSTR('ABCDE', 'Z')		-- 못 찾으면 0 
FROM DUAL;

SELECT EMAIL, 
	   INSTR(EMAIL, '_')
FROM EMPLOYEE;

-- SUBSTR : 주어진 문자열에서 특정 부분만 꺼내오는 함수
SELECT 'Hello Oracle',
		SUBSTR('Hello Oracle', 1, 5),
		SUBSTR('Hello Oracle', 3, 5),
		SUBSTR('Hello Oracle', 7)
FROM DUAL;

-- [문제2]
-- EMPLOYEE 테이블에서 사원들의 이름, 이메일 조회
-- 이메일은 아이디 부분만 조회하기
-- EX) 이창진 lee_cj
SELECT EMP_NAME, 
--		EMAIL,
		SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1)
FROM EMPLOYEE;

-- LPAD / RPAD
-- 빈칸을 지정한 문자로 채우는 함수
SELECT LPAD(EMAIL, 20, '#'),
		RPAD(EMAIL, 20, '*')
FROM EMPLOYEE;

-- LTRIM / RTRIM
-- 현재 부여된 컬럼 값이나, 특정 값으로부터 특정 문자를 찾아 지워준다.
SELECT '      HELLO',
		LTRIM('      HELLO'),
		RTRIM('HELLO      '),
		RTRIM('    HELLO  ')
FROM DUAL;

SELECT LTRIM('012345', '0'),
		LTRIM('111123', '1'),
		LTRIM('012345', '5'),
		RTRIM('012345', '5')
FROM DUAL;

-- TRIM
-- 주어진 문자열에서 양끝을 기준으로 특정 문자를 지워주는 함수 
SELECT TRIM('      HELLO     ')
FROM DUAL;

SELECT TRIM('0' FROM '0000123000')
FROM DUAL;

SELECT TRIM(LEADING '0' FROM '0000123000'),
		TRIM(TRAILING '0' FROM '0000123000'),
		TRIM(BOTH '0' FROM '0000123000')
FROM DUAL;

-- LOWER / UPPER / INITCAP
-- 주어진 문자열을 소문자, 대문자, 앞글자만 대문자로 변경하는 함수
SELECT LOWER('NICE TO MEET YOU'),
		UPPER('nice to meet you'),
		INITCAP('nice to meet you')
FROM DUAL;

-- CONCAT : 여러 문자열을 하나의 문자열로 합치는 함수
SELECT CONCAT('오라클', '재밌어요 :D')
FROM DUAL;

SELECT CONCAT(EMP_NAME, '님')
FROM EMPLOYEE;

SELECT EMP_NAME||'님'
FROM EMPLOYEE;

-- REPLACE : 주어진 문자열에서 특정 문자를 변경
SELECT REPLACE('HELLO ORACLE', 'HELLO', 'BYE')
FROM DUAL;

-- [문제3]
-- EMPLOYEE 테이블에서 사원의 주민번호를 확인
-- 생년 생월 생일 각각 조회 
-- EX) 
-- 이름	|	생년	|	생월	|	생일
-- 이창진	|	00년	|	00월	|	00일
SELECT EMP_NAME 이름, 
		SUBSTR(EMP_NO, 1, 2)||'년' 생년,
		TRIM(LEADING '0' FROM SUBSTR(EMP_NO, 3, 2))||'월' 생년,
		TRIM(LEADING '0' FROM SUBSTR(EMP_NO, 5, 2))||'일' 생년
FROM EMPLOYEE;

-- SUBSTR 이용하면 날짜 데이터도 쪼갤 수 있다.
-- '25/06/02' 
SELECT EMP_NAME,
		HIRE_DATE,
		SUBSTR(HIRE_DATE, 1, 2),
		SUBSTR(HIRE_DATE, 4, 2)
FROM EMPLOYEE;		

-- [문제4]
-- EMPLOYEE 테이블에서 현재 근무하는 
-- 여성사원의 사번, 사원명, 직급코드를 조회
-- ENT_YN : 퇴사여부 
SELECT ENT_YN FROM EMPLOYEE;

-- 단일형함수(Single Row Function)
SELECT EMP_ID 사번,
		EMP_NAME 사원명,
		JOB_CODE 직급코드,
		ENT_YN 퇴사여부
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = '2'
	  AND ENT_YN = 'N';

-- 그룹 함수 (Group Function)
-- SUM(), AVG(), MAX(), MIN(), COUNT()
-- SUM(숫자가 기록된 컬럼) : 해당 칼럼들의 합계
SELECT SUM(SALARY)
FROM EMPLOYEE;

-- AVG('') : 해당 컬럼들의 평균을 계산
SELECT AVG(SALARY)
FROM EMPLOYEE;

-- MAX() : 해당 컬럼들의 값 중 최대값
SELECT MAX(SALARY)
FROM EMPLOYEE;

-- MIN() : 해당 컬럼들의 값 중 최소값
SELECT MIN(SALARY)
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 '해외영업1부'->D5에 근무하는 모든 사원의
-- 평균 급여, 가장 높은 급여, 가장 낮은 급여, 급여 합계 조회하기
SELECT AVG(SALARY) "평균 급여", 
		MAX(SALARY) "가장 높은 급여",
		MIN(SALARY) "가장 낮은 급여",
		SUM(SALARY) "급여 합계"
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';

SELECT * FROM EMPLOYEE;

-- [ERROR] 단일 그룹의 그룹 함수가 아닙니다.
--SELECT MAX(SALARY), EMP_NAME
--FROM EMPLOYEE;
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY = (SELECT MAX(SALARY) FROM EMPLOYEE);

-- COUNT(컬럼명) : 행의 개수
SELECT COUNT(EMP_ID) FROM EMPLOYEE;
SELECT COUNT(DEPT_CODE) FROM EMPLOYEE;	-- NULL을 포함하는 경우 COUNT에서 제외 

SELECT COUNT(*),
		COUNT(DEPT_CODE),
		COUNT(DISTINCT DEPT_CODE)
FROM EMPLOYEE;

SELECT DISTINCT DEPT_CODE
FROM EMPLOYEE;

-- 날짜 함수
-- 현재 날짜, 시간 확인
SELECT SYSDATE, SYSTIMESTAMP, CURRENT_DATE
FROM DUAL;

-- MONTHS_BETWEEN : 두 날짜 사이의 개월 수 
SELECT HIRE_DATE "입사일",
		MONTHS_BETWEEN(SYSDATE, HIRE_DATE) "입사 후 개월 수"
FROM EMPLOYEE;		

-- ADD_MONTHS(날짜, 개월 수)
SELECT ADD_MONTHS(SYSDATE, 3)
FROM DUAL;

-- EXTRACT(YEAR|MONTH|DAY FROM 날짜데이터) : 지정한 날부터 날짜값을 추출하는 함수
SELECT EXTRACT(YEAR FROM SYSDATE),
		EXTRACT(MONTH FROM SYSDATE),
		EXTRACT(DAY FROM SYSDATE)
FROM DUAL;

SELECT EXTRACT(DAY FROM HIRE_DATE)
FROM EMPLOYEE;

-- 
SELECT HIRE_DATE,
		TO_CHAR(HIRE_DATE, 'YYYY/MM/DD')
FROM EMPLOYEE;		

-- TO_CHAR() : 날짜나 숫자 값을 문자형태로 변환
SELECT SALARY,
		TO_CHAR(SALARY, '000,000,000'),
		TO_CHAR(SALARY, '999,999,999'),
		TO_CHAR(SALARY, 'L999,999,999'),
		TO_CHAR(SALARY, 'L999,999,999')
FROM EMPLOYEE;	

-- 20250603 숫자값 => 날짜값
SELECT 20250603,
		TO_DATE(20250603, 'YYYY/MM/DD'),
		'20250603',
		TO_DATE('20250603', 'YYYYMMDD')
FROM DUAL;		


-- JAVA 3항 연산자
-- DECODE (컬럼|데이터, 비교값1, 결과1, 비교값2, 결과2, ..., 기본값)
-- 현재 근무하는 직원들의 성별을 남, 여로 출력해보자.
SELECT EMP_NAME 사원명,
		EMP_NO,
		DECODE(SUBSTR(EMP_NO, 8, 1), '2', '여', '남') 성별	-- '남'은 기본값
FROM EMPLOYEE
--ORDER BY EMP_NAME;
--ORDER BY EMP_NO;
--ORDER BY EMP_NAME ASC;	-- 오름차순(생략가능)
--ORDER BY EMP_NAME DESC;	-- 내림차순(생략불가능)
--ORDER BY 2;				-- 숫자 : SELECT문에 작성된 순서
--ORDER BY 3;
--ORDER BY 성별;			-- 별칭 
--ORDER BY 사원명 DESC;

-- [문제5]
-- EMPLOYEE 테이블에서
-- 모든 직원의 사번, 사원명, 부서코드, 직급코드(JOB_CODE), 근무여부, 관리자 여부(MANAGER_ID)를 조회
-- 만약 근무여부가 'Y' -> 퇴사자
--			    'N' -> 근무자
-- 관리자사번(MAMGER_ID) 없으면(NULL) -> 관리자
--						있으면 -> 사원
SELECT * FROM EMPLOYEE;

SELECT EMP_ID 사번, 
	   EMP_NAME 사원명, 
	   DEPT_CODE  부서코드, 
	   JOB_CODE 직급코드,
	   DECODE(ENT_YN, 'Y', '퇴사자', '근무자') 근무여부, 
	   DECODE(MANAGER_ID, NULL, '관리자', '사원')  관리자여부
FROM EMPLOYEE;

-- MANAGER_ID가 NULL이라면 NVL을 통해 0으로 값을 변경하여 확인 
-- NVL(BONUS, 0)
SELECT DECODE(NVL(MANAGER_ID, 0), 0, '관리자', '사원')  관리자여부
FROM EMPLOYEE;

-- NVL2(컬럼명|데이터, NULL이 아닐 경우 값, NULL일 경우 값)
SELECT EMP_ID 사번,
		EMP_NAME 사원명,
		BONUS 보너스,
		NVL(TO_CHAR(BONUS), 'X') "NVL 함수",
--		NVL2(BONUS, TO_CHAR(BONUS, '0.99'), 'X') "NVL2 함수"
		NVL2(BONUS, '0', 'X') "NVL2함수"
FROM EMPLOYEE;		

-- CASE 문
-- 자바의 SWITCH문과 흡사

-- 사용법
-- CASE 
--	WHEN 조건1 THEN 결과1
-- 	WHEN 조건2 TEHN 결과2
-- 	ELSE 결과3
-- END

SELECT EMP_ID 사번,
		EMP_NAME 사원명,
		CASE
			WHEN ENT_YN = 'Y' THEN '퇴사자'
			ELSE '근무자'			
		END	"근무 여부",
		CASE
			-- NULL일때 =로 판단을 할 수 없음 (오라클)
--			WHEN MANAGER_ID IS NULL THEN '관리자'
--			ELSE '사원'
			WHEN MANAGER_ID IS NOT NULL THEN '사원'
			ELSE '관리자'
		END "관리자 여부"
FROM EMPLOYEE;
		
-- 연산자 우선순위
-- 0. ()
-- 1. 산술
-- 2. 연결
-- 3. 비교
-- 4. IS NULL, IS NOT NULL, LIKE, IN, NOT IN
-- 5. BETWEEN A AND B
-- 6. NOT
-- 7. AND
-- 8. OR

-- DAY02 연습문제
-- 1.  직급이 'J2'이면서 200만원 이상 받는 직원 이거나,
-- 직급이 'J7' 인 사원의 사번, 사원명, 직급코드, 급여
-- 정보 조회하기
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE = 'J2' AND SALARY >= 2000000)
		OR (JOB_CODE = 'J7');

--  2.  직급이 'J7' 이거나 'J2'이면서 급여를 200만원 이상
--  받는 직원의 사번, 사원명, 직급코드, 급여, 연봉을 조회하시오.
SELECT EMP_ID 사번, EMP_NAME 사원명, JOB_CODE 직급코드, SALARY 급여, SALARY*12 연봉
FROM EMPLOYEE
WHERE (JOB_CODE = 'J7' OR JOB_CODE = 'J2')
		AND SALARY >= 2000000;

-- 3. EMPLOYEE 테이블에서
-- 모든 사원의 사번, 사원명, 이메일, 주민번호를 조회하여 사원 목록표를 만들고자 한다.
-- 이 때, 이메일은 '@' 전 까지, 
-- 주민번호는 7번째 자리 이후 '*' 처리를 하여 조회 하시오.
SELECT EMP_ID 사번, 
		EMP_NAME 사원명,
		SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1) 이메일, 
		RPAD(SUBSTR(EMP_NO, 1, 8), 14, '*') 주민번호
FROM EMPLOYEE;
		
--  4. 직원명과 주민번호를 조회함
--  단, 주민번호 9번째 자리부터 끝까지는 '*'문자로 채움
--  예 : 홍길동 771120-1******
SELECT EMP_NAME 직원명,
		RPAD(SUBSTR(EMP_NO, 1, 8), 14, '*') 주민번호
FROM EMPLOYEE;	

--  5. 직원명, 직급코드, 연봉(원) 조회
--  단, 연봉은 ￦57,000,000 으로 표시되게 함
--     연봉은 보너스포인트가 적용된 1년치 급여임
SELECT EMP_NAME 직원명,
		JOB_CODE 직급코드,
		TO_CHAR((SALARY + (SALARY*NVL(BONUS, 0)))*12, 'L999,999,999') 연봉
FROM EMPLOYEE;		
		
--   6. 부서코드가 D5, D9인 직원들 중에서 2004년도에 입사한 직원의 정보 조회함.
--   사번 사원명 부서코드 입사일
SELECT EMP_ID 사번,
		EMP_NAME 사원명,
		DEPT_CODE 부서코드,
		HIRE_DATE 입사일
FROM EMPLOYEE
WHERE EXTRACT(YEAR FROM HIRE_DATE)='2004';

--	7. 직원명, 부서코드, 생년월일, 나이(만) 조회
--   단, 생년월일은 주민번호에서 추출해서, 
--   ㅇㅇ년 ㅇㅇ월 ㅇㅇ일로 출력되게 함.
--   나이는 주민번호에서 추출해서 날짜데이터로 변환한 다음, 계산함
--  (이상한 날짜 값이 들어간 사원들은 WHERE 조건절을 이용하여 제외)
SELECT EMP_NAME 직원명,
		DEPT_CODE 부서코드,
		SUBSTR(EMP_NO, 1, 2)||'년 '||
		SUBSTR(EMP_NO, 3, 2)||'월 '||
		SUBSTR(EMP_NO, 5, 2)||'일' 생년월일,
		EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM TO_DATE(SUBSTR(EMP_NO, 1, 6), 'YYMMDD') ) 나이
FROM EMPLOYEE
WHERE EMP_ID NOT IN (200, 201, 214);

-- 직원들의 입사일로부터 년도만 가지고, 각 년도별 입사인원수를 구하시오
-- 아래의 년도에 입사한 인원수를 조회하시오
-- 		=> to_char, decode, sum 사용
--
-- --------------------------------------------------------
-- 전체직원수		2001년	2002년	2003년	2004년
-- --------------------------------------------------------
SELECT COUNT(*) 전체,
	   COUNT( DECODE( TO_CHAR( EXTRACT(YEAR FROM HIRE_DATE) ), '2001', 1 ) ) "2001년",
	   COUNT( DECODE( TO_CHAR( EXTRACT(YEAR FROM HIRE_DATE) ), '2002', 1 ) ) "2002년",
	   COUNT( DECODE( TO_CHAR( EXTRACT(YEAR FROM HIRE_DATE) ), '2003', 1 ) ) "2003년",
	   COUNT( DECODE( TO_CHAR( EXTRACT(YEAR FROM HIRE_DATE) ), '2004', 1 ) ) "2004년"
FROM EMPLOYEE;

-- 9. 부서코드가 D5면 총무부, D6이면 기획부, D9면 영업부로 처리하시오
-- 		단, 부서코드가 D5, D6, D9인 직원의 정보만 조회함
-- 		=> CASE 사용
--		부서코드 기준 오름차순 정렬
SELECT EMP_NAME 사원명, DEPT_CODE 부서코드,
		CASE
			WHEN DEPT_CODE='D5' THEN '총무부'
			WHEN DEPT_CODE='D6' THEN '기획부'
			WHEN DEPT_CODE='D9' THEN '영업부'
		END "부서명"
FROM EMPLOYEE
WHERE DEPT_CODE IN ('D5', 'D6', 'D9')
ORDER BY 부서코드;
		
