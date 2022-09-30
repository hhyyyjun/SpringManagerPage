package com.kim.biz.manager.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kim.biz.car.CarVO;
import com.kim.biz.member.MemberVO;

@Repository("managerDAO")
public class ManagerDAO2 {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	final String sql_selectAllC ="SELECT * FROM CAR ORDER BY CNUM ASC";	
	final String sql_selectAllM ="SELECT * FROM CMEMBER ORDER BY MID ASC";
	final String sql_insert = "INSERT INTO CAR VALUES((SELECT NVL(MAX(CNUM),0) +1 FROM CAR),?,?,?,?,?,?,?,?)";
	final String sql_selectOne="SELECT * FROM CAR WHERE CNUM=?";
	final String sql_update = "UPDATE CAR SET CTITLE=?, CSUBTITLE=?, CYEAR=?, CFUEL=?, CKM=?, CPRICE=?, CCITY=?, CIMG=? WHERE CNUM=?";

	public void update(CarVO vo) { 
		jdbcTemplate.update(sql_update,vo.getCtitle(),vo.getCsubtitle(),vo.getCyear(),vo.getCfuel(),vo.getCkm(),vo.getCprice(),vo.getCcity(),vo.getCimg(),vo.getCnum());
	}
	public void insert(CarVO vo) {
		jdbcTemplate.update(sql_insert, vo.getCtitle(),vo.getCsubtitle(),vo.getCyear(),vo.getCfuel(),vo.getCkm(),vo.getCprice(),vo.getCcity(),vo.getCimg());
	}
	public CarVO selectOne(CarVO vo) {
		Object[] args= {vo.getCnum()};
		return jdbcTemplate.queryForObject(sql_selectOne, args,new CarManagerRowMapper());
	}
	public List<CarVO> selectAllCar(CarVO vo){  
		return jdbcTemplate.query(sql_selectAllC,new CarManagerRowMapper());
	}	
	public List<MemberVO> selectAllMember(MemberVO vo){ 
		return jdbcTemplate.query(sql_selectAllM,new MemberManagerRowMapper());
	}
}
class CarManagerRowMapper implements RowMapper<CarVO>{

	@Override
	public CarVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CarVO cvo = new CarVO();
		cvo.setCtitle(rs.getString("ctitle"));
		cvo.setCsubtitle(rs.getString("csubtitle"));
		cvo.setCfuel(rs.getString("cfuel"));
		cvo.setCkm(rs.getInt("ckm"));
		cvo.setCprice(rs.getInt("cprice"));
		cvo.setCcity(rs.getString("ccity"));
		cvo.setCyear(rs.getInt("cyear"));
		cvo.setCimg(rs.getString("cimg"));
		cvo.setCnum(rs.getInt("cnum"));
		return cvo;
	}
}
class MemberManagerRowMapper implements RowMapper<MemberVO>{

	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO mvo=new MemberVO();
		mvo.setMid(rs.getString("mid")); //출력에 쓰일 것들
		mvo.setMpw(rs.getString("mpw"));
		mvo.setMname(rs.getString("mname"));
		mvo.setMnickname(rs.getString("mnickname"));
		mvo.setMadd(rs.getString("madd"));
		mvo.setMphone(rs.getString("mphone"));
		mvo.setMemail(rs.getString("memail"));
		mvo.setMrole(rs.getString("mrole"));
		return mvo;
	}
}
