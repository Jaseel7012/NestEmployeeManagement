package com.example.EmployeeManagementBackend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "leaves")
public class LeavesApply {
    @Id
    @GeneratedValue

    private int id;
    private int emp_id;
    private String type;
    private  String frmdate;
    private String todate;
    private String applydate;
    private String remarks;

    public LeavesApply() {
    }

    public LeavesApply(int id, int emp_id, String type, String frmdate, String todate, String applydate, String remarks) {
        this.id = id;
        this.emp_id = emp_id;
        this.type = type;
        this.frmdate = frmdate;
        this.todate = todate;
        this.applydate = applydate;
        this.remarks = remarks;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFrmdate() {
        return frmdate;
    }

    public void setFrmdate(String frmdate) {
        this.frmdate = frmdate;
    }

    public String getTodate() {
        return todate;
    }

    public void setTodate(String todate) {
        this.todate = todate;
    }

    public String getApplydate() {
        return applydate;
    }

    public void setApplydate(String applydate) {
        this.applydate = applydate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
