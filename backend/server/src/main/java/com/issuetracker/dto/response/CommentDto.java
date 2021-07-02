package com.issuetracker.dto.response;

import com.issuetracker.domain.Comment;
import com.issuetracker.domain.Writer;

import java.time.LocalDateTime;

public class CommentDto {
    private Long id;
    private Writer writer;
    private String content;
    private LocalDateTime dateTime;

    public CommentDto(Long id, Writer writer, String content, LocalDateTime dateTime) {
        this.id = id;
        this.writer = writer;
        this.content = content;
        this.dateTime = dateTime;
    }

    public static CommentDto from(Comment comment) {
        return new CommentDto(comment.getId(), comment.getWriter(), comment.getContent(), comment.getDateTime());
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
