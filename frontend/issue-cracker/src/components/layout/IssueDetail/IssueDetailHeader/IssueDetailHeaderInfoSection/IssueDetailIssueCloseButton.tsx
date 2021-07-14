import React from 'react';
import styled from 'styled-components';
import Button from '@material-ui/core/Button';
import TextGroup from '../../../../common/group/TextGroup';
import { TYPE as T, TEXT as TT } from '../../../../../utils/const';
import IssueClosedIcon from '../../../../styles/svg/IssueClosedIcon';

const IssueDetailIssueCloseButton = ({
  callback,
}: {
  callback: React.Dispatch<React.SetStateAction<boolean>>;
}): JSX.Element => {
  const handleClickIssueCloseButton = () => callback(false);

  return (
    <TitleEditButton
      onClick={handleClickIssueCloseButton}
      startIcon={
        <IssueClosedIcon color="#007AFF" style={{ width: 16, height: 16 }} />
      }
      color="primary"
    >
      <TextGroup type={T.SMALL} content={TT.CLOSE_ISSUE} color="#007AFF" />
    </TitleEditButton>
  );
};

export default IssueDetailIssueCloseButton;

const TitleEditButton = styled(Button)`
  width: 120px;
  height: 40px;
  margin: 5px;
  border: 1px solid #007aff;
  border-radius: 16px;
`;
