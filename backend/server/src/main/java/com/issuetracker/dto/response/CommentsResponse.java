package com.issuetracker.dto.response;

import com.issuetracker.domain.Comments;

import java.util.List;
import java.util.stream.Collectors;

public class CommentsResponse {
    private final List<CommentResponse> comments;

    public CommentsResponse(List<CommentResponse> comments) {
        this.comments = comments;
    }

    public static CommentsResponse from(Comments comments) {
        return new CommentsResponse(comments.toList().stream()
                .map(CommentResponse::from)
                .collect(Collectors.toList()));
    }

    public List<CommentResponse> getComments() {
        return comments;
    }
}
