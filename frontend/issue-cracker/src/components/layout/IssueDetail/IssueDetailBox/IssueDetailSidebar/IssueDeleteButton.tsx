import React from 'react';
import styled from 'styled-components';
import Button from '@material-ui/core/Button';
import TextGroup from '../../../../common/group/TextGroup';
import {
  TYPE as T,
  BUTTON_NAME as BN,
  URL as U,
} from '../../../../../utils/const';
import DeleteOutlineIcon from '@material-ui/icons/DeleteOutline';
import { useRecoilValue } from 'recoil';
import { issueDetailState } from '../../../../../store/Recoil';
import { getDelete } from '../../../../../utils/restAPI';

const IssueDeleteButton = (): JSX.Element => {
  const issueDetailId = useRecoilValue(issueDetailState);
  const userToken = localStorage.getItem('token');

  const handleClickDeleteButton = () => {
    const id = issueDetailId.issueId;
    const url = `${U.ISSUES}/${id}`;
    getDelete(url, userToken);
    window.history.back();
  };

  return (
    <IssueDeleteButtonDiv onClick={handleClickDeleteButton}>
      <IssueDeleteButtoStyle
        startIcon={
          <DeleteOutlineIcon style={{ fontSize: '14px', color: '#FF3B30' }} />
        }
        color="primary"
      >
        <TextGroup type={T.XSMALL} content={BN.DELETE_ISSUE} color="#FF3B30" />
      </IssueDeleteButtoStyle>
    </IssueDeleteButtonDiv>
  );
};

export default IssueDeleteButton;

const IssueDeleteButtonDiv = styled.div`
  display: flex;
  justify-content: flex-end;
`;

const IssueDeleteButtoStyle = styled(Button)`
  height: 40px;
  margin: 10px;
`;
