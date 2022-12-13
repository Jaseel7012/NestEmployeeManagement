package com.example.EmployeeManagementBackend.Dao;

import com.example.EmployeeManagementBackend.Model.LeaveCount;
import com.example.EmployeeManagementBackend.Model.LeavesApply;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface LeaveDao extends CrudRepository<LeavesApply,Integer> {
@Query(value = "SELECT l.`id`, l.`applydate`, l.`emp_id`, l.`frmdate`, l.`remarks`, l.`todate`, l.`type` FROM `leaves` As l JOIN employee As e ON e.id=l.emp_id ",nativeQuery = true)
    List<Map<String,String>> allLeaves();



}

