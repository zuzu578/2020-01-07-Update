package com.exhibition.project;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exhibition.project.BoardDao.AdminNoticeDao;
import com.exhibition.project.BoardDao.BoardDao;
import com.exhibition.project.BoardDao.DmDao;
import com.exhibition.project.BoardDto.AdminNoticeDto;
import com.exhibition.project.BoardDto.BoardDto;
import com.exhibition.project.BoardDto.DmDto;




@Controller
public class BoardController{
	@Autowired
	// ==> Userid ==>현재 내가 로그인한 상태의 id 
	//==> userid ==>다른 사람의 id 
	private SqlSession sqlSession;
	private String Userid;
	//Rankingid ==>
	private String Rankingid;
	private String Admin;
	//myDm
	@RequestMapping("/AdminUpdate")
	public String AdminUpdate(HttpServletRequest req, Model model) {
		
		String board_num = req.getParameter("board_num");
		System.out.println("debugNum1");
		System.out.println(board_num);
		System.out.println("debugNum2");
		AdminNoticeDao Adao = sqlSession.getMapper(AdminNoticeDao.class);
		System.out.println("debugNum3");
		AdminNoticeDto Adto = Adao.board_view(Integer.parseInt(board_num));
		System.out.println("debugNum4");
		 
		Adao.upHit(Integer.parseInt(board_num));
		System.out.println(board_num);
		
		model.addAttribute("Adto", Adto);
		
		return "AdminUpdate";
	}
	@RequestMapping("/DoUpdateAdmin")
	public String DoUpdateAdmin(HttpServletRequest req ,Model model) {

		String hidden = req.getParameter("hidden");
		System.out.println(hidden);
		if (hidden.equals("modify")) {
			String board_num = req.getParameter("board_num");
			String boardtopic = req.getParameter("boardtopic");
			String userid = req.getParameter("userid");
			String board_comment = req.getParameter("board_comment");
			System.out.println(board_num);
			System.out.println(boardtopic);
			System.out.println(userid);
			System.out.println(board_comment);

			// ==>interface Dao <==//
			AdminNoticeDao dao = sqlSession.getMapper(AdminNoticeDao.class);

			dao.Doboard_update(Integer.parseInt(board_num), boardtopic, userid, board_comment);
			model.addAttribute("board_view", dao);
			return "redirect:http://localhost:8080/project/board?pageNum=1";
		} else {

			String board_num = req.getParameter("board_num");

			// ==>interface Dao <==//
			AdminNoticeDao dao = sqlSession.getMapper(AdminNoticeDao.class);

			dao.Doboard_delete(Integer.parseInt(board_num));
			model.addAttribute("board_view", dao);
			return "redirect:http://localhost:8080/project/board?pageNum=1";

		}

	
	}
	//어드민이 공지글 쓸때 
	@RequestMapping("/AdminNotice")
	public String AdminNotice() {
		return "AdminNotice";
	}
	
