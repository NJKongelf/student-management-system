package se.iths.rest;

import se.iths.entity.Student;
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

@Path("new")
@POST
public Response createStudent(Student student){
    studentService.createStudent(student);
    return Response.ok(student).build();
}

@Path("update")
@PUT
public  Response updateStudent(Student student){
    studentService.updateTodo(student);
    return Response.ok(student).build();
}

@Path("searchById/{id}")
@GET
public Student getStudent(@PathParam("id") Long id) {
        return studentService.findStudentById(id);
    }

@Path("searchByLastName/{lastname}")
@GET
public List<Student> getStudentByLastName(@PathParam("lastname") String lastN) {
    return studentService.findStudentByLastName(lastN);
}


@Path("getall")
@GET
public List<Student> getAllItems() {   //List<Optional<Student>>
        return studentService.getAllStudents();
    }
}
