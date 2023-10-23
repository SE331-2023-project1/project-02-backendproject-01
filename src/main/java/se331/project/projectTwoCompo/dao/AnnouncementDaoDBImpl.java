package se331.project.projectTwoCompo.dao;
import java.util.Optional;

import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import se331.project.projectTwoCompo.entity.Announcement;
import se331.project.projectTwoCompo.repository.AnnouncementRepository;

@Repository
@RequiredArgsConstructor
@Profile("db")
public class AnnouncementDaoDBImpl implements AnnouncementDao{
    final AnnouncementRepository announcementRepository;
    @Override
    public Integer getAnnouncementSize() {
        return Math.toIntExact(announcementRepository.count());
    }

    @Override
    public Page<Announcement> getAnnouncement(Integer pageSize, Integer page) {
        return announcementRepository.findAll(PageRequest.of(page - 1, pageSize));
    }

    @Override
    public Announcement getAnnouncement(Long id) {
        return announcementRepository.findById(id).orElse(null);
    }

    @Override
    public Announcement save(Announcement student) {
        return announcementRepository.save(student);
    }

    @Override
    public Page<Announcement> getAnnouncement(Long advisorId, Pageable page) {
        return announcementRepository.findByAdvisorId(advisorId, page);
    }

    @Override
    public Optional<Announcement> findById(Long id){
        return announcementRepository.findById(id);
    }

}
