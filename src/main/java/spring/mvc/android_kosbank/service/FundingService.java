package spring.mvc.android_kosbank.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.android_kosbank.vo.FundingVO;

@Service
public interface FundingService {
	// ============================================================================	
	// 전형민
	// 펀드상품 조회
	public List<FundingVO> FundProducts(HttpServletRequest req, Model model); 
	// ============================================================================	
}
