package kr.or.ddit.prod.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.pard.vo.ProdVO;
import kr.or.ddit.util.DBUtil3;

public class ProdDaoImpl implements IProdDao{
	// DB관련 변수 선언 
	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;
	
	// 싱글톤 자신 객체 
	private static IProdDao dao; 
	
	// 생성자
	private ProdDaoImpl() {}
	
	// 싱글톤에서 자신의 객체 생성 리턴 
	public static IProdDao getDao() {
		if(dao==null) dao = new ProdDaoImpl();
		
		return dao;
	}
	
	
	@Override
	public List<ProdVO> selectByLgu(String lprod_gu) {
		List<ProdVO> list = new ArrayList<ProdVO>();
		
		String sql = " select prod_id, prod_name\r\n" + 
				"from prod\r\n" + 
				"where prod_lgu=?";
		
		try {
			conn = DBUtil3.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, lprod_gu);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				ProdVO vo = new ProdVO();
				vo.setProd_id(rs.getString("prod_id"));
				vo.setProd_name(rs.getString("prod_name"));
				
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try { rs.close(); } catch (Exception e) {}
			if(stmt != null) try { stmt.close(); } catch (Exception e) {}
			if(conn != null) try { conn.close(); } catch (Exception e) {}
		}
 		
		return list;
	}

	@Override
	public ProdVO selectById(String prod_Id) {
		ProdVO pvo = new ProdVO();
		
		String sql = "select * from prod where prod_id = ?";
		
		try {
			conn = DBUtil3.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, prod_Id);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				pvo.setProd_id(rs.getString("prod_id"));
				pvo.setProd_name(rs.getString("prod_name"));
				pvo.setProd_buyer(rs.getString("prod_buyer"));
				pvo.setProd_lgu(rs.getString("prod_lgu"));
				pvo.setProd_cost(rs.getInt("prod_cost"));
				pvo.setProd_price(rs.getInt("prod_price"));
				pvo.setProd_sale(rs.getInt("prod_sale"));
				
			}
 		} catch (SQLException e) {
 			e.printStackTrace();
 		} finally {
			if(rs != null) try { rs.close(); } catch (Exception e) {}
			if(stmt != null) try { stmt.close(); } catch (Exception e) {}
			if(conn != null) try { conn.close(); } catch (Exception e) {}
		}
		
		return pvo;
	}

}
