package com.iBlog.entity;

public class WriteNote {
	private int oid;
	private String note_title;
	private String note_content;
	private String username;
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getNote_title() {
		return note_title;
	}
	public void setNote_title(String note_title) {
		this.note_title = note_title;
	}
	public String getNote_content() {
		return note_content;
	}
	public void setNote_content(String note_content) {
		this.note_content = note_content;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public WriteNote(int oid, String note_title, String note_content,
			String username) {
		super();
		this.oid = oid;
		this.note_title = note_title;
		this.note_content = note_content;
		this.username = username;
	}
	public WriteNote() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
