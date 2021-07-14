import { atom, selector } from 'recoil';
import {
  dropCheckStateProps,
  MilestoneProps,
  Milestones,
  IssueDataProps,
} from '../utils/types/commonTypes';
import { URL as U } from '../utils/const';

// Login
export const token = atom({
  key: 'token',
  default: null,
});

export const decodedToken = atom({
  key: 'decodedToken',
  default: {
    name: '',
    avatarUrl: '',
  },
});

//SideBar
export const issueFormState = selector({
  key: 'issueFormState',
  get: async () => {
    const response = await fetch(U.FORM);
    const data = await response.json();
    return data;
  },
});

export const dropAssigneeState = atom({
  key: 'dropAssigneeState',
  default: false,
});
export const dropLabelState = atom({
  key: 'dropLabelState',
  default: false,
});
export const dropMilestoneState = atom({
  key: 'dropMilestoneState',
  default: false,
});

export const dropCheckState = atom<dropCheckStateProps>({
  key: 'dropCheckState',
  default: {
    assignee: [],
    label: [],
    milestone: [],
  },
});

//IssueList

export const issueListAtom = atom({
  key: 'issueListAtom',
  default: null,
});

export const issueListState = selector({
  key: 'issueListState',
  get: async () => {
    const response = await fetch(U.ISSUES);
    const data = await response.json();
    return data;
  },
});

// MilestoneList

export const milestoneAddState = atom({
  key: 'milestoneAddState',
  default: false,
});

export const milestoneEditState = atom({
  key: 'milestoneEditState',
  default: false,
});

export const milestoneListState = atom<Milestones | null>({
  key: 'milestoneListState',
  default: null,
});

export const milestoneEditIdState = atom({
  key: 'milestoneEditIdState',
  default: 0,
});

interface MilestoneAddInputProps {
  title: string;
  description: string;
}

export const milestoneAddInputState = atom<MilestoneAddInputProps>({
  key: 'milestoneAddInputState',
  default: {
    title: '',
    description: '',
  },
});

export const milestoneEditInputState = atom<MilestoneProps>({
  key: 'milestoneEditInputState',
  default: {
    id: 0,
    title: '',
    description: '',
    dueDate: '',
    status: '',
  },
});

// LabelList
export const labelAddState = atom({
  key: 'labelAddState',
  default: false,
});

//labelAdd
export interface labelAddStateInputProps {
  title: string;
  description: string;
  textColor: string;
  backgroundColor: string;
}

export const labelAddInputState = atom<labelAddStateInputProps>({
  key: 'labelAddInputState',
  default: {
    title: '',
    description: '',
    textColor: '#000',
    backgroundColor: '#EFF0F6',
  },
});

//labelEdit

export const labelEditIdState = atom({
  key: 'labelEditIdState',
  default: 0,
});

export const labelEditInputState = atom<labelAddStateInputProps>({
  key: 'labelEditInputState',
  default: {
    title: '',
    description: '',
    textColor: '#000',
    backgroundColor: '#EFF0F6',
  },
});

// //IssueAdd
export interface IssueAddStateInputProps {
  title: string;
  comment: string;
}

export const issueAddInputState = atom<IssueAddStateInputProps>({
  key: 'issueAddInputState',
  default: {
    title: '',
    comment: '',
  },
});

export const issueAddState = selector({
  key: 'issueAddState',
  get: ({ get }) => {
    const inputData = get(issueAddInputState);
    const dropCheck = get(dropCheckState);
    const assigneesIdList = dropCheck.assignee.map((ele) => ele.id);
    const labelsIdList = dropCheck.label.map((ele) => ele.id);
    const milestonesIdList = dropCheck.milestone?.map((ele) => ele?.id);
    return {
      title: inputData.title,
      comment: inputData.comment,
      assigneesId: assigneesIdList,
      labelsId: labelsIdList,
      milestoneId: milestonesIdList[0],
    };
  },
});
//IssueDetail
export const issueDetailState = atom<IssueDataProps>({
  key: 'issueDetailState',
  default: {
    issueId: 0,
    milestoneInfo: {
      id: 0,
      title: '',
      description: '',
      dueDate: '',
      status: '',
    },
    title: '',
    content: '',
    status: '',
    writer: {
      name: '',
      avatarUrl: '',
    },
    createdDateTime: '',
    assignees: [],
    labels: [],
    comments: [],
  },
});

//IssueDetailEdit
export const issueEditTitleState = atom({
  key: 'issueEditTitleState',
  default: false,
});

export const issueEditContentState = atom({
  key: 'issueEditContentState',
  default: false,
});

export const issueEditInputState = atom({
  key: 'issueEditInputTitleState',
  default: {
    title: '',
    comment: '',
  },
});

//IssueDetailID
export const issueDetailIdState = atom({
  key: 'issueDetailIdState',
  default: 0,
});
