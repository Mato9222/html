package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.config.MybatisUtil;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;
import kr.or.ddit.util.DBUtil3;

public class MemberDaoImpl implements IMemeberDao{
	// DB 접근 실행
	private Connection conn = DBUtil3.getConnection();
	private ResultSet rs = null;
	private PreparedStatement pstmt = null;

	// 싱글톤 
	private static MemberDaoImpl dao;
	
	private MemberDaoImpl() { }

	public static MemberDaoImpl getInstance() {
		if(dao == null) dao = new MemberDaoImpl();
		
		return dao;
	}
	
	@Override
	public List<MemberVO> getAllMember() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		String sql = "select * from member";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberVO mem = new MemberVO();
				
				mem.setMem_id(rs.getString("mem_id"));
				mem.setMem_hp(rs.getString("mem_hp"));
				mem.setMem_name(rs.getString("mem_name"));
				
				list.add(mem);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt!=null) try {pstmt.close(); } catch (SQLException e) {}
			if (rs!=null) try { rs.close(); } catch (SQLException e) {}
		}
		return list;
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
	
}
