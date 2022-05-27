package com.ms.payroll.feignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ms.payroll.model.Worker;

@Component
@FeignClient(name = "worker", path = "/worker")
public interface WorkerFeignClients {
	
	@GetMapping("{id}")
	public ResponseEntity<Worker> findId(@PathVariable("id") Long id);

}
