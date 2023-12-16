package com.sendotp.twilio.Controller;



import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.sendotp.twilio.Service.PhoneVerificationService;


@Controller
@RequestMapping("/api")
public class SMSController {
	
	private PhoneVerificationService phoneVerificationService;
	
	@Autowired
	public SMSController(PhoneVerificationService phoneVerificationService) {
		super();
		this.phoneVerificationService = phoneVerificationService;
	}


	// http://localhost:8080/api/sendotp
	@GetMapping
	public String home() {
		return "index";
	}
	
	    @PostMapping("/sendotp")
	    public ResponseEntity<String> sendOtp(@RequestParam("phone") String phone) {
	        // Generate OTP
	        String otp = generateOtp();
	        // Send OTP via Twilio
	        phoneVerificationService.sendOtp(phone, otp);
	        
			return ResponseEntity.ok("OTP send successfully");
	    }
	
	 
	 private String generateOtp() {
		 Random random = new Random();
		    int otpDigits = 6; // Define the number of OTP digits
		    StringBuilder otp = new StringBuilder();

		    for (int i = 0; i < otpDigits; i++) {
		        otp.append(random.nextInt(10)); // Generate a random digit (0-9) and append it to the OTP
		    }

		    return otp.toString();
	    }

}
