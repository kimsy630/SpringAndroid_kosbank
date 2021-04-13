package spring.mvc.android_kosbank.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.firebase.messaging.FirebaseMessagingException;

import spring.mvc.android_kosbank.service.InquiryTransferService;
import spring.mvc.android_kosbank.service.RegisterReleaseService;
import spring.mvc.android_kosbank.vo.AccountVO;

@Controller
public class InquiryTransferController {
		
	@Autowired
	RegisterReleaseService RegisterReleaseService;
	
	@Autowired
	InquiryTransferService InquiryTransferService;
	
	@Autowired
	spring.mvc.android_kosbank.service.FCMService FCMService;
	
	private static final Logger logger = LoggerFactory.getLogger(InquiryTransferController.class);
	
	@RequestMapping("/androidAccountTransfer")
	public @ResponseBody List<AccountVO> androidAccountTransfer(HttpServletRequest req){
		logger.info("url ==> /androidAccountTransfer");
		System.out.println("androidAccountTransfer");
		String id = req.getParameter("id");
		System.out.println("id == " + id);
		
		List<AccountVO> list = new ArrayList<AccountVO>();
		list = RegisterReleaseService.AccountInoutLoansType(req);
		return list;
	}
	
	@RequestMapping("/androidAccountNameCnk")
	public @ResponseBody Map<String, Object> androidAccountNameCnk(HttpServletRequest req){
		logger.info("url ==> /androidAccountNameCnk");
		System.out.println("androidAccountNameCnk");
		String id = req.getParameter("id");
		System.out.println("id == " + id);
		
		Map<String, Object> map = RegisterReleaseService.AccountNameChk(req);
		
		return map;
	}
	
	@RequestMapping("/androidAccountTransferAction")
	public @ResponseBody Map<String, Object> androidAccountTransferAction(HttpServletRequest req){
		logger.info("url ==> /androidAccountTransferAction");
		System.out.println("androidAccountTransferAction");
		String id = req.getParameter("id");
		System.out.println("id == " + id);
		
		Map<String, Object> map = InquiryTransferService.transferAction(req);
			
			try {
				FCMService.asFcmTest();
			} catch (FirebaseMessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return map;
	}
	
	
	
}
