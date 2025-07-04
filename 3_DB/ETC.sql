
-- 5_WEB. JSP10_ASYNC
DROP TABLE BIKE_TB;

CREATE TABLE BIKE_TB(
	ADDR_GU VARCHAR2(4000),
	CONTENT_IT NUMBER PRIMARY KEY,
	CONTENT_NM VARCHAR2(4000),
	NEW_ADDR VARCHAR2(4000),
	CRADLE_COUNT NUMBER,
	LONGITUDE NUMBER,
	LATITUDE NUMBER
);

SELECT * FROM BIKE_TB;

COMMIT;

DELETE  BIKE_TB;

-- 5_WEB. JSP11_MyBoard_Mybatis

SELECT * FROM MYBOARD;

------------------------------------------------------------------

-- MLP Member

DROP TABLE MLPMEMBER;
DROP SEQUENCE SEQ_MM;

CREATE SEQUENCE SEQ_MM;

CREATE TABLE MLPMEMBER(
	NO NUMBER PRIMARY KEY,
	ID VARCHAR2(500) NOT NULL UNIQUE,
	PW VARCHAR2(500) NOT NULL,
	NAME VARCHAR2(500) NOT NULL,
	PHONE VARCHAR2(2000) NOT NULL,
	EMAIL VARCHAR2(2000) NOT NULL
);

INSERT INTO MLPMEMBER 
VALUES(SEQ_MM.NEXTVAL, 'dkwjd', '1129', '송아정', '010-9861-3334', 'dkwjd@gmail.com');

INSERT INTO MLPMEMBER 
VALUES(0, 'ADMIN', 'ADMIN', '관리자', '010-0000-0000', 'ADMIN@admin.com');


SELECT * FROM MLPMEMBER 
ORDER BY NO;

COMMIT;


-----

-- BOARD (게시판)
DROP TABLE COMMUNITYBOARD;
DROP SEQUENCE SEQ_CB;

CREATE SEQUENCE SEQ_CB NOCACHE;
CREATE TABLE COMMUNITYBOARD(
	NO NUMBER PRIMARY KEY,
	NAME VARCHAR2(500) NOT NULL,
	TITLE VARCHAR2(2000) NOT NULL,
	CONTENT VARCHAR2(4000) NOT NULL,
	REGDATE DATE NOT NULL
);

INSERT INTO COMMUNITYBOARD
VALUES(SEQ_CB.NEXTVAL, '관리자', '테스트 제목', '테스트 글입니다.', SYSDATE);

SELECT * FROM COMMUNITYBOARD;

-- MEMBER (회원)
DROP TABLE COMMUNITYMEMBER;
DROP SEQUENCE SEQ_CM;

CREATE SEQUENCE SEQ_CM NOCACHE;

CREATE TABLE COMMUNITYMEMBER(
	NO NUMBER PRIMARY KEY,
	ID VARCHAR2(500) NOT NULL UNIQUE,
	PW VARCHAR2(500) NOT NULL,
	NAME VARCHAR2(500) NOT NULL,
	PHONE VARCHAR2(1000) NOT NULL, 
	ENABLED VARCHAR(10) CHECK(ENABLED IN ('Y', 'N'))
);

INSERT INTO COMMUNITYMEMBER
VALUES(SEQ_CM.NEXTVAL, 'ADMIN', 'ADMIN', '관리자', '010-1111-1111', 'Y')

SELECT * FROM COMMUNITYMEMBER;


--------------------------------
