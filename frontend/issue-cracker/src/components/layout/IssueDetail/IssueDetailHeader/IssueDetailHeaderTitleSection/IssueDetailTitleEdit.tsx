import React from 'react';
import styled from 'styled-components';
import { issueEditInputState } from '../../../../../store/Recoil';
import { useRecoilState } from 'recoil';

const IssueDetailTitleEdit = (): JSX.Element => {
  const [issueEditInput, setIssueEditInput] =
    useRecoilState(issueEditInputState);

  const handleChangeEditInput = (e: React.ChangeEvent<HTMLInputElement>) => {
    setIssueEditInput({
      ...issueEditInput,
      title: e.target.value,
    });
  };

  return (
    <IssueDetailTitleEditStyle id={'editButton'}>
      <IssueDetailTitleEditInput
        placeholder={'제목'}
        value={issueEditInput.title}
        onChange={handleChangeEditInput}
      />
    </IssueDetailTitleEditStyle>
  );
};

export default IssueDetailTitleEdit;

const IssueDetailTitleEditStyle = styled.div`
  display: flex;
  width: 100%;
`;

const IssueDetailTitleEditInput = styled.input`
  border-radius: 11px;
  outline: none;
  font-size: 24px;
  font-family: 'Montserrat', sans-serif;
  color: #4e4b66;
  height: 40px;
  margin: 5px 0;
  border: 1px solid #eff0f6;
  padding: 0 15px;
  width: 100%;

  ::placeholder {
    color: #f7f7fc;
  }

  :focus-within {
    border: 1px solid #f7f7fc;

    background: #eff0f6;
  }
`;
