package se331.project.projectTwoCompo.service;

import lombok.RequiredArgsConstructor;
import se331.project.projectTwoCompo.dao.StudentDao;
import se331.project.projectTwoCompo.entity.Student;
import se331.project.projectTwoCompo.entity.Teacher;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{
    final StudentDao studentDao;
    // final TeacherDao teacherDao;
    @Override
    public Integer getStudentSize() {
        return studentDao.getStudentSize();
    }

    @Override
    public Page<Student> getStudents(Integer pageSize, Integer page) {
        return studentDao.getStudents(pageSize, page);
    }

    @Override
    public Student getStudent(Long id) {
        return studentDao.getStudent(id);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        // Organizer organizer = organizerDao.findById(event.getOrganizer().getId()).orElse(null);
        // event.setOrganizer(organizer);
        // organizer.getOwnEvents().add(event);
        return studentDao.save(student);
    }

    @Override
    public Page<Student> getStudents(String title, Pageable pageable) {
        return studentDao.getStudents(title,pageable);
    }

}