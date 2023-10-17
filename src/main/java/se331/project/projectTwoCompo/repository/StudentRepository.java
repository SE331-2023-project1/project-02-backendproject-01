package se331.project.projectTwoCompo.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import se331.project.projectTwoCompo.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findAll();
    Page<Student> findByStudentIdContainingOrFirstnameIgnoreCaseContainingOrSurnameIgnoreCaseContaining(String studentId, String firstname, String surname, Pageable pageRequest);
    Page<Student> findByFirstnameIgnoreCaseContainingOrSurnameIgnoreCaseContaining(String firstname, String surname, Pageable pageRequest);
}