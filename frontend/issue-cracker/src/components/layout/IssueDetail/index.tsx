import React, { useEffect } from 'react';
import { useLocation } from 'react-router-dom';
import { useRecoilState, useSetRecoilState } from 'recoil';
import styled from 'styled-components';
import IssueDetailHeader from './IssueDetailHeader';
import IssueDetailBox from './IssueDetailBox';
import useFetch from '../../../utils/useFetch';
import { issueDetailState, issueEditInputState } from '../../../store/Recoil';
import { Line as S } from '../../styles/CommonStyles';
import { URL as U } from '../../../utils/const';

const IssueDetail = (): JSX.Element => {
  const location = useLocation<{ id: number }>();
  const issueDetailUrl = U.ISSUES + '/' + location.state.id;
  const issueDetails = useFetch(issueDetailUrl, []);
  const [issueDetail, setIssueDetail] = useRecoilState(issueDetailState);
  const setIssueEditInput = useSetRecoilState(issueEditInputState);
  setIssueDetail(issueDetails);

  useEffect(() => {
    setIssueEditInput({
      title: issueDetails?.title,
      comment: issueDetails?.content,
    });
  }, [issueDetails]);

  return (
    <>
      {issueDetail && (
        <IssueDetailStyle>
          <IssueDetailHeader />
          <S.TableLine />
          <IssueDetailBox />
        </IssueDetailStyle>
      )}
    </>
  );
};

export default IssueDetail;

const IssueDetailStyle = styled.div``;
