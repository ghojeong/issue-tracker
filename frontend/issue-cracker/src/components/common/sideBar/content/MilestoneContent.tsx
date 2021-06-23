import React from 'react';
import ProgressBar from '../../../common/ProgressBar';
import { Text as S } from '../../../styles/CommonStyles';
import { MilestoneDataProps } from '../../../../utils/types/sideBarType';
import styled from 'styled-components';

const MilestoneContent = ({
  checkedMilestone,
}: MilestoneDataProps): JSX.Element => {
  return (
    <>
      <ProgressBox>
        {checkedMilestone?.length !== 0 && <ProgressBar />}
      </ProgressBox>
      <TextBox>
        <S.TextSmall>
          {checkedMilestone && checkedMilestone[0]?.title}
        </S.TextSmall>
      </TextBox>
    </>
  );
};

export default MilestoneContent;

const ProgressBox = styled.div`
  margin-bottom: 5px;
`;

const TextBox = styled.div`
  margin-left: 2px;
`;
