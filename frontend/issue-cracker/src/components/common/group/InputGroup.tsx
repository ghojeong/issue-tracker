import React, { ChangeEventHandler, FC } from 'react';
import useInputStyles from '../../styles/InputStyles';
import TextField from '@material-ui/core/TextField';
import { ClassNameMap } from '@material-ui/styles/withStyles';

interface InputGroupProps {
  type: string;
  name: string;
  variant: 'filled' | 'outlined';
  value?: string;
  onChange?: ChangeEventHandler<HTMLTextAreaElement | HTMLInputElement>;
}
type IInputType = ClassNameMap<
  'InputLarge' | 'InputMedium' | 'InputSmall' | 'InputText'
>;

interface IInput {
  classes: IInputType;
  name: string;
  variant: 'filled' | 'outlined';
  value?: string;
  onChange?: ChangeEventHandler<HTMLTextAreaElement | HTMLInputElement>;
}

const InputGroup: FC<InputGroupProps> = ({
  type,
  name,
  variant,
  value,
  onChange,
}: InputGroupProps) => {
  const classes = useInputStyles();
  return {
    large: <InputLarge {...{ classes, name, variant, value, onChange }} />,
    medium: <InputMedium {...{ classes, name, variant, value, onChange }} />,
    small: <InputSmall {...{ classes, name, variant, value, onChange }} />,
    text: <InputText {...{ classes, name, variant, value, onChange }} />,
  }[type] as JSX.Element;
};

export default InputGroup;

function InputLarge({ classes, name, variant, value, onChange }: IInput) {
  return (
    <TextField
      label={name}
      variant={variant}
      className={classes.InputLarge}
      value={value}
      onChange={onChange}
    />
  );
}
function InputMedium({ classes, name, variant, value, onChange }: IInput) {
  return (
    <TextField
      label={name}
      variant={variant}
      className={classes.InputMedium}
      value={value}
      onChange={onChange}
    />
  );
}
function InputSmall({ classes, name, variant, value, onChange }: IInput) {
  return (
    <TextField
      label={name}
      variant={variant}
      className={classes.InputSmall}
      value={value}
      onChange={onChange}
    />
  );
}
function InputText({ classes, name, variant, value, onChange }: IInput) {
  return (
    <TextField
      label={name}
      variant={variant}
      className={classes.InputText}
      value={value}
      onChange={onChange}
    />
  );
}
