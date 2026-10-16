
package com.example.demo.controller;

import com.example.demo.model.PurchaseOrder;
import com.example.demo.service.PurchaseOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {

    private final PurchaseOrderService service;

    public PurchaseOrderController(PurchaseOrderService service) {
        this.service = service;
    }

    @GetMapping
    public List<PurchaseOrder> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrder> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PurchaseOrder> create(@RequestBody PurchaseOrder order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(order));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PurchaseOrder> update(
            @PathVariable Long id,
            @RequestBody PurchaseOrder updatedOrder) {

        return service.findById(id).map(order -> {
            if (updatedOrder.getSupplierName() != null) {
                order.setSupplierName(updatedOrder.getSupplierName());
            }
            if (updatedOrder.getDescription() != null) {
                order.setDescription(updatedOrder.getDescription());
            }
            if (updatedOrder.getTotalAmount() != null) {
                order.setTotalAmount(updatedOrder.getTotalAmount());
            }
            if (updatedOrder.getStatus() != null) {
                order.setStatus(updatedOrder.getStatus());
            }
            return ResponseEntity.ok(service.save(order));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (service.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
