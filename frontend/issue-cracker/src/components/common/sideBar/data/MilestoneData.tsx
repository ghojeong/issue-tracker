import React from 'react';
import styled from 'styled-components';
import { Issue as S } from '../../../styles/CommonStyles';
import { v4 as uuidv4 } from 'uuid';
import SideBarDropMilestone from '../SideBarDropMileStone';
import { MilestoneStateProps } from '../../../../utils/types/commonTypes';

const MilestoneData = ({ milestoneData }: MilestoneStateProps): JSX.Element => {
  return (
    <>
      {milestoneData?.map((milestone) => (
        <DropDownContent key={uuidv4()}>
          <SideBarDropMilestone data={milestone} />
        </DropDownContent>
      ))}
    </>
  );
};

export default MilestoneData;

const DropDownContent = styled(S.IssueCell)`
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 240px;
  height: 44px;
  padding: 8px 16px;
`;