	@RequestMapping("/AdminNoticeContentView")
	public String AdminNoticeContentView(HttpServletRequest req, Model model) {
		String board_num = req.getParameter("board_num");
		Userid = "minttears";
		System.out.println(board_num);
		AdminNoticeDao Adao = sqlSession.getMapper(AdminNoticeDao.class);
		AdminNoticeDto Adto = Adao.board_view(Integer.parseInt(board_num));
		 
		 
		Adao.upHit(Integer.parseInt(board_num));
		System.out.println(board_num);
		model.addAttribute("Userid", Userid);
		model.addAttribute("Adto", Adto);
		
		//model.addAttribute("Userid", Userid);
		
		
		
		
		return "AdminNoticeContentView";
	}
	@RequestMapping("/AdminNoticeView")
	public String viewAdminList(HttpServletRequest req, Model model) {
		 AdminNoticeDao Adao = sqlSession.getMapper(AdminNoticeDao.class);
		int boardCount = boardCount();
		int pageNum=Integer.parseInt(req.getParameter("pageNum"));  // 화면에서 한 페이지 번호
		double itemPerPage=6.0;  // 한 페이지당 item수
		int itemFirstNum=((int)itemPerPage)*(pageNum-1)+1;  // 첫 번째 item 번호 (페이지별)
		int pageLastNum=(int)Math.ceil(boardCount/itemPerPage);  // 마지막 페이지 수
		int LastPageItemNum
		
		=boardCount-(pageLastNum-1)*((int)itemPerPage);  // 마지막 페이지 마지막item수
		// 마지막 번째 item 번호 (페이지별)
		int itemLastNum=0;
		if(pageNum<pageLastNum){
			itemLastNum=((int)itemPerPage)*pageNum;
		}else {
			itemLastNum=LastPageItemNum+(((int)itemPerPage)*(pageNum-1));
		}
		//int item_cnt=itemCount(category);
		System.out.println("itemFirstNum : "+itemFirstNum);
		System.out.println("pageLastNum : "+pageLastNum);
		System.out.println("LastPageItemNum : "+LastPageItemNum);
		System.out.println(itemLastNum);
	
		System.out.println("boardCount : "+boardCount);
		//Adao=sqlSession.getMapper(AdminNoticeDao.class);
		model.addAttribute("board",Adao.AdaoPagelist(itemFirstNum,itemLastNum));
		model.addAttribute("pageLastNum",pageLastNum);
		
		model.addAttribute("pageNum",pageNum);
		
		return "AdminNoticeView";
	}
	//어드민 공지글 쓰기 
	@RequestMapping(value = "/WriteAdminNotice", method = RequestMethod.POST)
	public String AdminNotice(HttpServletRequest req, Model model) {
		 System.out.println("Admin1");
		 String boardtopic = req.getParameter("boardtopic");
		 System.out.println("Admin2");
		 String userid = req.getParameter("userid");
		 System.out.println("Admin3");
		 String board_comment =req.getParameter("board_comment");
		 System.out.println("Admin4");
		 System.out.println(boardtopic);
		 System.out.println(userid);
		 System.out.println(board_comment);
		 System.out.println("Admin5");
		 
		 AdminNoticeDao Adao = sqlSession.getMapper(AdminNoticeDao.class);
		 Adao.AdminInsert(userid,boardtopic,board_comment);
		 

		
		 
		 
		
		return "redirect:http://localhost:8080/project/AdminNoticeView?pageNum=1";
		
	}
	@RequestMapping("/ReplyDm")
	public String ReplyDm(HttpServletRequest req, Model model) {
		String writer = req.getParameter("writer");
		Userid = "minttears";
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		ArrayList<BoardDto> dtos = dao.userlist(Userid);
		String user = dao.checkuser(Userid);
		System.out.println(user);
		model.addAttribute("writer", writer);
	    int cnt = dao.userCount(Userid);
	    String rdate = dao.userDate(Userid);
	    model.addAttribute("rdate",rdate);
	    model.addAttribute("cnt",cnt);
		model.addAttribute("dtos", dtos);
		
		//==>userid 표기 //
		model.addAttribute("userid",Userid);
		return "ReplyDm";
	}
	@RequestMapping("/RankingStyle")
	public String RankingStyle(HttpServletRequest req, Model model) {
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		System.out.println("RankingStyle");
		//Hit ==> 랭킹 유저 의 값을 변수에 저장//+ 전역변수에 저장 //
		String Hit = dao.firstRanking();
		Rankingid = Hit;
		String Rcount = dao.RankingCount(Rankingid);
		
		System.out.println("RankingStyle2");
		String Rank = dao.firstRanking();
		System.out.println("RankingStyle3");
		String click = dao.firstRankingNclick();
		System.out.println("RankingStyle4");
		System.out.println(Rankingid);
		
		System.out.println(Rankingid);
		System.out.println("RankingStyle5");
		System.out.println(Rank);
		System.out.println("RankingStyle6");
		System.out.println(click);
		System.out.println("RankingStyle7");
		System.out.println(Rcount);
		System.out.println("RankingStyle8");
		
		ArrayList<BoardDto> UserRanking = dao.UserRanking();
		model.addAttribute("UserRanking", UserRanking);
		model.addAttribute("Rcount", Rcount);
		model.addAttribute("click", click);
		model.addAttribute("Rank", Rank);
		return "RankingStyle";
	}
	
	
	@RequestMapping("/mydm")
	public String myDM(HttpServletRequest req, Model model) {
		Userid = "minttears";
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		ArrayList<BoardDto> dtos = dao.userlist(Userid);
		String user = dao.checkuser(Userid);
		System.out.println(user);
		
	    int cnt = dao.userCount(Userid);
	    String rdate = dao.userDate(Userid);
	    model.addAttribute("rdate",rdate);
	    model.addAttribute("cnt",cnt);
		model.addAttribute("dtos", dtos);
		//==>userid 표기 //
		model.addAttribute("userid",Userid);
		
		//==>DM 보기 <==//
	
			
		
		System.out.println("debug1");
		DmDao dm = sqlSession.getMapper(DmDao.class);
		//ArrayList<DmDto> Dm = dm.userDm(Userid);
		ArrayList<DmDto> Dm = dm.userDm(Userid);
		int DmCnt = dm.userDmCnt(Userid);
		System.out.println("debug2");
		System.out.println(Userid);
		model.addAttribute("Dm", Dm);
		model.addAttribute("DmCnt", DmCnt);
		System.out.println("debug3");
		
		
		return "MyDM";
		
		}
	//DirectMessage
	@RequestMapping("/DM")
	public String DM(HttpServletRequest req, Model model) {
		String userid = req.getParameter("userid");
		//Userid ==>현재 로그인한 상태 
		Userid = "minttears";
		BoardDao dao= sqlSession.getMapper(BoardDao.class);
		String date = dao.userDate(userid);
		//dm 버튼을 눌렀을때 클릭한 유저의 게시물을확인 
		int DmCount = dao.DmCount(userid);
		model.addAttribute("userid", userid);
		model.addAttribute("date", date);
		model.addAttribute("Userid",Userid);
		model.addAttribute("DmCount", DmCount);
		/*
		Userid = "minttears";
		int cnt = dao.userCount(Userid);
		String date = dao.userDate(Userid);
		String userid = req.getParameter("userid");
		model.addAttribute("cnt", cnt);
		model.addAttribute("userid",userid);
		model.addAttribute("Userid",Userid);
		model.addAttribute("date",date);
		*/
		return "DirectMessage";
	}
	
	
	@RequestMapping("/myCommunity")
	public String myCommunity(HttpServletRequest req , Model model) {
		Userid = "minttears";
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		ArrayList<BoardDto> dtos = dao.userlist(Userid);
	    int cnt = dao.userCount(Userid);
	    String rdate = dao.userDate(Userid);
	    model.addAttribute("rdate",rdate);
	    model.addAttribute("cnt",cnt);
		model.addAttribute("dtos", dtos);
		//==>userid 표기 //
		model.addAttribute("userid",Userid);
		
		
		return "myCommunity";
	}
	@RequestMapping("/DirectMessage")
	public String DirectMessage(HttpServletRequest req, Model model) {
		String userid = req.getParameter("userid");
		String writer = req.getParameter("writer");
		String title = req.getParameter("title");
		String message = req.getParameter("message");
		System.out.println(userid);
		System.out.println(writer);
		System.out.println(title);
		System.out.println(message);
		
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		//ArrayList<DirectMessge> dm = dao.message(userid, writer , title, message);
		dao.message(userid, writer, title, message);
		
		return "redirect:http://localhost:8080/project/board?pageNum=1";
	}
	
