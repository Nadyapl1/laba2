
package com.example.laba1.repository;

import com.example.laba1.model.PurchaseOrder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PurchaseOrderRepository {
    private final List<PurchaseOrder> orders = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(0);

    public List<PurchaseOrder> findAll() {
        return new ArrayList<>(orders);
    }

    public Optional<PurchaseOrder> findById(Long id) {
        return orders.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }

    public PurchaseOrder save(PurchaseOrder order) {
        if (order.getId() == null) {
            order.setId(counter.incrementAndGet());
            orders.add(order);
        } else {
            deleteById(order.getId());
            orders.add(order);
        }
        return order;
    }

    public boolean deleteById(Long id) {
        return orders.removeIf(item -> item.getId().equals(id));
    }

    public boolean existsById(Long id) {
        return findById(id).isPresent();
    }
}
