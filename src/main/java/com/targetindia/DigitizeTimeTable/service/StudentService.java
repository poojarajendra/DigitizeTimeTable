package com.targetindia.DigitizeTimeTable.service;

import com.targetindia.DigitizeTimeTable.repository.TimeTableDao;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class StudentService {
    @Autowired
    TimeTableDao dao;

    @Autowired
    GetDow getDow;

    @SneakyThrows
    public HashMap<String, ArrayList<String>> getStudentDayTimeTable(int classId, String date_str) {
        String day = getDow.getDowFromDate(date_str);
        ResultSet resultset = dao.getStudentDayTimeTable(classId,day);
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        while(resultset.next())
        {
            ArrayList<String> data = new ArrayList<>();
            //slot, course_name, instructor_name, location

            String slot = resultset.getString(1);
            data.add(resultset.getString(2));
            data.add(resultset.getString(3));
            data.add(resultset.getString(4));
            hm.put(slot,data);
        }
        return hm;
    }
    @SneakyThrows
    public HashMap<String, ArrayList<HashMap<String, ArrayList<String>>>> getStudentWeeklyTimeTable(int classId){
        ResultSet resultset = dao.getStudentWeeklyTimeTable(classId);
        HashMap<String, ArrayList<HashMap<String, ArrayList<String>>>> hm = new HashMap<>();

        //week, slot, course_name, instructor_name, location


        while(resultset.next())
        {
            String week, slot;
            week = resultset.getString(1);
            slot = resultset.getString(2);

            HashMap<String, ArrayList<String>> inner_hm = new HashMap<>();
            ArrayList<String> data = new ArrayList<>();
            data.add(resultset.getString(3));
            data.add(resultset.getString(4));
            data.add(resultset.getString(5));
            inner_hm.put(slot, data);
            if(hm.get(week) == null){
                ArrayList<HashMap<String, ArrayList<String>>> ls = new ArrayList<>();
                ls.add(inner_hm);
                hm.put(week, ls);
            }
            else{
                ArrayList<HashMap<String, ArrayList<String>>> ls = hm.get(week);
                ls.add(inner_hm);
                hm.put(week, ls);
            }
        }
        return hm;
    }

    //hashmap<dow ,slot, instructor_name, course_name, location> > >
//    @SneakyThrows
//    public HashMap<Integer, ArrayList<String>> get_student_table_weekly(int classId){
//        ResultSet resultset = dao.get_student_time_table_weekly(classId);
//        HashMap<Integer, ArrayList<String>> hm = new HashMap<>();
//
//        //week, slot, course_name, instructor_name, location
//        int i=0;
//        while(resultset.next())
//        {
//            i++;
//            ArrayList<String> data = new ArrayList<>();
//
//            data.add(resultset.getString(1));
//            data.add(resultset.getString(2));
//            data.add(resultset.getString(3));
//            data.add(resultset.getString(4));
//            data.add(resultset.getString(5));
//            hm.put(i,data);
//        }
//        return hm;
//    }

}
