package se331.project.projectTwoCompo.dao;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import se331.project.projectTwoCompo.entity.Student;
import se331.project.projectTwoCompo.repository.StudentRepository;


@Repository
@RequiredArgsConstructor
@Profile("db")
public class StudentDaoDBImpl implements StudentDao{
    final StudentRepository studentRepository;
    @Override
    public Integer getStudentSize() {
        return Math.toIntExact(studentRepository.count());
    }

    @Override
    public Page<Student> getStudents(Integer pageSize, Integer page) {
        return studentRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Page<Student> getStudents(String title, Pageable page) {
        return studentRepository.findByStudentIdContainingOrFirstnameIgnoreCaseContainingOrSurnameIgnoreCaseContaining(title, title, title, page);
    }

    @Override
    public Page<Student> getStudents(Integer advisorId, Pageable page) {
        return studentRepository.findByAdvisor_Id(advisorId, page);
    }
    @Override
    public Page<Student> getStudents(Integer advisorId, String title, Pageable page) {
        return studentRepository.findByStudentIdContainingOrFirstnameIgnoreCaseContainingOrSurnameIgnoreCaseContaining(title, title, title, page);
    }

}
