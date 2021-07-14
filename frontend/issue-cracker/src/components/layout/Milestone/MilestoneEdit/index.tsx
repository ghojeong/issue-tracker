import React from 'react';
import styled from 'styled-components';
import { Issue as S } from '../../../styles/CommonStyles';
import MilestoneEditHeader from './MilestoneEditHeader';
import MilestoneEditName from './MilestoneEditName';
import MilestoneEditDescription from './MilestoneEditDescription';
import MilestoneEditDueDate from './MilestoneEditDueDate';
import MilestoneEditCompleteButton from './MilestoneEditCompleteButton';
import MilestoneEditCancelButton from './MilestoneEditCancelButton';

const MilestoneEdit = (): JSX.Element => {
  return (
    <MilestoneEditStyle>
      <MilestoneEditHeader />
      <MilestoneEditCell>
        <InputContainer>
          <EditUpper>
            <MilestoneEditName />
            <MilestoneEditDueDate />
          </EditUpper>
          <EditLower>
            <MilestoneEditDescription />
          </EditLower>
        </InputContainer>
      </MilestoneEditCell>
      <ButtonContainer>
        <MilestoneEditCancelButton />
        <MilestoneEditCompleteButton />
      </ButtonContainer>
    </MilestoneEditStyle>
  );
};

export default MilestoneEdit;

const MilestoneEditStyle = styled.div``;

const MilestoneEditCell = styled(S.IssueCell)`
  justify-content: center;
  height: fit-content;
  padding-bottom: 10px;

  :nth-child(2) {
    border-bottom: none;
  }
`;
const ButtonContainer = styled(S.IssueCell)`
  justify-content: flex-end;
  height: fit-content;
  padding: 20px;

  :last-child {
    border-radius: 0;
  }
`;

const InputContainer = styled.div`
  width: 100%;
`;

const EditUpper = styled.div`
  display: flex;
  width: 100%;
`;

const EditLower = styled.div``;
