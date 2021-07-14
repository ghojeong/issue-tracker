import React from 'react';
import { TYPE as T } from '../../../../../utils/const';
import { getElapsedTime } from '../../../../../utils/util';
import { IssueDataProps } from '../../../../../utils/types/commonTypes';
import TextGroup from '../../../../common/group/TextGroup';

const IssueDetailDescription = ({
  state,
  issueDetails,
}: {
  state: boolean;
  issueDetails: IssueDataProps;
}): JSX.Element => {
  const elapsedTime = getElapsedTime(issueDetails?.createdDateTime);

  return (
    <>
      {state ? (
        <TextGroup
          type={T.SMALL}
          content={`이 이슈가 ${elapsedTime}에 ${issueDetails?.writer?.name}님에 의해 열렸습니다 ∙ 코멘트 ${issueDetails?.comments?.length}개`}
          color="#6E7191"
        />
      ) : (
        <TextGroup
          type={T.SMALL}
          content={`이 이슈가 ${elapsedTime}에 ${issueDetails?.writer?.name}님에 의해 닫혔습니다 ∙ 코멘트 ${issueDetails?.comments?.length}개`}
          color="#6E7191"
        />
      )}
    </>
  );
};

export default IssueDetailDescription;
