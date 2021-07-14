import React from 'react';
import styled from 'styled-components';
import { useRecoilValue, useRecoilState } from 'recoil';

import Button from '@material-ui/core/Button';
import EditIcon from '@material-ui/icons/Edit';
import InsertEmoticonIcon from '@material-ui/icons/InsertEmoticon';
import EmojiEmotionsIcon from '@material-ui/icons/EmojiEmotions';
import LabelSmallGroup from '../../../../../common/group/LabelSmallGroup';
import TextGroup from '../../../../../common/group/TextGroup';
import {
  issueDetailState,
  issueEditContentState,
  issueEditInputState,
} from '../../../../../../store/Recoil';
import { IssueDataProps } from '../../../../../../utils/types/commonTypes';
import { getElapsedTime } from '../../../../../../utils/util';
import { getPut } from '../../../../../../utils/restAPI';
import {
  ProfileImg as P,
  Issue as S,
} from '../../../../../styles/CommonStyles';
import { TYPE as T, URL as U } from '../../../../../../utils/const';

const IssueDetailDisplayHeader = (): JSX.Element => {
  const issueDetails = useRecoilValue<IssueDataProps>(issueDetailState);
  const [issueEditInput, setIssueEditInput] =
    useRecoilState(issueEditInputState);

  const [issueEditContent, setIssueEditContent] = useRecoilState(
    issueEditContentState
  );

  const handleClickEditButton = () => {
    setIssueEditContent((prev) => !prev);
  };
  const handleClickCompleteButton = () => {
    const issueEditUrl = U.ISSUES + '/' + issueDetails.issueId;
    const userToken = localStorage.getItem('token');
    getPut(issueEditUrl, userToken, issueEditInput);

    setIssueEditContent((prev) => !prev);
  };

  return (
    <IssueDetailDisplayHeaderStyle>
      <S.IssueTableHeader>
        <LeftBox>
          <WriterBox>
            <TextGroup
              type={T.SMALL}
              content={issueDetails?.writer?.name}
              color="#14142B"
            />
          </WriterBox>
          <DateBox>
            <TextGroup
              type={T.SMALL}
              content={getElapsedTime(issueDetails?.createdDateTime)}
              color="#6E7191"
            />
          </DateBox>
        </LeftBox>
        <RightBox>
          <LabelBox>
            <LabelSmallGroup
              color="#6E7191"
              backgroundColor="transparent"
              label="작성자"
            />
          </LabelBox>
          <EditButtonBox>
            {issueEditContent ? (
              <TitleEditButton
                startIcon={<TitleEditIcon style={{ fontSize: '14px' }} />}
                color="primary"
                onClick={handleClickCompleteButton}
              >
                <TextGroup type={T.XSMALL} content={'완료'} color="#007AFF" />
              </TitleEditButton>
            ) : (
              <TitleEditButton
                startIcon={<TitleEditIcon style={{ fontSize: '14px' }} />}
                color="primary"
                onClick={handleClickEditButton}
              >
                <TextGroup type={T.XSMALL} content={'편집'} color="#6e7191" />
              </TitleEditButton>
            )}
          </EditButtonBox>
          <EmoticonBox>
            <InsertEmoticonIcon />
            <EmojiEmotionsIcon />
          </EmoticonBox>
        </RightBox>
      </S.IssueTableHeader>
    </IssueDetailDisplayHeaderStyle>
  );
};
export default IssueDetailDisplayHeader;

const IssueDetailDisplayHeaderStyle = styled.div``;

const LeftBox = styled.div`
  display: flex;
  margin-left: 20px;
`;

const RightBox = styled.div`
  display: flex;
  align-items: center;
`;

const WriterBox = styled.div`
  padding: 0px 5px;
`;

const DateBox = styled.div`
  padding: 0px 5px;
`;

const TitleEditButton = styled(Button)`
  width: 60px;
  height: 40px;
  margin: 5px;
`;

const TitleEditIcon = styled(EditIcon)`
  /* color: #007aff; */
`;

const EditButtonBox = styled.div``;

const LabelBox = styled.div``;

const EmoticonBox = styled.div``;
