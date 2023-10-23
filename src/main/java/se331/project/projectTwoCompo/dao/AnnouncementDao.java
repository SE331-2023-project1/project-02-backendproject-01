package se331.project.projectTwoCompo.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import se331.project.projectTwoCompo.entity.Announcement;

public interface AnnouncementDao {
    Integer getAnnouncementSize();
    Page<Announcement> getAnnouncement(Integer pageSize, Integer page);
    Announcement getAnnouncement(Long id);
    Announcement save(Announcement announcement);
    Page<Announcement> getAnnouncement(Long advisorId, Pageable page);
    Optional<Announcement> findById(Long id);
}
