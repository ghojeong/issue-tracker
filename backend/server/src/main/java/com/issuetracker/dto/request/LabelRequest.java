package com.issuetracker.dto.request;

import com.issuetracker.domain.Label;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LabelRequest {

    @NotNull(message = "title이 NULL일 수 없습니다.")
    @NotBlank(message = "title이 공백일 수 없습니다.")
    private final String title;

    @NotNull(message = "description이 NULL일 수 없습니다.")
    @NotBlank(message = "description이 공백일 수 없습니다.")
    private final String description;

    @NotNull(message = "backgroundColor가 NULL일 수 없습니다.")
    @NotBlank(message = "backgroundColor가 공백일 수 없습니다.")
    private final String backgroundColor;

    @NotNull(message = "textColor가 NULL일 수 없습니다.")
    @NotBlank(message = "textColor가 공백일 수 없습니다.")
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
