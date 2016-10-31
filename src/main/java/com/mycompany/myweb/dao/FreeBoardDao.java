package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.FreeBoard;

@Component
public class FreeBoardDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(FreeBoard freeBoard){
		String sql="insert into freeboard(bno, btitle, bcontent, bwriter, bhitcount, bdate) values(seq_freeboard_bno.nextval, ?, ?, ?, 0, sysdate)";
		int rowNo = jdbcTemplate.update(sql, 
										freeBoard.getBtitle(),
										freeBoard.getBcontent(),
										freeBoard.getBwriter()
										);
		return rowNo;
	}
	
	public int update(FreeBoard freeBoard){
		String sql = "update freeboard set btitle=?, bcontent=?, bhitcount=? where bno=?";
		int rowNo = jdbcTemplate.update(sql, 
										freeBoard.getBtitle(),
										freeBoard.getBcontent(),
										freeBoard.getBhitcount(),
										freeBoard.getBno()
				);
		return rowNo;
	}
	
	public int delete(int bno){
		String sql = "delete from freeboard where bno=?";
		int rowNo = jdbcTemplate.update(sql, 
										bno
				);
		return rowNo;
	}
	
	public FreeBoard selectByBno(int bno){
		String sql = "select bno, btitle, bcontent, bwriter, bhitcount, bdate from freeboard where bno=?";
		List<FreeBoard> list = jdbcTemplate.query(sql, new Object[]{bno}, new RowMapper<FreeBoard>(){

			@Override
			public FreeBoard mapRow(ResultSet rs, int row) throws SQLException {
				FreeBoard freeBoard = new FreeBoard();
				freeBoard.setBno(rs.getInt("bno"));
				freeBoard.setBtitle(rs.getString("btitle"));
				freeBoard.setBcontent(rs.getString("bcontent"));
				freeBoard.setBwriter(rs.getString("bwriter"));
				freeBoard.setBhitcount(rs.getInt("bhitcount"));
				freeBoard.setBdate(rs.getDate("bdate"));
				return freeBoard;
			}});
		return (list.size()!=0)? list.get(0) : null;
	}
	
	public List<FreeBoard> selectByPage(int pageNo, int rowsPerPage) {
		String sql = "select rn, bno, btitle, bcontent, bhitcount, bwriter, bdate "; 
				sql+="from ( ";
				sql += "select rownum as rn, bno, btitle, bcontent, bhitcount, bwriter, bdate ";
				sql+=" from (select bno, btitle, bcontent, bhitcount, bwriter, bdate from freeboard order by bno desc) ";
				sql+= "where rownum<=? ";
				sql += ") ";
				sql += "where rn>=? ";
		List<FreeBoard> list = jdbcTemplate.query(
			sql,
			new Object[]{(pageNo*rowsPerPage), ((pageNo-1)*rowsPerPage + 1)},
			new RowMapper<FreeBoard>(){

				@Override
				public FreeBoard mapRow(ResultSet rs, int row) throws SQLException {
					FreeBoard freeBoard = new FreeBoard();
					freeBoard.setBno(rs.getInt("bno"));
					freeBoard.setBtitle(rs.getString("btitle"));
					freeBoard.setBcontent(rs.getString("bcontent"));
					freeBoard.setBwriter(rs.getString("bwriter"));
					freeBoard.setBhitcount(rs.getInt("bhitcount"));
					freeBoard.setBdate(rs.getDate("bdate"));
					return freeBoard;
				}}
			);
		return list;
	}
	
	public int count(){
		String sql = "select count(*) from freeboard";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);	// 쿼리문을 실행한 후 하나의 객체를 리턴한다.
		return count;
	}
}
