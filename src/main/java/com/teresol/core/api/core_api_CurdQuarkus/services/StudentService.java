package com.teresol.core.api.core_api_CurdQuarkus.services;

import java.util.List;

import com.teresol.core.api.core_api_CurdQuarkus.dto.Student;

public interface StudentService {

    public int createStudent(Student student) throws Exception;
    public int updateStudent(Student student) throws Exception;
    public List<Student> getAllStudents() throws Exception;
    public Student getStudentById(int id) throws Exception;

    public int deleteStudent(Student student) throws Exception;

    
}
