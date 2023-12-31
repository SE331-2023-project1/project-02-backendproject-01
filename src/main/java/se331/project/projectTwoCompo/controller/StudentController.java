package se331.project.projectTwoCompo.controller;

import lombok.RequiredArgsConstructor;
import se331.project.projectTwoCompo.entity.Student;
import se331.project.projectTwoCompo.service.StudentService;
import se331.project.projectTwoCompo.util.LabMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class StudentController {
    List<Student> studentList;
    @Autowired
    final StudentService studentService;

    @GetMapping("students")
    public ResponseEntity<?> getStudentLists(@RequestParam(value = "advisorId", required = false) Integer advisorId,
                                            @RequestParam(value = "_limit", required = false) Integer perPage,
                                            @RequestParam(value = "_page", required = false) Integer page,
                                            @RequestParam(value = "title", required = false) String title) {

        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        advisorId = advisorId == 0? null : advisorId;
        Page<Student> pageOutput;
        if (advisorId == null) {
            if (title == null) {
                pageOutput = studentService.getStudents(perPage, page);
            } else {
                pageOutput = studentService.getStudents(title, PageRequest.of(page - 1, perPage));
            }
        } else {
            if (title == null) {
                pageOutput = studentService.getStudents(advisorId, PageRequest.of(page - 1, perPage));
            } else {
                pageOutput = studentService.getStudents(advisorId, title, PageRequest.of(page - 1, perPage));
            }
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getStudentDTO(pageOutput.getContent()), responseHeader,HttpStatus.OK);

    }

    @GetMapping("students/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") Long id) {
        Student output = studentService.getStudent(id);
        if (output != null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDTO(output));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    @PostMapping("/students")
    public ResponseEntity<?> addStudent(@RequestBody Student Student) {
        Student output = studentService.save(Student);
        return ResponseEntity.ok(LabMapper.INSTANCE.getStudentDTO(output));
    }

}
