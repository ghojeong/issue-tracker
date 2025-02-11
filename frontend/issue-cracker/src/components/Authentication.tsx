import React, { useEffect } from 'react';
import qs from 'qs';
import Loader from './layout/Loader';
import { URL as U, PATH as P } from '../utils/const';
import { useHistory, useLocation } from 'react-router';
import { useSetRecoilState } from 'recoil';
import { token } from '../store/Recoil';

const Authentication = (): JSX.Element => {
  const authUri = U.AUTH;
  const history = useHistory();
  const location = useLocation();
  const setUserToken = useSetRecoilState(token);

  console.log(authUri);

  useEffect(() => {
    const getToken = async () => {
      const { code } = qs.parse(location.search, {
        ignoreQueryPrefix: true,
      });

      try {
        const response = await fetch(`${authUri}`, {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify({
            code: code,
          }),
        });
        const data = await response.json();

        if (data.token) {
          localStorage.setItem('token', data.token);
          setUserToken(data.token);
          history.push(P.ISSUE_LIST);
        } else {
          history.push(P.LOGIN);
          console.log('로그인 실패: 토큰 겟 실패');
        }
      } catch (error) {}
    };

    getToken();
  }, [location, history, authUri]);

  return <Loader />;
};

export default Authentication;
