package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.buyer.dao.IDao;
import kr.or.ddit.buyer.dao.DaoImpl;
import kr.or.ddit.buyer.vo.BuyerVO;

public class ServiceImpl implements IService {
	private IDao dao;
	
	private static IService service;
	
	private ServiceImpl() {
		dao = DaoImpl.getInstance();
	}
	
	public static IService getInstance() {
		if(service == null) { 
			service = new ServiceImpl();
		}
		return service;
	}
	
	@Override
	public List<BuyerVO> menu() {
		// TODO Auto-generated method stub
		return dao.menu();
	}

	@Override
	public BuyerVO detail(String name) {
		// TODO Auto-generated method stub
		return dao.detail(name);
	}

}
