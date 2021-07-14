import React from 'react';
import { TYPE as T } from '../../../../../utils/const';
import LabelLargeGroup from '../../../../common/group/LabelLargeGroup';

const IssueDetailBadge = ({ state }: { state: boolean }): JSX.Element => {
  return (
    <>
      {state ? (
        <LabelLargeGroup type={T.OPEN} />
      ) : (
        <LabelLargeGroup type={T.CLOSED} />
      )}
    </>
  );
};

export default IssueDetailBadge;
