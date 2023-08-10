package com.example.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_m_student")
public class Student extends Human {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer student_id;
    private Integer semester;
    private String email;
    @ManyToOne
    @JoinColumn(name = "program")
    private Program program;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<Registration> registrations;

    @OneToOne(mappedBy = "student")
    @JsonIgnore
    private User user;


    public Integer getStudent_id() {
        return student_id;
    }



    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }



    public Integer getSemester() {
        return semester;
    }



    public void setSemester(Integer semester) {
        this.semester = semester;
    }



    public Program getProgram() {
        return program;
    }



    public void setProgram(Program program) {
        this.program = program;
    }



    public List<Registration> getRegistrations() {
        return registrations;
    }



    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }



    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }

 

}