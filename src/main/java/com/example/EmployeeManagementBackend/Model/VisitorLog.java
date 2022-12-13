//package com.example.EmployeeManagementBackend.Model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//
//@Entity
//@Table(name = "visiterlog")
//public class VisitorLog {
//    @Id
//    @GeneratedValue
//    private int id;
//    private String name;
//    private  String purpose;
//    private String entry_date;
//    private String exit_date;
//
//    public VisitorLog() {
//    }
//
//    public VisitorLog(int id, String name, String purpose, String entry_date, String exit_date) {
//        this.id = id;
//        this.name = name;
//        this.purpose = purpose;
//        this.entry_date = entry_date;
//        this.exit_date = exit_date;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPurpose() {
//        return purpose;
//    }
//
//    public void setPurpose(String purpose) {
//        this.purpose = purpose;
//    }
//
//    public String getEntry_date() {
//        return entry_date;
//    }
//
//    public void setEntry_date(String entry_date) {
//        this.entry_date = entry_date;
//    }
//
//    public String getExit_date() {
//        return exit_date;
//    }
//
//    public void setExit_date(String exit_date) {
//        this.exit_date = exit_date;
//    }
//}
