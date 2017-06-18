package com.codecool.jpaexample.model;

import org.eclipse.persistence.annotations.PrimaryKey;
import org.hibernate.tuple.entity.PojoEntityInstantiator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static org.hibernate.EntityMode.POJO;

@Entity(name = "Class")
public class Klass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @OneToMany(mappedBy = "klass")
    private Set<Student> students = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private CCLocation ccLocation;

    public Klass() {}

    public Klass(String name, CCLocation ccLocation) {
        this.name = name;
        this.ccLocation = ccLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.setKlass(this);
    }

}
