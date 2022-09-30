package com.kim.biz.manager;

import java.util.List;

import com.kim.biz.car.CarVO;
import com.kim.biz.member.MemberVO;

public interface ManagerService {
	public void insertCar(CarVO vo);
	public void updateCar(CarVO vo);
	public CarVO selectOne(CarVO vo);
	public List<MemberVO> selectAllM(MemberVO vo);
	public List<CarVO> selectAllC(CarVO vo);
	
}
