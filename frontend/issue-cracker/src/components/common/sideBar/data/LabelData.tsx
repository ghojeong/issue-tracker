import React from 'react';
import styled from 'styled-components';
import { Issue as S } from '../../../styles/CommonStyles';
import { v4 as uuidv4 } from 'uuid';
import SideBarDropLabel from '../SideBarDropLabel';
import { LabelStateProps } from '../../../../utils/types/commonTypes';

const LabelData = ({ labelData }: LabelStateProps): JSX.Element => {
  return (
    <>
      {labelData?.map((label) => (
        <DropDownContent key={uuidv4()}>
          <SideBarDropLabel data={label} />
        </DropDownContent>
      ))}
    </>
  );
};

export default LabelData;

const DropDownContent = styled(S.IssueCell)`
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 240px;
  height: 44px;
  padding: 8px 16px;
`;
