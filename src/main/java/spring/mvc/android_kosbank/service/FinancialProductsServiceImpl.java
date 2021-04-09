package spring.mvc.android_kosbank.service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.android_kosbank.persistence.FinancialProductsDAO;
import spring.mvc.android_kosbank.vo.Loans_productVO;


@Service
public class FinancialProductsServiceImpl implements FinancialProductsService{
	
	@Autowired
	FinancialProductsDAO dao;
	
	// ============================================================================
	// 박서하
	// 대출상품 조회
	@Override
	public List<Loans_productVO> loanProductsList(HttpServletRequest req) { 		
		return dao.getLoanList();		
	}

	// 박서하
	// 대출상품 상세조회
	@Override
	public Loans_productVO loanProductDetail(HttpServletRequest req, Model model) { 
		String d_name = req.getParameter("d_name");
		
		return dao.getLoanDetail(d_name);
	}
	// ============================================================================
	
}
