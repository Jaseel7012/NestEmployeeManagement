package com.example.EmployeeManagementBackend.Dao;

import com.example.EmployeeManagementBackend.Model.Security;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SecurityDao extends CrudRepository<Security,Integer> {

    @Query(value = "SELECT `id`, `name`, `password`, `sec_id`, `uname` FROM `security` WHERE `uname`=:uname AND `password`=:password",nativeQuery = true)
    List<Security> SecurityLogin(@Param("uname") String uname,@Param("password") String password);

}
