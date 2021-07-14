import React from 'react';
import { v4 as uuidv4 } from 'uuid';
import { useRecoilValue, useSetRecoilState } from 'recoil';
import { labelAddState } from '../../../../store/Recoil';
import useFetch from '../../../../utils/useFetch';
import LabelTableHeader from './LabelTableHeader';
import LabelCell from './LabelCell';
import LabelEdit from '../LabelEdit';
import {
  labelEditIdState,
  labelEditInputState,
} from '../../../../store/Recoil';
import { LabelProps } from '../../../../utils/types/commonTypes';
import { URL as U } from '../../../../utils/const';

const LabelTable = (): JSX.Element => {
  const labelAdd = useRecoilValue(labelAddState);

  const labelEditId = useRecoilValue(labelEditIdState);
  const setLabelEditInput = useSetRecoilState(labelEditInputState);

  const labelList = useFetch(U.LABELS, [labelAdd]);
  const labels = labelList?.labels;

  return (
    <>
      <LabelTableHeader />
      {labels?.map((label: LabelProps) => {
        labelEditId === label.id && setLabelEditInput(label);
        return (
          <React.Fragment key={uuidv4()}>
            <LabelCell {...{ label }} />
            {labelEditId === label.id && <LabelEdit />}
          </React.Fragment>
        );
      })}
    </>
  );
};

export default LabelTable;
