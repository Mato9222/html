package kr.or.ddit.lprod.service;

import java.util.List;

import kr.or.ddit.lprod.dao.ILprdDoa;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.vo.lprodVO;

public class LprodServiceImpl implements ILprodService {

	// dao 객체
	private ILprdDoa dao;
	
	// 싱글톤 자신의 객체
	private static ILprodService service;

	// 생성자
	private LprodServiceImpl () {
		dao = LprodDaoImpl.getDao();
	}
	
	// 자신의 객체 생성, 리턴
	public static ILprodService getInstance() {
		if ( service == null ) service = new LprodServiceImpl();
		
		return service;
	}
	
	@Override
	public List<lprodVO> selectLprod() {
		return dao.selectLprod();
	}
	
	
	
}
