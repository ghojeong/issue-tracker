import React from 'react';
import styled from 'styled-components';
import TextGroup from '../../../common/group/TextGroup';
import { TYPE as T, MILESTONE as M } from '../../../../utils/const';
import { Issue as S } from '../../../styles/CommonStyles';

const MilestoneAddHeader = (): JSX.Element => {
  return (
    <MilestoneAddHeaderStyle>
      <TextBox>
        <TextGroup type={T.LARGE} content={M.ADD} color="#14142B" />
      </TextBox>
    </MilestoneAddHeaderStyle>
  );
};

export default MilestoneAddHeader;

const MilestoneAddHeaderStyle = styled(S.IssueTableHeader)`
  background: #ffffff;
  border-bottom: none;
  padding-bottom: 30px;
  height: fit-content;
`;

const TextBox = styled.div`
  margin-left: 20px;
  margin-top: 20px;
`;
