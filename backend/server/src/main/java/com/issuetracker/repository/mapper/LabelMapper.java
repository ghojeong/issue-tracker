package com.issuetracker.repository.mapper;

import com.issuetracker.domain.Label;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LabelMapper implements RowMapper<Label> {

    @Override
    public Label mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Label(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("description"),
                rs.getString("backgroundColor"),
                rs.getString("textColor")
        );
    }
}
