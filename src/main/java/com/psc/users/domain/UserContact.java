package com.psc.users.domain;

public class UserContact {
	
	private int userid;
	private String cntctName;
	private String cntctEmail;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getCntctName() {
		return cntctName;
	}
	public void setCntctName(String cntctName) {
		this.cntctName = cntctName;
	}
	public String getCntctEmail() {
		return cntctEmail;
	}
	public void setCntctEmail(String cntctEmail) {
		this.cntctEmail = cntctEmail;
	}
	
	@Override
	public String toString() {
		return "UserContact [userid=" + userid + ", cntctName=" + cntctName
				+ ", cntctEmail=" + cntctEmail + "]";
	}

}
