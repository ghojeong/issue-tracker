import React from 'react';
import CommonButton from '../../../common/CommonButton';
import DeleteOutlineIcon from '@material-ui/icons/DeleteOutline';
import TextGroup from '../../../common/group/TextGroup';
import {
  TYPE as T,
  BUTTON_NAME as BN,
  URL as U,
} from '../../../../utils/const';
import { getDelete } from '../../../../utils/restAPI';

const MilestoneDeleteButton = ({ id }: { id: number }): JSX.Element => {
  const userToken = localStorage.getItem('token');

  const handleClickDeleteButton = (e: React.MouseEvent<HTMLInputElement>) => {
    const issueDeleteUrl = U.MILESTONE + '/' + e.currentTarget.id;
    getDelete(issueDeleteUrl, userToken);
  };

  return (
    <CommonButton
      icon={<DeleteOutlineIcon style={{ color: '#FF3B30', fontSize: 16 }} />}
      text={<TextGroup type={T.SMALL} content={BN.DELETE} color="#FF3B30" />}
      onClick={handleClickDeleteButton}
      id={id}
    />
  );
};

export default MilestoneDeleteButton;
