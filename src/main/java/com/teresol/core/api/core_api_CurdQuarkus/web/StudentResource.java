package com.teresol.core.api.core_api_CurdQuarkus.web;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import com.teresol.core.api.core_api_CurdQuarkus.dto.Student;
import com.teresol.core.api.core_api_CurdQuarkus.servicesImpl.StudentServiceImpl;

@Path("/student")
public class StudentResource {

    @Inject
    StudentServiceImpl studentServiceImpl;

    @Path("/createStudent")
    @POST
    public Response createStudent(Student student) throws Exception {
        return Response.ok(studentServiceImpl.createStudent(student)).build();
    }

    @Path("/updateStudent")
    @PUT
    public Response updateStudent(Student student) throws Exception{
        return Response.ok(studentServiceImpl.updateStudent(student)).build();
    }

    @Path("/getAllStudent")
    @GET
    public Response getAllStudent() throws Exception{
        return Response.ok(studentServiceImpl.getAllStudents()).build();
    }

    @Path("{id}")
    @GET
    public Response getStudentById(@PathParam("id") int id) throws Exception{
        return Response.ok(studentServiceImpl.getStudentById(id)).build();

    }

    @Path("/deleteStudent")
    @DELETE
    public Response deleteStudent(Student student) throws Exception{
        return Response.ok(studentServiceImpl.deleteStudent(student)).build();
    }




    
}
