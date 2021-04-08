package spring.mvc.android_kosbank.persistence;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import spring.mvc.android_kosbank.vo.Deposit_productVO;


public interface FinancialProductsDAO{
	
	public List<Deposit_productVO> getDepositList();
	
}
