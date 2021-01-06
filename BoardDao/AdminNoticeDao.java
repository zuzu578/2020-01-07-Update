package com.exhibition.project.BoardDao;

import java.util.ArrayList;

import com.exhibition.project.BoardDto.AdminNoticeDto;

public interface AdminNoticeDao {

	public void AdminInsert(String boardtopic,String userid,String board_comment);

	public ArrayList<AdminNoticeDto> AdaoPagelist(int itemFirstNum, int itemLastNum);

	public AdminNoticeDto board_view(int board_num);

	public void upHit(int board_num);

	public void Doboard_update(int board_num, String userid, String boardtopic, String board_comment);

	public void Doboard_delete(int board_num);

}
