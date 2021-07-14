import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import { ProfileImg as S, Text as T } from '../../styles/CommonStyles';
import { useRecoilState } from 'recoil';
import { dropCheckState } from '../../../store/Recoil';
import CheckOffIcon from '../../styles/svg/CheckOffIcon';
import CheckOnIcon from '../../styles/svg/CheckOnIcon';
import { AssigneeProps } from '../../../utils/types/commonTypes';

const SideBarDropAssignee = ({
  data,
}: {
  data: AssigneeProps;
}): JSX.Element => {
  const [isCheck, setIsCheck] = useState(false);
  const [dropCheck, setDropCheck] = useRecoilState(dropCheckState);

  const handleClickAssignee = () => {
    setIsCheck(!isCheck);

    if (!isCheck) {
      setDropCheck({
        ...dropCheck,
        assignee: [...dropCheck.assignee, data],
      });
    } else {
      setDropCheck({
        ...dropCheck,
        assignee: dropCheck.assignee.filter(
          (el: AssigneeProps) => el.id !== data.id
        ),
      });
    }
  };

  useEffect(() => {
    const idList = dropCheck.assignee?.map((el: AssigneeProps) => el.id);
    if (idList.includes(data.id)) {
      setIsCheck(true);
    }
  }, []);

  return (
    <SideBarDropAssigneeStyle
      onClick={() => {
        handleClickAssignee();
      }}
    >
      <DropLeft>
        <S.ProfileImgSmall src={data.avatarUrl}></S.ProfileImgSmall>
        <ProfileName>{data.name}</ProfileName>
      </DropLeft>
      <DropRight>{isCheck ? <CheckOnIcon /> : <CheckOffIcon />}</DropRight>
    </SideBarDropAssigneeStyle>
  );
};
export default SideBarDropAssignee;

const SideBarDropAssigneeStyle = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100%;
  cursor: pointer;
`;
const ProfileName = styled(T.TextSmall)`
  margin-left: 8px;
`;
const DropLeft = styled.div`
  display: flex;
  align-items: center;
`;
const DropRight = styled.div``;
