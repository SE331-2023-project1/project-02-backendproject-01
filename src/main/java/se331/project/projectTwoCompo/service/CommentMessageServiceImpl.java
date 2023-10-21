package se331.project.projectTwoCompo.service;

import lombok.RequiredArgsConstructor;
import se331.project.projectTwoCompo.dao.CommentMessageDao;
import se331.project.projectTwoCompo.entity.CommentMessage;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;


@Service
@RequiredArgsConstructor
public class CommentMessageServiceImpl implements CommentMessageService{
    final CommentMessageDao commentMessageDao;

    @Override
    public Integer getCommentMessageSize() {
        return commentMessageDao.getCommentMessageSize();
    }

    @Override
    public Page<CommentMessage> getCommentMessages(Integer pageSize, Integer page) {
        return commentMessageDao.getCommentMessages(pageSize, page);
    }

    @Override
    public CommentMessage getCommentMessage(Long id) {
        return commentMessageDao.getCommentMessage(id);
    }

    @Override
    @Transactional
    public CommentMessage save(CommentMessage commentMessage) {
        return commentMessageDao.save(commentMessage);
    }

    @Override
    public Page<CommentMessage> getCommentMessages(String title, Pageable pageable) {
        return commentMessageDao.getCommentMessages(title,pageable);
    }

}