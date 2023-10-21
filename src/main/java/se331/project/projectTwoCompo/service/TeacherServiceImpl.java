package se331.project.projectTwoCompo.service;

import lombok.RequiredArgsConstructor;
import se331.project.projectTwoCompo.dao.TeacherDao;
import se331.project.projectTwoCompo.entity.Teacher;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService{
    final TeacherDao TeacherDao;

    @Override
    public Integer getTeacherSize() {
        return TeacherDao.getTeacherSize();
    }

    @Override
    public Page<Teacher> getTeachers(Integer pageSize, Integer page) {
        return TeacherDao.getTeachers(pageSize, page);
    }

    @Override
    public Teacher getTeacher(Long id) {
        return TeacherDao.getTeacher(id);
    }

    @Override
    @Transactional
    public Teacher save(Teacher Teacher) {
        return TeacherDao.save(Teacher);
    }

    @Override
    public Page<Teacher> getTeachers(String title, Pageable pageable) {
        return TeacherDao.getTeachers(title,pageable);
    }

}