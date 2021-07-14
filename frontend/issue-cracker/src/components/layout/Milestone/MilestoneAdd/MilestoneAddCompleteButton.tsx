import React from 'react';
import styled from 'styled-components';
import ButtonGroup from '../../../common/group/ButtonGroup';
import { getPost } from '../../../../utils/restAPI';
import {
  BUTTON_SIZE as BS,
  BUTTON_NAME as BN,
  URL as U,
} from '../../../../utils/const';
import AddIcon from '@material-ui/icons/Add';
import { useSetRecoilState, useRecoilValue } from 'recoil';
import {
  milestoneAddInputState,
  milestoneAddState,
} from '../../../../store/Recoil';

const MilestoneAddCompleteButton = (): JSX.Element => {
  const setMilestoneAdd = useSetRecoilState(milestoneAddState);
  const milestoneAddInput = useRecoilValue(milestoneAddInputState);
  const userToken = localStorage.getItem('token');

  const handleClickButton = () => {
    getPost(U.MILESTONE, userToken, milestoneAddInput);
    setMilestoneAdd((prev) => !prev);
  };

  return (
    <ButtonBox onClick={handleClickButton}>
      <ButtonGroup
        type={BS.SMALL_FILL}
        name={BN.COMPLETE}
        icon={<AddIcon style={{ fontSize: 16 }} />}
      />
    </ButtonBox>
  );
};

export default MilestoneAddCompleteButton;

const ButtonBox = styled.div`
  display: flex;
`;
