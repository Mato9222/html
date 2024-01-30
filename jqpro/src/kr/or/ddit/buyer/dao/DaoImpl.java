package kr.or.ddit.buyer.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.buyer.vo.BuyerVO;
import kr.or.ddit.config.MybatisUtil;

public class DaoImpl implements IDao {
	
	private static IDao dao;
	
	private DaoImpl() {}
	
	public static IDao getInstance() {
		if(dao == null) {
			dao = new DaoImpl();
		}
		return dao;
	}
	
	@Override
	public List<BuyerVO> menu() {
		SqlSession session = null;
		
		List<BuyerVO> name = null;
		try {
			session = MybatisUtil.getSqlSession();
			
			name = session.selectList("buyer.name");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return name;
	}

	@Override
	public BuyerVO detail(String name) {
		BuyerVO res = null;
		
		SqlSession session = null;
		
		try {
			session = MybatisUtil.getSqlSession();
			
			res = session.selectOne("buyer.detail",name);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return res;
	}

}
