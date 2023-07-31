package com.targetindia.DigitizeTimeTable.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
@Data
public class Student {
    @Id
    private int student_id;

    private String student_name;
    private long student_contact;
    private int class_number;
    private String section;

    public int getInstructor_id() {
        return student_id;
    }

    public void setInstructor_id(int student_id) {
        this.student_id = student_id;
    }

    public String getInstructor_name() {
        return student_name;
    }

    public void setInstructor_name(String student_name) {
        this.student_name = student_name;
    }

    public long getInstructor_contact() {
        return student_contact;
    }

    public void setInstructor_contact(long student_contact) {
        this.student_contact = student_contact;
    }

}
