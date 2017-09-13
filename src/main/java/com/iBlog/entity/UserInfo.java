package com.iBlog.entity;
public class UserInfo {
	private String username;
	private String password;
	private String nick;
	private String head_photo;
	private String telephone;
	private String address;
	private String createTime;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getHead_photo() {
		return head_photo;
	}
	public void setHead_photo(String head_photo) {
		this.head_photo = head_photo;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public UserInfo(String username, String password, String nick,
			String head_photo, String telephone, String address,
			String createTime) {
		super();
		this.username = username;
		this.password = password;
		this.nick = nick;
		this.head_photo = head_photo;
		this.telephone = telephone;
		this.address = address;
		this.createTime = createTime;
	}
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
