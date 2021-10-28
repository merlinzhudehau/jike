package com.zdh.home.week05.bean;

import lombok.Data;

import java.util.List;

@Data
public class Klass { 
    
    List<Student> students;
    
    public void dong(){
        System.out.println(this.getStudents());
    }
    
}
