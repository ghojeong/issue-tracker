import React from 'react';
import styled from 'styled-components';
import IssueNav from './IssueNav';
import IssueTable from './IssueTable';

const IssueList = (): JSX.Element => {
  return (
    <IssueListDiv>
      <IssueNav />
      <React.Suspense fallback={null}>
        <IssueTable />
      </React.Suspense>
    </IssueListDiv>
  );
};

export default IssueList;

const IssueListDiv = styled.div``;
