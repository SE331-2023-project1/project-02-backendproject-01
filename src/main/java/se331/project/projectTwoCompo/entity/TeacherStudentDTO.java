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
public class TeacherStudentDTO {
    Long id;
    String firstname;
    String surname;
    String department;
    List<String> images;
}
