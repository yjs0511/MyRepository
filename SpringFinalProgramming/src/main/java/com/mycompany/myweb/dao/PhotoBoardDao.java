package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.FreeBoard;
import com.mycompany.myweb.dto.PhotoBoard;

@Component
public class PhotoBoardDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int insert(PhotoBoard photoBoard){
		String sql="insert into photoboard(bno, btitle, bcontent, bwriter, bhitcount, bdate, originalfile, savedfile, mimetype) values(seq_photoboard_bno.nextval, ?, ?, ?, 0, sysdate, ?, ?, ?)";
		int rowNo = jdbcTemplate.update(sql, 
										photoBoard.getBtitle(),
										photoBoard.getBcontent(),
										photoBoard.getBwriter(),
										photoBoard.getOriginalfile(),
										photoBoard.getSavedfile(),
										photoBoard.getMimetype()
										);
		return rowNo;
	}
	
	public int update(PhotoBoard photoBoard){
		String sql = "update photoboard set btitle=?, bcontent=?, bhitcontent=?, originalfile=?, savedfile=?, mimefile=? where bno=?";
		int rowNo = jdbcTemplate.update(sql, 
										photoBoard.getBtitle(),
										photoBoard.getBcontent(),
										photoBoard.getBwriter(),
										photoBoard.getOriginalfile(),
										photoBoard.getSavedfile(),
										photoBoard.getMimetype(),
										photoBoard.getBno()
				);
		return rowNo;
	}
	
	public int delete(int bno){
		String sql = "delete from photoboard where bno=?";
		int rowNo = jdbcTemplate.update(sql, bno);
		return rowNo;
	}
	
	public PhotoBoard selectByBno(int bno){
		String sql = "select bno, btitle, bcontent, bwriter, bhitcount, bdate, originalfile, savedfile, mimetype from photoboard where bno=?";
		List<PhotoBoard> list = jdbcTemplate.query(sql, new Object[]{bno}, new RowMapper<PhotoBoard>(){

			@Override
			public PhotoBoard mapRow(ResultSet rs, int row) throws SQLException {
				PhotoBoard photoBoard = new PhotoBoard();
				photoBoard.setBno(rs.getInt("bno"));
				photoBoard.setBtitle(rs.getString("btitle"));
				photoBoard.setBcontent(rs.getString("bcontent"));
				photoBoard.setBwriter(rs.getString("bwriter"));
				photoBoard.setBhitcount(rs.getInt("bhitcount"));
				photoBoard.setBdate(rs.getDate("bdate"));
				photoBoard.setOriginalfile(rs.getString("orginalfile"));
				photoBoard.setSavedfile(rs.getString("savedfile"));
				photoBoard.setMimetype(rs.getString("mimetype"));
				return photoBoard;
			}});
		return (list.size()!=0)? list.get(0) : null;
	}
	
	public List<PhotoBoard> selectByPage(int pageNo, int rowsPerPage) {
		String sql = "select rn, bno, btitle, bhitcount, savedfile ";	// 단순히 브라우저 상에 보여주기만 할 거면 savedfile을 쓰는게 낫다 (orginalfile은 다운로드 할 때 사용) 
				sql+="from ( ";
				sql += "select rownum as rn, bno, btitle, bhitcount, savedfile ";
				sql+=" from (select bno, btitle, bhitcount, savedfile from photoboard order by bno desc) ";
				sql+= "where rownum<=? ";
				sql += ") ";
				sql += "where rn>=? ";
		List<PhotoBoard> list = jdbcTemplate.query(
			sql,
			new Object[]{(pageNo*rowsPerPage), ((pageNo-1)*rowsPerPage + 1)},
			new RowMapper<PhotoBoard>(){

				@Override
				public PhotoBoard mapRow(ResultSet rs, int row) throws SQLException {
					PhotoBoard photoBoard = new PhotoBoard();
					photoBoard.setBno(rs.getInt("bno"));
					photoBoard.setBtitle(rs.getString("btitle"));
					photoBoard.setBhitcount(rs.getInt("bhitcount"));
					photoBoard.setSavedfile(rs.getString("savedfile"));
					return photoBoard;
				}}
			);
		return list;
	}
	
	public int count(){
		String sql = "select count(*) from photoboard";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);	// 쿼리문을 실행한 후 하나의 객체를 리턴한다.
		return count;
	}
}
