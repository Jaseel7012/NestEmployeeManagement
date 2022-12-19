package com.example.EmployeeManagementBackend.Controller;


import com.example.EmployeeManagementBackend.Dao.VisitorLogDao;
import com.example.EmployeeManagementBackend.Model.VisitorLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@RestController
public class VisitorLogController {

    @Autowired
    private VisitorLogDao visitorLogDao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addvisitorlog",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> addVisitor(@RequestBody VisitorLog visitorLog){
        HashMap<String,String> hm=new HashMap<>();
        visitorLogDao.save(visitorLog);
        hm.put("Status","Success");
        hm.put("Quest_Id",String.valueOf(visitorLog.getId()));
        return hm;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/exitvisitorlog",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> exitVisitorlog(@RequestBody VisitorLog vl){
        HashMap<String,String> hm=new HashMap<>();
        visitorLogDao.ExitLogvisitor(vl.getExittime(),vl.getId());
        hm.put("status","success");

        return hm;
    }
    @CrossOrigin(origins = "*")
    @GetMapping (path = "/viewvisitorlog")
    public List<VisitorLog> viewvisitor(){
        return (List<VisitorLog>) visitorLogDao.findAll();
    }

}
