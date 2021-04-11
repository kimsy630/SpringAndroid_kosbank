package spring.mvc.android_kosbank.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.mvc.android_kosbank.service.FundingService;
import spring.mvc.android_kosbank.vo.FundingVO;

@Controller
public class FundingController {
	private static final Logger logger = LoggerFactory.getLogger(FundingController.class);
	
	@Autowired
	FundingService service;
	
	// 전형민
	// 펀드상품   
	@RequestMapping("/FundProducts")
	public  @ResponseBody  List<FundingVO> FundProducts(HttpServletRequest req, Model model) {
		logger.info("url ==> /FundProducts");
		
		return service.FundProducts(req, model);
	}
		
}