	//페이징//
	@RequestMapping("/Next")
	public String Next(HttpServletRequest req, Model model) {
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		ArrayList<BoardDto> dtos = dao.listPage();
		model.addAttribute("dtos", dtos);
		return "board";
	}
	// ==> 게시판 글 읽어오기 <==//
	@RequestMapping("/new12")
	public String new12() {
		return "new12";
	}
	public String Rankingid() {
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		Userid = dao.UserTop();
		return"";
	}
	//게시판을 했더라면 ..?//
	@RequestMapping(value = "/IfBoard", method = RequestMethod.POST)
	public String IfBoard(HttpServletRequest req, Model model) {
		String userid = req.getParameter("userid");
		Userid=userid;
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		int checkCount = dao.memberCheck(userid);
		String time = dao.userDate(userid);
		model.addAttribute("time", time);
		model.addAttribute("checkCount", checkCount);
		model.addAttribute("userid",userid);
		return "IfBoard";
		
	}
	@RequestMapping("/Sort_items")
	public String Sort_items(HttpServletRequest req, Model model){
		String sort = req.getParameter("sort");
		System.out.println(sort);
		
		if(sort.equals("viewDsc")) {
			BoardDao dao = sqlSession.getMapper(BoardDao.class);
			ArrayList<BoardDto> ViewDescList = dao.ViewDescList();
			model.addAttribute("ViewDescList", ViewDescList);
			return "viewDsc";
			
		}else if(sort.equals("viewAsc")) {
				BoardDao dao = sqlSession.getMapper(BoardDao.class);
				ArrayList<BoardDto> ViewAsc = dao.ViewAscList();
				model.addAttribute("ViewAsc",ViewAsc );
				return "viewAsc";
			
		}else if(sort.equals("dateDsc")) {
				BoardDao dao = sqlSession.getMapper(BoardDao.class);	
				ArrayList<BoardDto>ViewDateDsc = dao.ViewDateDsc();
				model.addAttribute("ViewDateDsc", ViewDateDsc);
				return "viewDateDsc";
		}else if(sort.equals("dateAsc")) {
				BoardDao dao = sqlSession.getMapper(BoardDao.class);	
				ArrayList<BoardDto>ViewDateAsc = dao.ViewDateAsc();
				model.addAttribute("ViewDateAsc", ViewDateAsc);
				return "viewDateAsc";
		}
		return sort;
		
			
	}
	@RequestMapping("/RankingPage")
	public String RankingPage(HttpServletRequest req, Model model) {
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		String Hit = dao.firstRanking();
		String nClick = dao.firstRankingNclick();
		ArrayList<BoardDto> UserRanking = dao.UserRanking();
		model.addAttribute("UserRanking", UserRanking);
		
		Rankingid = Hit;
	
		int userCount = dao.UserCount();
		String Rcount = dao.RankingCount(Rankingid);
		model.addAttribute("userCount",userCount);
		model.addAttribute("Rcount", Rcount);
		model.addAttribute("nClick",nClick);
		model.addAttribute("Hit", Hit);
		return "RankingPage";
	}
	
