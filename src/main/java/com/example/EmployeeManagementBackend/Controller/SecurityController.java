package com.example.EmployeeManagementBackend.Controller;

import com.example.EmployeeManagementBackend.Dao.SecurityDao;

import com.example.EmployeeManagementBackend.Model.SecurityNew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class SecurityController {
    @Autowired
    private SecurityDao sdao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addsec", consumes = "application/json", produces = "application/json")
    public String addsecurity(@RequestBody SecurityNew sc) {
        sdao.save(sc);
        return "added";
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/viewsecquard")
    public List<SecurityNew> viewallsec() {
        return (List<SecurityNew>) sdao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/searchsecname", consumes = "application/json", produces = "application/json")
    public List<SecurityNew> searchSecurityByname(@RequestBody SecurityNew s) {
        return (List<SecurityNew>) sdao.SearchSecurityQuard(s.getName());

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/loginsecurity", consumes = "application/json", produces = "application/json")
    public HashMap<String, String> seclog(@RequestBody SecurityNew sc) {

        HashMap<String, String> hm1 = new HashMap<>();

        List<SecurityNew> re = (List<SecurityNew>) sdao.SecurityLogin(sc.getUname(), sc.getPassword());
        System.out.println(sc.getPassword());
        System.out.println(sc.getUname());
        System.out.println(sc.getId());

        if (re.size() == 0) {
            hm1.put("message", "invalid");
            hm1.put("status", "fail");

        } else {
            int id = re.get(0).getId();
            System.out.println(id);
            hm1.put("s_id", String.valueOf(id));
            hm1.put("status", "success");
        }
        return hm1;

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/securityprofile", consumes = "application/json", produces = "application/json")
    public List<SecurityNew> securityprofile(@RequestBody SecurityNew sc) {
        return (List<SecurityNew>) sdao.securitygetid(sc.getId());
    }
}
