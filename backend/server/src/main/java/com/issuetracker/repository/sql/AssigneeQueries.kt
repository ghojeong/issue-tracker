package com.issuetracker.repository.sql

const val FIND_ALL_ASSIGNEE_BY_USER_ID: String = """
    SELECT user.id, user.name, user.avatarUrl
         FROM user
         INNER JOIN assignee ON assignee.userId = user.id
    WHERE assignee.issueId = :issueId;
"""

const val INSERT_ASSIGNEE: String = """
    INSERT INTO assignee(issueId, userId) VALUES (:issueId, :assigneeId);
"""

const val DELETE_ASSIGNEE: String = """
    DELETE FROM assignee WHERE issueId = :issueId;
"""