	//없는 유저를 검색시에//
	@RequestMapping("/UserNotFound")
	public String UserNotFound() {
		return "UserNotFound";
	}
	// report//
	@RequestMapping("/report")
	public String report(HttpServletRequest req, Model model) {
		System.out.println("댓글쓰기()");
		int board_num = Integer.parseInt(req.getParameter("board_num"));
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		BoardDto dto = dao.board_view(board_num);
		dao.upHit(board_num);
		System.out.println(board_num);
		model.addAttribute("reply_view", dto);
		model.addAttribute("Userid", Userid);
		dao = sqlSession.getMapper(BoardDao.class);
		ArrayList<BoardDto> dtos = dao.list();
		model.addAttribute("dtos", dtos);

		return "report";
	}

	@RequestMapping("/try_report")
	public String Doreport(HttpServletRequest req, Model model) {
		// int board_num = Integer.parseInt(req.getParameter("board_num"));
		String userid = req.getParameter("userid");
		String boardTitle = req.getParameter("boardTitle");
		String board_comment = req.getParameter("board_comment");
		String report_comment = req.getParameter("report_comment");

		System.out.println(userid);
		System.out.println(boardTitle);
		System.out.println(board_comment);
		System.out.println(report_comment);
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		dao.try_report(userid, boardTitle, board_comment, report_comment);
		// int board_num = Integer.parseInt(req.getParameter("board_num"));
		/*
		 * BoardDao dao = sqlSession.getMapper(BoardDao.class); BoardDto dto =
		 * dao.contentView(board_num);
		 * 
		 * model.addAttribute("content_view",dto);
		 */

		return "redirect:board";
	}
	@RequestMapping("/SearchBoard")
	public String SearchBoard(HttpServletRequest req, Model model) {
		String boardtopic = req.getParameter("boardtopic");
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		ArrayList<BoardDto> dtos = dao.SearchBoard(boardtopic);
		model.addAttribute("dtos", dtos);
		
		
		
		
		return "SearchBoard";
	}
	@RequestMapping("/board")
	public String list(HttpServletRequest req, Model model) {
		System.out.println("board()");
		
		
		int boardCount = boardCount();
		int pageNum=Integer.parseInt(req.getParameter("pageNum"));  // 화면에서 한 페이지 번호
		double itemPerPage=6.0;  // 한 페이지당 item수
		int itemFirstNum=((int)itemPerPage)*(pageNum-1)+1;  // 첫 번째 item 번호 (페이지별)
		int pageLastNum=(int)Math.ceil(boardCount/itemPerPage);  // 마지막 페이지 수
		int LastPageItemNum=boardCount-(pageLastNum-1)*((int)itemPerPage);  // 마지막 페이지 마지막item수
		// 마지막 번째 item 번호 (페이지별)
		int itemLastNum=0;
		if(pageNum<pageLastNum){
			itemLastNum=((int)itemPerPage)*pageNum;
		}else {
			itemLastNum=LastPageItemNum+(((int)itemPerPage)*(pageNum-1));
		}
		//int item_cnt=itemCount(category);
		System.out.println("itemFirstNum : "+itemFirstNum);
		System.out.println("pageLastNum : "+pageLastNum);
		System.out.println("LastPageItemNum : "+LastPageItemNum);
		System.out.println(itemLastNum);
	
		System.out.println("boardCount : "+boardCount);
		BoardDao dao=sqlSession.getMapper(BoardDao.class);
		model.addAttribute("board",dao.Pagelist(itemFirstNum,itemLastNum));
		model.addAttribute("pageLastNum",pageLastNum);
		
		model.addAttribute("pageNum",pageNum);
		
	
		return "board";

	}
	public int boardCount() {
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		
		int bCnt = dao.allCount();
		return bCnt;
		
	}

