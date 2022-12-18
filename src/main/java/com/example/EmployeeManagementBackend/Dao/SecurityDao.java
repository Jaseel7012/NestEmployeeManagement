package com.example.EmployeeManagementBackend.Dao;


import com.example.EmployeeManagementBackend.Model.SecurityNew;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecurityDao extends CrudRepository<SecurityNew,Integer> {

    @Query(value = "SELECT `id`, `email`, `name`, `password`, `sec_code`, `uname` FROM `securitynew` WHERE `uname`=:uname AND`password`=:password",nativeQuery = true)
    List<SecurityNew> SecurityLogin(@Param("uname") String uname,@Param("password") String password);
//
    @Query(value = "SELECT `id`, `email`, `name`, `password`, `sec_code`, `uname` FROM `securitynew` WHERE `name` LIKE %:name%",nativeQuery = true)
    List<SecurityNew> SearchSecurityQuard(@Param("name")String name);

    @Query(value = "SELECT * FROM `securitynew` WHERE `id`=:id",nativeQuery = true)
    List<SecurityNew> securitygetid(@Param("id") Integer id);

}
