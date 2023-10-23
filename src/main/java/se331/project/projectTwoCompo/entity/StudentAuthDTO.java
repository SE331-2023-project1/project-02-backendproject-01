package se331.project.projectTwoCompo.entity;

import java.util.ArrayList;
import java.util.List;

import com.google.auto.value.AutoValue.Builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import se331.project.projectTwoCompo.security.user.Role;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentAuthDTO {
    Long id;
    String name;
    List<Role> roles = new ArrayList<>();
}