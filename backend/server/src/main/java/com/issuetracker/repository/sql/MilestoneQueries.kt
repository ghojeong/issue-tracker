package com.issuetracker.repository.sql

const val FIND_ALL_MILESTONE: String = """
SELECT id, title, description, statusId, dueDate 
FROM milestone;
"""

const val INSERT_MILESTONE: String = """

INSERT INTO `pyrodb`.`milestone`(title, description, statusId, dueDate)
VALUES (:title, :description, :statusId,  now())
    
"""

const val UPDATE_MILESTONE: String = """

UPDATE `pyrodb`.`milestone`
SET title=:title, description=:description
WHERE id=:milestoneId
    
"""
