package com.issuetracker.domain;

import java.util.List;

public class Comments {
    private final List<Comment> comments;

    public Comments(List<Comment> comments) {
        this.comments = comments;
    }

    public void add(Comment comment) {
        comments.add(comment);
    }

    public List<Comment> toList() {
        return comments;
    }
}
