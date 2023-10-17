package se331.project.projectTwoCompo.util;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import se331.project.projectTwoCompo.entity.Student;
import se331.project.projectTwoCompo.entity.StudentDTO;
import se331.project.projectTwoCompo.entity.Teacher;
import se331.project.projectTwoCompo.entity.TeacherDTO;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    StudentDTO getStudentDTO(Student student);
    List<StudentDTO> getStudentDTO(List<Student> students);
    TeacherDTO getTeacherDTO(Teacher teacher);
    List<TeacherDTO> getTeacherDTO(List<Teacher> teachers);
    // @Mapping(target = "roles", source = "user.roles")
    // OrganizerAuthDTO getOrganizerAuthDTO(Organizer organizer);
}
