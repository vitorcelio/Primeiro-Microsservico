package com.ms.payroll.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.payroll.feignClients.WorkerFeignClients;
import com.ms.payroll.model.Payment;
import com.ms.payroll.model.Worker;

@Service
public class PaymentService {
	
	@Autowired
	private WorkerFeignClients workerFeignClients;
	
	public Payment getPayment(Long workerId, Integer days) {
		Worker worker = workerFeignClients.findId(workerId).getBody();
		System.out.println(worker.getName());
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
