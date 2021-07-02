package com.issuetracker.dto.response;

import com.issuetracker.domain.IssuesNumbers;

import java.util.List;

//TODO. 네이밍 변경해야함.
// 클라이언트가 복수개로 선택한 이슈 번호를 서버로 리퀘스트 보낼 때 매칭되는 dto
public class IssuesNumbersDto {
    private List<Long> issueNumbers;

    public IssuesNumbersDto() {}

    public IssuesNumbersDto(List<Long> issueNumbers) {
        this.issueNumbers = issueNumbers;
    }

    public IssuesNumbers toIssueNumber() {
        return new IssuesNumbers(issueNumbers);
    }

    public List<Long> getIssueNumbers() {
        return issueNumbers;
    }
}
