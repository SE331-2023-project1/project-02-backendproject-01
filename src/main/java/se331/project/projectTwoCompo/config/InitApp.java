package se331.project.projectTwoCompo.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import se331.project.projectTwoCompo.entity.Student;
import se331.project.projectTwoCompo.entity.Teacher;
import se331.project.projectTwoCompo.repository.StudentRepository;
import se331.project.projectTwoCompo.repository.TeacherRepository;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final StudentRepository studentRepository;
    final TeacherRepository teacherRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        System.out.println("Init started.");

        Teacher t1, t2;
        t1 = teacherRepository.save(Teacher.builder()
            .firstname("Kanye")
            .surname("West")
            .academicPosition("Something")
            .department("Somewhere")
            .build()
        );
        t2 = teacherRepository.save(Teacher.builder()
            .firstname("Travis")
            .surname("Scott")
            .academicPosition("Something")
            .department("Somewhere")
            .build()
        );

        Student tempSt;
        tempSt = studentRepository.save(Student.builder()
            .studentId("644115001")
            .firstname("Ariana")
            .surname("Grande")
            .department("Software Engineering")
            .build()
        );
        tempSt.setAdvisor(t1);
        t1.getAdvisee().add(tempSt);
        tempSt = studentRepository.save(Student.builder()
            .studentId("644115002")
            .firstname("Olivia")
            .surname("Rodrigo")
            .department("Software Engineering")
            .build()
        );
        tempSt.setAdvisor(t1);
        t1.getAdvisee().add(tempSt);
        tempSt = studentRepository.save(Student.builder()
            .studentId("644115032")
            .firstname("Kimberly")
            .surname("Kardashian")
            .department("Software Engineering")
            .build()
        );
        tempSt.setAdvisor(t2);
        t2.getAdvisee().add(tempSt);
        tempSt = studentRepository.save(Student.builder()
            .studentId("642115004")
            .firstname("Taylor")
            .surname("Swift")
            .department("Software Engineering")
            .build()
        );
        tempSt.setAdvisor(t2);
        t2.getAdvisee().add(tempSt);

        System.out.println("Init Finished.");
    }
    
}
