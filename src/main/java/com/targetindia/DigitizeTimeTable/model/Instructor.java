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
public class Instructor {
    @Id
    private int instructor_id;

    private String instructor_name;
    private long instructor_contact;

    public int getInstructor_id() {
        return instructor_id;
    }

    public void setInstructor_id(int instructor_id) {
        this.instructor_id = instructor_id;
    }

    public String getInstructor_name() {
        return instructor_name;
    }

    public void setInstructor_name(String instructor_name) {
        this.instructor_name = instructor_name;
    }

    public long getInstructor_contact() {
        return instructor_contact;
    }

    public void setInstructor_contact(long instructor_contact) {
        this.instructor_contact = instructor_contact;
    }

}
