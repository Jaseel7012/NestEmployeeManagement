package com.example.EmployeeManagementBackend.Controller;

import com.example.EmployeeManagementBackend.Dao.EmployeeDao;
//import com.example.EmployeeManagementBackend.Dao.LeaveDao;
import com.example.EmployeeManagementBackend.Dao.LeaveCountDao;
import com.example.EmployeeManagementBackend.Dao.LeaveDao;
import com.example.EmployeeManagementBackend.Dao.SecurityDao;
import com.example.EmployeeManagementBackend.Model.EmployeeModel;
//import com.example.EmployeeManagementBackend.Model.Leave;
import com.example.EmployeeManagementBackend.Model.LeaveCount;
import com.example.EmployeeManagementBackend.Model.LeavesApply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private LeaveDao leaveDao;
    @Autowired
    private SecurityDao securityDao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/loginemp",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> login(@RequestBody EmployeeModel e){
    HashMap<String,String> hm=new HashMap<>();
    List<EmployeeModel> l=(List<EmployeeModel>)  employeeDao.employeeChecklogin(e.getUsername(),e.getPassword());
    if (l.size()==0){
        hm.put("message","user does not exist");

        }
    else {
        int id=l.get(0).getId();
        hm.put("message","Success");
        hm.put("emp_id",String.valueOf(id));
    }
    return hm;




    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemp",consumes = "application/json",produces = "application/json")
    public String empreg(@RequestBody EmployeeModel em){
        employeeDao.save(em);
        return "added success";
    }

    @PostMapping(path = "/leave",consumes = "application/json",produces = "application/json")
    public  String leaveapply(@RequestBody LeavesApply le){
       leaveDao.save(le);

        return "apply";
    }

//    @PostMapping(path = "/leavesview",consumes = "application/json",produces = "application/json")
//    public  String Leavesview(@RequestBody LeavesApply l){
//         leaveDao.allLeaves();
//
//
//        return "added" ;
//
//    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchname",consumes = "application/json",produces = "application/json")
    public List<EmployeeModel> seachByName(@RequestBody EmployeeModel e){

        return (List<EmployeeModel>) employeeDao.SearchEmp(e.getName());
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/edit",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> editEmployee(@RequestBody EmployeeModel em){
        int id=em.getId();
        HashMap<String,String> hm=new HashMap<>();
        employeeDao.Edit(em.getId(),em.getDesignation(),em.getEmail(),em.getUsername(),em.getPassword(),em.getName());
        hm.put("status","updated");
        return hm;
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<EmployeeModel> view(){
        return (List<EmployeeModel>) employeeDao.findAll();
    }






    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userid",consumes = "application/json",produces = "application/json")
    public List<EmployeeModel> emplgetid(@RequestBody EmployeeModel em){
        return (List<EmployeeModel>) employeeDao.getuser(em.getId());
    }






}
