package com.issuetracker.service.github;

import org.springframework.stereotype.Service;

@Service
public class GitHubWebService extends GitHubService {
    @Override
    String getClientId() {
        return "2a42dd1b1e2aad1238e9";
    }

    @Override
    String getClientSecret() {
        return "c34678e8b0aaca11d7c2f53dfc46993bc0a29748";
    }
}
