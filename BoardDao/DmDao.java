package com.exhibition.project.BoardDao;

import java.util.ArrayList;

import com.exhibition.project.BoardDto.DmDto;

public interface DmDao {

	//ArrayList<DmDto> userDm(String userid);
	ArrayList<DmDto> userDm(String Userid);

	int userDmCnt(String userid);
}
