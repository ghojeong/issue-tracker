package com.issuetracker.service.github;

import org.springframework.stereotype.Service;

@Service
public class GitHubIosService extends GitHubService {
    @Override
    String getClientId() {
        return "6cd127b711edc7a10a5c";
    }

    @Override
    String getClientSecret() {
        return "3dc13a8fb7474e085ec63c3b928d2bdf20f64a89";
    }
}
