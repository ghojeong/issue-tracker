import React, { useEffect, useState } from 'react';
import styled from 'styled-components';
import { ProfileImg as S, Text as T } from '../../styles/CommonStyles';
import { useRecoilState, useRecoilValue, useSetRecoilState } from 'recoil';
import { decodedToken, dropCheckState } from '../../../store/Recoil';
import CheckOffIcon from '../../styles/svg/CheckOffIcon';
import CheckOnIcon from '../../styles/svg/CheckOnIcon';
import { AssigneeProps } from '../../../utils/types/sideBarType';

const SideBarDropAssignee = ({
  data,
}: {
  data: AssigneeProps;
}): JSX.Element => {
  const decoded = decodedToken && useRecoilValue(decodedToken);
  const profileURL = decoded && decoded.profileImageUrl;
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
  console.log('제발 확인', dropCheck);
  return (
    <SideBarDropAssigneeStyle
      onClick={() => {
        handleClickAssignee();
      }}
    >
      <DropLeft>
        <S.ProfileImgSmall src={profileURL}></S.ProfileImgSmall>
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
