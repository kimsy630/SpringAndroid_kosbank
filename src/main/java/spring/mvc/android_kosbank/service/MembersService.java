package spring.mvc.android_kosbank.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.android_kosbank.vo.AccountVO;
import spring.mvc.android_kosbank.vo.And_TransferDetailVO;

@Service
public interface MembersService {
	public Map<String,Object> androidLogiIn(HttpServletRequest req);
	public int androidSignUp(HttpServletRequest req);
	public Map<String,Object> getAccountInfo_Main(HttpServletRequest req);
	public List<AccountVO> my_Account_List(HttpServletRequest req);
	public List<And_TransferDetailVO> get_TransferDetail(HttpServletRequest req);
}
