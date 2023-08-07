package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Room;
import com.example.demo.repositories.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService{
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> Get() {
        return roomRepository.findAll();
    }

    @Override
    public Room Get(Integer id) {
        return roomRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Room model) {
        roomRepository.save(model);
        return roomRepository.findById(model.getRoom_id()).isPresent();
    }

    @Override
    public Boolean Delete(Integer id) {
        roomRepository.deleteById(id);
        return !roomRepository.findById(id).isPresent();
    }
}
