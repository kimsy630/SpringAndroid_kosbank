package spring.mvc.android_kosbank.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public interface InquiryTransferService {
	
	/*
	//입출금 계좌조회
	public void AccountTable(HttpServletRequest req);
	//대출 조회
	public void LoansTable(HttpServletRequest req);
	//적금 조회
	public void IS_Table(HttpServletRequest req);
	//펀드 조회
	public void fund_Table(HttpServletRequest req);
	//예금 조회
	public void DepositTable(HttpServletRequest req);
	//휴면/정지 조회
	public void StopSleepTable(HttpServletRequest req);
	//전체조회
	public void AllTable(HttpServletRequest req);
	//거래내역 조회
	public void TransactionDetails(HttpServletRequest req);
	//거래내역 테이블
	public void TransactionDetails_Table(HttpServletRequest req);
	
	//계좌이체 입력정보
	public void transferTable(HttpServletRequest req);
	*/
	//계좌이체 실행
	public Map<String,Object> transferAction(HttpServletRequest req);

}
