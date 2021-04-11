package spring.mvc.android_kosbank.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.android_kosbank.persistence.MembersDAO;
import spring.mvc.android_kosbank.persistence.RegisterReleaseDAO;
import spring.mvc.android_kosbank.vo.AccountVO;

@Service
public class RegisterReleaseServiceImpl implements RegisterReleaseService{
	
	@Autowired
	RegisterReleaseDAO accountDAO;
	
	@Autowired
	MembersDAO memberDAO;
	
	// 계좌개설
	@Override
	public Map<String,Object> AddAccountService(HttpServletRequest req) {
		AccountVO vo = new AccountVO();
		String id = req.getParameter("id");
		vo.setId(id);
		vo.setAccountPW(Integer.parseInt(req.getParameter("accountPW")));
		
		System.out.println("id"+id);
		System.out.println("accountPW"+vo.getAccountPW());
				
		int insertCnt = accountDAO.insertAccount(vo);
		System.out.println("insertCnt"+insertCnt);
		
		Map<String, Object> out = new HashMap<String, Object>();
		out.put("insertCnt", insertCnt);
		return out;
	}
	
	// 해지 리스트
	@Override
	public List<String> DeleteAccountService(HttpServletRequest req) {
		String id = req.getParameter("id");
		List<String> list = accountDAO.deleteAccountList(id);
		
		System.out.println("list : "+list);
		
		return list;
	}
	
	// 해지 액션
	@Override
	public Map<String,Object> DeleteAccount(HttpServletRequest req) {
		Map<String, Object> map = new HashMap<String, Object>();
		String account = req.getParameter("account");
		int accountPW = Integer.parseInt(req.getParameter("accountPW"));
		System.out.println("account : "+account);
		System.out.println("accountPW : "+accountPW);
		
		map.put("account", account);
		map.put("accountPW", accountPW);	
		
				
		Map<String, Object> map1 = new HashMap<String, Object>();
		int updateCnt = accountDAO.deleteAccount(map);
		
		
		map1.put("updateCnt", updateCnt);
		
		return map1;
	}
	
	// 계좌(정상+입출금+대출)리스트
	@Override
	public List<AccountVO> AccountInoutLoansType(HttpServletRequest req) {
		String id = req.getParameter("id");
		System.out.println("id : "+id);
		List<AccountVO> list = accountDAO.selectTransferType(id);
		System.out.println("list : "+ list);
		
		return list;
	}
	
	/*
	@Override
	public void AccountList(HttpServletRequest req, Model model) {
			String strId = (String)req.getSession().getAttribute("id");
			List<AccountVO> list = accountDAO.selectById(strId);
			System.out.println("list"+list);
			model.addAttribute("list", list);
	}	
	*/
	
	// 예금주 조회(이체시)
	@Override
	public Map<String,Object> AccountNameChk(HttpServletRequest req) {
		String sender_account = req.getParameter("sender_account");
		System.out.println("sender_account"+sender_account);
		String name = accountDAO.AccountNameChk(sender_account);
		
		Map<String, Object> out = new HashMap<String, Object>();
		out.put("sender_name", name);
		System.out.println("sender_name"+name);
		
		return out;
		
	}
	
	
	// 예금주 조회(계좌개설시)
	@Override
	public Map<String,Object> IdNameChk(HttpServletRequest req) {
		String strId = req.getParameter("id");
		String name = accountDAO.IdNameChk(strId);
		
		System.out.println("name : "+name);
		
		Map<String, Object> out = new HashMap<String, Object>();
		out.put("name", name);
		return out;
		
	}

	
	

}
