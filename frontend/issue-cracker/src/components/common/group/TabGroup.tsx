import React from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import Button from '@material-ui/core/Button';
import ButtonGroup from '@material-ui/core/ButtonGroup';
import LocalOfferIcon from '@material-ui/icons/LocalOffer';
import FlagIcon from '@material-ui/icons/Flag';
import { makeStyles, createStyles, Theme } from '@material-ui/core/styles';
import TextGroup from '../group/TextGroup';
import CountGroup from '../group/CountGroup';
import { TEXT as TT, TYPE as T, PATH as P } from '../../../utils/const';

const useStyles = makeStyles((theme: Theme) =>
  createStyles({
    root: {
      display: 'flex',
      flexDirection: 'column',
      alignItems: 'center',
      '& > *': {
        margin: theme.spacing(1),
      },
    },
    button: {
      display: 'flex',
      alignItems: 'center',
      justifyContent: 'space-between',
      height: '40px',
      color: 'gray',
    },
  })
);

const TabGroup = ({
  labelCount,
  milestoneCount,
}: {
  labelCount?: number;
  milestoneCount?: number;
}): JSX.Element => {
  const classes = useStyles();

  return (
    <div className={classes.root}>
      <CustomTabGroup
        size="large"
        color="primary"
        aria-label="large outlined primary button group"
      >
        <Button
          className={classes.button}
          startIcon={<LocalOfferIcon />}
          component={Link}
          to={P.ISSUE_LABELLIST}
        >
          <TextGroup type={T.SMALL} content={TT.LABEL} color="#6E7191" />
          <CountGroup count={!labelCount ? 0 : labelCount} color="#6E7191" />
        </Button>

        <Button
          className={classes.button}
          startIcon={<FlagIcon />}
          component={Link}
          to={P.ISSUE_MILESTONE}
        >
          <TextGroup type={T.SMALL} content={TT.MILESTONE} color="#6E7191" />
          <CountGroup
            count={!milestoneCount ? 0 : milestoneCount}
            color="#6E7191"
          />
        </Button>
      </CustomTabGroup>
    </div>
  );
};

export default TabGroup;

const CustomTabGroup = styled(ButtonGroup)`
  a {
    border: 1px solid ${({ theme }) => `${theme.colors.gray3}`};
    border-radius: 16px;
  }

  button {
    border-color: ${({ theme }) => `${theme.colors.gray3}`};
    color: ${({ theme }) => `${theme.colors.gray3}`};
    padding: 0px 15px;

    :hover {
      border-color: ${({ theme }) => `${theme.colors.gray3}`};
      background: transparent;
    }
  }

  margin: 0;
  margin-right: 20px;
`;
