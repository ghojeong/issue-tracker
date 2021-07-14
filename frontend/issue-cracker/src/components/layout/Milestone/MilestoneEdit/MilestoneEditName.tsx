import React from 'react';
import { useRecoilState } from 'recoil';
import styled from 'styled-components';
import { TYPE as T, MILESTONE as M } from '../../../../utils/const';
import { milestoneEditInputState } from '../../../../store/Recoil';
import InputGroup from '../../../common/group/InputGroup';

const MilestoneEditName = (): JSX.Element => {
  const [milestoneEdit, setMilestoneEdit] = useRecoilState(
    milestoneEditInputState
  );
  const { title } = milestoneEdit;

  const handleChangeInputTitle = (
    e: React.ChangeEvent<HTMLInputElement>
  ): void =>
    setMilestoneEdit({
      ...milestoneEdit,
      title: e.target.value,
    });

  return (
    <InputBox>
      <InputGroup
        variant="outlined"
        name={M.NAME}
        type={T.LARGE}
        onChange={handleChangeInputTitle}
        value={title}
      />
    </InputBox>
  );
};

export default MilestoneEditName;

const InputBox = styled.div`
  padding: 10px 20px;
  width: 100%;

  div {
    width: 100%;
  }

  input {
    background: #eff0f6;
    border-radius: 16px;
  }

  fieldset {
    border-radius: 16px;
  }
`;
