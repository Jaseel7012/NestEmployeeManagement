//package com.example.EmployeeManagementBackend.Controller;
//
//import com.example.EmployeeManagementBackend.Dao.LeaveCountDao;
//import com.example.EmployeeManagementBackend.Dao.LeaveDao;
//import com.example.EmployeeManagementBackend.Model.EmployeeModel;
//import com.example.EmployeeManagementBackend.Model.LeaveCount;
//import com.example.EmployeeManagementBackend.Model.LeavesApply;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.time.temporal.ChronoUnit;
//import java.util.HashMap;
//import java.util.List;
//
//@RestController
//public class LeaveController {
//    @Autowired
//            private LeaveDao leaveDao;
//    @Autowired
//            private LeaveCountDao leaveCountDao;
//    DateTimeFormatter dtf1=DateTimeFormatter.ofPattern("dd/MM/yyyy");
//    DateTimeFormatter ytf=DateTimeFormatter.ofPattern("yyyy");
//
//
//   public int daysbtwdate(String date1,String date2){
//       LocalDate dt1=LocalDate.parse(date1);
//       LocalDate dt2=LocalDate.parse(date2);
//       return Math.abs((int) ChronoUnit.DAYS.between(dt1,dt2));
//   }
////
////
////
//    @CrossOrigin(origins = "*")
//    @PostMapping(path = "/leaveapply",consumes = "application/json",produces="application/json")
//    public HashMap<String, String> Leaveapply(@RequestBody LeavesApply la) {
//        HashMap<String, String> hm = new HashMap<>();
//        String strt = la.getFrmdate();
//        String end = la.getTodate();
//        int difference = daysbtwdate(strt, end);
//        leaveDao.save(la);
//        int empid=la.getEmp_id();
//        LeaveCount lc1=new LeaveCount();
//
//        LeaveCount lc=leaveCountDao.leavedtls(la.getEmp_id());
//
//        System.out.println(lc.getEmp_id());
//        System.out.println(la.getType());
//        if(la.getType().equals("sick")){
//            if(difference<=lc.getSick()){
//                lc.setSick(lc.getCas()-difference);
//                leaveCountDao.save(lc);
//            }else {
//                System.out.println("failed");
//                hm.put("status","failed");
//            }
//        } else if (la.getType().equals("special")) {
//          if (difference<=lc.getSpecial()) {
//              lc.setSpecial(lc.getSpecial()-difference);
//              leaveCountDao.save(lc);
//
//          }
//          else {
//              hm.put("status","failed");
//          }
//        }
//
//    return hm;
//    }
//
//
////    @PostMapping(path = "/leave",produces = "application/json",consumes="application/json")
////    public List<LeaveCount > Getleavedtle(@RequestBody LeavesApply lc){
////       LocalDateTime now=LocalDateTime.now();
////       List<LeaveCount> leave=leaveCountDao.getleavedtls(Integer.valueOf(lc.getEmp_id()),ytf.format(now));
////       if (leave.size()==0){
////           LeaveCount l1=new LeaveCount();
////           l1.setEmp_id(lc.getEmp_id());
////           l1.setSick(7);
////           l1.setCas(20);
////           l1.setSpecial(3);
////           l1.setYear(ytf.format(now));
////           leaveCountDao.save(l1);
////           List<LeaveCount> tl=leaveCountDao.getleavedtls(Integer.valueOf(lc.getEmp_id()),ytf.format(now));
////           return tl;
////       }
////       else {
////           return leave;
////       }
////    }
//
//}
