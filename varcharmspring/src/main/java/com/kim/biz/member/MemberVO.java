package com.kim.biz.member;

public class MemberVO {
    private String mid;         //회원 ID(PK) 
    private String mpw;         //회원 비밀번호
    private String mname;       //회원 이름 
    private String mnickname;   //회원 닉네임
    private String madd;        //회원 주소 
    private String mphone;      //회원 번호 
    private String memail;      //회원 이메일 
    private String mrole;        //계정 권한 
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMnickname() {
		return mnickname;
	}
	public void setMnickname(String mnickname) {
		this.mnickname = mnickname;
	}
	public String getMadd() {
		return madd;
	}
	public void setMadd(String madd) {
		this.madd = madd;
	}
	public String getMphone() {
		return mphone;
	}
	public void setMphone(String mphone) {
		this.mphone = mphone;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	public String getMrole() {
		return mrole;
	}
	public void setMrole(String mrole) {
		this.mrole = mrole;
	}
	@Override
	public String toString() {
		return "MemberVO [mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", mnickname=" + mnickname + ", madd="
				+ madd + ", mphone=" + mphone + ", memail=" + memail + ", mrole=" + mrole + "]";
	}
  
   
    
    
}