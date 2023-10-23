package se331.project.projectTwoCompo.security.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se331.project.projectTwoCompo.entity.StudentAuthDTO;
import se331.project.projectTwoCompo.entity.StudentDTO;
import se331.project.projectTwoCompo.entity.Teacher;
import se331.project.projectTwoCompo.entity.TeacherDTO;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

  @JsonProperty("access_token")
  private String accessToken;
  @JsonProperty("refresh_token")
  private String refreshToken;
  @JsonProperty("user")
  private TeacherDTO users;

  @JsonProperty("user")
  private StudentAuthDTO user;
}
