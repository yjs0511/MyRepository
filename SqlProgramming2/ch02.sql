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
