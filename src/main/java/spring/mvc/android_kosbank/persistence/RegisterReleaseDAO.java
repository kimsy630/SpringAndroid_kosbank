package spring.mvc.android_kosbank.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import spring.mvc.android_kosbank.vo.AccountVO;


@Repository
public interface RegisterReleaseDAO{
	// 계좌 개설
	public int insertAccount(AccountVO accountvo);
	
	// 계좌 해지 리스트
	public List<String> deleteAccountList(String id);
	
	// ID로 회원이름 조회
	public String IdNameChk(String id);
	
	// 계좌 해지 액션
	public int deleteAccount(Map<String, Object> map);
	
	// 보유 계좌(입출금&대출) 리스트
	public List<AccountVO> selectTransferType(String id);
	
	// 예금주 조회
	public String AccountNameChk(String account);
	
	/*
	// 보유 전체계좌 리스트
	public List<AccountVO> selectById(String id);
	
	// 보유 계좌(정상) 리스트
	public List<AccountVO> selectNomalById(String id);
	
	// 보유 계좌(입출금) 리스트
	public List<AccountVO> selectType(String id);
	
	// 계좌비밀번호 Chk
	public int AccountPwdCheck(String aacount);
	
	*/
}
