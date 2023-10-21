package se331.project.projectTwoCompo.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import se331.project.projectTwoCompo.entity.CommentHistory;

public interface CommentHistoryService {
    Integer getCommentHistorySize();
    Page<CommentHistory> getCommentHistory(Integer pageSize, Integer page);
    CommentHistory getCommentHistory(Long id);
    CommentHistory save(CommentHistory student);
    Page<CommentHistory> getCommentHistory(Integer advisorId, Integer adviseeId, Pageable pageable);
}
