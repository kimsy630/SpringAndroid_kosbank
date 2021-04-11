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
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import spring.mvc.android_kosbank.persistence.FinancialProductsDAO;
import spring.mvc.android_kosbank.service.MembersService;
import spring.mvc.android_kosbank.vo.Deposit_productVO;
import spring.mvc.android_kosbank.vo.savings_productVO;

@Controller
public class FinancialProductsController extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(FinancialProductsController.class);
	
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
	
	
	
	
	
	
	
}
 