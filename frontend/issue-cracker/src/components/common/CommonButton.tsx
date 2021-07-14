import React from 'react';
import styled from 'styled-components';
import { CommonButtonProps } from '../../utils/types/commonTypes';

const CommonButton = ({
  icon,
  text,
  count,
  onClick,
  id,
}: CommonButtonProps): JSX.Element => {
  return (
    <CommonButtonStyle {...{ onClick }} id={`${id}`}>
      <IconBox>{icon}</IconBox>
      <div>
        <TextBox>{text}</TextBox>
        <CountBox>{count}</CountBox>
      </div>
    </CommonButtonStyle>
  );
};

export default CommonButton;

const CommonButtonStyle = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0px 10px;
  cursor: pointer;

  div {
    display: flex;
    align-items: center;
  }
`;

const IconBox = styled.div`
  padding-right: 5px;
`;

const TextBox = styled.div``;

const CountBox = styled.div``;
