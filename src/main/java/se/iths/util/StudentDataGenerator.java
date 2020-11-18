package se.iths.util;

import se.iths.entity.Student;
import se.iths.entity.Subject;
import se.iths.entity.Teacher;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Singleton
@Startup
public class StudentDataGenerator {

    @PersistenceContext
    EntityManager entityManager;

    @PostConstruct
    public void generateData() {
        Teacher teacher = new Teacher("Bill", "Gates", "Microsoft@google.com", "555-1234");
        Subject subject = new Subject("Java",teacher);
        entityManager.persist(teacher);
        entityManager.persist(new Student("Luis", "Gutierrez", "luis@google.com", "555-2343"));
        entityManager.persist(new Student("Erick", "Gutierrez", "erick@google.com", "555-2673"));
        entityManager.persist(new Student("Nicklas", "Johansson", "nicklas@google.com", "555-7596"));
        entityManager.persist(new Student("Lennart", "Johansson", "lennart@google.com", "555-9867"));
        entityManager.persist(new Student("Rob", "Sam", "rob@google.com", "555-3639"));
        entityManager.persist(new Student("Daniel", "Van Rankin", "daniel@google.com", "555-1086"));
        Set<Student> listofStudents =  entityManager.createQuery("SELECT s from Student s", Student.class).getResultStream().collect(Collectors.toSet());
        subject.setStudents(listofStudents);
        entityManager.persist(subject);

    }


}