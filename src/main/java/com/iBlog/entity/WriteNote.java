package com.iBlog.entity;

public class WriteNote {
	private int oid;
	private String noteTitle;
	private String noteContent;
	private String username;
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getNoteTitle() {
		return noteTitle;
	}
	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}
	public String getNoteContent() {
		return noteContent;
	}
	public void setNoteContent(String noteContent) {
		this.noteContent = noteContent;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "WriteNote [oid=" + oid + ", noteTitle=" + noteTitle
				+ ", noteContent=" + noteContent + ", username=" + username
				+ "]";
	}
	public WriteNote() {
		super();
	}
	
}
