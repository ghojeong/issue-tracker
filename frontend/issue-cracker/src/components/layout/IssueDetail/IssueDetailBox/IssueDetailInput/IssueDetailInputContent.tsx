import React, { useState } from 'react';
import TextArea from './CommentTextArea';
import styled from 'styled-components';
import IssueDetailButton from '../../IssueDetailHeader/IssueDetailHeaderInfoSection/IssueDetailButton';
import { URL } from '../../../../../utils/const';
import { getPost } from '../../../../../utils/restAPI';
import { useRecoilState } from 'recoil';
import { issueDetailState } from '../../../../../store/Recoil';

const IssueDetailInputContent = (): JSX.Element => {
  const userToken = localStorage.getItem('token');
  const [comment, setComment] = useState("");
  const [issueDetail, setIssueDetail] = useRecoilState(issueDetailState);

  const submitComment = () => {
    getPost(
      `${URL.ISSUES}/${issueDetail.issueId}/comments`, 
      userToken, { content: comment }
    ).then(() => location.reload())
  }

  return (
    <IssueDetailInputContentStyle>
      <TextArea onChange={(e) => setComment(e.target.value)}/>
      <IssueDetailButton
        disabled={!comment}
        onClick={submitComment}
      />
    </IssueDetailInputContentStyle>
  );
};

export default IssueDetailInputContent;

const IssueDetailInputContentStyle = styled.div`
  padding-left: 50px;
`;
