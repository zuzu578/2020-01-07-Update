package com.exhibition.project.BoardDto;

public class AdminNoticeDto {
	private int board_num;
	private String userid;
	private String boardtopic;
	private String board_comment;
	private String rdate;
	private int nClick;
	private int bGroup;
	private int bStep;
	private int bIndent;
	AdminNoticeDto(){
		
	}
	
	public AdminNoticeDto(int board_num, String userid, String boardtopic, String board_comment, String rdate,
			int nClick, int bGroup, int bStep, int bIndent) {
		super();
		this.board_num = board_num;
		this.userid = userid;
		this.boardtopic = boardtopic;
		this.board_comment = board_comment;
		this.rdate = rdate;
		this.nClick = nClick;
		this.bGroup = bGroup;
		this.bStep = bStep;
		this.bIndent = bIndent;
	}

	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getBoardtopic() {
		return boardtopic;
	}
	public void setBoardtopic(String boardtopic) {
		this.boardtopic = boardtopic;
	}
	public String getBoard_comment() {
		return board_comment;
	}
	public void setBoard_comment(String board_comment) {
		this.board_comment = board_comment;
	}
	public String getRdate() {
		return rdate;
	}
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}
	public int getnClick() {
		return nClick;
	}
	public void setnClick(int nClick) {
		this.nClick = nClick;
	}
	public int getbGroup() {
		return bGroup;
	}
	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}
	public int getbStep() {
		return bStep;
	}
	public void setbStep(int bStep) {
		this.bStep = bStep;
	}
	public int getbIndent() {
		return bIndent;
	}
	public void setbIndent(int bIndent) {
		this.bIndent = bIndent;
	}
	
}
