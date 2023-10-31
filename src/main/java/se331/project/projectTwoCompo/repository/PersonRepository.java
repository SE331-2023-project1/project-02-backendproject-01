package se331.project.projectTwoCompo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import se331.project.projectTwoCompo.entity.Person;


public interface PersonRepository extends JpaRepository<Person,Long> {
}