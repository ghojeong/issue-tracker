import React from 'react';
import MilestoneTableHeader from './MilestoneTableHeader';
import MilestoneCell from './MilestoneCell';
import {
  milestoneEditIdState,
  milestoneAddState,
  milestoneEditInputState,
} from '../../../../store/Recoil';
import { useRecoilValue, useSetRecoilState } from 'recoil';
import useFetch from '../../../../utils/useFetch';
import { URL as U } from '../../../../utils/const';
import MilestoneEdit from '../MilestoneEdit';
import { MilestoneDataProps } from '../../../../utils/types/commonTypes';
import { v4 as uuidv4 } from 'uuid';

const MilestoneTable = (): JSX.Element => {
  const milestoneAdd = useRecoilValue(milestoneAddState);
  const milestoneEditId = useRecoilValue(milestoneEditIdState);
  const setMilestoneEditInput = useSetRecoilState(milestoneEditInputState);

  const milestoneList = useFetch(U.MILESTONE, [milestoneAdd]);
  const milestones = milestoneList?.milestones;

  return (
    <>
      <MilestoneTableHeader />
      {milestones?.map((milestone: MilestoneDataProps) => {
        milestoneEditId === milestone.id &&
          setMilestoneEditInput(milestone.milestoneInfo);

        return (
          <React.Fragment key={uuidv4()}>
            <MilestoneCell {...{ milestone }} />
            {milestoneEditId === milestone.id && <MilestoneEdit />}
          </React.Fragment>
        );
      })}
    </>
  );
};

export default MilestoneTable;
