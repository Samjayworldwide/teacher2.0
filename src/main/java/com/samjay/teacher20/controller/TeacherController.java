package com.samjay.teacher20.controller;

import com.samjay.teacher20.dto.request.TeacherRequestDto;
import com.samjay.teacher20.entity.Teacher;
import com.samjay.teacher20.service.TeacherService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {
    private final TeacherService teacherServiceImplementation;
    @Autowired
    public TeacherController(TeacherService teacherServiceImplementation) {
        this.teacherServiceImplementation = teacherServiceImplementation;
    }


    @GetMapping("/registerTeacher")
    public String getTeachersRegistrationPage(){
        return "teacherRegistrationPage";
    }

    @GetMapping("/loginTeacher")
    public String getTeachersLoginPage(){
        return "teacherLoginPage";
    }

    @PostMapping("/registerTeacher")
    public String registerTeacher(@RequestBody TeacherRequestDto teacherRequestDto){
        Teacher registeredTeacher = teacherServiceImplementation.registerTeacher(teacherRequestDto);
        return registeredTeacher == null ? "errorPage" : "teacherLoginPage";
    }
    @PostMapping("/loginTeacher")
    public String loginTeacher(@RequestBody TeacherRequestDto teacherRequestDto, HttpServletRequest request){
        Teacher loginATeacher = teacherServiceImplementation.loginATeacher(teacherRequestDto);
        if (loginATeacher != null){
            HttpSession session = request.getSession();
            session.setAttribute("teacherId", loginATeacher.getId());
            return "addToBookStorePage";
        }else return  "errorPage";

    }
}

