package com.issuetracker.repository.sql

const val FIND_ALL_LABEL: String = """
    
SELECT id, title, description, backgroundColor, textColor 
FROM `label`;
    
"""

const val FIND_ALL_LABEL_BY_ISSUE_ID: String = """
    
SELECT label.id, label.title, label.description, label.backgroundColor, label.textColor 
       FROM label
            INNER JOIN issueLabel ON issueLabel.labelId = label.id 
        WHERE issueLabel.issueId = :issueId; 
    
"""

const val INSERT_LABEL: String = """

INSERT INTO `pyrodb`.`label`(title, description, backgroundColor, textColor)
VALUES (:title, :description, :backgroundColor,  :textColor)
    
"""

const val UPDATE_LABEL: String = """

UPDATE `pyrodb`.`label`
SET title=:title, description=:description, backgroundColor=:backgroundColor, textColor=:textColor
WHERE id=:labelId
    
"""

const val DELETE_LABEL: String = """
    
DELETE FROM label WHERE id=:labelId;

"""
