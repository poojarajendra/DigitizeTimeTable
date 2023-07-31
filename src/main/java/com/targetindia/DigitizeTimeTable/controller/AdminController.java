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

    @PostMapping("post/instructors")
    public String addInstructor(@RequestBody Instructor instructor)
    {
        return service.addInstructor(instructor);
    }

    @PutMapping("/put/instructors/instructor_id/{id}/instructor_name/{name}/instructor_contact/{contact}")
    public String updateInstructor(@PathVariable int id, @PathVariable String name, @PathVariable long contact){
        return service.updateInstructor(id,name,contact);
    }

    @DeleteMapping("/delete/instructors/{id}")
    public String deleteInstructor(@PathVariable int id){
        return service.deleteInstructorById(id);
    }

    @GetMapping("GET/instructors")
    public List<Instructor> getAllInstructors(){
        List<Instructor> instructors = service.getAllInstructors();
        System.out.println(instructors);
        return instructors;
    }

    @GetMapping("GET/instructors/{id}")
    public Instructor getInstructorById(@PathVariable int id){
        Optional<Instructor> instructor = service.getInstructorById(id);
        System.out.println(instructor);
        return instructor.get();
    }












//    @GetMapping("GET/students/{id}")
//    public student getStudentById(@PathVariable int id){
//        Optional<Student> student=service.getStudentById(id);
//        System.out.println(student);
//        return student.get();
//    }





























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
