package spring.mvc.android_kosbank.controller;

import java.io.IOException;
import java.util.HashMap;
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
}
