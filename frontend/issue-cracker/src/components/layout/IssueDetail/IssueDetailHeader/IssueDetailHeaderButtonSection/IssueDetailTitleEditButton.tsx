import React from 'react';
import styled from 'styled-components';
import Button from '@material-ui/core/Button';
import EditIcon from '@material-ui/icons/Edit';
import TextGroup from '../../../../common/group/TextGroup';
import { TYPE as T, TEXT as TT } from '../../../../../utils/const';
import { useSetRecoilState } from 'recoil';
import { issueEditTitleState } from '../../../../../store/Recoil';

const IssueDetailTitleEditButton = (): JSX.Element => {
  const setIssueEditTitle = useSetRecoilState(issueEditTitleState);

  const handleClickEditButton = () => setIssueEditTitle((prev) => !prev);

  return (
    <TitleEditButton
      startIcon={<TitleEditIcon />}
      color="primary"
      onClick={handleClickEditButton}
      id={'editButton'}
    >
      <TextGroup type={T.SMALL} content={TT.EDIT_TITLE} color="#007AFF" />
    </TitleEditButton>
  );
};

export default IssueDetailTitleEditButton;

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
