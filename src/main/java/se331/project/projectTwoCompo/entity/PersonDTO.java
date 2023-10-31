package se331.project.projectTwoCompo.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {
    Long id;
    String firstname;
    String surname;
    String department;
    List<String> images;
}
