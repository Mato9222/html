package kr.or.ddit.board.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;
import kr.or.ddit.config.MybatisUtil;

public class BoardDaoImpl implements IBoardDao{

	private static BoardDaoImpl dao;
	
	private BoardDaoImpl() { }
	
	public static BoardDaoImpl getInstance() {
		if(dao == null) {
			dao = new BoardDaoImpl();
		}
		return dao;
	}
	
	
	@Override
	public List<BoardVO> selectByPage(Map<String, Object> map) {

		SqlSession session = null;
		
		List<BoardVO> res = new ArrayList<BoardVO>();
		
		try {
			session = MybatisUtil.getSqlSession();
			
			res = session.selectList("board.selectByPage", map);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return res;
	}

	@Override
	public int insertBoard(BoardVO vo) {
		
		SqlSession session = null;
		int res = 0;
		try {
			session = MybatisUtil.getSqlSession();
			
			res = session.insert("board.insertBoard", vo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			if(session != null) session.close();
		}
		
		return res;
	}

	@Override
	public int updateBoard(BoardVO vo) {
		SqlSession session = null;
		int res = 0;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			res = session.update("board.updateBoard", vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			if(session != null) session.close();
		}
		
		return res;
	}

	@Override
	public int deleteBoard(int num) {
		
		SqlSession session = null;
		int res = 0;

		try {
			session = MybatisUtil.getSqlSession();
			
			res = session.delete("board.deleteBoard", num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			if(session != null) session.close();
		}
		
		return res;
	}

	@Override
	public int getTotalCount(Map<String, Object> map) {
		
		SqlSession session = null;
		
		int res = 0;
		try {
			session = MybatisUtil.getSqlSession();
			
			res = session.selectOne("board.getTotalCount", map);
					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return res;
	}

	@Override
	public int updateHit(int num) {
		SqlSession session = null;
		
		int res = 0;
		try {
			session = MybatisUtil.getSqlSession();
			
			res = session.update("board.updateHit", num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null) session.close();
		}
		
		return res;
	}

}
