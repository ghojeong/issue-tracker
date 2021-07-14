import React from 'react';
import styled from 'styled-components';
import TextGroup from '../../../common/group/TextGroup';
import { TYPE as T, MILESTONE as M } from '../../../../utils/const';
import { Issue as S } from '../../../styles/CommonStyles';

const MilestoneEditHeader = (): JSX.Element => {
  return (
    <MilestoneEditHeaderStyle>
      <TextBox>
        <TextGroup type={T.LARGE} content={M.EDIT} color="#14142B" />
      </TextBox>
    </MilestoneEditHeaderStyle>
  );
};

export default MilestoneEditHeader;

const MilestoneEditHeaderStyle = styled(S.IssueTableHeader)`
  background: #ffffff;
  height: fit-content;
  padding-bottom: 30px;
  border-top: none;
  border-bottom: none;
  border-radius: 0;
`;

const TextBox = styled.div`
  margin-left: 20px;
  margin-top: 20px;
`;
