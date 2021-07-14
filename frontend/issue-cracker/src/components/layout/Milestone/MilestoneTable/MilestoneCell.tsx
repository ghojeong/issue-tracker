import React from 'react';
import styled from 'styled-components';
import TextGroup from '../../../common/group/TextGroup';
import ProgressBar from '../../../common/ProgressBar';
import { getIssueCount, getProgressRate } from '../../../../utils/util';
import { MilestoneDataProps } from '../../../../utils/types/commonTypes';
import { Issue as S } from '../../../styles/CommonStyles';
import { TYPE as T } from '../../../../utils/const';
import MilestoneEditButton from './MilestoneEditButton';
import MilestoneCloseButton from './MilestoneCloseButton';
import MilestoneDeleteButton from './MilestoneDeleteButton';
import MilestoneTitle from './MilestoneTitle';
import MilestoneDueDate from './MilestoneDueDate';
import MilestoneDescription from './MilestoneDescription';
import MilestoneProgressRate from './MilestoneProgressRate';

const MilestoneCell = ({
  milestone,
}: {
  milestone: MilestoneDataProps;
}): JSX.Element => {
  const { id, issues, milestoneInfo } = milestone;

  const openIssue = getIssueCount(issues, 'OPEN');
  const closeIssue = getIssueCount(issues, 'CLOSE');
  const progressRate = getProgressRate(openIssue, closeIssue);

  return (
    <MilestoneCellStyle>
      <LeftBox>
        <LeftUpper>
          <MilestoneTitle title={milestoneInfo.title} />
          <MilestoneDueDate dueDate={milestoneInfo.dueDate} />
        </LeftUpper>
        <LeftLower>
          <MilestoneDescription description={milestoneInfo.description} />
        </LeftLower>
      </LeftBox>
      <RightBox>
        <RightUpper>
          <MilestoneCloseButton {...{ id }} />
          <MilestoneEditButton {...{ id }} />
          <MilestoneDeleteButton {...{ id }} />
        </RightUpper>
        <RightCenter>
          <ProgressBar value={progressRate} />
        </RightCenter>
        <RightLower>
          <MilestoneProgressRate progressRate={progressRate} />
          <IssueButtonBox>
            {/* 열린이슈 */}
            <TextGroup
              type={T.SMALL}
              content={`열린이슈(${openIssue})`}
              color="#6E7191"
            />
            &nbsp;
            {/* 닫힌이슈 */}
            <TextGroup
              type={T.SMALL}
              content={`닫힌이슈(${closeIssue})`}
              color="#6E7191"
            />
          </IssueButtonBox>
        </RightLower>
      </RightBox>
    </MilestoneCellStyle>
  );
};

export default MilestoneCell;

const MilestoneCellStyle = styled(S.IssueCell)`
  align-items: center;
  padding: 0px 25px;
`;

const LeftBox = styled.div`
  display: flex;
  flex-direction: column;
`;

const LeftUpper = styled.div`
  display: flex;
  padding: 3px 0px;
  cursor: pointer;
`;
const LeftLower = styled.div`
  padding: 3px 10px;
  cursor: pointer;
`;

const RightBox = styled.div`
  display: flex;
  flex-direction: column;
`;

const RightUpper = styled.div`
  display: flex;
  justify-content: flex-end;
  cursor: pointer;
`;

const RightCenter = styled.div`
  padding: 5px 0px;
  min-width: 245px;
`;

const RightLower = styled.div`
  display: flex;
  justify-content: space-between;
`;

const IssueButtonBox = styled.div`
  display: flex;
`;
