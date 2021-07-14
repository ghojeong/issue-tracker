//IssueForm 이슈 옵션 조회
//assignee
export interface AssigneeProps {
  id?: string;
  name: string;
  emails?: string[];
  avatarUrl: string;
}
//writer
export interface WriterProps {
  name: string;
  avatarUrl: string;
}

//label
export interface LabelProps {
  id: number;
  title: string;
  description: string;
  backgroundColor: string;
  textColor: string;
}

//Milestone
export interface MilestoneProps {
  id: number;
  title: string;
  description: string;
  dueDate: string;
  status?: string;
}
export interface MilestoneDataProps {
  id: number;
  issues: IssueDataProps[];
  milestoneInfo: MilestoneProps;
}

export interface Milestones {
  milestones: MilestoneDataProps[];
}

//comment
export interface CommentsProps {
  id: number;
  writer: {
    id: string;
    avatarUrl: string;
  };
  content: string;
  dateTime: string;
}

//Issue
export interface IssueDataProps {
  issueId: number;
  milestoneInfo: MilestoneProps;
  title: string;
  content: string;
  status: string;
  writer: AssigneeProps;
  createdDateTime: string;
  assignees: WriterProps[] | AssigneeProps[];
  labels: LabelProps[];
  comments?: CommentsProps[];
}

//state data props
export interface AssigneeStateProps {
  checkedAssignee?: AssigneeProps[];
  assignees?: AssigneeProps[];
  userData?: AssigneeProps[];
}
export interface LabelStateProps {
  checkedLabel?: LabelProps[];
  labelData?: LabelProps[];
}

export interface MilestoneStateProps {
  checkedMilestone?: MilestoneProps[];
  milestoneData?: MilestoneProps[];
}

export interface dropCheckStateProps {
  assignee: AssigneeProps[];
  label: LabelProps[];
  milestone: MilestoneProps[];
}

// Common
export interface CommonButtonProps {
  icon: JSX.Element;
  text: JSX.Element;
  count?: JSX.Element;
  onClick?: React.MouseEventHandler<HTMLDivElement>;
  id?: number;
}
