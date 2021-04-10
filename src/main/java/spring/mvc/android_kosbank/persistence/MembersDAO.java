package spring.mvc.android_kosbank.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import spring.mvc.android_kosbank.vo.AccountVO;
import spring.mvc.android_kosbank.vo.And_TransferDetailVO;
import spring.mvc.android_kosbank.vo.MembersVO;




public interface MembersDAO{
	public int insertMember(Map<String,String> map);

	public MembersVO getMemberInfo(String id);

	@Select("SELECT COUNT(*) FROM members WHERE id=#{id}")
	public int idCheck(String id);
	public AccountVO getAccountInfo_Main(String id);
	public List<AccountVO> my_Account_List(String id);
	public List<And_TransferDetailVO> get_TransferDetail(String account);
}
