package spring.mvc.android_kosbank.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.mvc.android_kosbank.persistence.FinancialProductsDAO;
import spring.mvc.android_kosbank.persistence.InquiryTransferDAO;
import spring.mvc.android_kosbank.vo.AccountVO;
import spring.mvc.android_kosbank.vo.TransferVO;



@Service
public class InquiryTransferServiceImpl implements InquiryTransferService{
	
	@Autowired
	InquiryTransferDAO IDAO;
	
	@Autowired
	FinancialProductsDAO FDAO;
	
	/*
	
	@Override
	public void transferTable(HttpServletRequest req, Model model) {
		TransferVO vo = new TransferVO();
		vo.setAccount(req.getParameter("account"));
		vo.setSender_account(req.getParameter("sender_account"));
		System.out.println(req.getParameter("money"));
		vo.setMoney(Integer.parseInt(req.getParameter("money")));
		vo.setSender_name(req.getParameter("sender_name"));
		vo.setOut_comment(req.getParameter("out_comment"));
		vo.setIn_comment(req.getParameter("in_comment"));
		System.out.println("vo : "+vo);
		
		model.addAttribute("vo",vo);
		
	}
	*/
	// 김소림
	// 계좌이체 실행
	@Override
	public Map<String,Object> transferAction(HttpServletRequest req) {
		String strId = req.getParameter("id");
		TransferVO vo = new TransferVO();
		AccountVO vo2 = new AccountVO();
		vo.setAccount(req.getParameter("account"));
		vo.setSender_account(req.getParameter("sender_account"));
		System.out.println("money : "+req.getParameter("money"));
		vo.setMoney(Integer.parseInt(req.getParameter("money")));
		vo.setSender_name(req.getParameter("sender_name"));
		System.out.println("sender_name : "+req.getParameter("sender_name"));
		vo.setOut_comment(req.getParameter("out_comment"));
		vo.setIn_comment(req.getParameter("in_comment"));
		
		//-------------------------------------------
		// pwd Chk
		vo2.setAccount(req.getParameter("account"));
		System.out.println("account : "+req.getParameter("account"));
		vo2.setAccountPW(Integer.parseInt(req.getParameter("accountPW")));
		System.out.println("accountPW : "+Integer.parseInt(req.getParameter("accountPW")));
		
		int insertCnt= FDAO.checkPwd(vo2);
		System.out.println("insertCnt : "+ insertCnt);
		
			
			// 내 계좌 이체내역
			int mylog = IDAO.addMyLog(vo);
			// 상대 계좌 입금내역
			int yourlog = IDAO.addYourLog(vo);
			// 잔액 감소
			IDAO.withdrawal(vo);
			// 상대 잔액 추가
			IDAO.deposit(vo);
			
			System.out.println("mylog : "+mylog);
			System.out.println("yourlog : "+yourlog);
			System.out.println("vo2"+vo);
			
			Map<String, Object> out = new HashMap<String, Object>();
			out.put("insertCnt", insertCnt);
			
			return out;		
		

	}

}
