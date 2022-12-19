package com.example.EmployeeManagementBackend.Controller;

import com.example.EmployeeManagementBackend.Dao.EmployeeDao;
import com.example.EmployeeManagementBackend.Dao.LeaveDao;
import com.example.EmployeeManagementBackend.Dao.LogDao;
import com.example.EmployeeManagementBackend.Model.EmployeeLog;
import com.example.EmployeeManagementBackend.Model.EmployeeModel;
import com.example.EmployeeManagementBackend.Model.LeavesApply;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.lang.model.util.Elements;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LogEmpController {

    @Autowired
    private LogDao logDao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addemplog",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> addemplog(@RequestBody EmployeeLog el){
        HashMap<String,String> hm=new HashMap<>();
        logDao.save(el);
        hm.put("status","success");
        return hm;

    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/exitaddemplog",consumes = "application/json",produces = "application/json")
    public String deleteemp(@RequestBody EmployeeLog el){
        logDao.updateExitLog(el.getExitTime(),el.getEmp_id());
        return "failed";
    }

@CrossOrigin(origins = "*")
    @PostMapping(path = "/viewlogemp",consumes = "application/json",produces = "application/json")
    public List<Map<String,String>>  viewlogemp(@RequestBody EmployeeLog el){
        return  (List<Map<String,String>>) logDao.alllogwithnme();
    }
@CrossOrigin(origins = "*")
    @PostMapping(path = "/viewlogempdate",consumes = "application/json",produces = "application/json")
    public List<Map<String,String>> viewdatelog(@RequestBody EmployeeLog el){
        return (List<Map<String,String>>) logDao.datewithlog(el.getDate());
    }







//    @CrossOrigin(origins = "*")
//    @PostMapping(path = "/emplogadd",consumes = "application/json",produces = "application/json")
//    public HashMap<String,String> addlogEmp(@RequestBody EmployeeLog el){
//        HashMap<String,String> hm=new HashMap<>();
//        List<EmployeeModel> l=employeeDao.getuser(el.getId());
//        if(l.size()>0){
//            List<LeavesApply> leavecheck=leaveDao.emplcheckleave(l.get(0).getId(),el.getDate());
//            if(leavecheck.size()==0){
//                el.setEmp_id(l.get(0).getId());
//                logDao.save(el);
//                hm.put("status","success");
//
//            }else{
//                hm.put("status","fail");
//            }
//        }
//        return hm;
//    }

}
