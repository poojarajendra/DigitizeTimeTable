package com.targetindia.DigitizeTimeTable.controller;

import com.targetindia.DigitizeTimeTable.service.AdminService;
import com.targetindia.DigitizeTimeTable.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("instructor")
public class InstructorController {
    @Autowired
    InstructorService service;

    @GetMapping("GET/time_table/instructors_id/{id}/day/{day}")
    public HashMap<String, ArrayList<String>> getInstructorDayTimeTable(@PathVariable int id, @PathVariable String day){
        return service.getInstructorDayTimeTable(id, day);
    }
    @GetMapping("GET/time_table/{id}")
    public HashMap<String,HashMap<String, ArrayList<String>>> getInstructorWeeklyTimeTable(@PathVariable int id){
        return service.getInstructorWeeklyTimeTable(id);
    }
}
