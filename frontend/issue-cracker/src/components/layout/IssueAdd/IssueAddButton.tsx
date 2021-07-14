import React from 'react';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import TextGroup from '../../common/group/TextGroup';
import ButtonGroup from '../../common/group/ButtonGroup';
import CloseIcon from '@material-ui/icons/Close';
import {
  BUTTON_SIZE as BS,
  TYPE as T,
  PATH as P,
  BUTTON_NAME as BN,
  URL as U,
} from '../../../utils/const';
import { issueAddState } from '../../../store/Recoil';
import { useRecoilValue } from 'recoil';
import { useHistory } from 'react-router';

const IssueAddButton = (): JSX.Element => {
  const issueAdd = useRecoilValue(issueAddState);

  const userToken = localStorage.getItem('token');
  const history = useHistory();

  const handleClickCompleteButton = async () => {
    return await fetch(U.ISSUES, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        Authorization: `Bearer ${userToken}`,
      },
      body: JSON.stringify({
        title: issueAdd.title,
        comment: issueAdd.comment,
        milestoneId: issueAdd.milestoneId,
        assigneeIds: issueAdd.assigneesId,
        labelIds: issueAdd.labelsId,
      }),
    })
      .then((res) => console.log('SUCCESS', res))
      .then((error) => console.error(error))
      .then(() => history.push('/'));
  };

  return (
    <IssueAddButtonStyle>
      <Link to={P.ISSUE_LIST}>
        <CancelButton>
          <WriteCancelButton />
          <TextGroup
            type={T.SMALL}
            content={BN.WRITING_CANCEL}
            color="#6E7191"
          />
        </CancelButton>
      </Link>
      <ButtonGroup
        type={BS.MEDIUM}
        name={BN.COMPLETE}
        onClick={handleClickCompleteButton}
        color="#ffffff"
      />
    </IssueAddButtonStyle>
  );
};

export default IssueAddButton;

const IssueAddButtonStyle = styled.div`
  display: flex;
  justify-content: flex-end;
  align-items: center;
`;

const CancelButton = styled.button`
  display: flex;
  align-items: center;
  background: none;
  padding: 10px 20px;
  margin: 10px;
  cursor: pointer;
`;

const WriteCancelButton = styled(CloseIcon)`
  color: #6e7191;
  font-size: 12px;
  margin: 3px;
`;
