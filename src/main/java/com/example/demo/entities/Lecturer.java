package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="tb_m_lecturer")
public class Lecturer extends Human {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer lecturer_id;
    private Integer faculty;
    public Integer getLecturer_id() {
        return lecturer_id;
    }
    public void setLecturer_id(Integer lecturer_id) {
        this.lecturer_id = lecturer_id;
    }
    public Integer getFaculty() {
        return faculty;
    }
    public void setFaculty(Integer faculty) {
        this.faculty = faculty;
    }
}
