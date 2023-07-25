package com.targetindia.DigitizeTimeTable.repository;

import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Repository
public class StudentDao {
    Connection conn = null;

    static String url="jdbc:postgresql://localhost:5432/dtt";
    static String username="postgres";
    static String password="krishna";



    public StudentDao() {

        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");
    }
    public ResultSet getStudentWeeklyTimeTable(int classId){
        Statement statement;
        ResultSet rs=null;
        try{
            String query="select time_table.week,time_table.slot,course_table.course_name,instructor_table.instructor_name,course_table.location "+
                    "from time_table "+
                    "inner join course_table on time_table.course_id=course_table.course_id "+
                    "inner join instructor_table on time_table.instructor_id=instructor_table.instructor_id "+
                    "where time_table.class_id="+classId;
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return rs;
    }

    public ResultSet getStudentDayTimeTable(int class_id, String day){
        Statement statement;
        ResultSet rs=null;
        try{
            String query="select time_table.slot,course_table.course_name,instructor_table.instructor_name,course_table.location "+
                    "from time_table "+
                    "inner join course_table on time_table.course_id=course_table.course_id "+
                    "inner join instructor_table on time_table.instructor_id=instructor_table.instructor_id "+
                    "where time_table.class_id="+class_id+" and time_table.week='"+day+"'";
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
        }
        catch(Exception e){
            System.out.println(e);
        }
        return rs;
    }
}
