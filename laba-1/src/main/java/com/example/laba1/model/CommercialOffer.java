
package com.example.laba1.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CommercialOffer {
    private Long id;
    private Long purchaseRequestId;
    private Long supplierId;
    private BigDecimal price;
    private Integer deliveryDays;
    private LocalDateTime validUntil;

    public CommercialOffer() {
    }

    public CommercialOffer(Long id, Long purchaseRequestId, Long supplierId,
                           BigDecimal price, Integer deliveryDays,
                           LocalDateTime validUntil) {
        this.id = id;
        this.purchaseRequestId = purchaseRequestId;
        this.supplierId = supplierId;
        this.price = price;
        this.deliveryDays = deliveryDays;
        this.validUntil = validUntil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPurchaseRequestId() {
        return purchaseRequestId;
    }

    public void setPurchaseRequestId(Long purchaseRequestId) {
        this.purchaseRequestId = purchaseRequestId;
    }

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getDeliveryDays() {
        return deliveryDays;
    }

    public void setDeliveryDays(Integer deliveryDays) {
        this.deliveryDays = deliveryDays;
    }

    public LocalDateTime getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(LocalDateTime validUntil) {
        this.validUntil = validUntil;
    }
}
