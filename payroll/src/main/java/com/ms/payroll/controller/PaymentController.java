package com.ms.payroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.payroll.model.Payment;
import com.ms.payroll.service.PaymentService;

@RestController
@RequestMapping("payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("{workerId}/days/{days}")
	public ResponseEntity<Payment> findById(@PathVariable("workerId") Long id, @PathVariable("days") Integer days){
		Payment payment = paymentService.getPayment(id, days);
		return ResponseEntity.ok(payment);
	}
	
}
