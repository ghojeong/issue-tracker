package com.issuetracker.repository.sql

const val INSERT_ISSUE_LABEL: String = """
    
INSERT INTO issueLabel(issueId, labelId)
VALUES (:issueId, :labelId)
    
"""

const val DELETE_ISSUE_LABEL_BY_LABEL_ID: String = """
    DELETE FROM issueLabel WHERE issueId = :issueId;
"""

const val DELETE_ISSUE_LABEL_BY_ISSUE_ID: String = """
    DELETE FROM issueLabel WHERE issueId = :issueId;
"""
