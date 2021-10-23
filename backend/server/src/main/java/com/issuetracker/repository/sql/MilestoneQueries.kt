package com.issuetracker.repository.sql

const val FIND_ALL_MILESTONE: String = """
SELECT id, title, description, statusId, dueDate 
FROM milestone;
"""

const val INSERT_MILESTONE: String = """
INSERT INTO `pyrodb`.`milestone`(title, description, statusId, dueDate)
VALUES (:title, :description, :statusId, :dueDate)
"""

const val UPDATE_MILESTONE: String = """
UPDATE `pyrodb`.`milestone`
SET title=:title, description=:description
WHERE id=:milestoneId
"""

const val DELETE_MILESTONE: String = """

DELETE FROM milestone WHERE id=:milestoneId 
  
"""

const val CLOSE_MILESTONE: String = """

UPDATE milestone SET statusId = 'CLOSE' WHERE milestone.id = :milestoneId;
  
"""

const val OPEN_MILESTONE: String = """

UPDATE milestone SET statusId = 'OPEN' WHERE milestone.id = :milestoneId;
  
"""

const val FIND_MILESTONE_BY_ID: String = """

SELECT id, title, description, statusId, dueDate
FROM milestone
WHERE milestone.id = :milestoneId;
  
"""
