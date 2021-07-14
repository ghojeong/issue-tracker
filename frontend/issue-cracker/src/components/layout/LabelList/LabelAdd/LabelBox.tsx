import React from 'react';
import styled from 'styled-components';
import { useRecoilValue } from 'recoil';
import LabelSmallGroup from '../../../common/group/LabelSmallGroup';
import { labelAddInputState } from '../../../../store/Recoil';
import { LABEL as L } from '../../../../utils/const';
//labelAdd
const LabelBox = (): JSX.Element => {
  const labelAdd = useRecoilValue(labelAddInputState);
  return (
    <LabelBoxStyle>
      <LabelSmallGroup
        label={labelAdd.title === '' ? L.NAME : labelAdd.title}
        backgroundColor={labelAdd.backgroundColor}
        color={labelAdd.textColor}
      />
    </LabelBoxStyle>
  );
};
export default LabelBox;

const LabelBoxStyle = styled.div``;
