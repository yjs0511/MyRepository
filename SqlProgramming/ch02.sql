-- 1.1 ����� ��
select * from emp;
-- 1.2 Ư�� �����͸� ����
select empno, ename from emp;
-- 1.3 ��� ������
select ename, sal, sal*12 from emp;
-- 1.4 NULL ����� ��������
select ename, sal, comm, sal*12+nvl(comm,0) from emp;
-- 1.5 �÷� �̸��� ��Ī �����ϱ�
select ename as �̸�, sal as ����, comm ���ʽ�, sal*12+nvl(comm,0) ���� from emp;
-- 1.6 Concatenation ������(���ڿ� ����)
select empno, ename from emp;
select empno || '-' || ename from emp;
select ename || '�� ������ ' || job || ' �Դϴ�.' as ���� from emp;
-- 1.7 DISTINCT Ű���� (�ߺ�����)
-- ����� �ִ� �μ� ��ȣ��?
select distinct deptno from emp;

-----------------------------------------------------------------------------
-- 조건절 작성
select ename, deptno from emp where deptno=20;
-- 2.1 비교 연산자
select ename, deptno from emp where deptno!=20;
select ename, deptno from emp where deptno<>20;
select ename, deptno from emp where sal>=500;

-- 2.1.1 문자 데이터 조회
select * from emp where ename='이문세';

-- 2.1.2 날짜 데이터 조회
-- 2005년 1월 1일 이전에 입사한 사원의 정보
select * from emp where hiredate < '2005-01-01';
select * from emp where hiredate < to_date('2005/01/01', 'YYYY/MM/DD');

-- 2.2 논리 연산자
-- 2.2.1 AND 연산자
-- 10번 부서에 소속된 사원 중에서 직급이 과장인 사원
select * from emp where deptno=10 and job='과장';
-- 월급이 400 이상, 500 이하인 사원의 정보
select * from emp where sal>=400 and sal<=500;

-- 2.2.2 OR 연산자
-- -- 10번 부서에 소속된 사원 또는 직급이 과장인 사원
select * from emp where deptno=10 or job='과장';

-- 2.2.3 NOT 연산자
-- 10번 부서가 아닌 사원의 정보
select * from emp where deptno!=10;
select * from emp where deptno<>10;
select * from emp where not deptno=10;

-- 2.3 BETWEEN AND 연산자
select * from emp where 400<=sal and 500>=sal;  -- 연산자 3개 사용
select * from emp where sal between 400 and 500;  -- 연산자 1개 사용(이런 방법이 좋다)
select * from emp where ename between '바' and '자';

-- 2.4 IN 연산자
-- 보너스가 80이거나, 100이거나, 200인 사원의 정보
select * from emp where comm=80 or comm=100 or comm=200;  -- 연산자 5개 사용
select * from emp where comm in (80, 100, 200); -- 연산자 1개 사용 (괄호 안의 값중 하나인 경우 / 문자열도 가능하다 / 갯수 제한 없다)

-- 2.5 LIKE 연산자와 와일드 카드
-- 2.5.1 와일드 카드(%) 사용하기
-- 성이 이씨인 사원의 정보
select * from emp where ename between '이' and '익';
select * from emp where ename like '이%';  -- '이' 로 시작하는 문자열 찾기

-- 이름 중에 '성'이 포함된 사원의 정보
select * from emp where ename like '%성%'; -- '성' 을 포함하는 문자열 찾기

-- 2.5.1 와일드카드(_) 사용하기
-- 이름 중에 두  번째 글자가 '성'인 사원의 정보
select * from emp where ename like '_성%';

-- 이름 중에'성'이 포함되지 않는 사원의 정보
select * from emp where not ename like '%성%'; -- 조건 자체를 부정

-- 2.6 NULL을 위한 연산자
-- 보너스가 없는(NULL)인 사원의 정보
select * from emp where comm=null;  -- 아무것도 안 뜸
select * from emp where comm is null;
select * from emp where comm is not null;

-- 3.1 오름차순 정렬을 위한 ASC;
select * from emp order by sal;
select * from emp order by hiredate desc;

-- 입사날 내림차순 순서(1차 정렬) -> 이름 올림 차순(2차 정렬)
select * from emp order by hiredate desc, ename asc;

select empno, ename, (sal*12+nvl(comm,0)) as yearsal from emp 
where sal>200 and deptno=30
order by hiredate desc, ename asc;

-- 30번 부서에서 월급이 400이상인 사원의 번호, 이름, 연봉을 가져오세요.
select empno, ename, (sal*12+nvl(comm,0))as yearsal from emp 
where deptno=30 and sal>400;