	@RequestMapping("/finduser")
	public String finduser(HttpServletRequest req, Model model) {
		/*
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		ArrayList<BoardDto> dtos = dao.list();
		model.addAttribute("dtos", dtos);
		*/
System.out.println("board()");
		
		
		int boardCount = boardCount();
		int pageNum=Integer.parseInt(req.getParameter("pageNum"));  // 화면에서 클릭한 페이지 번호
		double itemPerPage=6.0;  // 한 페이지당 item수
		int itemFirstNum=((int)itemPerPage)*(pageNum-1)+1;  // 첫 번째 item 번호 (페이지별)
		int pageLastNum=(int)Math.ceil(boardCount/itemPerPage);  // 마지막 페이지 수
		int LastPageItemNum=boardCount-(pageLastNum-1)*((int)itemPerPage);  // 마지막 페이지 마지막item수
		// 마지막 번째 item 번호 (페이지별)
		int itemLastNum=0;
		if(pageNum<pageLastNum){
			itemLastNum=((int)itemPerPage)*pageNum;
		}else {
			itemLastNum=LastPageItemNum+(((int)itemPerPage)*(pageNum-1));
		}
		//int item_cnt=itemCount(category);
		System.out.println("itemFirstNum : "+itemFirstNum);
		System.out.println("pageLastNum : "+pageLastNum);
		System.out.println("LastPageItemNum : "+LastPageItemNum);
		System.out.println(itemLastNum);
	
		System.out.println("boardCount : "+boardCount);
		BoardDao dao=sqlSession.getMapper(BoardDao.class);
		model.addAttribute("board",dao.Pagelist(itemFirstNum,itemLastNum));
		model.addAttribute("pageLastNum",pageLastNum);
		
		model.addAttribute("pageNum",pageNum);
		
	
		return "finduser";
	}

