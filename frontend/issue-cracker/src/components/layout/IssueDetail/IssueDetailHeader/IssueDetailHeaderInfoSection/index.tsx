import React from 'react';
import styled from 'styled-components';
import IssueDetailBadge from './IssueDetailBadge';
import IssueDetailDescription from './IssueDetailDescription';

const IssueDetailHeaderInfoSection = ({
  state,
  issueDetails,
}: {
  state: boolean;
  issueDetails: any;
}): JSX.Element => {
  return (
    <>
      <ButtonBox>
        <IssueDetailBadge {...{ state }} />
      </ButtonBox>
      <TextBox>
        <IssueDetailDescription {...{ state, issueDetails }} />
      </TextBox>
    </>
  );
};

export default IssueDetailHeaderInfoSection;

const ButtonBox = styled.div`
  margin-right: 10px;
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
