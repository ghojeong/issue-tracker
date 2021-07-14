import React from 'react';
import styled from 'styled-components';
import { Issue as S } from '../../../styles/CommonStyles';
import MilestoneAddHeader from './MilestoneAddHeader';
import MilestoneAddName from './MilestoneAddName';
import MilestoneAddDescription from './MilestoneAddDescription';
import MilestoneAddDueDate from './MilestoneAddDueDate';
import MilestoneAddCompleteButton from './MilestoneAddCompleteButton';

const MilestoneAdd = (): JSX.Element => {
  return (
    <MilestoneAddStyle>
      <MilestoneAddHeader />
      <MilestoneAddCell>
        <InputContainer>
          <AddUpper>
            <MilestoneAddName />
            <MilestoneAddDueDate />
          </AddUpper>
          <AddLower>
            <MilestoneAddDescription />
          </AddLower>
        </InputContainer>
      </MilestoneAddCell>
      <ButtonContainer>
        <MilestoneAddCompleteButton />
      </ButtonContainer>
    </MilestoneAddStyle>
  );
};

export default MilestoneAdd;

const MilestoneAddStyle = styled.div`
  margin: 20px 0px;
`;

const MilestoneAddCell = styled(S.IssueCell)`
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
`;

const InputContainer = styled.div`
  width: 100%;
`;

const AddUpper = styled.div`
  display: flex;
  width: 100%;
`;

const AddLower = styled.div``;
