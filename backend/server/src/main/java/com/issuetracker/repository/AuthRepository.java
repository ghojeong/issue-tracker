package com.issuetracker.repository;

import com.issuetracker.domain.auth.Auth;
import org.springframework.data.repository.CrudRepository;

public interface AuthRepository extends CrudRepository<Auth, String> {
}
