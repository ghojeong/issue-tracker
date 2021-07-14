import React from 'react';
import { v4 as uuidv4 } from 'uuid';
import { Issue as S } from '../../../styles/CommonStyles';
import CheckBoxes from '../../../common/CheckBoxes';
import OpenIconGroup from '../../../common/group/OpenIconGroup';
import ClosedIconGroup from '../../../common/group/ClosedIconGroup';
import {
  TEXT as TT,
  TYPE as T,
  FILTER as F,
  FILTER_DROPDOWN,
} from '../../../../utils/const';
import TextGroup from '../../../common/group/TextGroup';
import CountGroup from '../../../common/group/CountGroup';
import CommonButton from '../../../common/CommonButton';
import FilterMenu from '../../../common/FilterMenu';
import { IssueDataProps } from '../../../../utils/types/commonTypes';
import { getIssueCount } from '../../../../utils/util';

const IssueTableHeader = ({
  issues,
}: {
  issues: IssueDataProps[];
}): JSX.Element => {
  const openIssue = getIssueCount(issues, 'OPEN');
  const closedIssue = getIssueCount(issues, 'CLOSE');

  return (
    <S.IssueTableHeader>
      <S.IssueTableHeaderLeft>
        <CheckBoxes />
        <CommonButton
          icon={<OpenIconGroup type={'default'} />}
          text={
            <TextGroup type={T.SMALL} content={TT.OPEN_ISSUE} color="#222" />
          }
          count={<CountGroup count={openIssue} color="#222" />}
        />
        <CommonButton
          icon={<ClosedIconGroup type={'disabled'} />}
          text={
            <TextGroup
              type={T.SMALL}
              content={TT.CLOSED_ISSUE}
              color="#6E7191"
            />
          }
          count={<CountGroup count={closedIssue} color="#6E7191" />}
        />
      </S.IssueTableHeaderLeft>
      <S.IssueTableHeaderRight>
        {F.ISSUE_TABLE_HEADER_LIST.map((menu) => (
          <FilterMenu {...{ menu }} list={FILTER_DROPDOWN} key={uuidv4()} />
        ))}
      </S.IssueTableHeaderRight>
    </S.IssueTableHeader>
  );
};

export default IssueTableHeader;
