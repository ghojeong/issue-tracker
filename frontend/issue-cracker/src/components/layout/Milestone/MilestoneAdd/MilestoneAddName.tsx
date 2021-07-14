import React from 'react';
import { useRecoilState } from 'recoil';
import styled from 'styled-components';
import { TYPE as T, MILESTONE as M } from '../../../../utils/const';
import { milestoneAddInputState } from '../../../../store/Recoil';
import InputGroup from '../../../common/group/InputGroup';

const MilestoneAddName = (): JSX.Element => {
  const [milestoneAddInput, setMilestoneAddInput] = useRecoilState(
    milestoneAddInputState
  );

  const handleChangeInputTitle = (
    e: React.ChangeEvent<HTMLInputElement>
  ): void =>
    setMilestoneAddInput({
      ...milestoneAddInput,
      title: e.target.value,
    });

  return (
    <InputBox>
      <InputGroup
        variant="outlined"
        name={M.NAME}
        type={T.LARGE}
        onChange={handleChangeInputTitle}
      />
    </InputBox>
  );
};

export default MilestoneAddName;

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
