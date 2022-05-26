package com.ms.worker.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private WorkerRepository workerRepository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = workerRepository.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping("{id}")
	public ResponseEntity<Worker> findId(@PathVariable("id") Long id){
		Optional<Worker> worker = workerRepository.findById(id);
		return ResponseEntity.ok(worker.get());
	}
}
