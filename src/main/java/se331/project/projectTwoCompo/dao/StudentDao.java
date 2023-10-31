package se331.project.projectTwoCompo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import se331.project.projectTwoCompo.entity.Student;

public interface StudentDao {
    Integer getStudentSize();
    Page<Student> getStudents(Integer pageSize, Integer page);
    Student getStudent(Long id);
    Student save(Student student);
    Page<Student> getStudents(String name, Pageable page);
    Page<Student> getStudents(Integer advisorId, Pageable page);
    Page<Student> getStudents(Integer advisorId, String name, Pageable page);
}
