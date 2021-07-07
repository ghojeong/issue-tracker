package com.issuetracker.repository.sql

const val FIND_ALL_ISSUE: String = """
SELECT id, title, content, writerId, statusId, milestoneId, createdDate 
FROM issue;
"""

const val INSERT_ISSUE: String = """
INSERT INTO `pyrodb`.`issue`(title, content, writerId, statusId, milestoneId, createdDate)
VALUES (:title, :content, :writerId,  :statusId, :milestoneId, NOW())
"""

const val UPDATE_ISSUE: String = """
UPDATE issue SET title = :title, content = :content
WHERE issue.id = :issueId;
"""

const val UPDATE_ISSUE_MILESTONE: String = """
UPDATE issue SET milestoneId = :milestoneId
WHERE issue.id = :issueId;
"""

const val DELETE_MILESTONE_OF_ISSUE: String = """
    
UPDATE issue 
SET milestoneId=null 
WHERE milestoneId=:milestoneId;
  
"""

const val DELETE_ISSUE_BY_ID: String = """
    
DELETE FROM issue WHERE id=:issueId
  
"""
