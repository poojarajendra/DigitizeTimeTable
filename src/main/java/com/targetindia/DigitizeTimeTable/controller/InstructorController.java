//package com.targetindia.DigitizeTimeTable.controller;
//
//import com.targetindia.DigitizeTimeTable.service.AdminService;
//import com.targetindia.DigitizeTimeTable.service.InstructorService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("instructor")
//public class InstructorController {
//    @Autowired
//    InstructorService service;
//
//    @GetMapping("GET/time_table/instructors_id/{id}/day/{day}")
//    public HashMap<String, ArrayList<String>> getInstructorDayTimeTable(@PathVariable int id, @PathVariable String day){
//        return service.getInstructorDayTimeTable(id, day);
//    }
//    @GetMapping("GET/time_table/{id}")
//    public HashMap<String,HashMap<String, ArrayList<String>>> getInstructorWeeklyTimeTable(@PathVariable int id){
//        return service.getInstructorWeeklyTimeTable(id);
//    }
//}
package com.targetindia.DigitizeTimeTable.controller;

        import com.targetindia.DigitizeTimeTable.service.AdminService;
        import com.targetindia.DigitizeTimeTable.service.InstructorService;
        import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("instructors")
public class InstructorController {
    @Autowired
    InstructorService service;

    @GetMapping("/time_table/{id}/{day}")
    public ResponseEntity<HashMap<String, ArrayList<String>>> getInstructorDayTimeTable(@PathVariable int id, @PathVariable String day){
        HashMap<String, ArrayList<String>> instructorDayTimeTable = service.getInstructorDayTimeTable(id, day);
        if(instructorDayTimeTable.isEmpty()){
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }
        return ResponseEntity.of(Optional.of(instructorDayTimeTable));
    }
    @GetMapping("/time_table/{id}")
    public ResponseEntity<HashMap<String,HashMap<String, ArrayList<String>>>> getInstructorWeeklyTimeTable(@PathVariable int id){
        HashMap<String,HashMap<String, ArrayList<String>>> instructorWeeklyTimeTable = service.getInstructorWeeklyTimeTable(id);
        if(instructorWeeklyTimeTable.isEmpty()){
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }
        return ResponseEntity.of(Optional.of(instructorWeeklyTimeTable));
    }}

