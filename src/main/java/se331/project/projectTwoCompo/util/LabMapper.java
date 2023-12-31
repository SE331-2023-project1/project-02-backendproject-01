package se331.project.projectTwoCompo.util;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import se331.project.projectTwoCompo.entity.Announcement;
import se331.project.projectTwoCompo.entity.AnnouncementDTO;
import se331.project.projectTwoCompo.entity.*;

@Mapper
public interface LabMapper {
    LabMapper INSTANCE = Mappers.getMapper(LabMapper.class);
    StudentDTO getStudentDTO(Student student);
    List<StudentDTO> getStudentDTO(List<Student> students);
    TeacherDTO getTeacherDTO(Teacher teacher);
    List<TeacherDTO> getTeacherDTO(List<Teacher> teachers);
    CommentMessageDTO getCommentMessageDTO(CommentMessage commentMessage);
    List<CommentMessageDTO> getCommentMessageDTO(List<CommentMessage> commentMessage);
    CommentHistoryDTO getCommentHistoryDTO(CommentHistory commentHistory);
    List<CommentHistoryDTO> getCommentHistoryDTO(List<CommentHistory> commentHistory);
    PersonDTO getPersonDTO(Person person);
    List<PersonDTO> getPersonDTO(List<Person> person);
    @Mapping(target = "roles", source = "user.roles")
    PersonAuthDTO getPersonAuthDTO(Person person);
    AnnouncementDTO getAnnouncementDTO(Announcement announcement);
    List<AnnouncementDTO> getAnnouncementDTO(List<Announcement> announcement);
}
