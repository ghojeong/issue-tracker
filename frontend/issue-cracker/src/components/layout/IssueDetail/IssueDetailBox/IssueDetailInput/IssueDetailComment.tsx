import React from 'react';
import styled from 'styled-components';
import { v4 as uuidv4 } from 'uuid';
import { useRecoilValue } from 'recoil';
import InsertEmoticonIcon from '@material-ui/icons/InsertEmoticon';
import EmojiEmotionsIcon from '@material-ui/icons/EmojiEmotions';
import TextGroup from '../../../../common/group/TextGroup';
import { getElapsedTime } from '../../../../../utils/util';
import { issueDetailState } from '../../../../../store/Recoil';
import { IssueDataProps } from '../../../../../utils/types/commonTypes';
import { ProfileImg as P, Issue as S } from '../../../../styles/CommonStyles';
import { TYPE as T } from '../../../../../utils/const';

const IssueDetailComment = (): JSX.Element => {
  const issueDetail = useRecoilValue<IssueDataProps>(issueDetailState);
  // const { comments } = issueDetail;
  console.log(issueDetail);
  return (
    <>
      {issueDetail?.comments?.map((comment) => {
        return (
          <DisplayWrapper key={uuidv4()}>
            <ProfileImgStyle>
              <P.ProfileImgLarge src={comment.writer?.avatarUrl} />
            </ProfileImgStyle>

            <DisplayBox>
              <S.IssueTableHeader>
                <LeftBox>
                  <WriterBox>
                    <TextGroup
                      type={T.SMALL}
                      content={comment.writer.id}
                      color="#14142B"
                    />
                  </WriterBox>
                  <DateBox>
                    <TextGroup
                      type={T.SMALL}
                      content={getElapsedTime(comment.dateTime)}
                      color="#6E7191"
                    />
                  </DateBox>
                </LeftBox>
                <RightBox>
                  <EmoticonBox>
                    <InsertEmoticonIcon />
                    <EmojiEmotionsIcon />
                  </EmoticonBox>
                </RightBox>
              </S.IssueTableHeader>
              <S.IssueCell>
                <ContentBox>
                  <TextGroup
                    type={T.SMALL}
                    content={comment.content}
                    color="#6e7191"
                  />
                </ContentBox>
              </S.IssueCell>
            </DisplayBox>
          </DisplayWrapper>
        );
      })}
    </>
  );
};

export default IssueDetailComment;

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

const EmoticonBox = styled.div``;

const ContentBox = styled.div`
  padding: 15px 25px;
`;
