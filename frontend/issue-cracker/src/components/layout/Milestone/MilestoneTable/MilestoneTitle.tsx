import React from 'react';
import CommonButton from '../../../common/CommonButton';
import FlagTwoToneIcon from '@material-ui/icons/FlagTwoTone';
import TextGroup from '../../../common/group/TextGroup';
import { TYPE as T } from '../../../../utils/const';

const MilestoneTitle = ({ title }: { title: string }): JSX.Element => {
  return (
    <CommonButton
      icon={
        <FlagTwoToneIcon
          style={{
            width: '16px',
            height: '16px',
            color: '#007AFF',
          }}
        />
      }
      text={<TextGroup type={T.MEDIUM} content={title} color="#222" />}
    />
  );
};

export default MilestoneTitle;
