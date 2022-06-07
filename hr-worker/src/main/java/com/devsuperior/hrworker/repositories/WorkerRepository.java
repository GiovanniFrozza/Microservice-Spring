package com.devsuperior.hrworker.repositories;

import com.devsuperior.hrworker.entities.Worker;
import org.springframework.data.repository.CrudRepository;

public interface WorkerRepository extends CrudRepository<Worker, Long> {

}
