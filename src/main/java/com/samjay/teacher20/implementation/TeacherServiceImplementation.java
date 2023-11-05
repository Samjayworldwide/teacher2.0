package com.samjay.teacher20.implementation;

import com.samjay.teacher20.dto.request.TeacherRequestDto;
import com.samjay.teacher20.entity.Teacher;
import com.samjay.teacher20.repository.TeacherRepository;
import com.samjay.teacher20.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;

@Service
public class TeacherServiceImplementation implements TeacherService {
    private TeacherRepository teacherRepository;
    @Autowired
    public TeacherServiceImplementation(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher registerTeacher(TeacherRequestDto teacherRequestDto) {
        if (teacherRequestDto.getFirstname() == null || teacherRequestDto.getPassword() == null){
            throw  new InputMismatchException("check for incorrect input");
        }else{
            if (teacherRepository.findFirstByEmail(teacherRequestDto.getEmail()).isPresent()){
                throw new InputMismatchException("check for incorrect input");
            }
            Teacher teacher = new Teacher();
            teacher.setFirstname(teacherRequestDto.getFirstname());
            teacher.setLastname(teacherRequestDto.getLastname());
            teacher.setEmail(teacherRequestDto.getEmail());
            teacher.setPassword(teacherRequestDto.getPassword());
            teacherRepository.save(teacher);
            return teacher;
        }
    }

    @Override
    public Teacher loginATeacher(TeacherRequestDto teacherRequestDto) {
        return teacherRepository
                .findByEmailAndPassword(teacherRequestDto
                                .getEmail()
                        ,teacherRequestDto.getPassword())
                .orElseThrow(()-> new InputMismatchException("invalid input"));
    }
}
