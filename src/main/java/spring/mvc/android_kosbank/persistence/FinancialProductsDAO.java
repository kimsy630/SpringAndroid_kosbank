package spring.mvc.android_kosbank.persistence;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import spring.mvc.android_kosbank.vo.AccountVO;


public interface FinancialProductsDAO{
	
	// 가입폼에 입력한 출금/자동이체용 계좌 비밀번호 일치확인
	public int checkPwd(AccountVO vo);
	
}
