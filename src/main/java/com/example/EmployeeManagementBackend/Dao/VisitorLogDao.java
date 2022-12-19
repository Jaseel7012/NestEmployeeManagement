package com.example.EmployeeManagementBackend.Dao;

import com.example.EmployeeManagementBackend.Model.VisitorLog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface VisitorLogDao extends CrudRepository<VisitorLog,Integer> {


    @Query(value = "UPDATE `visitorlog1` SET `exittime`=:exittime WHERE `id`=:id",nativeQuery = true)

  void ExitLogvisitor(@Param("exittime") String exittime,@Param("id") Integer Quest_id);

}
