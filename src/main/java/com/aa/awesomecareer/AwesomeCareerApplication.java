package com.aa.awesomecareer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.aa.awesomecareer.repository.impl.BaseRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories (repositoryBaseClass = BaseRepositoryImpl.class)
public class AwesomeCareerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwesomeCareerApplication.class, args);
	}

}
