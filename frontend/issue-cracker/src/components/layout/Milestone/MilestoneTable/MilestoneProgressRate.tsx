import React from 'react';
import TextGroup from '../../../common/group/TextGroup';
import { TYPE as T } from '../../../../utils/const';

const MilestoneProgressRate = ({
  progressRate,
}: {
  progressRate: number;
}): JSX.Element => {
  return (
    <TextGroup type={T.SMALL} content={`${progressRate}%`} color="#6E7191" />
  );
};

export default MilestoneProgressRate;
