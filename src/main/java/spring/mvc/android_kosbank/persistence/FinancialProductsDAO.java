package spring.mvc.android_kosbank.persistence;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import spring.mvc.android_kosbank.vo.Deposit_productVO;
import spring.mvc.android_kosbank.vo.savings_productVO;


public interface FinancialProductsDAO{
	
	public List<Deposit_productVO> getDepositList();
	
	public List<savings_productVO> getSavingsList();
	
	public Deposit_productVO BankItemDeposit();
	
	public savings_productVO BankItemSavings();
}
