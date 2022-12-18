package com.example.EmployeeManagementBackend.Dao;

import com.example.EmployeeManagementBackend.Model.EmployeeModel;
import com.example.EmployeeManagementBackend.Model.LeaveCount;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LeaveCountDao extends CrudRepository<LeaveCount,Integer> {
@Query(value = "SELECT * FROM `leavecountnew` WHERE `emp_id`= :emp_id",nativeQuery = true)
    List<LeaveCount> leavecountEmp(@Param("emp_id") int emp_id);
@Modifying
@Transactional
@Query(value = "UPDATE `leavecountnew` SET `sick`=:sick WHERE `emp_id`=:emp_id",nativeQuery = true)
    void sick(@Param("sick") Integer difference,@Param("emp_id") Integer emp_id);

//@Modifying
//@Transactional
//@Query(value = "UPDATE `leavecountnew` SET `special`=:diff1 WHERE `emp_id`=:emp_id",nativeQuery = true)
//    void special(@Param("special") Integer difference,@Param("emp_id") Integer emp_id);
@Modifying
@Transactional
@Query(value = "UPDATE `leavecountnew` SET `cas`=:cas WHERE `emp_id`=:emp_id",nativeQuery = true)
    void cas(@Param("cas") Integer difference,@Param("emp_id") Integer emp_id);
@Modifying
@Transactional
@Query(value = "UPDATE `leavecountnew` SET `special`=:special WHERE `emp_id`=:emp_id",nativeQuery = true)
    void special(@Param("special") Integer difference,@Param("emp_id") Integer emp_id);
//@Modifying
//@Transactional
//@Query(value = "UPDATE `leavecountnew` SET `special`=:difference WHERE `emp_id`=:emp_id",nativeQuery = true)
//    void special(@Param("special") Integer difference,@Param("emp_id") Integer emp_id);

}

