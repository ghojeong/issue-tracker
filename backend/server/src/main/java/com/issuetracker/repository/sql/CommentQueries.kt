package com.issuetracker.repository.sql

const val FIND_ALL_COMMENT_BY_ISSUE_ID: String = """
SELECT comment.id, comment.issueId, dateTime, comment.writerId, comment.content, user.name, user.avatarUrl
FROM comment
         INNER JOIN user ON comment.writerId = user.id
         INNER JOIN issue ON comment.issueId = issue.id
WHERE comment.issueId = :issueId;
"""

const val INSERT_COMMENT: String = """

INSERT INTO `pyrodb`.`comment`(content, dateTime, writerId, issueId)
VALUES (:content, now(), :writerId,  :issueId)
    
"""


const val UPDATE_COMMENT: String = """

UPDATE `pyrodb`.`comment`
SET content=:content
WHERE id=:commentId
    
"""