	@RequestMapping("/userinfomation")
	public String doFindUser(HttpServletRequest req, Model model) {
		
		//==> 검색 한 유저 게시글 검색하기//
		String userid = req.getParameter("userid");
		System.out.println(userid);
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		int checkCount = dao.memberCheck(userid);
		if(checkCount>=1) {
			ArrayList<BoardDto> dtos = dao.userlist(userid);
		    int cnt = dao.userCount(userid);
		    String rdate = dao.userDate(userid);
		    model.addAttribute("rdate",rdate);
		    model.addAttribute("cnt",cnt);
			model.addAttribute("dtos", dtos);
			//==>userid 표기 //
			model.addAttribute("userid",userid);
			
			return "userinfomation";
		}else {
			model.addAttribute("userid",userid);
			return "UserNotFound";
		}
		
		
	}

	@RequestMapping("/previous")
	public String previous(Model model) {

		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		ArrayList<BoardDto> dtos = dao.previous();
		model.addAttribute("dtos", dtos);
		return "board";

	}

	@RequestMapping("/board_new")
	public String board_new(HttpServletRequest req, Model model) {
		// ==>로그인을 해야 게시글 작성 페이지로 redirect
		/*
		 * HttpSession session =req.getSession(); if(session.getAttribute("uid")==null
		 * || session.getAttribute("uid").equals("")) { return"login"; }
		 */

		return "board_new";

	}

	@RequestMapping(value = "/board_write_view", method = RequestMethod.POST)
	public String board_write_view(HttpServletRequest req, Model model) {
		String boardtopic = req.getParameter("boardtopic");
		String userid = req.getParameter("userid");
		String board_comment = req.getParameter("board_comment");
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		dao.write(boardtopic, userid, board_comment);
		return "redirect:http://localhost:8080/project/board?pageNum=1";
	}

	// ==> board_view 에서 댓글 쓰기 ,삭제 , 수정기능
	@RequestMapping(value = "/board_view")
	public String board_view(HttpServletRequest req, Model model) {
		Userid = "minttears";
		model.addAttribute("Userid", Userid);
		
		
		// 댓글쓰기를 보여주는 페이지//
		/*
		 * System.out.println("content_view()"); // <a
		 * href="content_view?bId=${dto.bId}">${dto.bTitle}</a> 를 이용하면됨// // queryString
		 * ==> String type ==> parseInt( ); int
		 * bId=Integer.parseInt(req.getParameter("bId")); //==>interface Dao <==// IDao
		 * dao = sqlSession.getMapper(IDao.class);
		 * 
		 * BDto dto = dao.contentView(bId); model.addAttribute("reply_view",dto); return
		 * "reply_view";
		 */
		
		
		int board_num = Integer.parseInt(req.getParameter("board_num"));
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		BoardDto dto = dao.board_view(board_num);
		dao.upHit(board_num);
		System.out.println(board_num);
		model.addAttribute("reply_view", dto);
		model.addAttribute("Userid", Userid);
		
		/*
		dao = sqlSession.getMapper(BoardDao.class);
		ArrayList<BoardDto> dtos = dao.list();
		model.addAttribute("dtos", dtos);
		*/
		int boardCount = boardCount();
		int pageNum=Integer.parseInt(req.getParameter("pageNum"));  // 화면에서 클릭한 페이지 번호
		double itemPerPage=6.0;  // 한 페이지당 item수
		int itemFirstNum=((int)itemPerPage)*(pageNum-1)+1;  // 첫 번째 item 번호 (페이지별)
		int pageLastNum=(int)Math.ceil(boardCount/itemPerPage);  // 마지막 페이지 수
		int LastPageItemNum=boardCount-(pageLastNum-1)*((int)itemPerPage);  // 마지막 페이지 마지막item수
		// 마지막 번째 item 번호 (페이지별)
		int itemLastNum=0;
		if(pageNum<pageLastNum){
			itemLastNum=((int)itemPerPage)*pageNum;
		}else {
			itemLastNum=LastPageItemNum+(((int)itemPerPage)*(pageNum-1));
		}
		//int item_cnt=itemCount(category);
		System.out.println("itemFirstNum : "+itemFirstNum);
		System.out.println("pageLastNum : "+pageLastNum);
		System.out.println("LastPageItemNum : "+LastPageItemNum);
		System.out.println(itemLastNum);
	
		System.out.println("boardCount : "+boardCount);
	    dao=sqlSession.getMapper(BoardDao.class);
		model.addAttribute("board",dao.Pagelist(itemFirstNum,itemLastNum));
		model.addAttribute("pageLastNum",pageLastNum);
		
		model.addAttribute("pageNum",pageNum);
		
		return "board_view";
	}

