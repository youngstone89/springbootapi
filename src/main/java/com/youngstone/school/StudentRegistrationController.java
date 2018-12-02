package com.youngstone.school;

import org.springframework.web.bind.annotation.*;

@RestController
public class StudentRegistrationController {


    @RequestMapping(value = "/register/student",method = RequestMethod.POST)
    @ResponseBody
    public StudentRegistrationReply registerStudent(@RequestBody Student student){
        StudentRegistrationReply stdregreply = new StudentRegistrationReply();
        StudentRegistration.getInstance().add(student);
        //We are setting the below value just to reply a message back to the caller
        stdregreply.setName(student.getName());
        stdregreply.setAge(student.getAge());
        stdregreply.setRegistrationNumber(student.getRegistrationNumber());
        stdregreply.setRegistrationStatus("Successful");
        return stdregreply;
    }
}
