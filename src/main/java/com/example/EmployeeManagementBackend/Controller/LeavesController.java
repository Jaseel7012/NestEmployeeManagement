package com.example.EmployeeManagementBackend.Controller;

import com.example.EmployeeManagementBackend.Dao.LeaveCountDao;
import com.example.EmployeeManagementBackend.Dao.LeaveDao;
import com.example.EmployeeManagementBackend.Model.LeaveCount;
import com.example.EmployeeManagementBackend.Model.LeavesApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LeavesController {
    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/yyyy");
    @Autowired
    private LeaveCountDao leaveCountDao;
    @Autowired
    private LeaveDao leaveDao;
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/leaveapply",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> leaveapply(@RequestBody LeavesApply la){
        HashMap<String,String> hm=new HashMap<>();
        List<LeaveCount> l1=leaveCountDao.leavecountEmp(la.getEmp_id());
        LocalDate todate=LocalDate.parse(la.getTodate());
        LocalDate frmdte=LocalDate.parse(la.getFrmdate());
        int days=(int) ChronoUnit.DAYS.between(frmdte,todate)+1;
        if(l1.size()>0){
            if(days<leavecheck(l1,la.getType())){
                leaveDao.save(la);
                hm.put("status","success");
            }else{
                hm.put("status","fil");
            }
        }
        else {
            hm.put("status","not see");
        }
        return hm;
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/viewcountempleave",consumes = "application/json",produces = "application/json")
    public List<LeaveCount> leavecountemp(@RequestBody LeaveCount leaveCount){
        return (List<LeaveCount>) leaveCountDao.leavecountEmp(leaveCount.getEmp_id());
    }
    @CrossOrigin(origins = "*")

    @PostMapping(path="/leavestatus",consumes = "application/json",produces = "application/json")
    public List<LeavesApply> viewstatusLeave(@RequestBody LeavesApply la){
        return (List<LeavesApply>) leaveDao.leavestts(la.getEmp_id());
    }

//    @PostMapping(path="viewallleave",consumes = "application/json",produces = "application/json")
    @CrossOrigin(origins = "*")

    @GetMapping("/viewallleave")
    public List<Map<String,String>> viewalltypeleave(){
        return (List<Map<String, String>>)  leaveDao.allleaves();

    }
    @CrossOrigin(origins = "*")

    @GetMapping("/leavepending")
    public List<Map<String,String>> allPendingleaves(){
        return  (List<Map<String,String>>) leaveDao.remainingleaves();
    }

    public int leavecheck(List<LeaveCount> leaveCounts,String leavetype){
        if(leavetype.equals("sick")){
            return leaveCounts.get(0).getSick();
        } else if (leavetype.equals("special")) {
            return  leaveCounts.get(0).getSpecial();
        }
        else {
            return leaveCounts.get(0).getCas();
        }
    }



}
