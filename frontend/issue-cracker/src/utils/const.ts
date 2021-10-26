// Logo
export const LOGO_TITLE = 'Issue Cracker..🍪';

// Mode (DEVELOPE=3000, DEPLOY=squad, LOCAL=8080, )

// const DEPLOY = 'http://issue-tracker.pyro-squad.com';
// const LOCAL = 'http://localhost:8080';
// const DEVELOPE = 'http://localhost:3000';

// const DEPLOY_ID = '2a42dd1b1e2aad1238e9';
// const DEVELOPE_ID = 'e0ec416c1189c6a7f776';

// const LOGIN_URL = LOCAL_LOGIN;
// const BASE_URL = DEPLOY;
// const CLIENT_ID = DEVELOPE_ID;

const DEVELOPE = {
  BASE_URL: 'http://3.38.105.34',
  CLIENT_ID: 'bd67de79012efe833a1e',
  API_URL: '/api/web/localhost/auth',
};

const DEPLOY = {
  BASE_URL: 'http://3.38.105.34:8080',
  CLIENT_ID: '2a42dd1b1e2aad1238e9',
  API_URL: '/api/web/localhost/auth',
};

const selectMode = (mode: string) => (mode === 'dev' ? DEVELOPE : DEPLOY);
const MODE = selectMode('dev');

//url
export const URL = {
  AUTH: `${DEPLOY.BASE_URL}${MODE.API_URL}`,
  LOGIN: `https://github.com/login/oauth/authorize?client_id=${MODE.CLIENT_ID}&scope=read:user,user:email&redirect_uri=${MODE.BASE_URL}/authentication`,
  FORM: `${DEPLOY.BASE_URL}/api/web/issues/form`,
  ISSUES: `${DEPLOY.BASE_URL}/api/web/issues`,
  LABELS: `${DEPLOY.BASE_URL}/api/web/labels`,
  MILESTONE: `${DEPLOY.BASE_URL}/api/web/milestones`,
};
//path
export const PATH = {
  ROOT: '/',
  LOGIN: '/login',
  AUTH: '/authentication',
  MAIN: '/main',
  ISSUE_LIST: '/main/issue-list',
  ISSUE_ADD: '/main/issue-add',
  ISSUE_DETAIL: '/main/issue-detail/:id',
  ISSUE_LABELLIST: '/main/label-list',
  ISSUE_MILESTONE: '/main/milestone',
};

// LogIn
export const LOGIN = {
  ID: '아이디',
  PASSWORD: '비밀번호',
  GITHUB_LOGIN: 'GitHub 계정으로 로그인',
  DEFAULT_LOGIN: '아이디로 로그인',
};

// ButtonName
export const BUTTON_NAME = {
  ADD: '추가',
  DELETE: '삭제',
  COMPLETE: '완료',
  CANCEL: '취소',
  CLOSE: '닫기',
  EDIT: '편집',
  WRITING_ISSUE: '이슈작성',
  WRITING_CANCEL: '작성 취소',
  DELETE_ISSUE: '이슈 삭제',
};

// ButtonSize
export const BUTTON_SIZE = {
  LARGE: 'large',
  MEDIUM: 'medium',
  SMALL_FILL: 'smallFill',
  SMALL_BORDER: 'smallBorder',
  MEDIUM_TEXT: 'mediumText',
  SMALL_TEXT: 'smallText',
};

// TEXTs

export const TEXT = {
  OPEN_ISSUE: '열린 이슈',
  CLOSED_ISSUE: '닫힌 이슈',
  ASSIGNEE: '담당자',
  LABEL: '레이블',
  MILESTONE: '마일스톤',
  WRITER: '작성자',
  OPEN_MILESTONE: '열린 마일스톤',
  CLOSED_MILESTONE: '닫힌 마일스톤',
  EDIT_TITLE: '제목 편집',
  EDIT_COMPLETE: '편집 완료',
  EDIT_CANCEL: '편집 취소',
  CLOSE_ISSUE: '이슈 닫기',
};
export const SIDEBAR_TYPE = {
  ASSIGNEE: '담당자',
  LABEL: '레이블',
  MILESTONE: '마일스톤',
};

// Filter
export const FILTER = {
  FILTER: '필터',
  WRITTEN_ISSUE: '내가 작성한 이슈',
  ASSIGNED_ISSUE: '나에게 할당된 이슈',
  COMMENTED_ISSUE: '내가 댓글을 남긴 이슈',
  ISSUE_TABLE_HEADER_LIST: [
    TEXT.ASSIGNEE,
    TEXT.LABEL,
    TEXT.MILESTONE,
    TEXT.WRITER,
  ],
};

export const LABEL = {
  ADD: '새로운 레이블 추가',
  EDIT: '레이블 편집',
  NAME: '레이블 이름',
  DESC: '설명(선택)',
  BACKGROUND_COLOR: '배경색상',
  TEXT_COLOR: '텍스트 색상',
};

export const MILESTONE = {
  TITLE: '마일스톤 제목',
  ADD: '새로운 마일스톤 추가',
  EDIT: '마일스톤 수정',
  NAME: '마일스톤 이름',
  DESC: '설명(선택)',
  DUE: '완료일(선택) ex. YYYY-MM-DD',
  COMPLETE: '완료일 일정',
};

export const TYPE = {
  XSMALL: 'xSmall',
  SMALL: 'small',
  MEDIUM: 'medium',
  LARGE: 'large',
  OPEN: 'open',
  CLOSED: 'closed',
};

export const TOKEN = 'token';

// temp
export const FILTER_DROPDOWN = ['Tami', 'Raccoon', 'Noel', 'Neo', 'Pyro'];
export const SIDEBAR_MENU = [TEXT.ASSIGNEE, TEXT.LABEL, TEXT.MILESTONE];
