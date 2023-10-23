package se331.project.projectTwoCompo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import se331.project.projectTwoCompo.entity.Announcement;

import java.util.List;

public interface AnnouncementRepository extends JpaRepository<Announcement,Long> {
    List<Announcement> findAll();
    Page<Announcement> findByAdvisorId(Long advisorId, Pageable pageRequest);

}