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
    public Response createStudent(Student student) {
            if(verifyStudent(student))
                 return Response.ok(studentService.createStudent(student)).build();
            else
                throw badformatInput();
    }
    private StudentNotFoundException badformatInput(){
        throw new StudentNotFoundException("Must have Json with fields:\n {\n \"firstname\":\"value\" \n  \"lastname\":\"value\"\n  \"email\":\"value\"\n{\n");
    }

    //
    private boolean verifyStudent(Student student){
        return !(student.getEmail() == null || student.getFirstname() == null || student.getLastname() == null);
    }

    @Path("update")
    @PUT
    public Response updateStudent(Student student) {
    if(verifyStudent(student))
            return Response.ok(studentService.updateTodo(student)).build();
        else
            throw badformatInput();
    }

    @Path("searchById/{id}")
    @GET
    public Student getStudent(@PathParam("id") Long id) {
        Student foundStudent = studentService.findStudentById(id);
        if (foundStudent != null) {
            return foundStudent;
        } else {
            throw new StudentNotFoundException("Student not found with id " + id);
        }
    }

    @Path("searchByLastName/{lastname}")
    @GET
    public List<Student> getStudentByLastName(@PathParam("lastname") String lastN) {
        return list_stundentsCheck(studentService.findStudentByLastName(lastN),"No Students registered with "+lastN);
    }
    private List<Student> list_stundentsCheck(List<Student> studentlist,String message){
        List<Student> studentList = studentlist;
        if(studentList.size()>0)
            return studentList;
        else
            throw new StudentNotFoundException(message);
    }

    @Path("getall")
    @GET
    public List<Student> getAllItems() {
        return list_stundentsCheck(studentService.getAllStudents(),"No Students registered");
    }


    @Path("deleteById/{id}")
    @DELETE
    public Response deleteStudent(@PathParam("id") Long id) {
        studentService.removeStudent(id);
        return Response.ok().build();
    }
}