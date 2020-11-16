package se.iths.service;

import se.iths.entity.Student;
import se.iths.entity.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class TeacherService {


        @PersistenceContext
        EntityManager entityManager;

        public Teacher createTeacher(Teacher teacher) {
            entityManager.persist(teacher);
            return teacher;
        }

        public Teacher updateTodo(Teacher teacher) {
            entityManager.merge(teacher);
            return teacher;
        }

        public Teacher findTeacherById(Long id) {
            return entityManager.find(Teacher.class, id);
        }

        public List<Teacher> getAllTeachers() {
            return entityManager.createQuery("SELECT t from Teacher t", Teacher.class).getResultList();

        }

//        public List<Teacher> findStudentByLastName(String LName) {
//            return entityManager.createQuery("SELECT t from Teacher t where t.lastname like :lastname", Teacher.class).setParameter("lastname", LName).getResultList();
//
//        }

        public void removeTeacher(long id) {
            Teacher object = entityManager.find(Teacher.class, id);
            entityManager.remove(object);
        }


}
