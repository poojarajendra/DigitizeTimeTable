package com.targetindia.DigitizeTimeTable.service;

import com.targetindia.DigitizeTimeTable.DbSettings;
import com.targetindia.DigitizeTimeTable.repository.TimeTableDao;
import com.targetindia.DigitizeTimeTable.model.Instructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.*;


@Service
public class AdminService {

    @Autowired
    DbSettings dbSettings;

    @Autowired
    TimeTableDao dao;



    public String updateInstructor(int id, String name, long contact){
        dao.updateInstructor(id,name,contact);
        return "Updated instructor data whose id = "+id;
    }
    @SneakyThrows
    public List<Instructor> getAllInstructors() {
        ResultSet resultset = dao.findAllInstructors();
        List<Instructor> list = new ArrayList<Instructor>();
        while (resultset.next()) {
            int id = resultset.getInt("instructor_id");
            String name = resultset.getString("instructor_name");
            Long contact = resultset.getLong("contact");
            Instructor instructor = new Instructor(id,name, contact);
            list.add(instructor);
        }
        return list;
    }

    @SneakyThrows
    public Optional<Instructor> getInstructorById(int id) {
        ResultSet result = dao.findInstructorById(id);
        Instructor instructor = new Instructor();
        while(result.next()){
            instructor.setInstructor_id(result.getInt(1));
            instructor.setInstructor_name(result.getString(2));
            instructor.setInstructor_contact(result.getLong(3));
        }
        return Optional.of(instructor);
    }

    public String deleteInstructorById(int id) {
        dao.deleteById(id);
        String str="Successfully deleted instructor with id = "+id ;

        return str;
    }

    public String addInstructor(Instructor instructor) {

        dao.addInstructor(instructor);
        String str = "Successfully added instructor";
        System.out.println(str);
        return str;

    }

    public void addAllInstructors(List<Instructor> instructor){
        dao.addAllInstructors(instructor);
    }

//    public void updateInstructor(Instructor instructor){
//        dao.updateInstructor(instructor);
//    }


    public String updatePeriodInfo(int classId, String dow, String slot) {
        dao.updatePeriodInfo(classId,dow,slot);
        return "The subject info of "+dow+" "+slot+" time is updated.";
    }
}
