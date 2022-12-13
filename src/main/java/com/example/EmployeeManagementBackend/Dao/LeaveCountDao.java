package com.example.EmployeeManagementBackend.Dao;

import com.example.EmployeeManagementBackend.Model.EmployeeModel;
import com.example.EmployeeManagementBackend.Model.LeaveCount;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LeaveCountDao extends CrudRepository<LeaveCount,Integer> {

}

