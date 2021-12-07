package com.issuetracker.controller.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.issuetracker.domain.Assignee;
import com.issuetracker.domain.Assignees;
import com.issuetracker.dto.response.AssigneesResponse;
import com.issuetracker.service.AssigneeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(MockitoExtension.class)
class WebAssigneeControllerTest {

    private MockMvc mvc;

    @Mock
    private AssigneeService assigneeService;

    @InjectMocks
    private WebAssigneeController webAssigneeController;

    private JacksonTester<AssigneesResponse> jsonAssignee;

    @BeforeEach
    public void setUp() {
        JacksonTester.initFields(this, new ObjectMapper());
        mvc = MockMvcBuilders.standaloneSetup(webAssigneeController)
                .addFilter(new CharacterEncodingFilter(StandardCharsets.UTF_8.name(), true))
                .build();
    }

    @Test
    @DisplayName("이슈트래커에 등록된 모든 유저 목록을 가져올 수 있다.")
    public void getAllIssues() throws Exception {

        // given
        Assignees assignees = new Assignees(
                Arrays.asList(
                        new Assignee("testId", "테스트 계정", "테스트 이미지 주소"),
                        new Assignee("testId2", "테스트 계정2", "테스트 이미지 주소2"),
                        new Assignee("testId3", "테스트 계정3", "테스트 이미지 주소3")
                )
        );

        AssigneesResponse assigneesResponse = AssigneesResponse.from(assignees);
        AssigneesResponse expectResponse = AssigneesResponse.from(assignees);

        given(assigneeService.getAllIssues())
                .willReturn(assigneesResponse);

        // when
        MockHttpServletResponse response = mvc.perform(
                get("/api/web/assignees")
                        .characterEncoding("utf8")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn()
                .getResponse();


        // then
        //TODO. expect 구문은 가능한 테스트 코드 가독성 때문에 상수로 쓰고 싶은데, 좋은 방법 없을까..빌더?..
        assertThat(response.getContentAsString()).isEqualTo(jsonAssignee.write(expectResponse).getJson());
    }

}
