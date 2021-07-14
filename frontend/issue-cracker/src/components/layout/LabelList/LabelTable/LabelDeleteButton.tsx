import React from 'react';
import DeleteOutlineIcon from '@material-ui/icons/DeleteOutline';
import CommonButton from '../../../common/CommonButton';
import TextGroup from '../../../common/group/TextGroup';
import { getDelete } from '../../../../utils/restAPI';

import {
  TYPE as T,
  BUTTON_NAME as BN,
  URL as U,
} from '../../../../utils/const';

const LabelDeleteButton = ({ id }: { id: number }): JSX.Element => {
  const userToken = localStorage.getItem('token');
  const handleClickDeleteButton = (e: React.MouseEvent<HTMLInputElement>) => {
    const issueDeleteUrl = U.LABELS + '/' + e.currentTarget.id;
    getDelete(issueDeleteUrl, userToken);
  };

  return (
    <CommonButton
      icon={<DeleteOutlineIcon style={{ color: '#EE7785', fontSize: 16 }} />}
      text={<TextGroup type={T.SMALL} content={BN.DELETE} color="#EE7785" />}
      onClick={handleClickDeleteButton}
      id={id}
    />
  );
};

export default LabelDeleteButton;
