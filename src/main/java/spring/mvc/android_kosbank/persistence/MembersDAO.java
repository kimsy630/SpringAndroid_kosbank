package spring.mvc.android_kosbank.persistence;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import spring.mvc.android_kosbank.vo.MembersVO;




public interface MembersDAO{
	public int insertMember(MembersVO vo);

	public MembersVO getMemberInfo(String id);

	@Select("SELECT COUNT(*) FROM members WHERE id=#{id}")
	public int idCheck(String id);
}
