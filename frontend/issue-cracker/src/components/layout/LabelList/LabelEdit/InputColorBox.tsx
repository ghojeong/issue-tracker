import React, { useState } from 'react';
import styled from 'styled-components';
import { useRecoilState } from 'recoil';
import SyncIcon from '@material-ui/icons/Sync';
import IconButton from '@material-ui/core/IconButton';
import TextGroup from '../../../common/group/TextGroup';
import { labelEditInputState } from '../../../../store/Recoil';
import { TYPE as T, LABEL as L } from '../../../../utils/const';

const InputColorBox = (): JSX.Element => {
  const [labelTextColor, setLabelTextColor] = useState(false);
  const [labelEdit, setLabelEdit] = useRecoilState(labelEditInputState);

  const getRandomColor = (): string => {
    const randomColor = [
      '#815854',
      '#1E4174',
      '#DDA94B',
      '#6E7191',
      '#C89EC4',
      '#EE7785',
      '#71b8a4',
    ];
    return randomColor[Math.floor(Math.random() * randomColor.length)];
  };
  const handleInputLabelBackgroundColor = () => {
    const randomColor = getRandomColor();
    setLabelEdit({
      ...labelEdit,
      backgroundColor: randomColor,
    });
  };

  const handleInputLabelTextColor = () => {
    setLabelTextColor(!labelTextColor);
    const color = labelTextColor ? '#000' : '#ffffff';
    setLabelEdit({
      ...labelEdit,
      textColor: color,
    });
  };

  return (
    <InputColorBoxStyle>
      <BackgroundColorBox>
        <TextGroup
          type={T.XSMALL}
          content={L.BACKGROUND_COLOR}
          color="#6E7191"
        />
        <TextGroup
          type={T.SMALL}
          content={labelEdit.backgroundColor}
          color="#14142B"
        />
        <IconButton onClick={handleInputLabelBackgroundColor}>
          <SyncIcon
            style={{
              color: '#6E7191',
              fontSize: 20,
              transform: `rotate(-45deg)`,
              cursor: 'pointer',
            }}
          />
        </IconButton>
      </BackgroundColorBox>
      <TextColorBox>
        <TextGroup type={T.XSMALL} content={L.TEXT_COLOR} color="#6E7191" />
        <TextGroup
          type={T.SMALL}
          content={labelEdit.textColor === '#ffffff' ? '⚪️' : '⚫️'}
          color="#14142B"
        />
        <IconButton onClick={handleInputLabelTextColor}>
          <SyncIcon
            style={{
              color: '#6E7191',
              fontSize: 20,
              transform: `rotate(-45deg)`,
              cursor: 'pointer',
            }}
          />
        </IconButton>
      </TextColorBox>
    </InputColorBoxStyle>
  );
};

export default InputColorBox;

const InputColorBoxStyle = styled.div`
  display: flex;
  padding: 10px 20px;
`;

const BackgroundColorBox = styled.div`
  width: fit-content;
  height: 40px;
  background: #eff0f6;
  border-radius: 16px;
  display: flex;
  align-items: center;
  color: #6e7191;

  div {
    display: flex;
    margin-left: 20px;

    :last-child {
      margin-right: 20px;
    }
  }
`;

const TextColorBox = styled.div`
  width: fit-content;
  height: 40px;
  background: #eff0f6;
  border-radius: 16px;
  display: flex;
  align-items: center;
  margin: 0px 10px;
  color: #6e7191;

  div {
    display: flex;
    margin-left: 20px;

    :last-child {
      margin-right: 20px;
    }
  }
`;
