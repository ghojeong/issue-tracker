import React from 'react';
import styled from 'styled-components';
import AddIcon from '@material-ui/icons/Add';
import ButtonGroup from '../../../common/group/ButtonGroup';
import {
  URL as U,
  BUTTON_SIZE as BS,
  BUTTON_NAME as BN,
} from '../../../../utils/const';
import { useRecoilValue, useRecoilState } from 'recoil';
import {
  labelEditIdState,
  labelEditInputState,
} from '../../../../store/Recoil';
import { getPut } from '../../../../utils/restAPI';
const LabelEditCompleteButton = (): JSX.Element => {
  const [labelEditId, setLabelEditId] = useRecoilState(labelEditIdState);
  const labelEditInput = useRecoilValue(labelEditInputState);
  const userToken = localStorage.getItem('token');
  const issueEditUrl = U.LABELS + '/' + labelEditId;

  const handleClickCompleteButton = () => {
    getPut(issueEditUrl, userToken, labelEditInput);
    setLabelEditId(0);
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

export default LabelEditCompleteButton;

const ButtonBox = styled.div`
  display: flex;
  margin-left: 8px;
`;
