package com.ms.worker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ms.worker.model.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
