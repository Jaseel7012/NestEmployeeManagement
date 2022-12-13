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
import com.example.EmployeeManagementBackend.Model.Security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private LeaveCountDao ldao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private LeaveDao leaveDao;
    @Autowired
    private SecurityDao securityDao;


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
    @PostMapping(path = "/addemp",consumes = "application/json",produces = "application/json")
    public String empreg(@RequestBody EmployeeModel em){
        employeeDao.save(em);
        return "added success";
    }
    @PostMapping(path = "/leavec",consumes = "application/json",produces="application/json")
    public String leaveadd(@RequestBody LeaveCount l){

        ldao.save(l);
        return  "leave";
    }
    @PostMapping(path = "/leave",consumes = "application/json",produces = "application/json")
    public  String leaveapply(@RequestBody LeavesApply le){
       leaveDao.save(le);

        return "apply";
    }

    @PostMapping(path = "/leavesview",consumes = "application/json",produces = "application/json")
    public  String Leavesview(@RequestBody LeavesApply l){
         leaveDao.allLeaves();


        return "added" ;

    }
    @PostMapping(path = "/searchname",consumes = "application/json",produces = "application/json")
    public List<EmployeeModel> seachByName(@RequestBody EmployeeModel e){

        return (List<EmployeeModel>) employeeDao.SearchEmp(e.getName());
    }

    @PostMapping(path = "/edit",consumes = "application/json",produces = "application/json")
    public String editEmployee(@RequestBody EmployeeModel em){
        int id=em.getId();
        employeeDao.Edit(em.getId(),em.getDesignation(),em.getEmail(),em.getUsername(),em.getPassword(),em.getName());

        return "edited";
    }
    @GetMapping("/view")
    public List<EmployeeModel> view(){
        return (List<EmployeeModel>) employeeDao.findAll();
    }

    @PostMapping(path = "/addsec",consumes = "application/json",produces = "application/json")
    public String addsecurity(@RequestBody Security sc){

        securityDao.save(sc);
        return "security added";
    }

    @PostMapping(path = "/loginsecurity",consumes = "application/json",produces="application/json")
    public HashMap<String,String> seclog(@RequestBody Security sc){

        HashMap<String,String> hm1=new HashMap<>();

        List<Security> re=(List<Security>) securityDao.SecurityLogin(sc.getUname(),sc.getPassword());
        System.out.println(sc.getPassword());
        System.out.println(sc.getUname());
        if(re.size()==0){
            hm1.put("message","invalid");

        }else {
            hm1.put("status","success");
        }
        return hm1;

    }



}
