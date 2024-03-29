package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardDao {

	// 페이지별 리스트 - 검색, 페이지처리
	public List<BoardVO> selectByPage(Map<String , Object> map);
	
	// 글쓰기
	public int insertBoard(BoardVO vo);
	
	// 글수정
	public int updateBoard(BoardVO vo);
	
	// 글 삭제
	public int deleteBoard(int num);
	
	// 조회수 증가
	public int updateHit(int num);
	
	// 전체글 갯수 얻기
	public int getTotalCount(Map<String, Object> map);
	
	
	// 댓글쓰기
	public int insertReply(ReplyVO vo);
	
	// 댓글 수정
	public int updateReply(ReplyVO vo);
	
	// 댓글 삭제
	public int deleteReply(ReplyVO vo);
	
	// 댓글 리스트
	
}
