package spring.mvc.android_kosbank.persistence;

import java.util.List;
import java.util.Map;

import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;

import spring.mvc.android_kosbank.vo.AccountVO;
import spring.mvc.android_kosbank.vo.And_TransferDetailVO;
import spring.mvc.android_kosbank.vo.MembersVO;


@Repository
public class MembersDAOImpl implements MembersDAO{
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public int insertMember(Map<String, String> map) {
		return sqlSession.insert("spring.mvc.android_kosbank.persistence.MembersDAO.insertMember",map);
	}

	@Override
	public MembersVO getMemberInfo(String id) {
		return sqlSession.selectOne("spring.mvc.android_kosbank.persistence.MembersDAO.getMemberInfo",id);
	}
	@Override
	public int idCheck(String id) {	//아이디 체크
		return sqlSession.selectOne("spring.mvc.android_kosbank.persistence.MembersDAO.idCheck",id);
	}

	@Override
	public AccountVO getAccountInfo_Main(String id) {
		return sqlSession.selectOne("spring.mvc.android_kosbank.persistence.MembersDAO.getAccountInfo_Main",id);
	}

	@Override
	public List<AccountVO> my_Account_List(String id) {
		
		return sqlSession.selectList("spring.mvc.android_kosbank.persistence.MembersDAO.my_Account_List",id);
	}

	@Override
	public List<And_TransferDetailVO> get_TransferDetail(String account) {
		return sqlSession.selectList("spring.mvc.android_kosbank.persistence.MembersDAO.get_TransferDetail",account);
	}

}
