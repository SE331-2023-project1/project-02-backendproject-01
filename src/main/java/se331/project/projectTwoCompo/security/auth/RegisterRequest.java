package se331.project.projectTwoCompo.security.auth;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
  
  private String password;
  private String firstname;
  private String surname;
  private String department;
  private String studentId;
  private List<String> images;
}
