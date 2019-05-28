package jp.co.central_soft.train2019.bean;

import java.io.Serializable;
import java.time.LocalDateTime;

public class IdInputBean implements Serializable
{
	private String userId;
	private String name;
	private LocalDateTime loginDateTime;
	private String message ="";

	public LoginInfo getLoginInfo()
	{
		return new LoginInfo(userId, name, loginDateTime );

	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
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

	public void setLoginInfo(LoginInfo attribute)
	{
		this.loginDateTime 	= attribute.getLoginDateTime();
		this.name 			= attribute.getName();
		this.userId 		= attribute.getUserId();
	}



}
