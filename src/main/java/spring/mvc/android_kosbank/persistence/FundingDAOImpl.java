package spring.mvc.android_kosbank.persistence;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.android_kosbank.vo.FundingVO;


@Repository
public class FundingDAOImpl implements FundingDAO{
	
	@Autowired
	SqlSession sqlSession;

	// ============================================================================
	//전형민
	@Override
	public List<FundingVO> getFundProductAll() { // 금융상품(대출) 조회
		List<FundingVO> list = sqlSession.selectList("spring.mvc.android_kosbank.persistence.FundingDAO.getFundProductAll");
		return list;
	}
	
	//전형민
		@Override
		public List<FundingVO> getFundProductCat(String f_category) { // 금융상품(대출) 조회
			List<FundingVO> list = sqlSession.selectList("spring.mvc.android_kosbank.persistence.FundingDAO.getFundProductCat",f_category);
			return list;
		}
	// ============================================================================
	
}
