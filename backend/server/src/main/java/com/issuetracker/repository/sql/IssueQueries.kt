package com.issuetracker.repository.sql

const val FIND_ALL_ISSUE: String = """
SELECT id, title, content, writerId, statusId, milestoneId, createdDate 
FROM issue;
"""

const val INSERT_ISSUE: String = """

INSERT INTO `pyrodb`.`issue`(title, content, writerId, statusId, milestoneId, createdDate)
VALUES (:title, :content, :writerId,  :statusId, :milestoneId, NOW())
    
"""

const val INSERT_COMMENT: String = """

INSERT INTO `pyrodb`.`comment`(content, dateTime, writerId, issueId)
VALUES (:content, now(), :writerId,  :issueId)
    
"""
