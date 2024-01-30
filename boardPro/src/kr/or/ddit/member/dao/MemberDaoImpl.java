package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.config.MybatisUtil;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public class MemberDaoImpl implements IMemeberDao{

	// 싱글톤 
	private static MemberDaoImpl dao;
	
	private MemberDaoImpl() { }

	public static MemberDaoImpl getInstance() {
		if(dao == null) dao = new MemberDaoImpl();
		
		return dao;
	}
	
	@Override
	public String selectById(String id) {
		SqlSession session = MybatisUtil.getSqlSession();
		String res = null;
		
		try {
			
			res = session.selectOne("member.selectById",id);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) session.close();
		}
		return res;
	}

	@Override
	public List<ZipVO> selectByDong(String dong) {
		SqlSession session = null;
		List<ZipVO> res = null;
 		
		try {
			session = MybatisUtil.getSqlSession();
			
			res = session.selectList("member.selectByDong",dong);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(session != null ) session.close();
		}
		
		return res;
	}

	@Override
	public int insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		SqlSession session = MybatisUtil.getSqlSession();
		
		int res = 0;
		
		try {
			
			res = session.insert("member.insertMem",vo);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			if (session != null) session.close();
		}
		
		return res;
	}

	@Override
	public MemberVO logSelect(MemberVO vo) {
		MemberVO res = null;
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			res = session.selectOne("member.logSelect", vo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			if (session != null) session.close();
		}
		
		return res;
	}
	
}
