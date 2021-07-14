import React from 'react';
import styled from 'styled-components';
import IssueTableHeader from './IssueTableHeader';
import IssueCell from './IssueCell';
import useFetch from '../../../../utils/useFetch';
import { URL as U } from '../../../../utils/const';

const IssueTable = (): JSX.Element => {
  const issueData = useFetch(U.ISSUES, []);
  const issues = issueData?.issues;

  return (
    <IssueTableContainer>
      <IssueTableHeader {...{ issues }} />
      <IssueCell {...{ issues }} />
    </IssueTableContainer>
  );
};

export default IssueTable;

const IssueTableContainer = styled.div``;
