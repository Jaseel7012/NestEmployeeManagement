package com.example.EmployeeManagementBackend.Dao;

import com.example.EmployeeManagementBackend.Model.LeaveCount;
import com.example.EmployeeManagementBackend.Model.LeavesApply;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface LeaveDao extends CrudRepository<LeavesApply,Integer> {
@Query(value = "SELECT * FROM `leavesmodel` WHERE `emp_id`=:emp_id",nativeQuery = true)
    List<LeavesApply> leavestts(@Param("emp_id") Integer emp_id);
@Query(value = "SELECT * FROM `leavesmodel` lm JOIN `employee` e ON lm.emp_id=e.id",nativeQuery = true)
    List<Map<String,String>> allleaves();
@Query(value = "SELECT l.`id`, l. `emp_id`, l.`frmdate`, l.`leavestatus`, l.`remarks`, l.`todate`, l.`type` FROM\n" +
        "`leavesmodel` l JOIN leavecountnew lc ON l.emp_id=lc.emp_id JOIN employee e ON e.id=l.emp_id\n" +
        "WHERE l.leavestatus=0",nativeQuery = true)
    List<Map<String,String>> remainingleaves();



}

