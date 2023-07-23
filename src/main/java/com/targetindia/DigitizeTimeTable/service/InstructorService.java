package com.targetindia.DigitizeTimeTable.service;

import com.targetindia.DigitizeTimeTable.repository.TimeTableDao;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class InstructorService {
    @Autowired
    TimeTableDao dao;

    @Autowired
    GetDow getDow;

    @SneakyThrows
    public HashMap<String, ArrayList<String>> getInstructorDayTimeTable(int id, String date_str) {
        String day = getDow.getDowFromDate(date_str);
        ResultSet resultset = dao.getInstructorDayTimeTable(id,day);
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        while(resultset.next())
        {
            ArrayList<String> data = new ArrayList<>();
            //slot, class, section, location

            String slot = resultset.getString(1);
            data.add(String.valueOf(resultset.getInt(2)));
            data.add(resultset.getString(3));
            data.add(resultset.getString(4));
            hm.put(slot,data);
        }
        return hm;
    }

    @SneakyThrows
    public HashMap<String, ArrayList<HashMap<String, ArrayList<String>>>> getInstructorWeeklyTimeTable(int classId){
        ResultSet resultset = dao.getInstructorWeeklyTimeTable(classId);
        HashMap<String, ArrayList<HashMap<String, ArrayList<String>>>> hm = new HashMap<>();

        //week, slot, class, section, location

        while(resultset.next())
        {
            String week, slot;
            week = resultset.getString(1);
            slot = resultset.getString(2);

            HashMap<String, ArrayList<String>> inner_hm = new HashMap<>();
            ArrayList<String> data = new ArrayList<>();
            data.add(String.valueOf(resultset.getInt(3)));
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
}
