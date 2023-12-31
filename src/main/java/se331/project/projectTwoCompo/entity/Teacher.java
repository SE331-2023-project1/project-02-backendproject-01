package se331.project.projectTwoCompo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Teacher extends Person {
    String username;
    String academicPosition;
    @Builder.Default
    @OneToMany(mappedBy = "advisor")
    List<Student> advisee = new ArrayList<>();

}
