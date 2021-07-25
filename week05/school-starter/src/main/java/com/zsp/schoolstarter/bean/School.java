package com.zsp.schoolstarter.bean;

import lombok.Data;

@Data
public class School implements ISchool {

    private Klass klass;
    private Student student;

    public void ding() {
        System.out.println("Class have " + this.klass.getStudents().size()
                + " students and one is " + this.student);
    }
}
