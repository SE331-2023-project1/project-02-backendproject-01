package se331.project.projectTwoCompo.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import se331.project.projectTwoCompo.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findAll();
    // Page<Student> findByTitle(String title, Pageable pageRequest);
    // Page<Event> findByTitleContaining(String title, Pageable pageRequest);
    // Page<Event> findByTitleContainingOrDescriptionContaining(String title, String description, Pageable pageRequest);
    // Page<Event> findByTitleContainingAndDescriptionContaining(String title, String description, Pageable pageRequest);
    // Page<Event> findByTitleIgnoreCaseContainingOrDescriptionIgnoreCaseContainingOrOrganizer_NameIgnoreCaseContaining(String title, String description, String organizerName, Pageable pageRequest);
}