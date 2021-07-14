import React from 'react';
import styled from 'styled-components';
import { useRecoilState } from 'recoil';
import InputGroup from '../../../common/group/InputGroup';
import { labelEditInputState } from '../../../../store/Recoil';
import { TYPE as T, LABEL as L } from '../../../../utils/const';

const InputContentBox = (): JSX.Element => {
  const [labelEdit, setLabelEdit] = useRecoilState(labelEditInputState);
  const { title, description } = labelEdit;

  const handleInputLabelTitle = (e: React.ChangeEvent<HTMLInputElement>) => {
    setLabelEdit({
      ...labelEdit,
      title: e.target.value,
    });
  };

  const handleInputLabelDescription = (
    e: React.ChangeEvent<HTMLInputElement>
  ) => {
    setLabelEdit({
      ...labelEdit,
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
          value={title}
          onChange={handleInputLabelTitle}
        />
      </InputBox>
      <InputBox>
        <InputGroup
          variant="outlined"
          name={L.DESC}
          type={T.LARGE}
          value={description}
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
