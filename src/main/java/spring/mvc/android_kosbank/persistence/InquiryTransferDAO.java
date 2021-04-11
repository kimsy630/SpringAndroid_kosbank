package spring.mvc.android_kosbank.persistence;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import spring.mvc.android_kosbank.vo.TransferVO;


@Repository
public interface InquiryTransferDAO {
		
	// 내 계좌 이체내역
	public int addMyLog(TransferVO transferVO);
	
	// 상대 계좌 입금내역
	public int addYourLog(TransferVO transferVO);
	
	// 잔액 감소
	public int withdrawal(TransferVO transferVO);
	
	// 상대 잔액 추가
	public int deposit(TransferVO transferVO);
	
	
}
