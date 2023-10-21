package se331.project.projectTwoCompo.util;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import se331.project.projectTwoCompo.entity.CommentHistory;
import se331.project.projectTwoCompo.entity.CommentHistoryDTO;
import se331.project.projectTwoCompo.entity.CommentMessage;
import se331.project.projectTwoCompo.entity.CommentMessageDTO;
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
    CommentMessageDTO getCommentMessageDTO(CommentMessage commentMessage);
    List<CommentMessageDTO> getCommentMessageDTO(List<CommentMessage> commentMessage);
    CommentHistoryDTO getCommentHistoryDTO(CommentHistory commentHistory);
    List<CommentHistoryDTO> getCommentHistoryDTO(List<CommentHistory> commentHistory);
}
