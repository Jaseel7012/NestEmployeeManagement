package com.example.EmployeeManagementBackend.Dao;

import com.example.EmployeeManagementBackend.Model.EmployeeModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends CrudRepository<EmployeeModel,Integer> {

    @Query(value = "SELECT `id`, `designation`, `email`, `name`, `password`, `username` FROM `employee` WHERE `username`=:username AND `password`=:password",nativeQuery = true)
    List<EmployeeModel> employeeChecklogin(@Param("username") String username,@Param("password") String password);
    @Query(value = "SELECT `id`, `designation`, `email`, `name`, `password`, `username` FROM `employee` WHERE `name` Like %:name%",nativeQuery = true)
    List<EmployeeModel> SearchEmp(@Param("name") String name) ;

@Modifying
@Transactional
    @Query(value = "UPDATE `employee` SET  `designation`=:designation,`email`=:email,`name`=:name,`password`=:password,`username`=:username WHERE `id`=:id",nativeQuery = true)
    void  Edit(@Param("id") int id,@Param("designation") String designation,@Param("email") String email,@Param("name") String name,@Param("password") String password,@Param("username") String username);

}
