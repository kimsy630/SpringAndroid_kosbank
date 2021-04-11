package spring.mvc.android_kosbank.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.android_kosbank.service.RegisterReleaseService;

@Controller
public class RegisterReleaseController {

	@Autowired
	RegisterReleaseService RegisterReleaseService;
	
	private static final Logger logger = LoggerFactory.getLogger(RegisterReleaseController.class);
	
	@RequestMapping("/androidAccountAddPage")
	public @ResponseBody Map<String, Object> androidAccountAddPage(HttpServletRequest req){
		logger.info("url ==> /androidAccountAddPage");
		String id = req.getParameter("id");
		System.out.println("id == " + id);
		Map<String, Object> map = RegisterReleaseService.IdNameChk(req);
		
		return map;
	}
	
	@RequestMapping("/androidAccountAdd")
	public @ResponseBody Map<String, Object> androidAccountAdd(HttpServletRequest req){
		logger.info("url ==> /androidAccountAdd");
		System.out.println("androidAccountAdd");
		String id = req.getParameter("id");
		System.out.println("id == " + id);
		Map<String, Object> map = RegisterReleaseService.AddAccountService(req);
		
		return map;
	}
	
	
	@RequestMapping("/androidAccountDelete")
	public @ResponseBody List<String> androidAccountDelete(HttpServletRequest req){
		logger.info("url ==> /androidAccountDelete");
		System.out.println("androidAccountDelete");
		String id = req.getParameter("id");
		System.out.println("id == " + id);		
		List<String> list = new ArrayList<String>();
		list = RegisterReleaseService.DeleteAccountService(req);
		
		return list;
	}
	
	@RequestMapping("/androidAccountDeleteAction")
	public @ResponseBody Map<String, Object> androidAccountDeleteAction(HttpServletRequest req){
		logger.info("url ==> /androidAccountDeleteAction");
		System.out.println("androidAccountDeleteAction");
		String id = req.getParameter("id");
		System.out.println("id == " + id);
		Map<String, Object> map = RegisterReleaseService.DeleteAccount(req);
		
		return map;
	}
	
}
