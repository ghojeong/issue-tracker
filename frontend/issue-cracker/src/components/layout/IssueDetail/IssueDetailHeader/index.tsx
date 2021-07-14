import React, { useState, useEffect, useRef } from 'react';
import styled from 'styled-components';
import { useRecoilValue, useRecoilState } from 'recoil';
import { issueDetailState } from '../../../../store/Recoil';
import { issueEditTitleState } from '../../../../store/Recoil';
import IssueDetailHeaderTitleSection from './IssueDetailHeaderTitleSection';
import IssueDetailHeaderButtonSection from './IssueDetailHeaderButtonSection';
import IssueDetailHeaderInfoSection from './IssueDetailHeaderInfoSection';
import IssueDetailIssueId from './IssueDetailHeaderInfoSection/IssueDetailIssueId';

const IssueDetailHeader = (): JSX.Element => {
  const issueDetails = useRecoilValue<any | null>(issueDetailState);
  const [issueEditTitle, setIssueEditTitle] =
    useRecoilState(issueEditTitleState);
  // const { issueId, status, title, writer, comments } = issueDetails;
  const editRef = useRef<HTMLInputElement>(null);

  const isOpen = issueDetails?.status === 'OPEN' ? true : false;
  const [issueState, setIssueState] = useState(isOpen);

  useEffect(() => {
    const handleClickBody = (e: MouseEvent) => {
      // if (editRef.current && !editRef.current.contains(e.target)) {
      //   setIssueEditTitle((prev) => !prev);
      // }
      // console.log(e.target);
      // console.log('current', editRef.current);
      // setIssueEditTitle((prev) => !prev);
    };
    window.addEventListener('mousedown', handleClickBody);

    return () => window.removeEventListener('mousedown', handleClickBody);
  }, [editRef]);

  return (
    <IssueDetailHeaderStyle>
      <IssueDetailHeaderUpperBox>
        <TextBox>
          <IssueDetailHeaderTitleSection state={issueEditTitle} />
          <IssueDetailIssueId content={issueDetails?.issueId} />
        </TextBox>

        <ButtonBox ref={editRef}>
          <IssueDetailHeaderButtonSection
            state={issueEditTitle}
            id={issueDetails?.issueId}
            callback={setIssueState}
          />
        </ButtonBox>
      </IssueDetailHeaderUpperBox>
      <TitleLowerBox>
        <IssueDetailHeaderInfoSection
          state={issueState}
          issueDetails={issueDetails}
        />
      </TitleLowerBox>
    </IssueDetailHeaderStyle>
  );
};

export default IssueDetailHeader;

const IssueDetailHeaderStyle = styled.div`
  display: flex;
  flex-direction: column;
`;

const IssueDetailHeaderUpperBox = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  width: 100%;
`;

const TitleLowerBox = styled.div`
  display: flex;
`;

const TextBox = styled.div`
  display: flex;
  align-items: center;
  width: 100%;

  div {
    :last-child {
      margin-left: 5px;
    }
  }
`;

const ButtonBox = styled.div`
  margin-right: 10px;
  display: flex;
`;
