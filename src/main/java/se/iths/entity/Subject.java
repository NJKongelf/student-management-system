package se.iths.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String name;

    @OneToOne
    @JoinColumn
    private Teacher teacher;

    @ManyToMany(mappedBy = "subjects",cascade = CascadeType.ALL)
    private Set<Student> students = new HashSet<>();


    public Subject(@NotNull String name, Teacher teacher ) {
        this.name = name;
        this.teacher = teacher;
    }

    public Subject() {

    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
