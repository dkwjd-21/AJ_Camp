-- 주석
--실행 : alt+x, ctrl+enter

SELECT * FROM TEST;

SELECT * FROM TEST2;

-- EMPLOYEE SCRIPT 실행 후 (테이블 생성 및 데이터 추가 후)
-- CMD 에서 실행해도 똑같은 결과가 나온다!! 
SELECT * FROM EMPLOYEE;

-- 현재 계정이 가진 모든 테이블 정보 조회
SELECT * FROM TABS;

-- SELECT 문
-- 특정 테이블의 특정 데이터들을 조회하는 명령어
-- SELECT 컬럼명[, (컬럼명), (계산식)..] FROM 테이블명 

-- 모든 행, 모든 컬럼 조회
-- 모든 행 : 조건이 딱히 없다. 
-- 모든 컬럼 : SELECT *
SELECT * FROM EMPLOYEE;

-- 사원 ID와(EMP_ID) 사원명(EMP_NAME), 연락처(PHONE) 조회
-- EMPLOYEE 테이블에서 
SELECT EMP_ID, EMP_NAME, PHONE
FROM EMPLOYEE;

-- WHERE 절
-- 테이블에서 조건을 만족하는 값을 가진 행을 따로 선택하여 조회하는 조건 절

-- 부서코드가 'D6'인 사원 정보 모두 조회 
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6';

-- 진행순서 : FROM -> WHERE -> SELECT
SELECT EMP_NAME, EMP_NO
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6';

-- 직급(JOB_CODE)이 'J1'인 사원의
-- 사번, 사원명, 직급코드, 부서코드를 조회하자
SELECT EMP_NO, EMP_NAME, JOB_CODE, DEPT_CODE 
FROM EMPLOYEE
WHERE JOB_CODE = 'J1';

-- EMPLOYEE 테이블에서
-- 급여(SALARY)가 300만원 이상인 사원의 
-- 아이디(EMP_ID), 이름(EMP_NAME), 직급(JOB_CODE), 급여(SALARY) 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3000000;

-- 위와 동일한 정보를 조회하는데 급여가 300만원 이상이고 직급이 'J3'인 사원 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 3000000 AND JOB_CODE = 'J3'; 
