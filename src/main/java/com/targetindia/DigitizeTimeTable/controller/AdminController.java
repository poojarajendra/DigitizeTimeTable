
package com.targetindia.DigitizeTimeTable.controller;

import com.targetindia.DigitizeTimeTable.model.Instructor;
import com.targetindia.DigitizeTimeTable.service.AdminService;
//import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("admins")
public class AdminController {
    @Autowired
    AdminService service;

    @PostMapping("/instructors")
    public ResponseEntity<String> addInstructor(@RequestBody Instructor instructor)
    {
        service.addInstructor(instructor);
        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body("Instructor added successfully");
    }
    @PutMapping("/instructors/{id}/{name}/{contact}")
    public ResponseEntity<Optional<String>> updateInstructor(@PathVariable int id, @PathVariable String name, @PathVariable long contact) {
        String updatedInstructor = service.updateInstructor(id, name, contact);
        if (updatedInstructor.isEmpty()) {
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }
        return ResponseEntity.ok(Optional.of(updatedInstructor));

    }

    @DeleteMapping("/instructors/{id}")
    public ResponseEntity<Optional<String>> deleteInstructor(@PathVariable int id){
        String deleted =service.deleteInstructorById(id);
        if(deleted.isEmpty()){
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }
        return ResponseEntity.ok(Optional.of(deleted));
    }

    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> getAllInstructors(){
        List<Instructor> instructors = service.getAllInstructors();
        if (instructors.isEmpty()) {
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }
        return ResponseEntity.of(Optional.of(instructors));
    }

    @GetMapping("/instructors/{id}")
    public ResponseEntity<Optional<Instructor>> getInstructorById(@PathVariable int id){
        Optional<Instructor> instructor = service.getInstructorById(id);
        if (instructor.isEmpty()){
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
        }
        System.out.println(instructor);
        return ResponseEntity.of(Optional.of(instructor));
    }}






//@PostMapping("/addInstructors")
//    public void addAllInstructor(@RequestBody List<Instructor> instr)
//    {
//
//        service.addAllInstructors(instructors);
//        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body("Instructors added successfully");
//    }
//   //instructor data in obj format
//
//    @PutMapping("/updateInstructor")
//    public void updateInstructor(@RequestBody Instructor instr){
//        service.updateInstructor(instr);
//    }
//    @PutMapping("/{class_id}/{dow}/{slot}")
//    public ResponseEntity<Optional<String>> updatePeriodInfo(@PathVariable int class_id, @PathVariable String dow, @PathVariable String slot){
//        String updatedPeriodInfo = service.updatePeriodInfo(class_id,dow,slot);
//        if (updatedPeriodInfo.isEmpty()) {
//            return ResponseEntity.status(HttpStatusCode.valueOf(404)).build();
//        }
//        return ResponseEntity.ok(Optional.of(updatedPeriodInfo));
//
//    }
