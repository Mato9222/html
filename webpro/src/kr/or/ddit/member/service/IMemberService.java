package kr.or.ddit.member.service;

public class IMemberService {

	private static IMemberService instance = null;

	private IMemberService() {
	}

	public static IMemberService getInstance() {
		if (instance == null) {
			instance = new IMemberService();
		}
		return instance;
	}
}
