import React from 'react';
import TextGroup from '../../../../common/group/TextGroup';
import { TYPE as T } from '../../../../../utils/const';

const IssueDetailIssueId = ({ content }: { content: string }): JSX.Element => {
  return <TextGroup type={T.LARGE} content={`#${content}`} color="#6E7191" />;
};

export default IssueDetailIssueId;
