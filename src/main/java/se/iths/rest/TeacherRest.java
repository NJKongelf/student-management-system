package se.iths.rest;

import se.iths.entity.Student;
import se.iths.entity.Teacher;
import se.iths.rest.verifiers.TeacherVerifier;
import se.iths.service.TeacherService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("teacher")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class TeacherRest {
    @Inject
    TeacherService teacherService;
    TeacherVerifier verifier;

    @Path("new")
    @POST
    public Response createTeacher(Teacher teacher) {
        verifier.verifyTeacher(teacher);
        return Response.ok(teacherService.createTeacher(teacher)).build();
    }

    @Path("update")
    @PUT
    public Response updateTeacher(Teacher teacher) {
        verifier.verifyTeacher(teacher);
        return Response.ok(teacherService.updateTodo(teacher)).build();
    }

    @Path("searchById/{id}")
    @GET
    public Teacher getTeacher(@PathParam("id") Long id) {
        return verifier.TeacherExist(teacherService.findTeacherById(id), id);
    }

//    @Path("searchByLastName/{lastname}")
//    @GET
//    public List<Teacher> getStudentByLastName(@PathParam("lastname") String lastName) {
//        return verifier.list_teachersCheck(teacherService.findTeacherByLastName(lastName), "No student registered with last name " + lastName);
//    }

    @Path("getall")
    @GET
    public List<Teacher> getAllItems() {
        return verifier.list_teachersCheck(teacherService.getAllTeachers(), "No teachers registered");
    }

    @Path("deleteById/{id}")
    @DELETE
    public Response deleteTecher(@PathParam("id") Long id) {
        return verifier.TeacherExist(teacherService.findTeacherById(id), teacherService);
    }

}
