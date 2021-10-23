package com.issuetracker.service.github;

import org.springframework.stereotype.Service;

@Service
public class GitHubSpringService extends GitHubService {
    @Override
    String getClientId() {
        return "613d2f8134285ef8a4f6";
    }

    @Override
    String getClientSecret() {
        return "fa3da7c96b59ed8436bd2d4eb716f42db1ec5d6e";
    }
}
