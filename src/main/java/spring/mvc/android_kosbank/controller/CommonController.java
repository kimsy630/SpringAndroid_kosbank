package spring.mvc.android_kosbank.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.mvc.android_kosbank.service.MembersService;
import spring.mvc.android_kosbank.vo.AccountVO;
import spring.mvc.android_kosbank.vo.And_TransferDetailVO;

@Controller
public class CommonController extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	MembersService memberService;
	
	@RequestMapping("/androidLogiIn")
	public @ResponseBody Map<String, Object> androidSignIn(HttpServletRequest req){
		logger.info("url ==> /androidLogiIn");
		System.out.println("123123213");
		
		Map<String, Object> map =memberService.androidLogiIn(req);
		
		return map;
	}
	
	@RequestMapping("/androidSignUp")
	public @ResponseBody int androidSignUp(HttpServletRequest req){
		logger.info("url ==> /androidSignUp");
		System.out.println("signUp");
		int insertCnt = memberService.androidSignUp(req);
		
		System.out.println(insertCnt);
		return insertCnt;
	}
	@RequestMapping("/getAccountInfo_Main")
	public @ResponseBody Map<String, Object> getAccountInfo_Main(HttpServletRequest req,Model model) {
		logger.info("url ==> /getAccountInfo_Main");
		Map<String, Object> map = memberService.getAccountInfo_Main(req);
		return map;
	}
	@RequestMapping("/my_Account_List")
	public @ResponseBody List<AccountVO> my_Account_List(HttpServletRequest req) {
		logger.info("url ==> /my_Account_List");
		List<AccountVO> vo = memberService.my_Account_List(req);
		return vo;
	}
	@RequestMapping("/get_TransferDetail")
	public @ResponseBody List<And_TransferDetailVO> get_TransferDetail(HttpServletRequest req) {
		logger.info("url ==> /get_TransferDetail");
		List<And_TransferDetailVO> vo = memberService.get_TransferDetail(req);
		System.out.println(vo);
		return vo;
	}
	
}
