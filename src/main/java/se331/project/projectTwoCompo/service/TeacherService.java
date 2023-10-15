package se331.project.projectTwoCompo.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import se331.project.projectTwoCompo.entity.Teacher;

public interface TeacherService {
    Integer getTeacherSize();
    Page<Teacher> getTeachers(Integer pageSize, Integer page);
    Teacher getTeacher(Long id);
    Teacher save(Teacher teacher);
    Page<Teacher> getTeachers(String title, Pageable pageable);
}
