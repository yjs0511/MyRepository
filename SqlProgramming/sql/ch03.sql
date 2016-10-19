-- section01 DUAL 테이블
-- 단순 계산을 하고 싶을 때 사용하는 테이블
select * from dual;
select 10+20 from emp;
select 10+20 from dual;
-- 프로시저(괄호가 없는 함수)
select sysdate from dual; -- 현재 오라클 db의 날짜 
-- section02 숫자 함수
-- 2.1 절대값을 구하는 ABS 함수
select abs(-15) "Absolute" from dual;
-----------------------------
update emp set sal=sal/7;
select * from emp;
rollback;
------------------------------------------------------
-- 소소 첫째 자리까지 내타내기 (반올림)
select sal, round(sal) from emp;
select sal, round(sal, 1) from emp;   -- 반올림
-- 바로 아래 정수(소수를 정수로 만드는 방법)
select sal, floor(sal) from emp;   -- 값 바로 밑에 정수
-- 바로 위 정수
select sal, ceil(sal) from emp;
-- 소수 첫째 자리까지 나타내기(잘라내기)
-- section03 문자처리 함수
-- 3.1 대소문자 변환함수
select phone_number from employees where lower(first_name)='steven';

-- 3.3 문자 조작 함수
-- 3.3.1 문자열 일부만 추출하는 SUBSTR 함수
select * from employee;
select substr(first_name,1,5) from employees;

-- 3.3.5 특정 기호로 채우는 LPAD/RPAD 함수
select lpad('oracle',20,'*') from dual;
select rpad('oracle',20,'*') from dual;
-- 10자리 공간에 사원 이름(first_name)을 5자리 까지만 나오게 하고 나머지는 오른쪽(*) 처리 하시오.
select rpad(substr(first_name,1,5), 10, '*') from employees;

-- Section04 형 병환 함수
-- 4.1.1 날짜형을 문자형으로 변환하기
select hire_date, to_char(hire_date, 'YYYY.MM.DD DAY HH') from employees;

-- 4.2 문자형을 날짜형으로 변환하기
select first_name, hire_date from employees where hire_date = to_date('06-17-2003', 'MM-DD-YYYY');

--Section05 날짜함수
-- 5.1 DBMS의 현재 날짜
select SYSDATE from dual;
-- DBMS의 현재 날짜를 "2016.10.17 월요일"로 변환해 보세요.
select to_char(sysdate, 'YYYY.MM.DD DAY HH:mi') from dual;

-- Section06 NULL을 다른 값으로 변환하는 NVL 함수
select salary*12+nvl(commission_pct,0)*salary from employees;
select nvl2(
    commission_pct,                     -- 이게 NULL이 아니면
    (salary*12+commission_pct*salary),  -- 이 값이 나오고
    salary*12)                          -- NULL 이면 이게 나온다
  from employees;
  
