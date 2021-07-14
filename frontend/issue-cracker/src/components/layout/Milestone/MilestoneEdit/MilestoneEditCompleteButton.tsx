import React from 'react';
import styled from 'styled-components';
import ButtonGroup from '../../../common/group/ButtonGroup';
import { getPut } from '../../../../utils/restAPI';
import {
  BUTTON_SIZE as BS,
  BUTTON_NAME as BN,
  URL as U,
} from '../../../../utils/const';
import AddIcon from '@material-ui/icons/Add';
import { useRecoilValue, useRecoilState } from 'recoil';
import {
  milestoneEditIdState,
  milestoneEditInputState,
} from '../../../../store/Recoil';

const MilestoneEditCompleteButton = (): JSX.Element => {
  const [milestoneEditId, setMilestoneEditId] =
    useRecoilState(milestoneEditIdState);
  const milestoneEditInput = useRecoilValue(milestoneEditInputState);
  const userToken = localStorage.getItem('token');
  const milestoneEditUrl = U.MILESTONE + '/' + milestoneEditId;

  const handleClickCompleteButton = () => {
    getPut(milestoneEditUrl, userToken, milestoneEditInput);
    setMilestoneEditId(0);
  };

  return (
    <ButtonBox onClick={handleClickCompleteButton}>
      <ButtonGroup
        type={BS.SMALL_FILL}
        name={BN.COMPLETE}
        icon={<AddIcon style={{ fontSize: 16 }} />}
      />
    </ButtonBox>
  );
};

export default MilestoneEditCompleteButton;

const ButtonBox = styled.div`
  display: flex;
  margin-left: 8px;
`;
