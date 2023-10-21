package se331.project.projectTwoCompo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import se331.project.projectTwoCompo.entity.CommentHistory;

import java.util.List;

public interface CommentHistoryRepository extends JpaRepository<CommentHistory,Long> {
    List<CommentHistory> findAll();
    Page<CommentHistory> findByAdvisorIdAndAdviseeId(Long advisorId, Long adviseeId, Pageable pageRequest);

}