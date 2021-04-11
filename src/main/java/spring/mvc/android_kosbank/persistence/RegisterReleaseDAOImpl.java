package spring.mvc.android_kosbank.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.android_kosbank.vo.AccountVO;


@Repository
public class RegisterReleaseDAOImpl implements RegisterReleaseDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override  
	public int insertAccount(AccountVO vo) {
		return sqlSession.insert("spring.mvc.android_kosbank.persistence.RegisterReleaseDAO.insertAccount", vo);
	}

	@Override
	public List<String> deleteAccountList(String id) {
		return sqlSession.selectList("spring.mvc.android_kosbank.persistence.RegisterReleaseDAO.deleteAccountList", id);
		
	}
	@Override
	public String IdNameChk(String id) {
		return sqlSession.selectOne("spring.mvc.android_kosbank.persistence.RegisterReleaseDAO.IdNameChk", id);
	}
	
	@Override
	public int deleteAccount(Map<String, Object> map) {
		return sqlSession.update("spring.mvc.android_kosbank.persistence.RegisterReleaseDAO.deleteAccount", map);
		
	}
	
	@Override
	public List<AccountVO> selectTransferType(String id) {
		List<AccountVO> accountList = sqlSession.selectList("spring.mvc.android_kosbank.persistence.RegisterReleaseDAO.selectTransferType", id);
		return accountList;
	}
	
	@Override
	public String AccountNameChk(String account) {
		Object o = sqlSession.selectOne("spring.mvc.android_kosbank.persistence.RegisterReleaseDAO.AccountNameChk", account);
		return o.toString();
	}
	/*
	@Override
	public List<AccountVO> selectById(String id) {
		
		List<AccountVO> accountList = sqlSession.selectList("spring.mvc.teamProject.persistence.RegisterReleaseDAO.selectById", id);
		
		return accountList;
	}
	
	@Override
	public List<AccountVO> selectNomalById(String id) {
		List<AccountVO> accountList = sqlSession.selectList("spring.mvc.teamProject.persistence.RegisterReleaseDAO.selectNomalById", id);
		return accountList;
	}
	
	@Override
	public List<AccountVO> selectType(String id) {
		List<AccountVO> accountList = sqlSession.selectList("spring.mvc.teamProject.persistence.RegisterReleaseDAO.selectType", id);
		return accountList;
	}
	
	@Override
	public int AccountPwdCheck(String account) {
		return sqlSession.selectOne("spring.mvc.teamProject.persistence.RegisterReleaseDAO.AccountPwdCheck", account);
	}

	

	*/
	
}
