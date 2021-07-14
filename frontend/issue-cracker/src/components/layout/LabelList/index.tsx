import React from 'react';
import { useRecoilValue } from 'recoil';
import styled from 'styled-components';
import { labelAddState } from '../../../store/Recoil';
import LabelAdd from './LabelAdd';
import LabelNav from './LabelNav';
import LabelTable from './LabelTable';

const LabelList = (): JSX.Element => {
  const labelAdd = useRecoilValue(labelAddState);

  return (
    <LabeListStyle>
      <LabelNav />
      {labelAdd && <LabelAdd />}
      <React.Suspense fallback={null}>
        <LabelTable />
      </React.Suspense>
    </LabeListStyle>
  );
};

export default LabelList;

const LabeListStyle = styled.div``;
