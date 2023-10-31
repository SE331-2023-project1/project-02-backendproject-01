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
import se331.project.projectTwoCompo.security.user.User;

@Data
@SuperBuilder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;
    String password;
    String firstname;
    String surname;
    String department;
    @OneToOne
    User user;
    @Column(length = 2083)
    @ElementCollection
    @Builder.Default
    List<String> images = new ArrayList<>();
}
