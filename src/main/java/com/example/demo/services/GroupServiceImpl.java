package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Group;
import com.example.demo.repositories.GroupRepository;

@Service
public class GroupServiceImpl implements GroupService{
    @Autowired
    private GroupRepository groupRepository;

    @Override
    public List<Group> Get() {
        return groupRepository.findAll();
    }

    @Override
    public Group Get(Integer id) {
        return groupRepository.findById(id).orElseThrow(null);
    }

    @Override
    public Boolean Save(Group model) {
        groupRepository.save(model);
        return groupRepository.findById(model.getGroup_id()).isPresent();
    }

    @Override
    public Boolean Delete(Integer id) {
        groupRepository.deleteById(id);
        return !groupRepository.findById(id).isPresent();
    }
}
