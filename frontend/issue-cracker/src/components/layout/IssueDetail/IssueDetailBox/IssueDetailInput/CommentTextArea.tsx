import React, { ChangeEventHandler } from 'react';
import TextareaAutosize from '@material-ui/core/TextareaAutosize';
import styled from 'styled-components';
import AttachFileIcon from '@material-ui/icons/AttachFile';

interface Props {
  onChange: ChangeEventHandler<HTMLTextAreaElement | HTMLInputElement>
}

const TextArea = ({ onChange }: Props): JSX.Element => (
    <TextAreaStyle>
        <TextAreaUI onChange={onChange} />
    </TextAreaStyle>
);

export default TextArea;

interface TextAreaUIProps {
  onChange: ChangeEventHandler<HTMLTextAreaElement | HTMLInputElement>;
}

const TextAreaUI = ({ onChange }: TextAreaUIProps): JSX.Element => {
  return (
    <TextareaAutosize
      aria-label="empty textarea"
      placeholder="코멘트를 입력하세요"
      onChange={onChange}
      style={{
        background: 'inherit',
        outline: 'none',
        border: 'none',
        borderRadius: '16px',
        padding: '16px 0px',
        minHeight: '343px',
        width: '100%',
        resize: 'vertical',
      }}
    />
  );
};

const TextAreaStyle = styled.div`
  position: relative;
  width: 100%;
  padding: 16px 24px;
  background: #eff0f6;
  border-radius: 16px;
  border: 1px solid #eff0f6;
  :focus-within {
    border: 1px solid #222;
    background: #ffffff;
  }
`;
