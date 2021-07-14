import React, { useEffect } from 'react';
import styled from 'styled-components';
import IssueAddTitle from '../IssueAdd/IssueAddTitle';
import IssueAddBox from '../IssueAdd/IssueAddBox';
import { Line as S } from '../../styles/CommonStyles';
import IssueAddButton from './IssueAddButton';
import { useSetRecoilState } from 'recoil';
import { dropCheckState } from '../../../store/Recoil';

const IssueAdd = (): JSX.Element => {
  const setCheckData = useSetRecoilState(dropCheckState);

  useEffect(() => {
    setCheckData({
      assignee: [],
      label: [],
      milestone: [],
    });
  }, []);

  return (
    <IssueAddStyle>
      <IssueAddTitle />
      <S.TableLine />
      <IssueAddBox />
      <S.TableLine />
      <React.Suspense fallback={null}>
        <IssueAddButton />
      </React.Suspense>
    </IssueAddStyle>
  );
};

export default IssueAdd;

const IssueAddStyle = styled.div``;
