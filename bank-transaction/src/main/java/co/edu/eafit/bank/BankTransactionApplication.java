package co.edu.eafit.bank;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class BankTransactionApplication {
	
	@Value("${otp.service.validate.url}")
    private String otpServiceValidateUrl;

	public static void main(String[] args) {
		SpringApplication.run(BankTransactionApplication.class, args);
	}
	
	// Activate WebClient
    @Bean
    public WebClient otpWebClient() {
        return WebClient.builder()
                .baseUrl(otpServiceValidateUrl)
                .build();
    }

}
