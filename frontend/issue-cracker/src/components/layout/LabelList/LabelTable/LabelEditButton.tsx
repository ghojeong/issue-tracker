import React from 'react';
import { useSetRecoilState } from 'recoil';
import EditIcon from '@material-ui/icons/Edit';
import CommonButton from '../../../common/CommonButton';
import TextGroup from '../../../common/group/TextGroup';
import { labelEditIdState } from '../../../../store/Recoil';
import { TYPE as T, BUTTON_NAME as BN } from '../../../../utils/const';

const LabelEditButton = ({ id }: { id: number }): JSX.Element => {
  const setLabelEditId = useSetRecoilState(labelEditIdState);
  const handleClickEditButton = (e: React.MouseEvent<HTMLInputElement>) => {
    setLabelEditId((prev) => (prev === 0 ? +e.currentTarget.id : 0));
  };

  return (
    <CommonButton
      icon={<EditIcon style={{ color: '#1E4174', fontSize: 16 }} />}
      text={<TextGroup type={T.SMALL} content={BN.EDIT} color="#1E4174" />}
      onClick={handleClickEditButton}
      id={id}
    />
  );
};

export default LabelEditButton;
