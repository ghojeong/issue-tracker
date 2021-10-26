package com.issuetracker.service.github;

import org.springframework.stereotype.Service;

@Service
public class GitHubWebService extends GitHubService {
    @Override
    String getClientId() {
        return "ada4e59669522bb588d4";
    }

    @Override
    String getClientSecret() {
        return "59435b92890a667d0b272d4cccdf332b45f75b6b";
    }
}
