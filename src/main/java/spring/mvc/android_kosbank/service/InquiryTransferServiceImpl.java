package spring.mvc.android_kosbank.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.fusesource.jansi.Ansi.Erase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.firebase.messaging.FirebaseMessagingException;

import spring.mvc.android_kosbank.persistence.FinancialProductsDAO;
import spring.mvc.android_kosbank.persistence.InquiryTransferDAO;
import spring.mvc.android_kosbank.vo.AccountVO;
import spring.mvc.android_kosbank.vo.TransferVO;



@Service
public class InquiryTransferServiceImpl implements InquiryTransferService{
	
	@Autowired
	InquiryTransferDAO IDAO;
	
	@Autowired
	FinancialProductsDAO FDAO;
	
	/*
	
	@Override
	public void transferTable(HttpServletRequest req, Model model) {
		TransferVO vo = new TransferVO();
		vo.setAccount(req.getParameter("account"));
		vo.setSender_account(req.getParameter("sender_account"));
		System.out.println(req.getParameter("money"));
		vo.setMoney(Integer.parseInt(req.getParameter("money")));
		vo.setSender_name(req.getParameter("sender_name"));
		vo.setOut_comment(req.getParameter("out_comment"));
		vo.setIn_comment(req.getParameter("in_comment"));
		System.out.println("vo : "+vo);
		
		model.addAttribute("vo",vo);
		
	}
	*/
	// 김소림
	// 계좌이체 실행
	@Override
	public Map<String,Object> transferAction(HttpServletRequest req) {
		String strId = req.getParameter("id");
		TransferVO vo = new TransferVO();
		AccountVO vo2 = new AccountVO();
		vo.setAccount(req.getParameter("account"));
		vo.setSender_account(req.getParameter("sender_account"));
		System.out.println("money : "+req.getParameter("money"));
		vo.setMoney(Integer.parseInt(req.getParameter("money")));
		vo.setSender_name(req.getParameter("sender_name"));
		System.out.println("sender_name : "+req.getParameter("sender_name"));
		vo.setOut_comment(req.getParameter("out_comment"));
		vo.setIn_comment(req.getParameter("in_comment"));
		
		//-------------------------------------------
		// pwd Chk
		vo2.setAccount(req.getParameter("account"));
		System.out.println("account : "+req.getParameter("account"));
		vo2.setAccountPW(Integer.parseInt(req.getParameter("accountPW")));
		System.out.println("accountPW : "+Integer.parseInt(req.getParameter("accountPW")));
		
		int insertCnt= FDAO.checkPwd(vo2);
		System.out.println("insertCnt : "+ insertCnt);
		
			
		// 내 계좌 이체내역
		int mylog = IDAO.addMyLog(vo);
		// 상대 계좌 입금내역
		int yourlog = IDAO.addYourLog(vo);
		// 잔액 감소
		IDAO.withdrawal(vo);
		// 상대 잔액 추가
		IDAO.deposit(vo);
		
		System.out.println("mylog : "+mylog);
		System.out.println("yourlog : "+yourlog);
		System.out.println("vo2"+vo);
		
		Map<String, Object> out = new HashMap<String, Object>();
		out.put("insertCnt", insertCnt);
		try {
			asFcmTest(vo.getAccount(),vo.getSender_account(),vo.getMoney(),req.getParameter("token"),"file:///"+req.getRealPath("/src/main/webapp/resources/fcm/")+"ivory-partition-310307-firebase-adminsdk-l7xoy-2d2d43dbbc.json");
		} catch (FirebaseMessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return out;		
	}
	public void asFcmTest(String account,String sender_account, int money,String token,String file) throws FirebaseMessagingException {
	      
	      try {    
	            
	         // 경로에 따라서 줘라
	    	  //file:///C:/apache-tomcat-8.5.61/wtpwebapps/SpringAndroid_kosbank/resources/fcm/
	    	  //       C:\apache-tomcat-8.5.61\wtpwebapps\SpringAndroid_kosbank\src\main\webapp\resources\fcm\
	    	  
	    	 ///C:/apache-tomcat-8.5.61/wtpwebapps/SpringAndroid_kosbank/resources/fcm/
	    	  	//String path=file.replace("src\\main\\webapp\\", "");
	            //String path = "D:/Dev76/workspace_android/SpringAndroid_kosbank/src/main/webapp/resources/fcm/ivory-partition-310307-firebase-adminsdk-l7xoy-2d2d43dbbc.json";           
	    	  String path="D:/Dev_76/workspace/SpringAndroid_kosbank/src/main/webapp/resources/fcm/ivory-partition-310307-firebase-adminsdk-l7xoy-2d2d43dbbc.json";
	            String MESSAGING_SCOPE = "https://www.googleapis.com/auth/firebase.messaging";
	            String[] SCOPES = { MESSAGING_SCOPE };
	            GoogleCredential googleCredential = GoogleCredential
	                                .fromStream(new FileInputStream(path))
	                                .createScoped(Arrays.asList(SCOPES));
	            googleCredential.refreshToken();
	                                
	            HttpHeaders headers = new HttpHeaders();
	            headers.add("content-type" , MediaType.APPLICATION_JSON_VALUE);
	            headers.add("Authorization", "Bearer " + googleCredential.getAccessToken());
	            
	            System.out.println("headers : " + headers);
	            Map<String, Object> notification = new HashMap<>();
	            notification.put("body", account+"계좌에서 "+sender_account+"계좌로 "+money+"원 계좌이체 되었습니다");
	            notification.put("title", "Kosbank");
	            
	            Map<String, Object> message = new HashMap<>();
	            // 기기별 토큰 주입
	            message.put("token", token);
	            message.put("notification", notification);
	            
	            Map<String, Object> jsonParams = new HashMap<>();
	            jsonParams.put("message", message);
	            
	            
	            HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<>(jsonParams, headers);
	            RestTemplate rt = new RestTemplate();            
	            
	            // Firebase 프로젝트 ID별 삽입
	            ResponseEntity<String> res = rt.exchange("https://fcm.googleapis.com/v1/projects/ivory-partition-310307/messages:send"
	                    , HttpMethod.POST
	                    , httpEntity
	                    , String.class);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	   }
	private String Erase(String file, String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
