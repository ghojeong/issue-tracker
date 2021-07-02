package com.issuetracker.dto.response;

import com.issuetracker.domain.Comments;

import java.util.List;
import java.util.stream.Collectors;

public class CommentsDto {

    private final List<CommentDto> comments;

    public CommentsDto(List<CommentDto> comments) {
        this.comments = comments;
    }

    public static CommentsDto from(Comments comments) {
        return new CommentsDto(comments.toList().stream()
                .map(CommentDto::from)
                .collect(Collectors.toList()));
    }

    public List<CommentDto> getComments() {
        return comments;
    }
}
