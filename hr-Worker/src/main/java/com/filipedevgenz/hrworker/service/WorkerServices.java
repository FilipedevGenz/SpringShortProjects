package com.filipedevgenz.hrworker.service;

import com.filipedevgenz.hrworker.infra.exceptions.GlobalException;
import com.filipedevgenz.hrworker.model.Worker;
import com.filipedevgenz.hrworker.repository.WorkerRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@Service
public class WorkerServices {
    @Autowired
    WorkerRepository repository;

    public List<Worker> getAll() {
        List<Worker> workers = repository.findAll();
        if (!workers.isEmpty()) {
            return workers;
        }
        throw new GlobalException("No workers found");
    }

    public Worker getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new GlobalException("Worker not found"));
    }

    public Worker save(Worker worker) {
        return repository.save(worker);
    }
}
