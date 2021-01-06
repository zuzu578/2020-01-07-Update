package com.exhibition.project.BoardDto;

public class DmDto {
	private String userid ;
	private String writer ;
	private String title ;
	private String message ;
	private String rdate ;
	DmDto(){
		
	}
	
	public DmDto(String userid, String writer, String title, String message, String rdate) {
		super();
		this.userid = userid;
		this.writer = writer;
		this.title = title;
		this.message = message;
		this.rdate = rdate;
	}

	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	
	
}
