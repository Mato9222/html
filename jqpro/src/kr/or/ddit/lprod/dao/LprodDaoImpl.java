package kr.or.ddit.lprod.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.lprod.vo.lprodVO;
import kr.or.ddit.util.DBUtil3;

public class LprodDaoImpl implements ILprdDoa{
	
	// 싱글톤 자신의 객체
	private static ILprdDoa dao; 
	
	private LprodDaoImpl() {}
	
	// 자신의 객체를 생성하고 맄턴하는 메소드
	public static ILprdDoa getDao() {
		if(dao == null) dao = new LprodDaoImpl();
		
		return dao;
	}
	
	//DB연결되는 객체들 
	Connection conn;
	PreparedStatement stmt;
	ResultSet rs;
	
	public List<lprodVO> selectLprod() {
		
		List<lprodVO> list = new ArrayList<lprodVO>();
		
		String sql = "select * from lprod";
		
		try {
			conn = DBUtil3.getConnection();
			stmt = conn.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				lprodVO lvo = new lprodVO();
				
				lvo.setLprod_id(rs.getInt("lprod_id"));
				lvo.setLprod_gu(rs.getString("lprod_gu"));
				lvo.setLprod_nm(rs.getString("lprod_nm"));
				
				list.add(lvo);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return list;
			
		
	}
	
}
