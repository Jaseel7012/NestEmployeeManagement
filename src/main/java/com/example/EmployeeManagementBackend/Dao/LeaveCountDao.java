package com.example.EmployeeManagementBackend.Dao;

import com.example.EmployeeManagementBackend.Model.EmployeeModel;
import com.example.EmployeeManagementBackend.Model.LeaveCount;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LeaveCountDao extends CrudRepository<LeaveCount,Integer> {
@Query(value = "SELECT * FROM `leavecountnew` WHERE `emp_id`= :emp_id",nativeQuery = true)
    List<LeaveCount> leavecountEmp(@Param("emp_id") int emp_id);
}

