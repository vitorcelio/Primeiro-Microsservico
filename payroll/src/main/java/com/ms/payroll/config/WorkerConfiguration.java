package com.ms.payroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.okhttp.OkHttpClient;

@Configuration
public class WorkerConfiguration {
	
	@Bean
    public OkHttpClient client() {
        return new OkHttpClient();
    }

}
