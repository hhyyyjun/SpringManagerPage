package com.kim.biz.car;

import org.springframework.web.multipart.MultipartFile;

public class CarVO {
	private int cnum;
	private String ctitle;
	private String csubtitle;
	private int cyear;
	private String cfuel;
	private int ckm;
	private int cprice;
	private String ccity;
	private int cnt;

	//파일 경로 저장할 변수
	private String cimg;

	//파일 업로드
	private MultipartFile uploadFile;
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public String getCtitle() {
		return ctitle;
	}
	public void setCtitle(String ctitle) {
		this.ctitle = ctitle;
	}
	public String getCsubtitle() {
		return csubtitle;
	}
	public void setCsubtitle(String csubtitle) {
		this.csubtitle = csubtitle;
	}
	public int getCyear() {
		return cyear;
	}
	public void setCyear(int cyear) {
		this.cyear = cyear;
	}
	public String getCfuel() {
		return cfuel;
	}
	public void setCfuel(String cfuel) {
		this.cfuel = cfuel;
	}
	public int getCkm() {
		return ckm;
	}
	public void setCkm(int ckm) {
		this.ckm = ckm;
	}
	public int getCprice() {
		return cprice;
	}
	public void setCprice(int cprice) {
		this.cprice = cprice;
	}
	public String getCcity() {
		return ccity;
	}
	public void setCcity(String ccity) {
		this.ccity = ccity;
	}
	public String getCimg() {
		return cimg;
	}
	public void setCimg(String cimg) {
		this.cimg = cimg;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "CarVO [cnum=" + cnum + ", ctitle=" + ctitle + ", csubtitle=" + csubtitle + ", cyear=" + cyear
				+ ", cfuel=" + cfuel + ", ckm=" + ckm + ", cprice=" + cprice + ", ccity=" + ccity + ", cimg=" + cimg
				+ ", cnt=" + cnt + "]";
	}






}