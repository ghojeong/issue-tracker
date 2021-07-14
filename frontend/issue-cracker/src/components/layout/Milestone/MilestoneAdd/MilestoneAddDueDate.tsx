import React from 'react';
import styled from 'styled-components';
import { TYPE as T, MILESTONE as M } from '../../../../utils/const';
import InputGroup from '../../../common/group/InputGroup';

const MilestoneAddDueDate = (): JSX.Element => {
  return (
    <InputBox>
      <InputGroup variant="outlined" name={M.DUE} type={T.LARGE} />
    </InputBox>
  );
};

export default MilestoneAddDueDate;

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
