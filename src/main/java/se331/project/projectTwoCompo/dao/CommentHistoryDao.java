package se331.project.projectTwoCompo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import se331.project.projectTwoCompo.entity.CommentHistory;

public interface CommentHistoryDao {
    Integer getCommentHistorySize();
    Page<CommentHistory> getCommentHistory(Integer pageSize, Integer page);
    CommentHistory getCommentHistory(Long id);
    CommentHistory save(CommentHistory commentHistory);
    Page<CommentHistory> getCommentHistory(Integer advisorId, Integer adviseeId, Pageable page);
}
