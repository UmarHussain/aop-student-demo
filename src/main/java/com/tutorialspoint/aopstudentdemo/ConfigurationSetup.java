package com.tutorialspoint.aopstudentdemo;

import com.tutorialspoint.aopstudentdemo.aspect.Logger;
import com.tutorialspoint.aopstudentdemo.entity.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Configuration
public class ConfigurationSetup {

    @Bean
    public Student getStudent(){

        Student student = new Student();
        student.setAge(10);
        student.setName("Ali");

        return student;
    }

    @Bean("logging")
    public Logger getLogger(){
        return new Logger();
    }

}
