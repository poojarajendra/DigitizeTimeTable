//package com.targetindia.DigitizeTimeTable.controller;
//
//import com.targetindia.DigitizeTimeTable.service.AdminService;
//import com.targetindia.DigitizeTimeTable.service.StudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
//@RestController
//@RequestMapping("student")
//public class StudentController {
//    @Autowired
//    StudentService service;
//
//    @GetMapping("/GET/time_table/class_id/{class_id}/day/{day}")
//    public HashMap<String, ArrayList<String>> getStudentDayTimeTable(@PathVariable int class_id, @PathVariable String day){
//        return service.getStudentDayTimeTable(class_id, day);
//    }
//
//    @GetMapping("/time_table/{class_id}")
//    public HashMap<String, HashMap<String, ArrayList<String>>> getStudentWeeklyTimeTable(@PathVariable int class_id){
//        return service.getStudentWeeklyTimeTable(class_id);
//    }
//}
package com.targetindia.DigitizeTimeTable.controller;

import com.targetindia.DigitizeTimeTable.service.AdminService;
import com.targetindia.DigitizeTimeTable.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@RestController
@RequestMapping("students")
public class StudentController {
    @Autowired
    StudentService service;

    @GetMapping("/time_table/{class_id}/{day}")
    public ResponseEntity<HashMap<String, ArrayList<String>>> getStudentDayTimeTable(@PathVariable int class_id, @PathVariable String day){
        HashMap<String, ArrayList<String>> studentDayTimeTable = service.getStudentDayTimeTable(class_id, day);
        if (studentDayTimeTable.isEmpty()){
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }
        return ResponseEntity.of(Optional.of(studentDayTimeTable));
    }

    @GetMapping("/time_table/{class_id}")
    public ResponseEntity<HashMap<String, HashMap<String, ArrayList<String>>>> getStudentWeeklyTimeTable(@PathVariable int class_id){
        HashMap<String, HashMap<String, ArrayList<String>>> studentWeeklyTimeTable = service.getStudentWeeklyTimeTable(class_id);
        if(studentWeeklyTimeTable.isEmpty()){
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }
        return ResponseEntity.of(Optional.of(studentWeeklyTimeTable));
    }
}

