package se331.project.projectTwoCompo.controller;

import lombok.RequiredArgsConstructor;
import se331.project.projectTwoCompo.entity.Announcement;
import se331.project.projectTwoCompo.service.AnnouncementService;
import se331.project.projectTwoCompo.util.LabMapper;

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
public class AnnouncementController {
    List<Announcement> announcementList;
    final AnnouncementService announcementService;
    @GetMapping("anns")
    public ResponseEntity<?> getAnnouncementLists(@RequestParam(value ="_limit", required = false) Integer perPage,
                                            @RequestParam(value = "_page", required = false) Integer page,
                                            @RequestParam(value = "advisorId", required = false) Long advisorId) {
                                                
        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Announcement> pageOutput;
        if (advisorId == null) {
            pageOutput = announcementService.getAnnouncement(perPage,page);
        }else{
            pageOutput = announcementService.getAnnouncement(advisorId,PageRequest.of(page-1,perPage));
        }
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));
        return new ResponseEntity<>(LabMapper.INSTANCE.getAnnouncementDTO(pageOutput.getContent()),responseHeader,HttpStatus.OK);

    }

    @GetMapping("anns/{id}")
    public ResponseEntity<?> getAnnouncement(@PathVariable("id") Long id) {
        Announcement output = announcementService.getAnnouncement(id);
        if (output != null){
            return ResponseEntity.ok(LabMapper.INSTANCE.getAnnouncementDTO(output));
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"The given id is not found");
        }
    }

    @PostMapping("/anns")
    public ResponseEntity<?> addAnnouncement(@RequestBody Announcement Announcement){
        Announcement output = announcementService.save(Announcement);
        return ResponseEntity.ok(LabMapper.INSTANCE.getAnnouncementDTO(output));
    }

}
