import React from 'react';
import Checkbox from '@material-ui/core/Checkbox';
import styled from 'styled-components';

export default function Checkboxes(): JSX.Element {
  const [checked, setChecked] = React.useState(true);

  const handleChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setChecked(event.target.checked);
  };

  return (
    <CheckBoxesStyle>
      <CustomCheckBox
        color="default"
        inputProps={{ 'aria-label': 'checkbox with default color' }}
      />
    </CheckBoxesStyle>
  );
}

const CheckBoxesStyle = styled.div`
  display: flex;
  height: fit-content;
`;

const CustomCheckBox = styled(Checkbox)`
  margin: 0px 15px;

  svg {
    fill: #d9dbe9;
  }
`;
