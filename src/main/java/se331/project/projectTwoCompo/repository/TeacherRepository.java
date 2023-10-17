package se331.project.projectTwoCompo.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import se331.project.projectTwoCompo.entity.Teacher;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher,Long> {
    List<Teacher> findAll();
    Page<Teacher> findByAcademicPositionIgnoreCaseContainingOrFirstnameIgnoreCaseContainingOrSurnameIgnoreCaseContaining(String academicPosition, String firstname, String surname, Pageable pageRequest);
    
}