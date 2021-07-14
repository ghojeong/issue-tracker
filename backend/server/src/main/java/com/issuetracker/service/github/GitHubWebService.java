package com.issuetracker.service.github;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GitHubWebService extends GitHubService {
    @Value("${github.web.client.id}")
    private String CLIENT_ID;

    @Value("${github.web.client.secret}")
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
