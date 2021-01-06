package com.exhibition.project.BoardDto;

public class BoardDto {
	private int board_num;
	private String userid;
	private String boardtopic;
	private String rdate;
	private int nClick;
	private String board_comment;
	private int bGroup;
	private int bStep;
	private int bIndent;
	
	BoardDto(){
		
	}
	

	public BoardDto(int board_num, String userid, String boardtopic, String rdate, int nClick, String board_comment,
			int bGroup, int bStep, int bIndent) {
		super();
		this.board_num = board_num;
		this.userid = userid;
		this.boardtopic = boardtopic;
		this.rdate = rdate;
		this.nClick = nClick;
		this.board_comment = board_comment;
		this.bGroup = bGroup;
		this.bStep = bStep;
		this.bIndent = bIndent;
	}


	public int getBoard_num() {
		return board_num;
	}

	public String getUserid() {
		return userid;
	}

	public String getBoardtopic() {
		return boardtopic;
	}

	public String getRdate() {
		return rdate;
	}

	public int getnClick() {
		return nClick;
	}

	public String getBoard_comment() {
		return board_comment;
	}

	public int getbGroup() {
		return bGroup;
	}

	public int getbStep() {
		return bStep;
	}

	public int getbIndent() {
		return bIndent;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public void setBoardtopic(String boardtopic) {
		this.boardtopic = boardtopic;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public void setnClick(int nClick) {
		this.nClick = nClick;
	}

	public void setBoard_comment(String board_comment) {
		this.board_comment = board_comment;
	}

	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}

	public void setbStep(int bStep) {
		this.bStep = bStep;
	}

	public void setbIndent(int bIndent) {
		this.bIndent = bIndent;
	}
	
}



