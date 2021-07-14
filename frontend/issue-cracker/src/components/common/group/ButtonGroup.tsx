import React, { FC } from 'react';
import Button from '@material-ui/core/Button';
import useButtonStyles from '../../styles/ButtonStyles';
import { ClassNameMap } from '@material-ui/styles/withStyles';
import styled from 'styled-components';

interface Prop {
  type: string;
  name: string;
  color?: string;
  icon?: JSX.Element;
  onClick?: React.MouseEventHandler<HTMLButtonElement>;
}
type IButtonType = ClassNameMap<
  | 'buttonLarge'
  | 'buttonMedium'
  | 'buttonSmallFill'
  | 'buttonSmallBorder'
  | 'buttonMediumText'
  | 'buttonSmallText'
>;

interface IButton {
  classes: IButtonType;
  name: string;
  color?: string;
  icon?: JSX.Element | undefined;
  onClick?: React.MouseEventHandler<HTMLButtonElement>;
}

const ButtonGroup: FC<Prop> = ({
  type,
  name,
  onClick,
  color = 'white',
  icon,
}: Prop) => {
  const classes = useButtonStyles();

  return {
    large: <ButtonLarge {...{ classes, name, onClick, color }} />,
    medium: <ButtonMedium {...{ classes, name, onClick, color }} />,
    smallFill: <ButtonSmallFill {...{ classes, name, onClick, color, icon }} />,
    smallBorder: (
      <ButtonSmallBorder {...{ classes, name, onClick, color, icon }} />
    ),
    mediumText: (
      <ButtonMediumText {...{ classes, name, onClick, color, icon }} />
    ),
    smallText: <ButtonSmallText {...{ classes, name, onClick, color, icon }} />,
  }[type] as JSX.Element;
};

export default ButtonGroup;

function ButtonLarge({ classes, name, onClick, color }: IButton) {
  return (
    <Button
      variant="contained"
      className={classes.buttonLarge}
      style={{
        backgroundColor: `${color}`,
        color: `${color === 'white' ? '#222' : '#ffffff'}`,
      }}
      onClick={onClick}
    >
      {name}
    </Button>
  );
}

function ButtonMedium({ classes, name, onClick, color }: IButton) {
  return (
    <Button
      variant="contained"
      className={classes.buttonMedium}
      style={{
        backgroundColor: `${color}`,
      }}
      onClick={onClick}
    >
      {name}
    </Button>
  );
}

function ButtonSmallFill({ classes, name, onClick, color, icon }: IButton) {
  return (
    <CustomButton
      variant="contained"
      startIcon={icon}
      className={classes.buttonSmallFill}
      style={{
        backgroundColor: `${color}`,
        color: `${color === 'white' ? '#222' : '#ffffff'}`,
      }}
      onClick={onClick}
    >
      {name}
    </CustomButton>
  );
}

function ButtonSmallBorder({ classes, name, onClick, color, icon }: IButton) {
  return (
    <Button
      variant="outlined"
      startIcon={icon}
      className={classes.buttonSmallBorder}
      style={{
        border: `1px solid ${color}`,
      }}
      onClick={onClick}
    >
      {name}
    </Button>
  );
}

function ButtonMediumText({ classes, name, onClick, icon }: IButton) {
  return (
    <Button
      variant="text"
      startIcon={icon}
      className={classes.buttonMediumText}
      onClick={onClick}
    >
      {name}
    </Button>
  );
}

function ButtonSmallText({ classes, name, icon, onClick }: IButton) {
  return (
    <Button
      variant="text"
      startIcon={icon}
      onClick={onClick}
      className={classes.buttonSmallText}
    >
      {name}
    </Button>
  );
}

const CustomButton = styled(Button)`
  border-radius: 16px;
`;
