import React from 'react';
import CommonButton from '../../../common/CommonButton';
import ClosedIconGroup from '../../../common/group/ClosedIconGroup';
import TextGroup from '../../../common/group/TextGroup';
import { TYPE as T, BUTTON_NAME as BN } from '../../../../utils/const';

const MilestoneCloseButton = ({ id }: { id: number }): JSX.Element => {
  const handleClickCloseButton = () => {
    console.log('Close');
  };
  return (
    <CommonButton
      icon={<ClosedIconGroup type={'disabled'} />}
      text={<TextGroup type={T.SMALL} content={BN.CLOSE} color="#6E7191" />}
      onClick={handleClickCloseButton}
      id={id}
    />
  );
};

export default MilestoneCloseButton;
