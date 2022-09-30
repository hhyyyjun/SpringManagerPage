package com.kim.biz.member.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kim.biz.member.MemberService;
import com.kim.biz.member.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	//2022.09.26
	@Autowired // MemberDAO Ÿ���� ��ü�� �޸𸮿� �־������ DI(������ ����) ������!
	private MemberDAO2 memberDAO; // �ٽɷ����� ������ ��ü
	
	@Override
	public void insertMember(MemberVO vo) {
		memberDAO.insertMember(vo);
	}

	@Override
	public void deleteMember(MemberVO vo) {
		memberDAO.deleteMember(vo);
	}

	@Override
	public void updateMember(MemberVO vo) {
		memberDAO.updateMember(vo);
	}

	@Override
	public MemberVO selectOneMember(MemberVO vo) {
		if(vo.getMid().equals("timo")) {
			throw new IllegalArgumentException("[����ÿ���]");
		}
		return memberDAO.selectOneMember(vo);
	}

	@Override
	public List<MemberVO> selectAll(MemberVO vo) {
		return memberDAO.selectAllMember(vo);
	}
}
