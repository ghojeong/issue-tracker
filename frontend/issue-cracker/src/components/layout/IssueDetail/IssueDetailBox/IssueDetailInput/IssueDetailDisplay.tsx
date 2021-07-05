import React from 'react';
import styled from 'styled-components';
import { ProfileImg as P, Issue as S } from '../../../../styles/CommonStyles';
import TextGroup from '../../../../common/group/TextGroup';
import LabelSmallGroup from '../../../../common/group/LabelSmallGroup';
import Button from '@material-ui/core/Button';
import EditIcon from '@material-ui/icons/Edit';
import InsertEmoticonIcon from '@material-ui/icons/InsertEmoticon';
import EmojiEmotionsIcon from '@material-ui/icons/EmojiEmotions';
import IssueDetailComment from './IssueDetailComment';
import { TYPE as T } from '../../../../../utils/const';
import { useRecoilValue } from 'recoil';
import { decodedToken, issueDetailState } from '../../../../../store/Recoil';
import { IssueDataProps } from '../../../../../utils/types/IssueDataType';
import { getElapsedTime } from '../../../../../utils/util';

const IssueDetailDisplay = (): JSX.Element => {
  const issueDetail = useRecoilValue<IssueDataProps>(issueDetailState);
  const { createdDateTime, writer, content } = issueDetail;

  return (
    <IssueDisplayStyle>
      <DisplayWrapper>
        <ProfileImgStyle>
          <P.ProfileImgLarge src={writer.avatarUrl} />
        </ProfileImgStyle>
        <DisplayBox>
          <S.IssueTableHeader>
            <LeftBox>
              <WriterBox>
                <TextGroup
                  type={T.SMALL}
                  content={writer.name}
                  color="#14142B"
                />
              </WriterBox>
              <DateBox>
                <TextGroup
                  type={T.SMALL}
                  content={getElapsedTime(createdDateTime)}
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
                <TitleEditButton
                  startIcon={<TitleEditIcon style={{ fontSize: '14px' }} />}
                  color="primary"
                >
                  <TextGroup type={T.XSMALL} content={'편집'} color="#6e7191" />
                </TitleEditButton>
              </EditButtonBox>
              <EmoticonBox>
                <InsertEmoticonIcon />
                <EmojiEmotionsIcon />
              </EmoticonBox>
            </RightBox>
          </S.IssueTableHeader>
          <S.IssueCell>
            <ContentBox>
              <TextGroup type={T.SMALL} content={content} color="#6e7191" />
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
  color: #6e7191;
`;

const EditButtonBox = styled.div``;

const LabelBox = styled.div``;

const EmoticonBox = styled.div``;

const ContentBox = styled.div`
  padding: 15px 25px;
`;
