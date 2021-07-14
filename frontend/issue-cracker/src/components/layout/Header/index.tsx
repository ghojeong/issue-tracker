import React, { FC, useEffect } from 'react';
import styled from 'styled-components';
import { ProfileImg as S } from '../../styles/CommonStyles';
import Logo from '../../common/Logo';
import { LOGO_TITLE, BUTTON_SIZE as BS } from '../../../utils/const';
import jwtDecode from 'jwt-decode';
import { useSetRecoilState } from 'recoil';
import { decodedToken } from '../../../store/Recoil';

interface TokenProps {
  name: string;
  avatarUrl: string;
}
const Header: FC = () => {
  const token = localStorage.getItem('token');
  const decoded = token && jwtDecode<TokenProps>(token);
  const setDecodedToken = useSetRecoilState(decodedToken);
  useEffect(() => {
    decoded &&
      setDecodedToken({
        name: decoded.name,
        avatarUrl: decoded.avatarUrl,
      });
  }, []);
  const profileURL = decoded && decoded.avatarUrl;
  const profileName = decoded && decoded.name;

  return (
    <HeaderDiv>
      <a href="/">
        <Logo type={BS.MEDIUM} name={LOGO_TITLE} />
      </a>
      <UserDiv>
        <AccountName>{profileName}</AccountName>
        {profileURL && <S.ProfileImgLarge src={profileURL} />}
      </UserDiv>
    </HeaderDiv>
  );
};

export default Header;

const HeaderDiv = styled.div`
  display: flex;
  justify-content: space-between;
  margin: 27px 0 57px 0;

  a {
    text-decoration: none;
    color: inherit;
  }
`;
const UserDiv = styled.div`
  display: flex;
  align-items: center;
`;
const AccountName = styled.div`
  margin-right: 10px;
  color: ${({ theme }) => theme.colors.gray2};
  font-family: 'Montserrat', sans-serif;
`;
