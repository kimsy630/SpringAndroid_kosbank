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
import spring.mvc.android_kosbank.persistence.FundingDAO;
import spring.mvc.android_kosbank.vo.FundingVO;


@Service
public class FundingServiceImpl implements FundingService{
	
	@Autowired
	FundingDAO dao;
	
	// ============================================================================

	// 전형민
	// 펀드상품 조회
	@Override
	public List<FundingVO> FundProducts(HttpServletRequest req, Model model) { 
		String f_category = req.getParameter("f_category");
		List<FundingVO> list = new ArrayList<FundingVO>();
		
		if(f_category.equals("전체보기")) {
			
			try {
				list = dao.getFundProductAll();
				for(int i = 0; i< list.size(); i++) {
					String str_end_date = list.get(i).getF_end_date();
					SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date end_date = transFormat.parse(str_end_date);
					Date today = new Date();
					int compare = end_date.compareTo(today);
					if(compare < 0) {
						list.remove(i);
						 i--;
					}
				}
				model.addAttribute("list", list);
			} 
			catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				list = dao.getFundProductCat(f_category);
				for(int i = 0; i< list.size(); i++) {
					String str_end_date = list.get(i).getF_end_date();
					SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date end_date = transFormat.parse(str_end_date);
					Date today = new Date();
					int compare = end_date.compareTo(today);
					if(compare < 0) {
						list.remove(i);
						 i--;
					}
				}
				model.addAttribute("list", list);
			} 
			catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	// ============================================================================

	
	
}
