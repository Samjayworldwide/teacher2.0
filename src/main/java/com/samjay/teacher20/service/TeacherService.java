package com.samjay.teacher20.service;

import com.samjay.teacher20.dto.request.TeacherRequestDto;
import com.samjay.teacher20.entity.Teacher;

public interface TeacherService {
    Teacher registerTeacher(TeacherRequestDto teacherRequestDto);
    Teacher loginATeacher(TeacherRequestDto teacherRequestDto);
}
