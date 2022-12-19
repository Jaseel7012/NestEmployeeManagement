package com.example.EmployeeManagementBackend.Dao;

import com.example.EmployeeManagementBackend.Model.EmployeeLog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface LogDao extends CrudRepository<EmployeeLog,Integer> {

    @Query(value = "UPDATE `emplog1` SET `exit_time`=:exit_time WHERE `emp_id`=:emp_id",nativeQuery = true)
    void updateExitLog(@Param("exit_time") String exitTime,@Param("emp_id") Integer emp_id);

    @Query(value = "SELECT el.`id`, el.`date`, el.`emp_id`, el.`entry_time`, el.`exit_time`,e.name FROM `emplog1` el JOIN employee e on e.id=el.emp_id",nativeQuery = true)
    List<Map<String,String>> alllogwithnme();

    @Query(value = "SELECT el.`id`, el.`date`, el.`emp_id`, el.`entry_time`, el.`exit_time`,e.id FROM `emplog1` el JOIN employee e ON e.id=el.emp_id" +
            " WHERE el.date=:date",nativeQuery = true)
    List<Map<String,String>> datewithlog(@Param("date") String date);
}
