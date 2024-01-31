package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.config.StreamData;

@WebServlet("/ReplyWrite.do")
public class ReplyWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 
		request.setCharacterEncoding("utf-8");
		
		// 요청시 전송데이터 받기
		// 일반적 가져오기 String bonum = request.getParameter("bonum");
		
		String reqdata = StreamData.dataChange(request);
		
		// 역직렬화
		Gson gson = new Gson();

		ReplyVO rvo = gson.fromJson(reqdata, ReplyVO.class);
		
		
		// service객체 생성
		IBoardService service = BoardServiceImpl.getInstance();
		
		// 메소드 호출
		int res = service.insertReply(rvo);
		
		// request에 저장
		request.setAttribute("result", res);
		
		// view페이지로 이동
		request.getRequestDispatcher("/boardView/result.jsp").forward(request, response);
		
	}

}
