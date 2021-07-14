import React from 'react';
import TextGroup from '../../../../common/group/TextGroup';
import { TYPE as T } from '../../../../../utils/const';
import { useRecoilValue } from 'recoil';
import { issueEditInputState } from '../../../../../store/Recoil';

const IssueDetailTitle = (): JSX.Element => {
  const issueEditInput = useRecoilValue(issueEditInputState);

  return (
    <TextGroup type={T.LARGE} content={issueEditInput?.title} color="#222" />
  );
};

export default IssueDetailTitle;
