package se.iths.rest;

import se.iths.entity.Student;
import se.iths.rest.verifiers.StudentVerifier;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
@Path("student")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class StudentRest {

    @Inject
    StudentService studentService;
    @Inject
    StudentVerifier verifier;

    @Path("new")
    @POST
    public Response createStudent(Student student) {
        verifier.verifyStudent(student);
        return Response.ok(studentService.createStudent(student)).build();
    }

    @Path("update")
    @PUT
    public Response updateStudent(Student student) {
        verifier.verifyStudent(student);
        return Response.ok(studentService.updateTodo(student)).build();
    }

    @Path("searchById/{id}")
    @GET
    public Student getStudent(@PathParam("id") Long id) {
      return  verifier.StudentExist(studentService.findStudentById(id),id);
    }

    @Path("searchByLastName/{lastname}")
    @GET
    public List<Student> getStudentByLastName(@PathParam("lastname") String lastN) {
        return verifier.list_stundentsCheck(studentService.findStudentByLastName(lastN),"No student registered with last name: "+lastN);
    }

    @Path("getall")
    @GET
    public List<Student> getAllItems() {
        return verifier.list_stundentsCheck(studentService.getAllStudents(),"No students registered");
    }

    @Path("deleteById/{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id) {
        return verifier.StudentExist(studentService.findStudentById(id),studentService);
    }



}