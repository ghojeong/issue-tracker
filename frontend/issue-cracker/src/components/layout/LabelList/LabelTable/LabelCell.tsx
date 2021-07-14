import React from 'react';
import { Issue as S } from '../../../styles/CommonStyles';
import styled from 'styled-components';
import LabelSmallGroup from '../../../common/group/LabelSmallGroup';
import TextGroup from '../../../common/group/TextGroup';
import LabelEditButton from './LabelEditButton';
import { LabelProps } from '../../../../utils/types/commonTypes';
import { TYPE as T } from '../../../../utils/const';
import LabelDeleteButton from './LabelDeleteButton';

const LabelCell = ({ label }: { label: LabelProps }): JSX.Element => {
  const { id, title, textColor, backgroundColor, description } = label;

  return (
    <LabelCellStyle>
      <LabelContent>
        <LabelBox>
          <LabelSmallGroup
            color={textColor}
            backgroundColor={backgroundColor}
            label={title}
          ></LabelSmallGroup>
        </LabelBox>
        <TextBox>
          <TextGroup type={T.SMALL} content={description} color="#6E7191" />
        </TextBox>
      </LabelContent>
      <ButtonBox>
        <LabelEditButton {...{ id }} />
        <LabelDeleteButton {...{ id }} />
      </ButtonBox>
    </LabelCellStyle>
  );
};

export default LabelCell;

const LabelCellStyle = styled(S.IssueCell)`
  align-items: center;
`;

const LabelContent = styled.div`
  display: flex;
  justify-content: space-evenly;
  align-items: center;
  margin-left: 20px;
`;

const LabelBox = styled.div`
  min-width: 250px;
`;

const TextBox = styled.div``;

const ButtonBox = styled.div`
  display: flex;
  margin-right: 20px;
`;
