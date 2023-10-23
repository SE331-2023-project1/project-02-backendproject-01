package se331.project.projectTwoCompo.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import se331.project.projectTwoCompo.entity.Announcement;

public interface AnnouncementService {
    Integer getAnnouncementSize();
    Page<Announcement> getAnnouncement(Integer pageSize, Integer page);
    Announcement getAnnouncement(Long id);
    Announcement save(Announcement announcement);
    Page<Announcement> getAnnouncement(Long advisorId, Pageable pageable);
}
