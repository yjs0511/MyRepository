package com.mycompany.myboard.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myboard.dto.FreeBoard;
import com.mycompany.myboard.dto.Member;

@Component
public class FreeBoardDao {
		
	@Autowired	
	private JdbcTemplate jdbcTemplate;
	
	public int insert(FreeBoard freeBoard){
		String sql="insert into freeboard(bno, btitle, bcontent, bwriter, bhitcount, bdate) values(seq_freeboard_bno.nextval, ?, ?, ?, 0, sysdate)";		
				int row = jdbcTemplate.update(sql,
									  		  freeBoard.getBtitle(),
									  		  freeBoard.getBcontent(),
									  		  freeBoard.getBwriter()
				);
		return row;
	}
	
	public int update(Member member){
		String sql = "update member set mpassword=?, maddress=?, mtel=?, memail=? where mid=?";
		int row = jdbcTemplate.update(sql,
									  member.getMpassword(),
									  member.getMaddress(),
									  member.getMtel(),
									  member.getMemail(),
									  member.getMid()
		);
		return row;
	}
	
	public int delete(String mid){
		String sql="delete from member where mid=?";
		int row = jdbcTemplate.update(sql, mid);
		return row;
		
	}
	
	public Member selectByMid(String mid){
		String sql = "select mid, mname, mpassword, maddress, mtel, memail from member where mid=?";
		List<Member> list = jdbcTemplate.query(sql, new Object[] {mid}, new RowMapper<Member>(){

			@Override
			public Member mapRow(ResultSet rs, int row) throws SQLException {
				Member member = new Member();
				member.setMid(rs.getString("mid"));
				member.setMname(rs.getString("mname"));
				member.setMpassword(rs.getString("mpassword"));
				member.setMaddress(rs.getString("mtel"));
				member.setMemail(rs.getString("memail"));
				return member;
			}});
		return (list.size()!=0)? list.get(0) : null;
	}
	
	public String selectByMemail(String memail){
		String sql = "select mid from member where memail=?";
		List<String> list = jdbcTemplate.query(sql, new Object[]{memail}, new RowMapper<String>(){

			@Override
			public String mapRow(ResultSet rs, int row) throws SQLException {
				return rs.getString("mid");
			}});
		return (list.size()!=0)? list.get(0):null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
