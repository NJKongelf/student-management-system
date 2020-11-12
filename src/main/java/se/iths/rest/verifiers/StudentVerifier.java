package se.iths.rest.verifiers;
import se.iths.entity.Student;
import se.iths.rest.exeptions.BadFormatInputException;
import se.iths.rest.exeptions.StudentNotFoundException;
import se.iths.service.StudentService;
import javax.ws.rs.core.Response;
import java.util.List;

public class StudentVerifier {
    public BadFormatInputException badformatInput() {
        throw new BadFormatInputException("Json object must include fields:\n {\n \"firstname\":\"value\" \n  \"lastname\":\"value\"\n  \"email\":\"value\"\n{\n");
    }

    public void verifyStudent(Student student) {
        if (student.getEmail() == null || student.getFirstname() == null || student.getLastname() == null)
            badformatInput();
    }

    public List<Student> list_stundentsCheck(List<Student> studentlist, String message) {
        List<Student> studentList = studentlist;
        if (studentList.size() > 0)
            return studentList;
        else
            throw new StudentNotFoundException(message);
    }

    public Response StudentExist(Student foundstudent, StudentService studentService) {
        if (!(foundstudent == null)) {
            studentService.removeStudent(foundstudent.getId());
            return Response.ok().build();
        } else {
            throw new StudentNotFoundException("student attempting to delete is not registered");
        }

    }

    public Student StudentExist(Student foundstudent, Long id) {
        if (foundstudent != null) {
            return foundstudent;
        } else {
            throw new StudentNotFoundException("Not student found with id " + id);
        }
    }
}
