package se331.project.projectTwoCompo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import se331.project.projectTwoCompo.entity.CommentMessage;

import java.util.List;

public interface CommentMessageRepository extends JpaRepository<CommentMessage,Long> {
    List<CommentMessage> findAll();
}