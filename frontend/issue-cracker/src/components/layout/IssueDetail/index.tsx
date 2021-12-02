import React, { useEffect } from 'react';
import { useLocation } from 'react-router-dom';
import { useSetRecoilState } from 'recoil';
import styled from 'styled-components';
import IssueDetailHeader from './IssueDetailHeader';
import IssueDetailBox from './IssueDetailBox';
import { issueDetailState, issueEditInputState } from '../../../store/Recoil';
import { Line as S } from '../../styles/CommonStyles';
import { URL as U } from '../../../utils/const';

const IssueDetail = (): JSX.Element => {
  const location = useLocation<{ id: number }>();
  const setIssueDetail = useSetRecoilState(issueDetailState);
  const setIssueEditInput = useSetRecoilState(issueEditInputState);

  useEffect(() => {
    fetch(`${U.ISSUES}/${location.state.id}`)
    .then(res => res.json())
    .then(issueDetail => {
      setIssueDetail(issueDetail)
      setIssueEditInput({
        title: issueDetail?.title,
        comment: issueDetail?.content,
      });
    });
  });

  return (
    <>
      <IssueDetailStyle>
        <IssueDetailHeader />
        <S.TableLine />
        <IssueDetailBox />
      </IssueDetailStyle>
    </>
  );
};

export default IssueDetail;

const IssueDetailStyle = styled.div``;
