package com.targetindia.DigitizeTimeTable.controller;

import com.targetindia.DigitizeTimeTable.model.Instructor;
import com.targetindia.DigitizeTimeTable.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminService service;

    @PostMapping("/addInstructor")
    public String addInstructor(@RequestBody Instructor instructor)
    {
        return service.addInstructor(instructor);
    }

    @PostMapping("/addInstructors")
    public void addAllInstructor(@RequestBody List<Instructor> ins)
    {
        service.addAllInstructors(ins);
    }
//   //instructor data in obj format
//
//    @PutMapping("/updateInstructor")
//    public void updateInstructor(@RequestBody Instructor instr){
//        service.updateInstructor(instr);
//    }

    @PutMapping("/updateInstructor/{id}/{name}/{contact}")
    public String updateInstructor(@PathVariable int id, @PathVariable String name, @PathVariable long contact){
        return service.updateInstructor(id,name,contact);
    }

    @DeleteMapping("/deleteInstructor/{id}")
    public String deleteInstructor(@PathVariable int id){
        return service.deleteInstructorById(id);
    }

    @PutMapping("/{class_id}/{dow}/{slot}")
    public String updatePeriodInfo(@PathVariable int class_id, @PathVariable String dow, @PathVariable String slot){
        return service.updatePeriodInfo(class_id,dow,slot);
    }

    @GetMapping("/instructors")
    public List<Instructor> getAllInstructors(){
        List<Instructor> instructors = service.getAllInstructors();
        System.out.println(instructors);
        return instructors;
    }

    @GetMapping("/instructor/{id}")
    public Instructor getInstructorById(@PathVariable int id){
        Optional<Instructor> instructor = service.getInstructorById(id);
        System.out.println(instructor);
        return instructor.get();
    }
//    @GetMapping("/checkavailabilityofinstructor/{id}/{slot}")
//    public String check_availability_of_instructor(@PathVariable int id,@PathVariable String slot){
//        String message = service.check_availability_of_instructor(id,slot);
//        System.out.println(message);
//        return message;
//    }
//    @PutMapping("/{class_id}")
//    public String classInfo(@PathVariable int class_id){
//        return service.updateClassInfo(class_id);
//    }

//    @PutMapping("/{student_id}")
//    public String updateStudentInfo(@PathVariable int student_id){
//        return service.updateStudentInfo(student_id);
//    }



//    @PostMapping("/addCourse/{class_id}/{course_name}/{location}/{instructor_id}")
//    public String addNewCourse(@PathVariable int class_id, @PathVariable String course_name,
//                               @PathVariable String location, @PathVariable int instructor_id){
//        return service.addNewCourse(class_id, course_name, location, instructor_id);
//    }

}
