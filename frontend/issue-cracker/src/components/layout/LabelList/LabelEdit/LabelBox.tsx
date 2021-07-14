import React from 'react';
import styled from 'styled-components';
import { useRecoilValue } from 'recoil';
import LabelSmallGroup from '../../../common/group/LabelSmallGroup';
import { labelEditInputState } from '../../../../store/Recoil';
import { LABEL as L } from '../../../../utils/const';

const LabelBox = (): JSX.Element => {
  const labelEdit = useRecoilValue(labelEditInputState);

  return (
    <LabelBoxStyle>
      <LabelSmallGroup
        label={labelEdit.title === '' ? L.NAME : labelEdit.title}
        backgroundColor={labelEdit.backgroundColor}
        color={labelEdit.textColor}
      />
    </LabelBoxStyle>
  );
};
export default LabelBox;

const LabelBoxStyle = styled.div``;
