package com.iBlog.entity;
public class UserInfo {
	private String username;
	private String password;
	private String nick;
	private String headPhoto;
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
	public String getHeadPhoto() {
		return headPhoto;
	}
	public void setHeadPhoto(String headPhoto) {
		this.headPhoto = headPhoto;
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
	@Override
	public String toString() {
		return "UserInfo [username=" + username + ", password=" + password
				+ ", nick=" + nick + ", headPhoto=" + headPhoto
				+ ", telephone=" + telephone + ", address=" + address
				+ ", createTime=" + createTime + "]";
	}
	public UserInfo() {
		super();
	}
	
}
