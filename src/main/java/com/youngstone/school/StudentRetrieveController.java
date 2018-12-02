package com.youngstone.school;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentRetrieveController {

    @RequestMapping(method = RequestMethod.GET, value = "/student/allstudent")
    @ResponseBody
    public List<Student> getAllStudents(){
        return StudentRegistration.getInstance().getStudents();
    }
}
