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

import spring.mvc.android_kosbank.service.FinancialProductsService;
import spring.mvc.android_kosbank.vo.Loans_productVO;

@Controller
public class FinancialProductsController {
	private static final Logger logger = LoggerFactory.getLogger(FinancialProductsController.class);
	
	@Autowired
	FinancialProductsService service;
	
	// 박서하
	//대출상품   
	@RequestMapping("/LoansProducts")
	public  @ResponseBody  List<Loans_productVO> LoansProducts(HttpServletRequest req) {
		logger.info("url ==> /LoansProducts");
		
		return service.loanProductsList(req);
	}
	
	// 박서하
	//대출상품 상세
	@RequestMapping("/LoansDetail")
	public @ResponseBody Loans_productVO LoansDetail(HttpServletRequest req,Model model) {
		logger.info("url ==> /LoansDetail");
		return service.loanProductDetail(req, model);
	}
		
}
