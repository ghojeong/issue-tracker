import React from 'react';
import styled from 'styled-components';
import { useRecoilValue, useSetRecoilState } from 'recoil';
import AddIcon from '@material-ui/icons/Add';
import LabelBox from './LabelBox';
import InputColorBox from './InputColorBox';
import InputContentBox from './InputContentBox';
import TextGroup from '../../../common/group/TextGroup';
import ButtonGroup from '../../../common/group/ButtonGroup';
import { labelAddState, labelAddInputState } from '../../../../store/Recoil';
import {
  TYPE as T,
  LABEL as L,
  BUTTON_SIZE as BS,
  BUTTON_NAME as BN,
  URL as U,
} from '../../../../utils/const';
import { Issue as S } from '../../../styles/CommonStyles';
import { getPost } from '../../../../utils/restAPI';

const LabelAdd = (): JSX.Element => {
  const setLabelAddState = useSetRecoilState(labelAddState);
  const userToken = localStorage.getItem('token');
  const labelAddInput = useRecoilValue(labelAddInputState);

  const handleClickButton = () => {
    getPost(U.LABELS, userToken, labelAddInput);
    setLabelAddState((prev) => !prev);
  };
  return (
    <LabelAddStyle>
      <LabelAddHeader>
        <TextBox>
          <TextGroup type={T.LARGE} content={L.ADD} color="#14142B" />
        </TextBox>
      </LabelAddHeader>
      <LabelAddCell>
        <LabelContainer>
          <LabelBox />
        </LabelContainer>
        <InputContainer>
          <InputContentBox />
          <InputColorBox />
        </InputContainer>
      </LabelAddCell>
      <ButtonContainer>
        <ButtonBox onClick={handleClickButton}>
          <ButtonGroup
            type={BS.SMALL_FILL}
            name={BN.COMPLETE}
            icon={<AddIcon style={{ fontSize: 16 }} />}
          />
        </ButtonBox>
      </ButtonContainer>
    </LabelAddStyle>
  );
};

export default LabelAdd;

const LabelAddStyle = styled.div`
  margin: 20px 0px;
`;

const LabelAddHeader = styled(S.IssueTableHeader)`
  background: #ffffff;
  border-bottom: none;
  padding-bottom: 30px;
  height: fit-content;
`;

const LabelAddCell = styled(S.IssueCell)`
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

const ButtonBox = styled.div`
  display: flex;
`;
