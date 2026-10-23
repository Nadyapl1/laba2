
package com.example.laba1.model;

public class Supplier {

    private Long id;
    private String name;
    private String category;
    private Boolean approved;

    public Supplier() {
    }

    public Supplier(Long id, String name, String category, Boolean approved) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.approved = approved;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getApproved() {
        return approved;
    }

    public void setApproved(Boolean approved) {
        this.approved = approved;
    }
}
