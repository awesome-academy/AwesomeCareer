package com.aa.awesomecareer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.aa.awesomecareer.repository.impl.BaseRepositoryImpl;
import com.cloudinary.Cloudinary;

@SpringBootApplication
@EnableJpaRepositories (repositoryBaseClass = BaseRepositoryImpl.class)
public class AwesomeCareerApplication implements WebMvcConfigurer {
	
	@Value("${cloudinary.cloud_name}")
	private String cloudName;

	@Value("${cloudinary.api_key}")
	private String apiKey;

	@Value("${cloudinary.api_secret}")
	private String apiSecret;

	public static void main(String[] args) {
		SpringApplication.run(AwesomeCareerApplication.class, args);
	}
	
	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/highchart").setViewName("/admin/landing-page");
    }
	
	@Bean
	public Cloudinary cloudinaryConfig() {
		Cloudinary cloudinary = null;
		Map config = new HashMap();
		config.put("cloud_name", cloudName);
		config.put("api_key", apiKey);
		config.put("api_secret", apiSecret);
		cloudinary = new Cloudinary(config);
		return cloudinary;
	}

}
