package com.issuetracker.service.github;

import org.springframework.stereotype.Service;

@Service
public class GitHubLocalhostService extends GitHubService {
    // 웹 프론튿와 동일한지 확인 필요
    @Override
    String getClientId() {
        return "bd67de79012efe833a1e";
    }

    @Override
    String getClientSecret() {
        return "ab4be51bbc28ffcd5b2ec952049ae2877d8665b2";
    }
}
