package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.dao.IMemeberDao;
import kr.or.ddit.member.dao.MemberDaoImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public class MemberServiceImpl implements IMemberService {

	// dao 객체가 필요 - dao메소드 호출 -> 결과값 받아서 controller로 넘김
//	private static MemberServiceImpl service;
	private IMemeberDao dao;
	
	private static IMemberService service; 
	
	//싱글톤 자신의 객체
	private MemberServiceImpl() {	
		dao = MemberDaoImpl.getInstance();
	}
	
	//생성자  - dao객체 얻어오기
	public static IMemberService getInstance() {
		if(service==null) {
			service = new MemberServiceImpl();
		}

		return service;
	}
	
	@Override
	public String selectById(String id) {
		// TODO Auto-generated method stub
		return dao.selectById(id);
	}

	@Override
	public List<ZipVO> selectByDong(String dong) {
		// TODO Auto-generated method stub
		return dao.selectByDong(dong);
	}

	@Override
	public int insertMember(MemberVO vo) {
		return dao.insertMember(vo);
	}

	@Override
	public MemberVO logSelect(MemberVO vo) {
		// TODO Auto-generated method stub
		return dao.logSelect(vo);
	}

}
