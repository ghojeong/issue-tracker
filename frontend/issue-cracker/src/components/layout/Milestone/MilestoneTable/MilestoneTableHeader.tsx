import React from 'react';
import { useRecoilValue } from 'recoil';
import styled from 'styled-components';
import FlagTwoToneIcon from '@material-ui/icons/FlagTwoTone';
import CommonButton from '../../../common/CommonButton';
import ClosedIconGroup from '../../../common/group/ClosedIconGroup';
import CountGroup from '../../../common/group/CountGroup';
import TextGroup from '../../../common/group/TextGroup';
import { milestoneAddState } from '../../../../store/Recoil';
import { getMilestoneCount } from '../../../../utils/util';
import useFetch from '../../../../utils/useFetch';
import { Issue as S } from '../../../styles/CommonStyles';
import { TEXT as TT, TYPE as T, URL as U } from '../../../../utils/const';

const MilestoneTableHeader = (): JSX.Element => {
  const milestoneAdd = useRecoilValue(milestoneAddState);
  const milestone = useFetch(U.MILESTONE, [milestoneAdd]);
  const milestones = milestone?.milestones;
  const openMilestoneCount = getMilestoneCount(milestones, 'OPEN');
  const closeMilestoneCount = getMilestoneCount(milestones, 'CLOSE');

  return (
    <S.IssueTableHeader>
      <MilestoneTableHeaderWrapper>
        <CommonButton
          icon={<FlagTwoToneIcon />}
          text={
            <TextGroup
              type={T.SMALL}
              content={TT.OPEN_MILESTONE}
              color="#222"
            />
          }
          count={<CountGroup count={openMilestoneCount} color="#222" />}
        />
        <CommonButton
          icon={<ClosedIconGroup type={'disabled'} />}
          text={
            <TextGroup
              type={T.SMALL}
              content={TT.CLOSED_MILESTONE}
              color="#6E7191"
            />
          }
          count={<CountGroup count={closeMilestoneCount} color="#6E7191" />}
        />
      </MilestoneTableHeaderWrapper>
    </S.IssueTableHeader>
  );
};

export default MilestoneTableHeader;

const MilestoneTableHeaderWrapper = styled.div`
  margin-left: 15px;
  display: flex;
  justify-content: flex-start;
`;
