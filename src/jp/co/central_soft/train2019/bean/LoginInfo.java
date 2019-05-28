package jp.co.central_soft.train2019.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

public class LoginInfo implements Serializable
{
	private String userId;
	private String name;
	private LocalDateTime loginDateTime;


	public LoginInfo(String userId, String name, LocalDateTime loginDateTime) {
		super();
		this.userId = userId;
		this.name = name;
		this.loginDateTime = loginDateTime;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getLoginDateTime() {
		return loginDateTime;
	}
	public void setLoginDateTime(LocalDateTime loginDateTime) {
		this.loginDateTime = loginDateTime;
	}



}
