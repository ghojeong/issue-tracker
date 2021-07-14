import React from 'react';
import TextGroup from '../../../common/group/TextGroup';
import { TYPE as T } from '../../../../utils/const';

const MilestoneDescription = ({
  description,
}: {
  description: string;
}): JSX.Element => {
  return <TextGroup type={T.SMALL} content={description} color="#6E7191" />;
};

export default MilestoneDescription;
