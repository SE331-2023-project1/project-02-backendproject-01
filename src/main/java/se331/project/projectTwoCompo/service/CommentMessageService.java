package se331.project.projectTwoCompo.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import se331.project.projectTwoCompo.entity.CommentMessage;

public interface CommentMessageService {
    Integer getCommentMessageSize();
    Page<CommentMessage> getCommentMessages(Integer pageSize, Integer page);
    CommentMessage getCommentMessage(Long id);
    CommentMessage save(CommentMessage teacher);
    Page<CommentMessage> getCommentMessages(String title, Pageable pageable);
}
