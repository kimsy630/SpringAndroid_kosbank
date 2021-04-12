package spring.mvc.android_kosbank.persistence;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import spring.mvc.android_kosbank.vo.AccountVO;
import spring.mvc.android_kosbank.vo.Deposit_productVO;
import spring.mvc.android_kosbank.vo.savings_productVO;

import java.util.List;

import spring.mvc.android_kosbank.vo.Loans_productVO;

public interface FinancialProductsDAO{
	// ============================================================================
	// 박서하
	public Loans_productVO getLoanProduct(); // 금융상품(대출) 조회
	public List<Loans_productVO> getLoanList(); // 대출상품 조회
	public Loans_productVO getLoanDetail(String d_name); // 대출상품 상세조회

	public List<Deposit_productVO> getDepositList();
	
	public List<savings_productVO> getSavingsList();
	
	public Deposit_productVO BankItemDeposit();
	
	public savings_productVO BankItemSavings();
	public int checkPwd(AccountVO vo);
	// ============================================================================
	
}
