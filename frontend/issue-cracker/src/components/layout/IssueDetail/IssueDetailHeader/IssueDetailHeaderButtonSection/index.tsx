import React from 'react';
import IssueDetailIssueCloseButton from '../IssueDetailHeaderInfoSection/IssueDetailIssueCloseButton';
import IssueDetailTitleEditButton from './IssueDetailTitleEditButton';
import IssueDetailTitleEditCancelButton from './IssueDetailTitleEditCancelButton';
import IssueDetailTitleEditCompleteButton from './IssueDetailTitleEditCompleteButton';

const IssueDetailHeaderButtonSection = ({
  state,
  id,
  callback,
}: {
  state: boolean;
  id: number;
  callback: React.Dispatch<React.SetStateAction<boolean>>;
}): JSX.Element => {
  return (
    <>
      {state ? (
        <>
          <IssueDetailTitleEditCancelButton />
          <IssueDetailTitleEditCompleteButton {...{ id }} />
        </>
      ) : (
        <>
          <IssueDetailTitleEditButton />
          <IssueDetailIssueCloseButton {...{ callback }} />
        </>
      )}
    </>
  );
};

export default IssueDetailHeaderButtonSection;
