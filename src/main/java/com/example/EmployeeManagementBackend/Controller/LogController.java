//package com.example.EmployeeManagementBackend.Controller;
//
//import com.example.EmployeeManagementBackend.Dao.EmployeeLogDao;
//import com.example.EmployeeManagementBackend.Model.EmployeeLog;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class LogController {
//    @Autowired
//    private EmployeeLogDao employeeLogDao;
//
//    @PostMapping(path = "/emplog",consumes = "application/json",produces = "application/json")
//    public String emplog(@RequestBody EmployeeLog el){
//        employeeLogDao.save(el);
//
//
//        return "emp log success";
//    }
//
//
//
//}
