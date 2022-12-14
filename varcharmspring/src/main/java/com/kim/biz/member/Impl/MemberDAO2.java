package com.kim.biz.member.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kim.biz.member.MemberVO;

@Repository("memberDAO")
public class MemberDAO2 {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	final String sql_selectOne="SELECT * FROM MEMBER WHERE MID=? AND MPW=?";
	final String sql_selectAll="SELECT * FROM CMEMBER";
	final String sql_insert="INSERT INTO MEMBER VALUES(?,?,?,?)";
	final String sql_update="UPDATE MEMBER SET MPW=?, NAME=? WHERE MID=?";
	final String sql_delete="DELETE MEMBER WHERE MID=?";
	
	public void insertMember(MemberVO vo) {
		System.out.println("dao2 지나감");
		jdbcTemplate.update(sql_insert,vo.getMid(),vo.getMpw(),vo.getMname(),vo.getMrole());
	}
	public void deleteMember(MemberVO vo) {
		jdbcTemplate.update(sql_delete,vo.getMid(),vo.getMpw());
	}
	public void updateMember(MemberVO vo) {
		jdbcTemplate.update(sql_update,vo.getMpw(),vo.getMname(),vo.getMid());
	}
	public MemberVO selectOneMember(MemberVO vo) {
		System.out.println("dao2 지나감");
		Object[] args= {vo.getMid(),vo.getMpw()};
		return jdbcTemplate.queryForObject(sql_selectOne,args,new MemberRowMapper());
	}
	public List<MemberVO> selectAllMember(MemberVO vo) {
		return jdbcTemplate.query(sql_selectAll,new MemberRowMapper());
	}
}
class MemberRowMapper implements RowMapper<MemberVO> {

	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO data=new MemberVO();
		data.setMid(rs.getString("mid"));
		data.setMpw(rs.getString("mpw"));
		data.setMname(rs.getString("mname"));
		data.setMnickname(rs.getString("mnickname"));
		data.setMadd(rs.getString("madd"));
		data.setMphone(rs.getString("mphone"));
		data.setMemail(rs.getString("memail"));
		data.setMrole(rs.getString("mrole"));
		return data;
	}
	
}