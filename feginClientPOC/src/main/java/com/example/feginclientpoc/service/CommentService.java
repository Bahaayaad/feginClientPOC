package com.example.feginclientpoc.service;

import java.util.List;

import com.example.feginclientpoc.domain.Comment;

public interface CommentService {

    List<Comment> getAllComments();

    Comment getCommentById(Long id);

    List<Comment> getAllCommentsByPostId(Long commentId);

    Comment createComment(Comment comment);

    void updateComment(Long commentId, Comment comment);

    void deleteComment(Long commentId);

}
