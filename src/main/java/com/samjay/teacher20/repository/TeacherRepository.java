package com.samjay.teacher20.repository;

import com.samjay.teacher20.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    Optional<Teacher> findFirstByEmail(String email);
    Optional<Teacher> findByEmailAndPassword(String email, String password);
}

