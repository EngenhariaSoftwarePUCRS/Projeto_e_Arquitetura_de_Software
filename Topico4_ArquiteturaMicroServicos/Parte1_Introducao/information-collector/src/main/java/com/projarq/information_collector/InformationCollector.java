package com.projarq.information_collector;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class InformationCollector {
    @Id
    private Long id;
    @Column(name = "currency")
    private String currency;
    @Column(name = "operation")
    private String operation;
    @Column(name = "timestmp")
    private Long timestamp;
    
    public InformationCollector() {
    }

    public InformationCollector(Long id, String currency, String operation, Long timestamp) {
        this.id = id;
        this.currency = currency;
        this.operation = operation;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

}
