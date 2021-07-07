import React from 'react';
import styled from 'styled-components';

interface IssueHeaderButtonProps {
  icon: JSX.Element;
  text: JSX.Element;
  count?: JSX.Element;
  onClick?: React.MouseEventHandler<HTMLDivElement>;
  // id?: number;
}

const IssueHeaderButton = ({
  icon,
  text,
  count,
  onClick,
}: // id,
IssueHeaderButtonProps): JSX.Element => {
  // console.log('id', id);

  return (
    <IssueHeaderButtonStyle {...{ onClick }}>
      <IconBox>{icon}</IconBox>
      <div>
        <TextBox>{text}</TextBox>
        <CountBox>{count}</CountBox>
      </div>
    </IssueHeaderButtonStyle>
  );
};

export default IssueHeaderButton;

const IssueHeaderButtonStyle = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0px 10px;

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
