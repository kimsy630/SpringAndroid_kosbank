package spring.mvc.android_kosbank.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.android_kosbank.persistence.MembersDAOImpl;
import spring.mvc.android_kosbank.vo.MembersVO;


@Service
public class MembersServiceImpl implements MembersService{

	@Autowired
	MembersDAOImpl memberDAO;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Override
	public Map<String, Object> androidLogiIn(HttpServletRequest req) {
		// 안드로이드에서 전달한 값
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		
		Map<String, String> in = new HashMap<String, String>();
		in.put("id", id);
		in.put("pw", pw);
		//로그인
		System.out.println(id);
		MembersVO vo= memberDAO.getMemberInfo(id);

		Map<String, Object> out = new HashMap<String, Object>();
		if(vo!=null) {
			if(passwordEncoder.matches(pw,vo.getPw())) {
				out.put("id",id);
			}else {
				out.put("id",null);
			}
		}else {
			out.put("id",null);
		}
		
		return out;
	}
	
	

}
