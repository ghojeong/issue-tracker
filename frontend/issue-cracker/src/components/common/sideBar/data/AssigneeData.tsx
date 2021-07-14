import React from 'react';
import styled from 'styled-components';
import { Issue as S } from '../../../styles/CommonStyles';
import { v4 as uuidv4 } from 'uuid';
import SideBarDropAssignee from '../SideBarDropAssignee';
import { AssigneeStateProps } from '../../../../utils/types/commonTypes';

const AssigneeData = ({ userData }: AssigneeStateProps): JSX.Element => {
  return (
    <>
      {userData?.map((user) => (
        <DropDownContent key={uuidv4()}>
          <SideBarDropAssignee data={user} />
        </DropDownContent>
      ))}
    </>
  );
};
const DropDownContent = styled(S.IssueCell)`
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 240px;
  height: 44px;
  padding: 8px 16px;
`;
export default AssigneeData;
