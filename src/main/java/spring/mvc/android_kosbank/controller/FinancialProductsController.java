package spring.mvc.android_kosbank.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.mvc.android_kosbank.persistence.FinancialProductsDAO;
import spring.mvc.android_kosbank.service.FinancialProductsService;
import spring.mvc.android_kosbank.vo.Deposit_productVO;
import spring.mvc.android_kosbank.vo.Loans_productVO;
import spring.mvc.android_kosbank.vo.savings_productVO;

@Controller
public class FinancialProductsController extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(FinancialProductsController.class);

	@Autowired
	FinancialProductsService service;
	
	@Autowired
	FinancialProductsDAO dao;
	
	@RequestMapping("/DepositList")
	public @ResponseBody List<Deposit_productVO> DepositList(HttpServletRequest req){
		logger.info("url ==> /DepositList");
		return dao.getDepositList();
	}
	@RequestMapping("/SavingsList")
	public @ResponseBody List<savings_productVO> SavingsList(HttpServletRequest req){
		logger.info("url ==> /SavingsList");
		return dao.getSavingsList();
	}
	@RequestMapping("/BankItemDeposit")
	public @ResponseBody Deposit_productVO BankItemDeposit(HttpServletRequest req){
		logger.info("url ==> /BankItemDeposit");
		return dao.BankItemDeposit();
	}
	@RequestMapping("/BankItemSavings")
	public @ResponseBody savings_productVO BankItemSavings(HttpServletRequest req){
		logger.info("url ==> /BankItemSavings");
		return dao.BankItemSavings();
	}
	

	
	// 박서하
	// 금융상품(대출)
	@RequestMapping("/BankItemLoan")
	public  @ResponseBody  Loans_productVO BankItemLoan(HttpServletRequest req) {
		logger.info("url ==> /BankItemLoan");
		
		return service.loanProduct(req);
	}
	
	// 박서하
	// 대출상품   
	@RequestMapping("/LoansProducts")
	public  @ResponseBody  List<Loans_productVO> LoansProducts(HttpServletRequest req) {
		logger.info("url ==> /LoansProducts");
		
		return service.loanProductsList(req);
	}
	
	// 박서하
	// 대출상품 상세
	@RequestMapping("/LoansDetail")
	public @ResponseBody Loans_productVO LoansDetail(HttpServletRequest req,Model model) {
		logger.info("url ==> /LoansDetail");
		return service.loanProductDetail(req, model);
	}
	
	
}
