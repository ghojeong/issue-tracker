import React from 'react';
import InputGroup from '../../../../common/group/InputGroup';
import styled from 'styled-components';
import { ProfileImg as P } from '../../../../styles/CommonStyles';
import { TYPE as T } from '../../../../../utils/const';
import { useRecoilValue, useRecoilState } from 'recoil';
import { decodedToken, issueAddInputState } from '../../../../../store/Recoil';
const IssueAddInputTitle = (): JSX.Element => {
  const decoded = decodedToken && useRecoilValue(decodedToken);
  const profileURL = decoded && decoded.avatarUrl;

  const [issueAddInput, setIssueAddInput] = useRecoilState(issueAddInputState);

  const handleChangeInputTitle = (
    e: React.ChangeEvent<HTMLInputElement>
  ): void =>
    setIssueAddInput({
      ...issueAddInput,
      title: e.target.value,
    });

  return (
    <IssueAddInputTitleStyle>
      <ProfileImgStyle>
        {profileURL && <P.ProfileImgLarge src={profileURL} />}
      </ProfileImgStyle>
      <InputGroupStyle>
        <InputGroup
          type={T.MEDIUM}
          name="제목"
          variant="outlined"
          value={issueAddInput.title}
          onChange={handleChangeInputTitle}
        />
      </InputGroupStyle>
    </IssueAddInputTitleStyle>
  );
};

export default IssueAddInputTitle;

const IssueAddInputTitleStyle = styled.div`
  display: flex;
  align-items: center;
`;

const ProfileImgStyle = styled.div`
  padding: 10px;
`;

const InputGroupStyle = styled.div`
  width: 100%;

  div {
    width: 100%;
    background: ${({ theme }) => `${theme.colors.gray5}`};
    border-radius: 16px;

    div {
      :focus-within {
        background: #ffffff;
      }
    }
  }

  fieldset {
    border: 1px solid ${({ theme }) => `${theme.colors.gray5}`};
  }
`;
