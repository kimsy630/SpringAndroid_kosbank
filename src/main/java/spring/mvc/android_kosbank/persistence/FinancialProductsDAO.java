package spring.mvc.android_kosbank.persistence;

import java.util.List;

import spring.mvc.android_kosbank.vo.Loans_productVO;

public interface FinancialProductsDAO{
	// ============================================================================
	// 박서하
	public Loans_productVO getLoanProduct(); // 금융상품(대출) 조회
	public List<Loans_productVO> getLoanList(); // 대출상품 조회
	public Loans_productVO getLoanDetail(String d_name); // 대출상품 상세조회
	// ============================================================================
	
}
