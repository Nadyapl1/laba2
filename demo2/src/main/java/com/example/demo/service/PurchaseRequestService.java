package com.example.demo.service;

import com.example.demo.model.PurchaseRequest;
import com.example.demo.repository.PurchaseRequestRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PurchaseRequestService {

    private final PurchaseRequestRepository repository;

    public PurchaseRequestService(PurchaseRequestRepository repository) {
        this.repository = repository;
    }

    public List<PurchaseRequest> findAll() {
        return repository.findAll();
    }

    public PurchaseRequest findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Заявка не найдена"));
    }

    public PurchaseRequest create(PurchaseRequest request) {
        request.setId(null);
        return repository.save(request);
    }

    public PurchaseRequest update(Long id, PurchaseRequest changes) {
        PurchaseRequest request = findById(id);

        if (changes.getAuthor() != null) {
            request.setAuthor(changes.getAuthor());
        }
        if (changes.getDescription() != null) {
            request.setDescription(changes.getDescription());
        }
        if (changes.getCeilingAmount() != null) {
            request.setCeilingAmount(changes.getCeilingAmount());
        }
        if (changes.getStatus() != null) {
            request.setStatus(changes.getStatus());
        }

        return repository.save(request);
    }

    public void delete(Long id) {
        PurchaseRequest request = findById(id);
        repository.delete(request);
    }
}