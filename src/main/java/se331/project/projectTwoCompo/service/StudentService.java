package se331.project.projectTwoCompo.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import se331.project.projectTwoCompo.entity.Student;

public interface StudentService {
    Integer getStudentSize();
    Page<Student> getStudents(Integer pageSize, Integer page);
    Student getStudent(Long id);
    Student save(Student student);
    Page<Student> getStudents(String title, Pageable pageable);
    Page<Student> getStudents(Integer advisorId, String title, Pageable pageable);
    Page<Student> getStudents(Integer advisorId, Pageable pageable);

}
