package com.ms.payroll.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ms.payroll.model.Payment;
import com.ms.payroll.model.Worker;

@Service
public class PaymentService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${host.worker}")
	private String hostWorker;
	
	public Payment getPayment(Long workerId, int days) {
		Map<String, String> uriVariable = new HashMap<>();
		uriVariable.put("id", workerId.toString());
		
		Worker worker = restTemplate.getForObject(hostWorker + "worker/{id}", Worker.class, uriVariable);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
