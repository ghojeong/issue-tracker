package com.issuetracker.repository.sql

const val FIND_ALL_COMMENT_BY_ISSUE_ID: String = """
SELECT comment.id, comment.issueId, dateTime, comment.writerId, comment.content, user.name, user.avatarUrl
FROM comment
         INNER JOIN user ON comment.writerId = user.id
         INNER JOIN issue ON comment.issueId = issue.id
WHERE comment.issueId = :issueId;
"""
