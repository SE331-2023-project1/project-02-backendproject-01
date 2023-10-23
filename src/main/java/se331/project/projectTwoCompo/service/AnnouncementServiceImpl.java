package se331.project.projectTwoCompo.service;

import lombok.RequiredArgsConstructor;
import se331.project.projectTwoCompo.dao.AnnouncementDao;
import se331.project.projectTwoCompo.entity.Announcement;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService{
    final AnnouncementDao announcementDao;
    @Override
    public Integer getAnnouncementSize() {
        return announcementDao.getAnnouncementSize();
    }

    @Override
    public Page<Announcement> getAnnouncement(Integer pageSize, Integer page) {
        return announcementDao.getAnnouncement(pageSize, page);
    }

    @Override
    public Announcement getAnnouncement(Long id) {
        return announcementDao.getAnnouncement(id);
    }

    @Override
    @Transactional
    public Announcement save(Announcement announcement) {
        return announcementDao.save(announcement);
    }

    @Override
    public Page<Announcement> getAnnouncement(Long advisorId, Pageable pageable) {
        return announcementDao.getAnnouncement(advisorId, pageable);
    }

}