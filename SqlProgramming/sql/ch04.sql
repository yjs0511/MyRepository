-- Section01 그룹 함수
-- 사원들의 전체 봉급의 합
select sum(sal) from emp;

-- 월급을 가장 많이 받아가는 사원의 정보
select * from emp where sal=(select max(sal) from emp);
select * from emp where sal=max(sal); -- 이거 안됩니다

-- 평균 월급 보다 많이 받아가는 사원의 정보
select * from emp where sal > (select avg(sal) from emp);

-- 전체 사원의 수 = 전체 행수
select count(*) from emp;
select count(empno) from emp;
select count(comm) from emp;

-- 평균 월급보다 많이 받아가는 사원의 수
select count(*) from emp where sal > (select avg(sal) from emp);

-- 1.1 그룹 함수와 null값
-- 1.2 그룹 함수와 단순 컬럼
select avg(comm) as from emp;
select sum(comm)/count(*) from emp;
select sum(comm)/count(comm) from emp;

-- 사원이 직급 개수는?
select count(distinct job) from emp;

-- Section02 데이터 그룹 : GROUP BY 절
-- 부서별로 평균 봉급은?
select deptno, sal from emp order by deptno;
select deptno, round(avg(sal),1) from emp group by deptno order by deptno;

-- 직급별 평균 봉급은?
select job, avg(sal) from emp group by job;

-- 부서별(1차 그룹핑) 직급별(2차 그룹핑) 평균 봉급은?
select deptno, job, avg(sal) from emp group by deptno, job order by deptno;

-- Section03 그룹 결과 제한 : HAVING 절
-- 부서의 평균 봉급이 500 이상인 부서 번호와 평균 봉급은?
select deptno, avg(sal) from emp group by deptno having avg(sal)>500;

-- 그룹핑 전의 조건은 where
-- 그룹핑 후의 조건은 having

-- 사원 중에서 부서별 평균 봉급이 300 이상인 부서와 평균 봉급은?
select deptno, avg(sal) from emp where job='사원' group by deptno having avg(sal)>=300;

-- 사원 중에서 부서별 평균 봉급이 300이상인 부서와 사원의 평균 봉급 및 수는?
select deptno, avg(sal), count(empno) from emp where job='사원' group by deptno having avg(sal)>=300;

-- 급여 총액이 1000을 넘는 직급에 대해서 직급과 급여 총액을 표시하되
-- 직급이 사원인 사람은 제외 시킨 후 급여 총액에 따라 정렬하시오.
select job, sum(sal) as salary from emp where not job='사원' group by job having sum(sal)>1000 order by sum(sal);