	// test 용
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest req, Model model) {
		System.out.println("content_view()");
		// <a href="content_view?bId=${dto.bId}">${dto.bTitle}</a> 를 이용하면됨//
		// queryString ==> String type ==> parseInt( );
		int board_num = Integer.parseInt(req.getParameter("board_num"));
		// ==>interface Dao <==//
		BoardDao dao = sqlSession.getMapper(BoardDao.class);

		BoardDto dto = dao.contentView(board_num);
		model.addAttribute("reply_view", dto);
		return "reply_view";
	}

	// 댓글작성하기 //
	@RequestMapping(value = "/reply", method = RequestMethod.POST)
	public String reply(HttpServletRequest req, Model model) {
		/*
		 * HttpSession session =req.getSession(); if(session.getAttribute("uid")==null
		 * || session.getAttribute("uid").equals("")) { return"login"; }
		 */

		String board_num = req.getParameter("board_num");
		String bGroup = req.getParameter("bGroup");
		String bStep = req.getParameter("bStep");
		String bIndent = req.getParameter("bIndent");
		String userid = req.getParameter("userid");
		String boardtopic = req.getParameter("boardtopic");
		String board_comment = req.getParameter("board_comment");
		System.out.println(board_num);
		System.out.println(bGroup);
		System.out.println(bStep);
		System.out.println(bIndent);
		System.out.println(userid);
		System.out.println(boardtopic);
		System.out.println(board_comment);

		// ==>interface Dao <==//
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		// dao.reply(bName,bTitle,bContent,Integer.parseInt(bGroup),Integer.parseInt(bStep)+1,Integer.parseInt(bIndent)+1);
		dao.reply(userid, boardtopic, board_comment, Integer.parseInt(bGroup), Integer.parseInt(bStep) + 1,
				Integer.parseInt(bIndent) + 1);
		// dao.replyShape(Integer.parseInt(bGroup),Integer.parseInt(bStep));
		dao.replyShape(Integer.parseInt(bGroup), Integer.parseInt(bStep));

		return "redirect:board";
	}

	@RequestMapping(value = "/board_update")
	public String board_update(HttpServletRequest req, Model model) {
		/*
		 * HttpSession session = req.getSession(); if(session.getAttribute("uid") ==
		 * null ||session.getAttribute("uid").equals("")) { return "redirect:login"; }
		 */
		int board_num = Integer.parseInt(req.getParameter("board_num"));
		// ==>interface Dao <==//
		System.out.println(board_num);
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		System.out.println("debug1");
		BoardDto dto = dao.board_view(board_num);
		System.out.println("debug2");
		model.addAttribute("board_update", dto);
		System.out.println("debug3");
		return "board_update";
	}

	// ==>board_update view==> 삭제 , 수정 동시에 가능<==//
	@RequestMapping(value = "/Doboard_update")
	public String Doboard_update(HttpServletRequest req, Model model) {
		/*
		 * HttpSession session = req.getSession(); if(session.getAttribute("uid") ==
		 * null ||session.getAttribute("uid").equals("")) { return "redirect:login"; }
		 */
		System.out.println("content_view()");
		// ==>현재 페이지를 수정하게 하기위해서는 게시물 번호를 getParameter( ) 를 통해서 , where 절 로 수정 해야한다//

		String hidden = req.getParameter("hidden");
		System.out.println(hidden);
		if (hidden.equals("modify")) {
			String board_num = req.getParameter("board_num");
			String boardtopic = req.getParameter("boardtopic");
			String userid = req.getParameter("userid");
			String board_comment = req.getParameter("board_comment");
			System.out.println(board_num);
			System.out.println(boardtopic);
			System.out.println(userid);
			System.out.println(board_comment);

			// ==>interface Dao <==//
			BoardDao dao = sqlSession.getMapper(BoardDao.class);

			dao.Doboard_update(Integer.parseInt(board_num), boardtopic, userid, board_comment);
			model.addAttribute("board_view", dao);
			return "redirect:http://localhost:8080/project/board?pageNum=1";
		} else {

			String board_num = req.getParameter("board_num");

			// ==>interface Dao <==//
			BoardDao dao = sqlSession.getMapper(BoardDao.class);

			dao.Doboard_delete(Integer.parseInt(board_num));
			model.addAttribute("board_view", dao);
			return "redirect:http://localhost:8080/project/board?pageNum=1";

		}

	}

	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public String loginCheck(HttpServletRequest req, Model model) {
		String id = req.getParameter("id");
		String passwd = req.getParameter("passwd");
		// session 이용
		HttpSession session = req.getSession();
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		int cnt = dao.loginCheck(id, passwd);
		if (cnt == 1) {
			// ==> 회원정보 존재 //
			// ==> uid담아줌
			session.setAttribute("uid", id);
			Userid = id;
		} else {
			// ==>회원정보 없음
			return "redirect:login";
		}
		return "redirect:list";
	}

	@RequestMapping("/logout")
	// 로그아웃할때
	public String doLogout(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		// 로그아웃시 세션종료를 하고 리스트로 돌아간다
		session.invalidate();
		model.addAttribute("logout", "Y");
		return "redirect:/list";

	}

	@RequestMapping("AboutUs")
	public String AboutUs() {
		return "AboutUs";

	}

	@RequestMapping("email_check")
	public String email_check() {
		return "email_check";

	}

	@RequestMapping("getId")
	public String getId() {
		return "getId";

	}

	@RequestMapping("getPw")
	public String getPw() {
		return "getPw";

	}

	@RequestMapping("home")
	public String home() {
		return "home";

	}

	@RequestMapping("login")
	public String login() {
		return "login";

	}

	@RequestMapping("/myInfo")
	public String myInfo(Model model) {
		BoardDao dao = sqlSession.getMapper(BoardDao.class);
		ArrayList<BoardDto> dto = dao.list();
		model.addAttribute("dto", dto);
		return "myInfo";
	}

	@RequestMapping("myInfoEdit")
	public String myInfoEdit() {
		return "myInfoEdit";

	}

	@RequestMapping("myItems")
	public String myItems() {
		return "myItems";

	}

	@RequestMapping("paint_new")
	public String paint_new() {
		return "paint_new";

	}

	@RequestMapping("paint")
	public String paint() {
		return "paint";

	}

	@RequestMapping("Signup")
	public String Signup() {
		return "Signup";

	}

	@RequestMapping("welcomeSignup")
	public String welcomeSignup() {
		return "welcomeSignup";

	}

	@RequestMapping("myList")
	public String myList() {
		return "myList";

	}

}
