package com.ms.worker.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.worker.model.Worker;
import com.ms.worker.repository.WorkerRepository;

@RestController
@RequestMapping("worker")
public class WorkerController {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerController.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private WorkerRepository workerRepository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = workerRepository.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping("{id}")
	public ResponseEntity<Worker> findId(@PathVariable("id") Long id){
		System.out.println("aqui, pow");
		logger.info("Port: " + env.getProperty("local.server.port"));
		
		Optional<Worker> worker = workerRepository.findById(id);
		return ResponseEntity.ok(worker.get());
	}
}
