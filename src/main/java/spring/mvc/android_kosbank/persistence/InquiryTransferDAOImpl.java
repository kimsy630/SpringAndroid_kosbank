package spring.mvc.android_kosbank.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.android_kosbank.vo.TransferVO;


@Repository
public class InquiryTransferDAOImpl implements InquiryTransferDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int addMyLog(TransferVO transferVO) {
		return sqlSession.insert("spring.mvc.android_kosbank.persistence.InquiryTransferDAO.addMyLog", transferVO);
	}

	@Override
	public int addYourLog(TransferVO transferVO) {
		return sqlSession.insert("spring.mvc.android_kosbank.persistence.InquiryTransferDAO.addYourLog", transferVO);
	}

	@Override
	public int withdrawal(TransferVO transferVO) {
		return sqlSession.update("spring.mvc.android_kosbank.persistence.InquiryTransferDAO.withdrawal", transferVO);
	}

	@Override
	public int deposit(TransferVO transferVO) {
		return sqlSession.update("spring.mvc.android_kosbank.persistence.InquiryTransferDAO.deposit", transferVO);
	}

}
