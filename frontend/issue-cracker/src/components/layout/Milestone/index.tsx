import React from 'react';
import { useRecoilValue } from 'recoil';
import styled from 'styled-components';
import { milestoneAddState } from '../../../store/Recoil';
import MilestoneAdd from './MilestoneAdd';
import MilestoneNav from './MilestoneNav';
import MilestoneTable from './MilestoneTable';

const MilestoneList = (): JSX.Element => {
  const milestoneAdd = useRecoilValue(milestoneAddState);

  return (
    <MilestoneistStyle>
      <MilestoneNav />
      {milestoneAdd && <MilestoneAdd />}
      <MilestoneTable />
    </MilestoneistStyle>
  );
};

export default MilestoneList;

const MilestoneistStyle = styled.div``;
