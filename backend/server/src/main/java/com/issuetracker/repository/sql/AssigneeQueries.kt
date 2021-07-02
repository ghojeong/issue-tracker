package com.issuetracker.repository.sql

const val FIND_ALL_ASSIGNEE_BY_USER_ID: String = """
    SELECT user.id, user.name, user.avatarUrl
         FROM user
         INNER JOIN assignee ON assignee.userId = user.id
    WHERE assignee.issueId = :issueId;
"""

const val FIND_ALL_ASSIGNEE: String = """
    SELECT issueId, userId FROM assignee;
"""
