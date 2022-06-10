package com.devsuperior.hrworker.resources;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
    @Autowired
    private Environment environment;

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping(value = "/listAll")
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> workers = (List<Worker>) workerRepository.findAll();
        return ResponseEntity.ok().body(workers);
    }

    //findById
    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        try {
            logger.info("PORT = " + environment.getProperty("local.server.port"));

            Worker worker = workerRepository.findById(id).get();
            return ResponseEntity.ok().body(worker);
        } catch (Exception e) {
            throw new RuntimeException("Worker not found");
        }

    }

}
