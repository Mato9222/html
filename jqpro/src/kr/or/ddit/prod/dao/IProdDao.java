package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.pard.vo.ProdVO;

public interface IProdDao {

	public List<ProdVO> selectByLgu(String lprod_gu);
	
	public ProdVO selectById(String prod_Id);

}
