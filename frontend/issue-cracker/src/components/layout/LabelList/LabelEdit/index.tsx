import React from 'react';
import styled from 'styled-components';
import LabelBox from './LabelBox';
import InputColorBox from './InputColorBox';
import InputContentBox from './InputContentBox';
import LabelEditCompleteButton from './LabelEditCompleteButton';
import LabelEditCancelButton from './LabelEditCancelButton';
import TextGroup from '../../../common/group/TextGroup';
import { TYPE as T, LABEL as L } from '../../../../utils/const';
import { Issue as S } from '../../../styles/CommonStyles';

const LabelEdit = (): JSX.Element => {
  return (
    <LabelEditStyle>
      <LabelEditHeader>
        <TextBox>
          <TextGroup type={T.LARGE} content={L.EDIT} color="#14142B" />
        </TextBox>
      </LabelEditHeader>
      <LabelEditCell>
        <LabelContainer>
          <LabelBox />
        </LabelContainer>
        <InputContainer>
          <InputContentBox />
          <InputColorBox />
        </InputContainer>
      </LabelEditCell>
      <ButtonContainer>
        <LabelEditCancelButton />
        <LabelEditCompleteButton />
      </ButtonContainer>
    </LabelEditStyle>
  );
};

export default LabelEdit;

const LabelEditStyle = styled.div``;

const LabelEditHeader = styled(S.IssueTableHeader)`
  background: #ffffff;
  height: fit-content;
  padding-bottom: 30px;
  border-top: none;
  border-bottom: none;
  border-radius: 0;
`;

const LabelEditCell = styled(S.IssueCell)`
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

const TextBox = styled.div`
  margin-left: 20px;
  margin-top: 20px;
`;

const LabelContainer = styled.div`
  width: 30%;
  margin: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
`;

const InputContainer = styled.div`
  width: 100%;
`;
