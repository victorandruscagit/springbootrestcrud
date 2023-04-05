package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.OptionalLong;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudedents;

    @PostConstruct
    public void loadData() {
        theStudedents = Arrays.asList(new Student("Marion", "Rossi"), new Student("Ion ", "Bostan"),
                new Student("Marry ", "Andrusca"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {

        return  theStudedents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if ((studentId >= theStudedents.size()) || (studentId < 0)) {
            throw  new StudentNotFoundException("Student ID -  " + studentId  + " not found");
        }
        return theStudedents.get(studentId);
    }


}
