package com.issuetracker.service.github;

import org.springframework.stereotype.Service;

@Service
public class GitHubLocalhostService extends GitHubService {
    @Override
    String getClientId() {
        return "e0ec416c1189c6a7f776";
    }

    @Override
    String getClientSecret() {
        return "33bea9cc6eae950f9ecf49f225af9f2e94ee6dda";
    }
}
