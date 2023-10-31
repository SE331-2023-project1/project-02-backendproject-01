package se331.project.projectTwoCompo.config;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import se331.project.projectTwoCompo.entity.Announcement;
import se331.project.projectTwoCompo.entity.CommentHistory;
import se331.project.projectTwoCompo.entity.CommentMessage;
import se331.project.projectTwoCompo.entity.Person;
import se331.project.projectTwoCompo.entity.Student;
import se331.project.projectTwoCompo.entity.Teacher;
import se331.project.projectTwoCompo.repository.AnnouncementRepository;
import se331.project.projectTwoCompo.repository.CommentHistoryRepository;
import se331.project.projectTwoCompo.repository.CommentMessageRepository;
import se331.project.projectTwoCompo.repository.PersonRepository;
import se331.project.projectTwoCompo.repository.StudentRepository;
import se331.project.projectTwoCompo.repository.TeacherRepository;
import se331.project.projectTwoCompo.security.user.Role;
import se331.project.projectTwoCompo.security.user.User;
import se331.project.projectTwoCompo.security.user.UserRepository;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final StudentRepository studentRepository;
    final TeacherRepository teacherRepository;
    final PersonRepository personRepository;
    final CommentMessageRepository commentMessageRepository;
    final CommentHistoryRepository commentHistoryRepository;
    final UserRepository userRepository;
    final AnnouncementRepository announcementRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        System.out.println("Init started.");
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        User admin = userRepository.save(User.builder()
            .username("admin")
            .password(encoder.encode("admin"))
            .firstname("admin")
            .lastname("admin")
            .email("admin@admin.com")
            .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
            .build()
        );
        Person tempAdmin = personRepository.save(Person.builder().build());
        tempAdmin.setUser(admin);
        admin.setUser(tempAdmin);
        admin.getRoles().add(Role.ROLE_ADMIN);

        Teacher t1, t2;
        t1 = teacherRepository.save(Teacher.builder()
            .username("kanye_west")
            .password(encoder.encode("1234"))
            .firstname("Kanye")
            .surname("West")
            .academicPosition("Something")
            .department("Somewhere")
            .build()
        );
        t1.getImages().add("https://storage.googleapis.com/download/storage/v1/b/drowninworkbn.appspot.com/o/2566-10-29%20045419205-2566-10-23%20165242659-eva-evangelion.gif?generation=1698530060683005&alt=media");
        User user1 = userRepository.save(User.builder()
            .username(t1.getUsername())
            .password(t1.getPassword())
            .firstname("Kanye")
            .lastname("West")
            .email("Kanye@West.com")
            .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
            .build()
        );
        t1.setUser(user1);
        user1.setUser(t1);
        user1.getRoles().add(Role.ROLE_TEACHER);

        t2 = teacherRepository.save(Teacher.builder()
            .firstname("Travis")
            .surname("Scott")
            .academicPosition("Something")
            .department("Somewhere")
            .build()
        );
        User user2 = userRepository.save(User.builder()
            .username("travis_scott")
            .password(encoder.encode("1234"))
            .firstname("Travis")
            .lastname("Scott")
            .email("Travis@Scott.com")
            .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
            .build()
        );
        t2.setUser(user2);
        user2.setUser(t2);
        user2.getRoles().add(Role.ROLE_TEACHER);

        Student tempSt;
        User tempUs;
        tempSt = studentRepository.save(Student.builder()
            .studentId("644115001")
            .firstname("Ariana")
            .surname("Grande")
            .department("Software Engineering")
            .build()
        );
        tempSt.getImages().add("https://storage.googleapis.com/download/storage/v1/b/drowninworkbn.appspot.com/o/2566-10-29%20045419205-2566-10-23%20165242659-eva-evangelion.gif?generation=1698530060683005&alt=media");
        tempUs = userRepository.save(User.builder()
            .username("ariana_grande")
            .password(encoder.encode("1234"))
            .firstname("Ariana")
            .lastname("Grande")
            .email("Ariana@Grande.com")
            .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
            .build()
        );
        tempSt.setUser(tempUs);
        tempUs.setUser(tempSt);
        tempUs.getRoles().add(Role.ROLE_STUDENT);
        tempSt.setAdvisor(t1);
        t1.getAdvisee().add(tempSt);
        CommentHistory his1 = commentHistoryRepository.save(CommentHistory.builder()
            .adviseeId(tempSt.getId())
            .advisorId(t1.getId())
            .build()
        );
        CommentMessage msg1 = commentMessageRepository.save(CommentMessage.builder()
            .message("hello")
            .sentFromAdvisor(false)
            .timeSent("now")
            .build()
        );
        msg1.setFrom(his1);
        his1.getHistory().add(msg1);
        CommentMessage msg2 = commentMessageRepository.save(CommentMessage.builder()
            .message("no")
            .sentFromAdvisor(true)
            .timeSent("when")
            .build()
        );
        msg2.setFrom(his1);
        his1.getHistory().add(msg2);
        CommentMessage msg3 = commentMessageRepository.save(CommentMessage.builder()
            .message("why")
            .sentFromAdvisor(false)
            .timeSent("idk")
            .build()
        );
        msg3.setFrom(his1);
        his1.getHistory().add(msg3);
        
        tempSt = studentRepository.save(Student.builder()
            .studentId("644115002")
            .firstname("Olivia")
            .surname("Rodrigo")
            .department("Software Engineering")
            .build()
        );
        tempUs = userRepository.save(User.builder()
            .username("olivia_rodrigo")
            .password(encoder.encode("1234"))
            .firstname("Olivia")
            .lastname("Rodrigo")
            .email("Olivia@Rodrigo.com")
            .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
            .build()
        );
        tempSt.setUser(tempUs);
        tempUs.setUser(tempSt);
        tempUs.getRoles().add(Role.ROLE_STUDENT);
        tempSt.setAdvisor(t1);
        t1.getAdvisee().add(tempSt);
        CommentHistory his2 = commentHistoryRepository.save(CommentHistory.builder()
            .adviseeId(tempSt.getId())
            .advisorId(t1.getId())
            .build()
        );
        tempSt = studentRepository.save(Student.builder()
            .studentId("644115032")
            .firstname("Kimberly")
            .surname("Kardashian")
            .department("Software Engineering")
            .build()
        );
        tempUs = userRepository.save(User.builder()
            .username("kimberly_kardashian")
            .password(encoder.encode("1234"))
            .firstname("Kimberly")
            .lastname("Kardashian")
            .email("Kimberly@Kardashian.com")
            .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
            .build()
        );
        tempSt.setUser(tempUs);
        tempUs.setUser(tempSt);
        tempUs.getRoles().add(Role.ROLE_STUDENT);
        tempSt.setAdvisor(t2);
        t2.getAdvisee().add(tempSt);
        CommentHistory his3 = commentHistoryRepository.save(CommentHistory.builder()
            .adviseeId(tempSt.getId())
            .advisorId(t2.getId())
            .build()
        );
        tempSt = studentRepository.save(Student.builder()
            .studentId("642115004")
            .firstname("Taylor")
            .surname("Swift")
            .department("Software Engineering")
            .build()
        );
        tempUs = userRepository.save(User.builder()
            .username("taylor_swift")
            .password(encoder.encode("1234"))
            .firstname("Taylor")
            .lastname("Swift")
            .email("Taylor@Swift.com")
            .lastPasswordResetDate(Date.from(LocalDate.of(2021, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()))
            .build()
        );
        tempSt.setUser(tempUs);
        tempUs.setUser(tempSt);
        tempUs.getRoles().add(Role.ROLE_STUDENT);
        tempSt.setAdvisor(t2);
        t2.getAdvisee().add(tempSt);
        CommentHistory his4 = commentHistoryRepository.save(CommentHistory.builder()
            .adviseeId(tempSt.getId())
            .advisorId(t2.getId())
            .build()
        );

        Announcement ann1 = announcementRepository.save(Announcement.builder()
            .title("Some Interesting Title")
            .message("私の名前は吉良良景です。 私は33歳です。 私の家はすべての別荘がある森王の北東部にあり、私は結婚していません。私は亀湯百貨店の従業員として働いており、遅くとも午後8時までに毎日家に帰ります。 私は喫煙しませんが、時々飲みます。")
            .timeSent("23/9/2023 15:13")
            .build()
        );
        ann1.setAdvisor(t1);
        Announcement ann2 = announcementRepository.save(Announcement.builder()
            .title("Crazy?")
            .message("Crazy? I was crazy once. They locked me in a room. A rubber room! A rubber room with rats,and rats make me crazy. Crazy? I was crazy once. They locked me in a room. A rubber room! A rubber room with rats,and rats make me crazy. Crazy? I was crazy once. They locked me in a room. A rubber room! A rubber room with rats,and rats make me crazy. Crazy? I was crazy once. They locked me in a room. A rubber room! A rubber room with rats,and rats make me crazy. Crazy? I was crazy once. They locked me in a room. A rubber room! A rubber room with rats,and rats make me crazy.")
            .timeSent("23/9/2023 15:18")
            .build()
        );
        ann2.setAdvisor(t1);


        System.out.println("Init Finished.");
    }

}
