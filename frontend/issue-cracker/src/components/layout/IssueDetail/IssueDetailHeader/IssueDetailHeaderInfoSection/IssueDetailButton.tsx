import React from 'react';
import styled from 'styled-components';
import ButtonGroup from '../../../../common/group/ButtonGroup';
import { BUTTON_SIZE as BS } from '../../../../../utils/const';

interface Props {
  disabled?: boolean
  onClick?: React.MouseEventHandler<HTMLButtonElement>
}

const IssueDetailButton = ({ disabled, onClick }: Props): JSX.Element => (
  <IssueDetailButtonStyle>
    <ButtonGroup
      disabled={disabled}
      onClick={onClick} 
      type={BS.SMALL_FILL} 
      name="코멘트 작성" 
    />
  </IssueDetailButtonStyle>
);

export default IssueDetailButton;

const IssueDetailButtonStyle = styled.div`
  display: flex;
  justify-content: flex-end;
  align-items: center;
  margin-top: 20px;
`;
