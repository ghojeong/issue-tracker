package com.issuetracker.domain;

import org.springframework.data.annotation.Id;

public class Label {

    @Id
    private final Long id;

    private final String title;

    private final String description;

    private final String backgroundColor;

    private final String textColor;

    public Label(Long id, String title, String description, String backgroundColor, String textColor) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public String getTextColor() {
        return textColor;
    }

    public Long getId() {
        return id;
    }
}
