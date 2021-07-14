import React from 'react';
import styled from 'styled-components';
import { useSetRecoilState } from 'recoil';
import CloseIcon from '@material-ui/icons/Close';
import ButtonGroup from '../../../common/group/ButtonGroup';
import { labelEditIdState } from '../../../../store/Recoil';
import { BUTTON_NAME as BN, BUTTON_SIZE as BS } from '../../../../utils/const';

const LabelEditCancelButton = (): JSX.Element => {
  const setLabelEditId = useSetRecoilState(labelEditIdState);

  const handleClickButton = () => {
    setLabelEditId(0);
  };
  return (
    <ButtonBox onClick={handleClickButton}>
      <ButtonGroup
        type={BS.SMALL_FILL}
        name={BN.CANCEL}
        icon={<CloseIcon style={{ fontSize: 16 }} />}
      />
    </ButtonBox>
  );
};
export default LabelEditCancelButton;

const ButtonBox = styled.div`
  display: flex;
`;
