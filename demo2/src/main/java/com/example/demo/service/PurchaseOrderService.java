
package com.example.demo.service;

import com.example.demo.model.PurchaseOrder;
import com.example.demo.repository.PurchaseOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderService {

    private final PurchaseOrderRepository repository;

    public PurchaseOrderService(PurchaseOrderRepository repository) {
        this.repository = repository;
    }

    public List<PurchaseOrder> findAll() {
        return repository.findAll();
    }

    public Optional<PurchaseOrder> findById(Long id) {
        return repository.findById(id);
    }

    public PurchaseOrder save(PurchaseOrder order) {
        return repository.save(order);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
