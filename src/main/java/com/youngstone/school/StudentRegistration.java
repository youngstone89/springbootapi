package com.youngstone.school;

import java.util.ArrayList;
import java.util.List;

public class StudentRegistration {

    private List<Student> students;

    private static StudentRegistration studentRegistration = null;

    private StudentRegistration() {
        students = new ArrayList<Student>();
    }

    public static StudentRegistration getInstance() {
        if(studentRegistration == null){
            studentRegistration = new StudentRegistration();
            return studentRegistration;
        }else {
            return studentRegistration;
        }
    }

    public void add(Student student){
        students.add(student);
    }

    public String updateStudent(Student student){

        for (int i = 0; i < students.size() ; i++) {

            Student tempStudent = students.get(i);
            if(student.getRegistrationNumber().equals(tempStudent.getRegistrationNumber())){
                students.set(i,student);
                return "Success";
            }
        }
        return "Failure in update";
    }

    public String deleteStudent(String resgisrationNumber){

        for (int i = 0; i < students.size() ; i++) {

            if(students.get(i).getRegistrationNumber().equals(resgisrationNumber)){
                students.remove(i);
                return "Success";
            }
        }
        return "Failure in deletion";
    }

    public List<Student> getStudents(){
        return students;
    }


}
