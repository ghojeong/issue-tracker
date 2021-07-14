package com.issuetracker.dto.response;

import com.issuetracker.domain.Label;

public class LabelResponse {
    private final Long id;
    private final String title;
    private final String description;
    private final String backgroundColor;
    private final String textColor;

    public LabelResponse(Long id, String title, String description, String backgroundColor, String textColor) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
    }

    public static LabelResponse from(Label label) {
        return new LabelResponse(label.getId(), label.getTitle(), label.getDescription(), label.getBackgroundColor(), label.getTextColor());
    }

    public Label toLabel() {
        return new Label(id, title, description, backgroundColor, textColor);
    }

    public Long getId() {
        return id;
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
}
