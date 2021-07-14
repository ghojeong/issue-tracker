import React from 'react';
import IssueDetailTitle from './IssueDetailTitle';
import IssueDetailTitleEdit from './IssueDetailTitleEdit';

const IssueDetailHeaderTitleSection = ({
  state,
}: {
  state: boolean;
}): JSX.Element => {
  return <>{state ? <IssueDetailTitleEdit /> : <IssueDetailTitle />}</>;
};

export default IssueDetailHeaderTitleSection;
