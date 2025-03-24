package com.filipedevgenz.hrworker.controller;

import com.filipedevgenz.hrworker.infra.exceptions.GlobalException;
import com.filipedevgenz.hrworker.model.Worker;
import com.filipedevgenz.hrworker.service.WorkerServices;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@NoArgsConstructor
@RestController
@RequestMapping(value = "/workers")
public class WorkerController {

    @Autowired
    WorkerServices services;

    @GetMapping
    public ResponseEntity<List<Worker>> getWorkers() {
        List<Worker> workers = services.getAll();
        return ResponseEntity.ok(workers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Worker> getWorkerById (@PathVariable Long id) {
        Worker obj = services.getById(id);
        return ResponseEntity.ok(obj);
    }

    @PostMapping("/addWorker/{name},{dailyIncome}")
    public ResponseEntity<Worker> addWorker(@RequestBody Worker worker) {
        Worker obj = services.save(worker);
        return ResponseEntity.ok(obj);
    }
}
