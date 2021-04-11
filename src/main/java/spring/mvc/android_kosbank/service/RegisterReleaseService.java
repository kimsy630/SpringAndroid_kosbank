package spring.mvc.android_kosbank.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.android_kosbank.vo.AccountVO;

@Service
public interface RegisterReleaseService {

	// 계좌등록
	public Map<String,Object> AddAccountService(HttpServletRequest req);
	
	// 계좌해지 계좌리스트
	public List<String> DeleteAccountService(HttpServletRequest req);
	
	// 계좌해지 계좌액션
	public Map<String,Object> DeleteAccount(HttpServletRequest req);
	
	// 계좌(정상+입출금+대출)리스트
	public List<AccountVO> AccountInoutLoansType(HttpServletRequest req);
	
	// 예금주 조회(이체시)
	public Map<String,Object> AccountNameChk(HttpServletRequest req);
	
	/*
	// 계좌(정상)조회
	public List<String> AccountNomalList(HttpServletRequest req);
	
	
	// 계좌리스트 전체조회(정상,해지,휴면)
	public List<String> AccountList(HttpServletRequest req);
	
	// 입출금 계좌 조회
	public void AccountInoutType(HttpServletRequest req, Model model);
	
	*/
	
	// 회원 이름 조회
	public Map<String,Object> IdNameChk(HttpServletRequest req);
	
	
	
}
