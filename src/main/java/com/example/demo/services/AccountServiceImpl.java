package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.entities.Student;
import com.example.demo.entities.User;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private UserService userService;
    
    @Autowired
    private StudentService studentService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean register(RegisterRequest registerRequest) {
        Student student = new Student();
        student.setEmail(registerRequest.getEmail());
        student.setName(registerRequest.getName());

        Boolean resultStudent = studentService.Save(student);
        if(resultStudent){
            Integer student_id = studentService.findIdByEmail(registerRequest.getEmail());
            User user = new User();
            user.setUser_id(student_id);
            user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));

            Boolean resultUser = userService.Save(user);
            return resultUser;
        }

        return resultStudent;
    }
    
}
