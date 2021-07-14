import React from 'react';
import { useSetRecoilState } from 'recoil';
import CommonButton from '../../../common/CommonButton';
import EditIcon from '@material-ui/icons/Edit';
import TextGroup from '../../../common/group/TextGroup';
import { milestoneEditIdState } from '../../../../store/Recoil';
import { TYPE as T, BUTTON_NAME as BN } from '../../../../utils/const';

const MilestoneEditButton = ({ id }: { id: number }): JSX.Element => {
  const setMilestoneEditId = useSetRecoilState(milestoneEditIdState);
  const handleClickEditButton = (e: React.MouseEvent<HTMLInputElement>) => {
    setMilestoneEditId((prev) => (prev === 0 ? +e.currentTarget.id : 0));
  };

  return (
    <CommonButton
      icon={<EditIcon style={{ color: '#6E7191', fontSize: 16 }} />}
      text={<TextGroup type={T.SMALL} content={BN.EDIT} color="#6E7191" />}
      onClick={handleClickEditButton}
      id={id}
    />
  );
};

export default MilestoneEditButton;
