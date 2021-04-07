package spring.mvc.android_kosbank.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public interface MembersService {
	public Map<String,Object> androidLogiIn(HttpServletRequest req);
	public int androidSignUp(HttpServletRequest req);
}
