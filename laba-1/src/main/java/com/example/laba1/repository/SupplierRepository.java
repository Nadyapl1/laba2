
package com.example.laba1.repository;

import com.example.laba1.model.Supplier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class SupplierRepository {
    private final List<Supplier> suppliers = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(0);

    public List<Supplier> findAll() {
        return new ArrayList<>(suppliers);
    }

    public Optional<Supplier> findById(Long id) {
        return suppliers.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();
    }

    public Supplier save(Supplier supplier) {
        if (supplier.getId() == null) {
            supplier.setId(counter.incrementAndGet());
            suppliers.add(supplier);
        } else {
            deleteById(supplier.getId());
            suppliers.add(supplier);
        }
        return supplier;
    }

    public boolean deleteById(Long id) {
        return suppliers.removeIf(item -> item.getId().equals(id));
    }

    public boolean existsById(Long id) {
        return findById(id).isPresent();
    }
}
