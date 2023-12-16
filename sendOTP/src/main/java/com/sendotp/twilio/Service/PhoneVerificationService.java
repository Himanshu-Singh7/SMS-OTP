package com.sendotp.twilio.Service;
import org.springframework.stereotype.Service;
import com.twilio.rest.api.v2010.account.Message;
import com.sendotp.twilio.Config.OTPPrperties;
import com.twilio.Twilio;
import com.twilio.exception.ApiException;
import com.twilio.type.PhoneNumber;


@Service
public class PhoneVerificationService {

	private OTPPrperties otpPrperties;

	public PhoneVerificationService(OTPPrperties otpPrperties) {
	
		this.otpPrperties = otpPrperties;
		Twilio.init(otpPrperties.getAccountSid(), otpPrperties.getAuthToken());
	}
	
	public void sendOtp(String toPhoneNumber, String otp) {
        // Twilio SMS sending logic
       try {
    	   Message.creator(
    	            new PhoneNumber(toPhoneNumber),
    	            new PhoneNumber("+12058430527"),
    	            "Your OTP is: " + otp
    	        ).create();
	} catch (ApiException e) {
		System.out.println(e.getMessage());
	}
    }
	
}
