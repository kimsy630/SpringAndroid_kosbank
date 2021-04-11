package spring.mvc.android_kosbank.persistence;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.android_kosbank.vo.AccountVO;


@Repository
public class FinancialProductsDAOImpl implements FinancialProductsDAO{
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public int checkPwd(AccountVO vo) {
		
		return sqlSession.getMapper(FinancialProductsDAO.class).checkPwd(vo);
	}
	
	

}
