import React from 'react';
import styled from 'styled-components';

const CheckOffIcon = (): JSX.Element => {
  return (
    <CheckOffIconStyle>
      <svg
        width="16"
        height="16"
        viewBox="0 0 16 16"
        fill="none"
        xmlns="http://www.w3.org/2000/svg"
      >
        <path
          d="M7.99992 14.6667C11.6818 14.6667 14.6666 11.6819 14.6666 8.00001C14.6666 4.31811 11.6818 1.33334 7.99992 1.33334C4.31802 1.33334 1.33325 4.31811 1.33325 8.00001C1.33325 11.6819 4.31802 14.6667 7.99992 14.6667Z"
          stroke="#4E4B66"
          strokeWidth="1.6"
          strokeLinecap="round"
          strokeLinejoin="round"
        />
      </svg>
    </CheckOffIconStyle>
  );
};
export default CheckOffIcon;
const CheckOffIconStyle = styled.div`
  display: flex;
  align-items: center;
`;