package com.example.demo.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_m_room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer room_id;
    private String name;

    @OneToMany(mappedBy = "room")
    @JsonIgnore
    private List<Schedule> schedules;


    public Integer getRoom_id() {
        return room_id;
    }
    public void setRoom_id(Integer room_id) {
        this.room_id = room_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


}
