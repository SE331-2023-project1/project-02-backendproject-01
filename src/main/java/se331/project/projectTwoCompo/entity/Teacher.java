package se331.project.projectTwoCompo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import se331.project.projectTwoCompo.security.user.User;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String academicPosition;
    String firstname;
    String surname;
    String department;
    @Builder.Default
    @OneToMany(mappedBy = "advisor")
    List<Student> advisee = new ArrayList<>();
    @ElementCollection
    List<String> images;
    @OneToOne
    User userTeacher;
}
