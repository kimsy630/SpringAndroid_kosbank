package spring.mvc.android_kosbank.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.android_kosbank.vo.Loans_productVO;

@Service
public interface FinancialProductsService {
	// ============================================================================
	// 박서하
	// 금융상품(대출) 조회
	public Loans_productVO loanProduct(HttpServletRequest req); 
		
	// 박서하
	// 대출상품 조회
	public List<Loans_productVO> loanProductsList(HttpServletRequest req); 
	
	// 박서하
	// 대출상품 상세조회
	public Loans_productVO loanProductDetail(HttpServletRequest req,Model model);
	// ============================================================================	
}
