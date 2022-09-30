package com.kim.biz.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.kim.biz.car.CarVO;
import com.kim.biz.manager.ManagerService;
import com.kim.biz.member.MemberVO;

@Controller
@SessionAttributes("data")
public class ManagerController {

	@Autowired
	private ManagerService managerService;

	@RequestMapping(value="manager.do")
	public String ManagerPage(MemberVO mvo, CarVO cvo, Model model, HttpSession session) {
		List<CarVO> cdata = managerService.selectAllC(cvo);
		List<MemberVO> mdata = managerService.selectAllM(mvo);
		model.addAttribute("cdata", cdata);
		model.addAttribute("mdata", mdata);
		return "manager.jsp";
	}
	@RequestMapping(value="managerUpdate.do", method=RequestMethod.POST)
	public String updateCar(@ModelAttribute("data")CarVO cvo, Model model, MultipartHttpServletRequest multipartRequest) throws IllegalStateException, IOException {
		MultipartFile uploadFile = multipartRequest.getFile("file");
		if(!uploadFile.isEmpty()) {//업로드한 파일 존재여부 확인
			String fileName = uploadFile.getOriginalFilename(); //업로드한 파일명
			uploadFile.transferTo(new File("E:\\0607_Lee\\3.wordspaceJSJSP\\varcharmspring\\src\\main\\webapp\\images\\"+fileName)); //저장할 경로 결정
			cvo.setCimg("images\\"+fileName);
			System.out.println("게시글 작성 파일이름 : "+fileName);
		}
		managerService.updateCar(cvo);
		return "manager.do";
	}
	@RequestMapping(value="selectCar.do")
	public String selectCar(CarVO cvo, Model model,HttpSession session) {
		cvo = managerService.selectOne(cvo);
		model.addAttribute("data", cvo);
		System.out.println("업데이트 : "+session.getAttribute("data"));
		return "manager.do";
	}
	@RequestMapping(value="insertCar.do")
	public String insertCar(CarVO cvo, Model model, MultipartHttpServletRequest multipartRequest) {
//		MultipartFile uploadFile = cvo.getUploadFile();
		MultipartFile uploadFile = multipartRequest.getFile("file");
		System.out.println("파일 인서트 : "+uploadFile);
		try {
			
		if(!uploadFile.isEmpty()) {//업로드한 파일 존재여부 확인
			String fileName = uploadFile.getOriginalFilename(); //업로드한 파일명
			uploadFile.transferTo(new File("E:\\0607_Lee\\3.wordspaceJSJSP\\varcharmspring\\src\\main\\webapp\\images\\"+fileName)); //저장할 경로 결정
			cvo.setCimg("images\\"+fileName);
			System.out.println("게시글 작성 파일이름 : "+fileName);
		}
		managerService.insertCar(cvo);
		} catch (Exception e) {
		e.printStackTrace();
		}
		return "manager.do";
	}
	@RequestMapping(value="managerClear.do")
	public String Clear(SessionStatus sessionStatus, HttpSession session) {
		System.out.println("제거 전 세션 값 : "+session.getAttribute("data"));
		session.removeAttribute("data"); //특정 세션 제거
		sessionStatus.setComplete();
		System.out.println("제거 후 세션 값 : "+session.getAttribute("data"));
		return "redirect:manager.do";
	}
}
