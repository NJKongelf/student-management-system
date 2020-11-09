package se.iths.rest;

import se.iths.entity.Student;
import se.iths.service.StudentService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

public class StudentRest {

    @Inject
    StudentService studentService;

@Path("newStudent")
@POST
public Response createStudent(Student student){
    studentService.createStudent(student);
    return Response.ok(student).build();
}

@Path("updateStudent")
@PUT
public  Response updateStudent(Student student){
    studentService.updateTodo(student);
    return Response.ok(student).build();
}

@Path("{id}")
@GET
public Student getStudent(@PathParam("id") Long id) {
        return studentService.findStudentById(id);
    }

@Path("getall")
@GET
public List<Student> getAllItems() {   //List<Optional<Student>>
        return studentService.getAllStudents();
    }
}
