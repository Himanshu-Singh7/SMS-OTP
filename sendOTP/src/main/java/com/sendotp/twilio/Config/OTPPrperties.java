package com.sendotp.twilio.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import lombok.Getter;
import lombok.Setter;

@Configuration

@Getter
@Setter
public class OTPPrperties {

	 @Value("${twilio.accountSid}")
	    private String accountSid;

	    @Value("${twilio.authToken}")
	    private String authToken;

	    
}
