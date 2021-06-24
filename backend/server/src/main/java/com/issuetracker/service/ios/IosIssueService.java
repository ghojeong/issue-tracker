package com.issuetracker.service.ios;

import com.issuetracker.domain.Comments;
import com.issuetracker.domain.Issue;
import com.issuetracker.domain.Status;
import com.issuetracker.dto.auth.UserDto;
import com.issuetracker.dto.ios.*;
import com.issuetracker.repository.CommentRepository;
import com.issuetracker.repository.IssueRepository;
import org.springframework.stereotype.Service;

@Service
public class IosIssueService {
    private final IssueRepository issueRepository;
    private final CommentRepository commentRepository;

    public IosIssueService(IssueRepository issueRepository, CommentRepository commentRepository) {
        this.issueRepository = issueRepository;
        this.commentRepository = commentRepository;
    }

    public IosIssuesDto getIssues(UserDto userDto, String status) {
        return IosIssuesDto.from(issueRepository.getIssues(userDto.toUser(), Status.from(status)));
    }

    //INFO.  "issueNumbers": [1, 2, 3] 이 들어오면, 해당 번호의 이슈의 상태를 반전
    //INFO. 아직 repository 완성되지 않음.
    public void toggleIssue(IosIssuesNumbersDto issueNumber) {
        issueRepository.toggle(issueNumber.toIssueNumber()); //TODO. toggle 네이밍 변경 필요해보임.
    }

    public IosIssueOptionDto findIssueOption() {
        return IosIssueOptionDto.from(issueRepository.findIssueOption());
    }

    public void save(UserDto userDto, IosNewIssueDto issueDto) {
        issueRepository.save(userDto.toUser(), issueDto.toNewIssue());
    }

    public IosIssueDetailDto findDetailedIssueId(Long issueId) {
        Issue issue = issueRepository.findById(issueId);
        Comments comments = commentRepository.findByIssueId(issueId);

        return IosIssueDetailDto.from(issue, comments);
    }

    public IosCommentsDto findCommentsByIssueId(Long issueId) {
        return IosCommentsDto.from(commentRepository.findByIssueId(issueId));
    }

}
