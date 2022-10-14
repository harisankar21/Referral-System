package com.social.referral;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

//exclude={DataSourceAutoConfiguration.class}
@SpringBootApplication()

public class ReferralApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReferralApplication.class, args);
	}

}
