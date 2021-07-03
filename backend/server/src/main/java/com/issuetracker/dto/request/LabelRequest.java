package com.issuetracker.dto.request;

import com.issuetracker.domain.Label;

public class LabelRequest {
    private final String title;
    private final String description;
    private final String backgroundColor;
    private final String textColor;

    public LabelRequest(String title, String description, String backgroundColor, String textColor) {
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

    public Label toLabel() {
        return new Label(null, title, description, backgroundColor, textColor);
    }
}
