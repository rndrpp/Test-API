package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Student;
import com.example.demo.entities.User;

@Repository
public interface AccountRepository extends JpaRepository<Student, Integer>{
    @Query("SELECT u FROM User u JOIN u.student s WHERE s.email = ?1")
    public User login(String email);
    // @Query("""
    //         select s.email, u.password, r.name from tb_m_user u join tb_m_role on u.role_id = r.role_id join tb_m_student
    //         """, native = true)
    
    // public Boolean register();  
}
