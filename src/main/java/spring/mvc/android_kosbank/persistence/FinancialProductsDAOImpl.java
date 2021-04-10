package spring.mvc.android_kosbank.persistence;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.android_kosbank.vo.Loans_productVO;


@Repository
public class FinancialProductsDAOImpl implements FinancialProductsDAO{
	
	@Autowired
	SqlSession sqlSession;

	// ============================================================================
	// 박서하
	
	@Override
	public Loans_productVO getLoanProduct() { // 금융상품(대출) 조회
		Loans_productVO vo = sqlSession.selectOne("spring.mvc.android_kosbank.persistence.FinancialProductsDAO.getLoanProduct");
		return vo;
	}
	
	@Override
	public List<Loans_productVO> getLoanList() { // 대출상품 조회
		List<Loans_productVO> list = sqlSession.selectList("spring.mvc.android_kosbank.persistence.FinancialProductsDAO.getLoanList");
		return list;
	}

	@Override
	public Loans_productVO getLoanDetail(String d_name) { // 대출상품 상세조회
		Loans_productVO vo = sqlSession.selectOne("spring.mvc.android_kosbank.persistence.FinancialProductsDAO.getLoanDetail", d_name);
		return vo;
	}

	// ============================================================================
	
}
