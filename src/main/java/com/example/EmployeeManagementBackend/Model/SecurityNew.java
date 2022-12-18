package com.example.EmployeeManagementBackend.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "securitynew")
public class SecurityNew {
    @Id
    @GeneratedValue
    private int id;
    private int sec_code;
    private String name;
    private String email;
    private String uname;
    private String password;

    public SecurityNew() {
    }

    public SecurityNew(int id, int sec_code, String name, String email, String uname, String password) {
        this.id = id;
        this.sec_code = sec_code;
        this.name = name;
        this.email = email;
        this.uname = uname;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSec_code() {
        return sec_code;
    }

    public void setSec_code(int sec_code) {
        this.sec_code = sec_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}