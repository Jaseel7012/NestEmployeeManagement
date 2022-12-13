package com.example.EmployeeManagementBackend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "leavecount")
public class LeaveCount {
    @Id
    @GeneratedValue

    private int id;
    private int emp_id;
    private String year;
    private int sick;
    private int cas;
    private int special=3;

    public LeaveCount() {
    }

    public LeaveCount(int id, int emp_id, String year, int sick, int cas, int special) {
        this.id = id;
        this.emp_id = emp_id;
        this.year = year;
        this.sick = sick;
        this.cas = cas;
        this.special = special;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getSick() {
        return sick;
    }

    public void setSick(int sick) {
        this.sick = sick;
    }

    public int getCas() {
        return cas;
    }

    public void setCas(int cas) {
        this.cas = cas;
    }

    public int getSpecial() {
        return special;
    }

    public void setSpecial(int special) {
        this.special = special;
    }
}
