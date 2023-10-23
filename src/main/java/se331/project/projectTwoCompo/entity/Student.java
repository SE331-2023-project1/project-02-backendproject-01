package se331.project.projectTwoCompo.entity;

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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String studentId;
    String studentPw;
    String firstname;
    String surname;
    String department;
    @ManyToOne
    Teacher advisor;
    @ElementCollection
    List<String> images;
    @OneToOne
    User userStudent;
}
