package se331.project.projectTwoCompo.service;

import lombok.RequiredArgsConstructor;
import se331.project.projectTwoCompo.dao.TeacherDao;
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
public class TeacherServiceImpl implements TeacherService {
    final TeacherDao teacherDao;
    final UserRepository userRepository;

    @Override
    public Integer getTeacherSize() {
        return teacherDao.getTeacherSize();
    }

    @Override
    public Page<Teacher> getTeachers(Integer pageSize, Integer page) {
        return teacherDao.getTeachers(pageSize, page);
    }

    @Override
    public Teacher getTeacher(Long id) {
        return teacherDao.getTeacher(id);
    }

    @Override
    @Transactional
    public Teacher save(Teacher teacher) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Teacher oldTeacher = getTeacher(teacher.getId());
        Teacher tempTeacher;
        if(oldTeacher == null){
            tempTeacher = Teacher.builder()
                    .username(teacher.getUsername())
                    .password(encoder.encode(teacher.getPassword()))
                    .firstname(teacher.getFirstname())
                    .surname(teacher.getSurname())
                    .academicPosition(teacher.getAcademicPosition())
                    .department(teacher.getDepartment())
                    .images(teacher.getImages())
                    .build();
            User tempUser = userRepository.save(User.builder()
                    .username(tempTeacher.getUsername())
                    .password(tempTeacher.getPassword())
                    .firstname(tempTeacher.getFirstname())
                    .lastname(tempTeacher.getSurname())
                    .build());
            tempTeacher.setUser(tempUser);
            tempUser.setUser(tempTeacher);
            tempUser.getRoles().add(Role.ROLE_TEACHER);
        } else {
            tempTeacher = Teacher.builder()
                    .id(oldTeacher.getId())
                    .username(oldTeacher.getUsername())
                    .password(oldTeacher.getPassword())
                    .firstname(teacher.getFirstname())
                    .surname(teacher.getSurname())
                    .academicPosition(teacher.getAcademicPosition())
                    .department(teacher.getDepartment())
                    .images(teacher.getImages())
                    .user(oldTeacher.getUser())
                    .build();
        }
        return teacherDao.save(tempTeacher);

    }

    @Override
    public Page<Teacher> getTeachers(String title, Pageable pageable) {
        return teacherDao.getTeachers(title, pageable);
    }

}