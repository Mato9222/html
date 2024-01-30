package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.buyer.vo.BuyerVO;

public interface IService {
	
	public List<BuyerVO> menu ();

	public BuyerVO detail(String name);
}
