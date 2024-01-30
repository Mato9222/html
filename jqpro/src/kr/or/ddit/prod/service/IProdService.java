package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.pard.vo.ProdVO;

public interface IProdService {

		public List<ProdVO> selectByLgu(String lprod_gu);
		
		public ProdVO selectById(String prod_Id);

}
