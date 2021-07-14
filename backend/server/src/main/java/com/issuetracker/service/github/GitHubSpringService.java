package com.issuetracker.service.github;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GitHubSpringService extends GitHubService {
    @Value("${github.client.id}")
    private String CLIENT_ID;

    @Value("${github.client.secret}")
    private String CLIENT_SECRET;


    @Override
    String getClientId() {
        return CLIENT_ID;
    }

    @Override
    String getClientSecret() {
        return CLIENT_SECRET;
    }
}
