package spring.mvc.android_kosbank.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.firebase.messaging.FirebaseMessagingException;

import spring.mvc.android_kosbank.persistence.FinancialProductsDAO;
import spring.mvc.android_kosbank.persistence.InquiryTransferDAO;
import spring.mvc.android_kosbank.vo.AccountVO;
import spring.mvc.android_kosbank.vo.TransferVO;



@Service
public class FCMService{
	
	// 안드로이드 FCM 테스트	
	   public void asFcmTest() throws FirebaseMessagingException {
	      
	      try {    
	            
	         // 경로에 따라서 줘라
	            String path = "D:/Dev76/workspace_android/SpringAndroid_kosbank/src/main/webapp/resources/fcm/ivory-partition-310307-firebase-adminsdk-l7xoy-2d2d43dbbc.json";           
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
	            notification.put("body", "계좌이체 되었습니다");
	            notification.put("title", "계좌이체");
	            
	            Map<String, Object> message = new HashMap<>();
	            // 기기별 토큰 주입
	            message.put("token", "d4DUK-kdUn4:APA91bFCbgJQUC0RKP6VafvNQqs0NFI_PrCz3iPLn6gxmk76NPkQT4wAOhafoKPcJHsWA1W8DKq-HK9mrs2afFKsTx8LppDxN5JH3DMH0B9YN0_7gkzIrd75a3gP0xhUtIEgpnbKg3ux");
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
}
