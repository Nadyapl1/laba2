
package com.example.laba1.model;

import java.math.BigDecimal;

public class PurchaseRequest {
    private Long id;
    private Long authorId;
    private String description;
    private BigDecimal maxAmount;
    private String status;

    public PurchaseRequest() {
    }

    public PurchaseRequest(Long id, Long authorId, String description,
                           BigDecimal maxAmount, String status) {
        this.id = id;
        this.authorId = authorId;
        this.description = description;
        this.maxAmount = maxAmount;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(BigDecimal maxAmount) {
        this.maxAmount = maxAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
