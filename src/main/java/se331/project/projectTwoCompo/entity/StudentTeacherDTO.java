package se331.project.projectTwoCompo.entity;

import java.util.List;

import com.google.auto.value.AutoValue.Builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherDTO {
    Long id;
    String academicPosition;
    String firstname;
    String surname;
    String department;
    TeacherStudentDTO student;
    List<String> images;
}
