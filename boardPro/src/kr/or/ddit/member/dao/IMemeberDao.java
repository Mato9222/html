package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemeberDao {

	// 로그인 처리 
	public MemberVO logSelect(MemberVO vo); 
	
	// 아이디 중복 검사
	public String selectById(String id);
	
	// 우편번호 검색 다음API안하고 따로 해볼거다
	public List<ZipVO> selectByDong(String dong);
	
	// 전송(가입신청)
	public int insertMember(MemberVO vo);

}
