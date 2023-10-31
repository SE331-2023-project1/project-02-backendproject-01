package se331.project.projectTwoCompo.service;

import lombok.RequiredArgsConstructor;
import se331.project.projectTwoCompo.dao.StudentDao;
import se331.project.projectTwoCompo.dao.TeacherDao;
import se331.project.projectTwoCompo.entity.Student;
import se331.project.projectTwoCompo.entity.Teacher;
import se331.project.projectTwoCompo.security.user.Role;
import se331.project.projectTwoCompo.security.user.User;
import se331.project.projectTwoCompo.security.user.UserRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    final StudentDao studentDao;
    final TeacherDao teacherDao;
    final UserRepository userRepository;

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
        if (student.getAdvisor() != null) {
            if (student.getAdvisor().getId() != 0) {
                Teacher teacher = teacherDao.findById(student.getAdvisor().getId()).orElse(null);
                teacher.getAdvisee().add(student);
            } else {
                student.setAdvisor(null);
            }
        }
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Student oldStudent = getStudent(student.getId());
        Student tempStudent;
        if (oldStudent == null) {
            tempStudent = Student.builder()
                    .studentId(student.getStudentId())
                    .password(encoder.encode(student.getPassword()))
                    .firstname(student.getFirstname())
                    .surname(student.getSurname())
                    .department(student.getDepartment())
                    .images(student.getImages())
                    .advisor(student.getAdvisor())
                    .build();
            User tempUser = userRepository.save(User.builder()
                    .username(tempStudent.getStudentId())
                    .password(tempStudent.getPassword())
                    .firstname(tempStudent.getFirstname())
                    .lastname(tempStudent.getSurname())
                    .build());
            tempStudent.setUser(tempUser);
            tempUser.setUser(tempStudent);
            tempUser.getRoles().add(Role.ROLE_STUDENT);
        } else {
            tempStudent = Student.builder()
                    .id(oldStudent.getId())
                    .studentId(oldStudent.getStudentId())
                    .password(oldStudent.getPassword())
                    .firstname(student.getFirstname())
                    .surname(student.getSurname())
                    .department(student.getDepartment())
                    .images(student.getImages())
                    .user(oldStudent.getUser())
                    .advisor(student.getAdvisor())
                    .build();
        }
        return studentDao.save(tempStudent);
    }

    @Override
    public Page<Student> getStudents(String title, Pageable pageable) {
        return studentDao.getStudents(title, pageable);
    }

    @Override
    public Page<Student> getStudents(Integer advisorId, Pageable pageable) {
        return studentDao.getStudents(advisorId, pageable);
    }
    @Override
    public Page<Student> getStudents(Integer advisorId, String title, Pageable pageable) {
        return studentDao.getStudents(advisorId, title, pageable);
    }

}