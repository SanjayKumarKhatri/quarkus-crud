package com.teresol.core.api.core_api_CurdQuarkus.servicesImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.teresol.core.api.core_api_CurdQuarkus.connection.DBConnection;
import com.teresol.core.api.core_api_CurdQuarkus.dto.Student;
import com.teresol.core.api.core_api_CurdQuarkus.services.StudentService;

@ApplicationScoped
public class StudentServiceImpl implements StudentService {

    @Inject
    DBConnection dbConnection;

    @Override
    public int createStudent(Student student) throws Exception {
        Connection connection= dbConnection.GlobalDbConnection();
        PreparedStatement prepareStatement=connection.prepareStatement("insert into user(userName,phoneNo) values(?,?)");
        prepareStatement.setString(1, student.getUserName());
        prepareStatement.setString(2, student.getPhoneNo());
        int result = prepareStatement.executeUpdate();  
        return result;
    }

    @Override
    public int updateStudent(Student student) throws Exception {
        Connection connection= dbConnection.GlobalDbConnection();
        PreparedStatement prepareStatement=connection.prepareStatement("UPDATE user SET userName=?, phoneNo=? where id = ?");
        prepareStatement.setString(1, student.getUserName());
        prepareStatement.setString(2, student.getPhoneNo());
        prepareStatement.setInt(3, student.getId());
        int result = prepareStatement.executeUpdate();  
        return result;
    }

    @Override
    public List<Student> getAllStudents() throws Exception {
        Connection connection= dbConnection.GlobalDbConnection();
        PreparedStatement prepareStatement=connection.prepareStatement("select * from user");
        ResultSet resultSet=prepareStatement.executeQuery();  
        List<Student> studentsList = new ArrayList<Student>();
        Student student = null;
        while(resultSet.next()){
            student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setUserName(resultSet.getString("userName"));
            student.setPhoneNo(resultSet.getString("phoneNo"));
            studentsList.add(student);
        }  
        return studentsList;
        
    }

    @Override
    public Student getStudentById(int id) throws Exception {
        Connection connection= dbConnection.GlobalDbConnection();
        PreparedStatement  prepareStatement=connection.prepareStatement("select * from user where id = ?");
        prepareStatement.setInt(1, id);
        ResultSet resultSet=prepareStatement.executeQuery();  
        Student student = null;
        while(resultSet.next()){
            student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setUserName(resultSet.getString("userName"));
            student.setPhoneNo(resultSet.getString("phoneNo"));
        }  
        return student;
    }

    @Override
    public int deleteStudent(Student student) throws Exception {
        Connection connection= dbConnection.GlobalDbConnection();
        PreparedStatement prepareStatement=connection.prepareStatement("Delete from user where id = ?");
        prepareStatement.setInt(1, student.getId());
        int result = prepareStatement.executeUpdate();  
        return result;
    }
    
}
