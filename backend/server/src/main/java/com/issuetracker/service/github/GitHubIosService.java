package com.issuetracker.service.github;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GitHubIosService extends GitHubService {
    @Value("${github.ios.client.id}")
    private String CLIENT_ID;

    @Value("${github.ios.client.secret}")
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
