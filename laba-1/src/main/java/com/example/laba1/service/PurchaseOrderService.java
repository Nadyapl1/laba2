
package com.example.laba1.service;

import com.example.laba1.model.PurchaseOrder;
import com.example.laba1.model.CommercialOffer;
import com.example.laba1.repository.PurchaseOrderRepository;
import com.example.laba1.repository.PurchaseRequestRepository;
import com.example.laba1.repository.CommercialOfferRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PurchaseOrderService {
    private final PurchaseOrderRepository repository;
    private final PurchaseRequestRepository requestRepository;
    private final CommercialOfferRepository offerRepository;

    public PurchaseOrderService(
            PurchaseOrderRepository repository,
            PurchaseRequestRepository requestRepository,
            CommercialOfferRepository offerRepository) {
        this.repository = repository;
        this.requestRepository = requestRepository;
        this.offerRepository = offerRepository;
    }

    public List<PurchaseOrder> findAll() {
        return repository.findAll();
    }

    public PurchaseOrder findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(
                        "Закупочный заказ не найден: " + id));
    }

    public PurchaseOrder create(PurchaseOrder order) {
        validateReferences(order);
        order.setId(null);
        return repository.save(order);
    }

    public PurchaseOrder update(Long id, PurchaseOrder changes) {
        PurchaseOrder order = findById(id);

        if (changes.getPurchaseRequestId() != null) {
            order.setPurchaseRequestId(changes.getPurchaseRequestId());
        }
        if (changes.getCommercialOfferId() != null) {
            order.setCommercialOfferId(changes.getCommercialOfferId());
        }
        if (changes.getStatus() != null) {
            order.setStatus(changes.getStatus());
        }

        validateReferences(order);
        return repository.save(order);
    }

    private void validateReferences(PurchaseOrder order) {
        if (order.getPurchaseRequestId() == null
                || !requestRepository.existsById(
                        order.getPurchaseRequestId())) {
            throw new IllegalArgumentException("Заявка не найдена");
        }

        CommercialOffer offer = offerRepository
                .findById(order.getCommercialOfferId())
                .orElseThrow(() -> new IllegalArgumentException(
                        "Коммерческое предложение не найдено"));

        if (!offer.getPurchaseRequestId()
                .equals(order.getPurchaseRequestId())) {
            throw new IllegalArgumentException(
                    "Предложение не относится к указанной заявке");
        }
    }

    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }
}
