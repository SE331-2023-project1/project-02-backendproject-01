package se331.project.projectTwoCompo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import se331.project.projectTwoCompo.entity.CommentMessage;

public interface CommentMessageDao {
    Integer getCommentMessageSize();
    Page<CommentMessage> getCommentMessages(Integer pageSize, Integer page);
    CommentMessage getCommentMessage(Long id);
    CommentMessage save(CommentMessage commentMessage);
    Page<CommentMessage> getCommentMessages(String name, Pageable page);
}
