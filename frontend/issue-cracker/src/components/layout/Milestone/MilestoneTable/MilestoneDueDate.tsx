import React from 'react';
import CommonButton from '../../../common/CommonButton';
import TextGroup from '../../../common/group/TextGroup';
import { TYPE as T } from '../../../../utils/const';
import CalendarTodayTwoToneIcon from '@material-ui/icons/CalendarTodayTwoTone';
import { getDate } from '../../../../utils/util';

const MilestoneDueDate = ({ dueDate }: { dueDate: string }): JSX.Element => {
  return (
    <>
      {dueDate && (
        <CommonButton
          icon={
            <CalendarTodayTwoToneIcon
              style={{ fontSize: 'small', color: '#6E7191' }}
            />
          }
          text={
            <TextGroup
              type={T.SMALL}
              content={getDate(dueDate)}
              color="#6E7191"
            />
          }
        />
      )}
    </>
  );
};

export default MilestoneDueDate;
