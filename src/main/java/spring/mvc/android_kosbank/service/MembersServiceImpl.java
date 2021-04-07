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
			if( passwordEncoder.matches(pw,vo.getPw())) {
				out.put("id",id);
			}else {
				out.put("id",null);
			}
		}else {
			out.put("id",null);
		}
		
		return out;
	}



	@Override
	public int androidSignUp(HttpServletRequest req) {
		System.out.println("service 1");
		String id = req.getParameter("id");
		String pw = req.getParameter("pw");
		String name = req.getParameter("name");
		String rrnf = req.getParameter("rrnf");
		String rrnl = req.getParameter("rrnl");
		String RRN = rrnf + "-" + rrnl;
		String address = req.getParameter("address");
		String job = req.getParameter("job");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		
		Map<String, String> info = new HashMap<String, String>(); 
		info.put("id", id);
		info.put("pw", passwordEncoder.encode(pw));
		info.put("name", name);
		info.put("RRN", RRN);
		info.put("address", address);
		info.put("job", job);
		info.put("phone", phone);
		info.put("email", email);
		System.out.println("service2");
		
		int insertCnt = memberDAO.insertMember(info);
		System.out.println("service3");
		
		
		return insertCnt;
	}
	
	

}
