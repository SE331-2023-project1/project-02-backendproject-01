package se331.project.projectTwoCompo.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnnouncementDTO {
    Long id;
    String title;
    String message;
    String timeSent;
    StudentTeacherDTO advisor;
    List<String> files;
    
}
