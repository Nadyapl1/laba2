
package com.example.laba1.model;

public class PurchaseOrder {
    private Long id;
    private Long purchaseRequestId;
    private Long commercialOfferId;
    private String status;

    public PurchaseOrder() {
    }

    public PurchaseOrder(Long id, Long purchaseRequestId,
                         Long commercialOfferId, String status) {
        this.id = id;
        this.purchaseRequestId = purchaseRequestId;
        this.commercialOfferId = commercialOfferId;
        this.status = status;
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

    public Long getCommercialOfferId() {
        return commercialOfferId;
    }

    public void setCommercialOfferId(Long commercialOfferId) {
        this.commercialOfferId = commercialOfferId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
