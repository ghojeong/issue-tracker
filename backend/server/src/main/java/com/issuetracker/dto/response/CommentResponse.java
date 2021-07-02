package com.issuetracker.dto.response;

import com.issuetracker.domain.Comment;
import com.issuetracker.domain.Writer;

import java.time.LocalDateTime;

public class CommentResponse {
    private final Long id;
    private final Writer writer;
    private final String content;
    private final LocalDateTime dateTime;

    public CommentResponse(Long id, Writer writer, String content, LocalDateTime dateTime) {
        this.id = id;
        this.writer = writer;
        this.content = content;
        this.dateTime = dateTime;
    }

    public static CommentResponse from(Comment comment) {
        return new CommentResponse(comment.getId(), comment.getWriter(), comment.getContent(), comment.getDateTime());
    }

    public Long getId() {
        return id;
    }

    public Writer getWriter() {
        return writer;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
