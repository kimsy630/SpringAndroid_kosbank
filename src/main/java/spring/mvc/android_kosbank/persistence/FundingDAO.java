package spring.mvc.android_kosbank.persistence;

import java.util.List;

import spring.mvc.android_kosbank.vo.FundingVO;

public interface FundingDAO{
	// ============================================================================
	// 전형민
	public List<FundingVO> getFundProductAll(); // 펀드상품 전체 조회
	
	public List<FundingVO> getFundProductCat(String f_category); // 펀드상품 전체 조회
	// ============================================================================
	
}
