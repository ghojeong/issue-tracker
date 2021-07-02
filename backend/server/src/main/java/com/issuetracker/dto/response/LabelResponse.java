package com.issuetracker.dto.response;

import com.issuetracker.domain.Label;

public class LabelResponse {
    private final Long id;
    private final String title;
    private final String description;
    private final String backgroundColorHexa;
    private final String textColorHexa;

    public LabelResponse(Long id, String title, String description, String backgroundColorHexa, String textColorHexa) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.backgroundColorHexa = backgroundColorHexa;
        this.textColorHexa = textColorHexa;
    }

    public static LabelResponse from(Label label) {
        return new LabelResponse(label.getId(), label.getTitle(), label.getDescription(), label.getBackgroundColorHexa(), label.getTextColorHexa());
    }

    public Label toLabel() {
        return new Label(id, title, description, backgroundColorHexa, textColorHexa);
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

    public String getBackgroundColorHexa() {
        return backgroundColorHexa;
    }

    public String getTextColorHexa() {
        return textColorHexa;
    }
}
