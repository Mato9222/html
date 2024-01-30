package kr.or.ddit.buyer.dao;

import java.util.List;

import kr.or.ddit.buyer.vo.BuyerVO;

public interface IDao {

	public List<BuyerVO> menu ();

	public BuyerVO detail(String name);
}
