import React from 'react';
import styled from 'styled-components';
import Button from '@material-ui/core/Button';
import EditIcon from '@material-ui/icons/Edit';
import TextGroup from '../../../../common/group/TextGroup';
import { TYPE as T, TEXT as TT, URL as U } from '../../../../../utils/const';
import { getPut } from '../../../../../utils/restAPI';
import { useRecoilValue, useSetRecoilState } from 'recoil';
import {
  issueEditTitleState,
  issueEditInputState,
} from '../../../../../store/Recoil';

const IssueDetailTitleEditCompleteButton = ({
  id,
}: {
  id: number;
}): JSX.Element => {
  const setIssueEditTitle = useSetRecoilState(issueEditTitleState);
  const issueEditInput = useRecoilValue(issueEditInputState);

  const handleClickCompleteButton = () => {
    const issueEditUrl = U.ISSUES + '/' + id;
    const userToken = localStorage.getItem('token');
    getPut(issueEditUrl, userToken, issueEditInput);
    setIssueEditTitle((prev) => !prev);
  };

  return (
    <TitleEditButton
      startIcon={<TitleEditIcon />}
      color="primary"
      onClick={handleClickCompleteButton}
    >
      <TextGroup type={T.SMALL} content={TT.EDIT_COMPLETE} color="#007AFF" />
    </TitleEditButton>
  );
};

export default IssueDetailTitleEditCompleteButton;

const TitleEditButton = styled(Button)`
  width: 120px;
  height: 40px;
  margin: 5px;
  border: 1px solid #007aff;
  border-radius: 16px;
`;

const TitleEditIcon = styled(EditIcon)`
  font-size: 10px;
  color: #007aff;
`;
