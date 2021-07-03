package com.issuetracker.dto.auth;

import com.issuetracker.domain.auth.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserDto {
    private final String id;

    private final String name;

    private final String avatarUrl;

    private final List<String> emails;

    public UserDto(String id, String name, String avatarUrl, List<String> emails) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.emails = emails;
    }

    public User toUser() {
        return new User(id, name, avatarUrl, emails);
    }

    public static UserDto from(UserInfoDto userInfoDto, UserEmailDto[] emails) {
        return new UserDto(userInfoDto.getLogin(),
                userInfoDto.getName(),
                userInfoDto.getAvatarUrl(),
                Arrays.stream(emails).map(dto -> dto.getEmail()).collect(Collectors.toList()));
    }

    public static UserDto from(User user) {
        return new UserDto(user.getId(), user.getName(), user.getAvatarUrl(), user.getEmails());
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public List<String> getEmails() {
        return emails;
    }
}
