package com.vishwajeet.job_tracker.entity;

import jakarta.persistence.*;
@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String company;
    private String role;
    private String status;       // APPLIED, INTERVIEW, OFFER, REJECTED, WISHLIST
    private String appliedDate;  // keep as String for now (yyyy-MM-dd)
    private String source;
    private String notes;

    // getters & setters

    public String getCompany() {
        return company;
    }

    public int getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public String getStatus() {
        return status;
    }

    public String getAppliedDate() {
        return appliedDate;
    }

    public String getSource() {
        return source;
    }

    public String getNotes() {
        return notes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setAppliedDate(String appliedDate) {
        this.appliedDate = appliedDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}