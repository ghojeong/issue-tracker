import React from 'react';
import styled from 'styled-components';
import { ProfileImg as P } from '../../../styles/CommonStyles';
import { v4 as uuidv4 } from 'uuid';
import { AssigneeStateProps } from '../../../../utils/types/commonTypes';

const AssigneeContent = ({
  checkedAssignee,
}: AssigneeStateProps): JSX.Element => {
  return (
    <>
      {checkedAssignee?.map((assignee) => (
        <AssigneeContentStyle key={uuidv4()}>
          <P.ProfileImgLarge src={assignee.avatarUrl} />
          <AccountName>{assignee.name}</AccountName>
        </AssigneeContentStyle>
      ))}
    </>
  );
};

export default AssigneeContent;

const AssigneeContentStyle = styled.div`
  display: flex;
`;

const AccountName = styled.div`
  padding: 0px 10px;
  color: ${({ theme }) => theme.colors.gray2};
  font-family: 'Montserrat', sans-serif;
`;
