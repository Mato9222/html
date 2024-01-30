package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.pard.vo.ProdVO;
import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;

public class ProdServiceImpl implements IProdService{

	// dao 객체 
	private IProdDao dao;
	
	// 싱글톤
	private static ProdServiceImpl service;
	
	// 생성자
	private ProdServiceImpl() {
		dao = ProdDaoImpl.getDao();
	}
	
	// 싱글톤 3번 
	public static ProdServiceImpl getInstance() {
		if(service == null) service = new ProdServiceImpl();
		
		return service;
	}
	// 
	@Override
	public List<ProdVO> selectByLgu(String lprod_gu) {
		return dao.selectByLgu(lprod_gu);
	}

	@Override
	public ProdVO selectById(String prod_Id) {
		return dao.selectById(prod_Id);
	}

}
