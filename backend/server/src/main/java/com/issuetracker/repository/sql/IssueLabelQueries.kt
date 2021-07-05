package com.issuetracker.repository.sql

const val INSERT_ISSUE_LABEL: String = """
    
INSERT INTO issueLabel(issueId, labelId)
VALUES (:issueId, :labelId)
    
"""

const val DELETE_ISSUE_LABEL: String = """
    DELETE FROM issueLabel WHERE issueId = :issueId;
"""
