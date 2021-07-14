import React from 'react';
import styled from 'styled-components';
import {
  ProfileImg as P,
  Issue as S,
} from '../../../../../styles/CommonStyles';
import TextGroup from '../../../../../common/group/TextGroup';
import IssueDetailComment from '../IssueDetailComment';

import { useRecoilValue, useRecoilState } from 'recoil';
import {
  issueDetailState,
  issueEditContentState,
  issueEditInputState,
} from '../../../../../../store/Recoil';
import { IssueDataProps } from '../../../../../../utils/types/commonTypes';
import IssueDetailDisplayHeader from './IssueDetailDisplayHeader';
import { TYPE as T } from '../../../../../../utils/const';

const IssueDetailDisplay = (): JSX.Element => {
  // const { createdDateTime, writer, content } = issueDetail;
  const issueDetail = useRecoilValue<IssueDataProps>(issueDetailState);
  const [issueEditInput, setIssueEditInput] =
    useRecoilState(issueEditInputState);
  const issueEditContent = useRecoilValue(issueEditContentState);

  const handleChangeEditInput = (e: React.ChangeEvent<HTMLInputElement>) => {
    setIssueEditInput({
      ...issueEditInput,
      comment: e.target.value,
    });
  };

  return (
    <IssueDisplayStyle>
      <DisplayWrapper>
        <ProfileImgStyle>
          <P.ProfileImgLarge src={issueDetail?.writer?.avatarUrl} />
        </ProfileImgStyle>
        <DisplayBox>
          <IssueDetailDisplayHeader />
          <S.IssueCell>
            <ContentBox>
              {issueEditContent ? (
                <IssueEditInputBox
                  value={issueEditInput.comment}
                  onChange={handleChangeEditInput}
                />
              ) : (
                <TextGroup
                  type={T.SMALL}
                  content={issueEditInput?.comment}
                  color="#6e7191"
                />
              )}
            </ContentBox>
          </S.IssueCell>
        </DisplayBox>
      </DisplayWrapper>
      <IssueDetailComment />
    </IssueDisplayStyle>
  );
};

export default IssueDetailDisplay;

const IssueDisplayStyle = styled.div`
  display: flex;
  flex-direction: column;
`;

const ProfileImgStyle = styled.div`
  margin-top: 5px;
  padding: 10px;
`;

const DisplayWrapper = styled.div`
  display: flex;
  margin-bottom: 20px;
`;

const DisplayBox = styled.div`
  width: 100%;
  display: flex;
  flex-direction: column;
`;

const ContentBox = styled.div`
  padding: 15px 25px;
  width: 100%;
`;

const IssueEditInputBox = styled.input`
  width: 100%;
  height: 40px;
  margin: 5px 0;
  border: 1px solid #eff0f6;
  padding: 0 15px;
  border-radius: 11px;
  color: #4e4b66;
  outline: none;

  ::placeholder {
    color: #f7f7fc;
  }

  :focus-within {
    border: 1px solid #f7f7fc;
    background: #eff0f6;
  }
`;
