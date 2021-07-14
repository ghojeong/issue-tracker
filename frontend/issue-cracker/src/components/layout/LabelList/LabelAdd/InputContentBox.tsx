import React from 'react';
import styled from 'styled-components';
import { useRecoilState } from 'recoil';
import InputGroup from '../../../common/group/InputGroup';
import { labelAddInputState } from '../../../../store/Recoil';
import { TYPE as T, LABEL as L } from '../../../../utils/const';

const InputContentBox = (): JSX.Element => {
  const [labelAdd, setLabelAdd] = useRecoilState(labelAddInputState);

  const handleInputLabelTitle = (e: React.ChangeEvent<HTMLInputElement>) => {
    setLabelAdd({
      ...labelAdd,
      title: e.target.value,
    });
  };

  const handleInputLabelDescription = (
    e: React.ChangeEvent<HTMLInputElement>
  ) => {
    setLabelAdd({
      ...labelAdd,
      description: e.target.value,
    });
  };

  return (
    <>
      <InputBox>
        <InputGroup
          variant="outlined"
          name={L.NAME}
          type={T.LARGE}
          onChange={handleInputLabelTitle}
        />
      </InputBox>
      <InputBox>
        <InputGroup
          variant="outlined"
          name={L.DESC}
          type={T.LARGE}
          onChange={handleInputLabelDescription}
        />
      </InputBox>
    </>
  );
};

export default InputContentBox;

const InputBox = styled.div`
  padding: 10px 20px;

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
