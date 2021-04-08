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

import spring.mvc.android_kosbank.vo.MembersVO;


@Repository
public class MembersDAOImpl implements MembersDAO{
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public int insertMember(MembersVO vo) {
		return sqlSession.insert("spring.mvc.android_kosbank.persistence.MembersDAO.insertMember",vo);
	}

	@Override
	public MembersVO getMemberInfo(String id) {
		return sqlSession.selectOne("spring.mvc.android_kosbank.persistence.MembersDAO.getMemberInfo",id);
	}
	@Override
	public int idCheck(String id) {	//아이디 체크
		return sqlSession.selectOne("spring.mvc.android_kosbank.persistence.MembersDAO.idCheck",id);
	}

}
