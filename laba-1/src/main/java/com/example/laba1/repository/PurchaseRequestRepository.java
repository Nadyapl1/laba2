
package com.example.laba1.repository;

import com.example.laba1.model.PurchaseRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PurchaseRequestRepository {
    private final List<PurchaseRequest> requests = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(0);

    public List<PurchaseRequest> findAll() {
        return new ArrayList<>(requests);
    }

    public Optional<PurchaseRequest> findById(Long id) {
        return requests.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }

    public PurchaseRequest save(PurchaseRequest request) {
        if (request.getId() == null) {
            request.setId(counter.incrementAndGet());
            requests.add(request);
        } else {
            deleteById(request.getId());
            requests.add(request);
        }
        return request;
    }

    public boolean deleteById(Long id) {
        return requests.removeIf(item -> item.getId().equals(id));
    }

    public boolean existsById(Long id) {
        return findById(id).isPresent();
    }
}
