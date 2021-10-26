package com.issuetracker.service.github;

import org.springframework.stereotype.Service;

@Service
public class GitHubLocalhostService extends GitHubService {
    // 웹 프론튿와 동일한지 확인 필요
    @Override
    String getClientId() {
        return "8d3e5607a4abb690a65d";
    }

    @Override
    String getClientSecret() {
        return "497e3104e2a0376fe3575dbf121ffbe9cc450529";
    }
}
