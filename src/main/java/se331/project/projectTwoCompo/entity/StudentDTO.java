package se331.project.projectTwoCompo.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    Long id;
    String studentId;
    String firstname;
    String surname;
    String department;
    StudentTeacherDTO advisor;
    List<String> images;
}
