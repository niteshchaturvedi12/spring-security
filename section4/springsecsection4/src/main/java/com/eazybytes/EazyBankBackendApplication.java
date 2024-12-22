package com.eazybytes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EntityScan("com.eazybytes.model") - not required as the entity class in subpackage
//@EnableJpaRepositories("com.eazybytes.repositories") - not required as the repository class in subpackage
//@EnableWebSecurity - Not required in spring boot
public class EazyBankBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazyBankBackendApplication.class, args);
	}

}
