package com.ms.payroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.payroll.feignClients.WorkerFeignClients;
import com.ms.payroll.model.Payment;
import com.ms.payroll.model.Worker;

@Service
public class PaymentService {
	
//	@Autowired
//	private RestTemplate restTemplate;
	
//	@Value("${host.worker}")
//	private String hostWorker;
	
	@Autowired
	private WorkerFeignClients workerFeignClients;
	
	public Payment getPayment(Long workerId, Integer days) {
//		Map<String, String> uriVariable = new HashMap<>();
//		uriVariable.put("id", workerId.toString());
//		
//		Worker worker = restTemplate.getForObject(hostWorker + "worker/{id}", Worker.class, uriVariable);
		
		Worker worker = workerFeignClients.findId(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
