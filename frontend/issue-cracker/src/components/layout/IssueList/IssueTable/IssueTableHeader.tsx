import React from 'react';
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
import IssueHeaderButton from '../../../common/IssueHeaderButton';
import FilterMenu from '../../../common/FilterMenu';
import { v4 as uuidv4 } from 'uuid';
import { IssueDataProps } from '../../../../utils/types/IssueDataType';

const IssueTableHeader = ({
  issues,
}: {
  issues: IssueDataProps[];
}): JSX.Element => {
  const getIssueCount = (list: IssueDataProps[], str: string): number =>
    list.filter((el) => el.status === str).length;

  const openIssue = getIssueCount(issues, 'OPEN');
  const closedIssue = getIssueCount(issues, 'CLOSED');

  return (
    <S.IssueTableHeader>
      <S.IssueTableHeaderLeft>
        <CheckBoxes />
        <IssueHeaderButton
          icon={<OpenIconGroup type={'default'} />}
          text={
            <TextGroup type={T.SMALL} content={TT.OPEN_ISSUE} color="#222" />
          }
          count={<CountGroup count={openIssue} color="#222" />}
        />
        <IssueHeaderButton
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
