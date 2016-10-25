-- 행 순번 붙이기
select rownum, bno, btitle 
from board
order by bno;

select rownum, bno, btitle 
from (select bno, btitle from board order by bno);

-- 최근 삽입된 행 5개를 가져와라
select rownum, bno, btitle 
from (select bno, btitle from board order by bno desc)
where rownum<=5;

select rownum, bno, btitle 
from (select bno, btitle from board order by bno desc)
where rownum>=5000;

select rownum, bno, btitle 
from (select bno, btitle from board order by bno desc)
where rownum>=11;

-- 행의 순번이 11번 ~ 20번까지를 가져와라

select rn, bno, btitle 
from (
  select rownum as rn, bno, btitle 
  from (select bno, btitle from board order by bno desc)
  where rownum<=20
)
where rn>=11;

-- 1 페이지에 10개씩 구성하고, n번째 페이지를 가져와라
select rn, bno, btitle 
from (
  select rownum as rn, bno, btitle 
  from (select bno, btitle from board order by bno desc)
  where rownum<=(1*10)
)
where rn>=((1-1)*9+1);
