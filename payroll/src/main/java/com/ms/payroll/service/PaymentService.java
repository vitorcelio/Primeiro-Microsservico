package com.ms.payroll.service;

import org.springframework.stereotype.Service;

import com.ms.payroll.model.Payment;

@Service
public class PaymentService {
	public Payment getPayment(Long workerId, int days) {
		return new Payment("Vitor", 200.0, days);
	}
}
