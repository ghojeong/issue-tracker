import { IssueDataProps } from './types/commonTypes';
import {
  MilestoneDataProps,
  AssigneeProps,
  LabelProps,
  MilestoneProps,
} from './types/commonTypes';

export const getIssue = (
  list: IssueDataProps[],
  str: string
): IssueDataProps[] | null => {
  if (!list) return null;
  else return list?.filter((el) => el.status === str);
};

export const getElapsedTime = (date: string): string => {
  const createdTime = new Date(date);
  const current = new Date();
  const gapMin = Math.floor((+current - +createdTime) / 1000 / 60);

  if (gapMin < 1) return '방금 전';

  if (gapMin < 60) return `${gapMin}분 전`;

  const gapHour = Math.floor(gapMin / 60);
  if (gapHour < 24) return `${gapHour}시간 전`;

  const gapDay = Math.floor(gapHour / 24);
  if (gapDay < 30) return `${gapDay}일 전`;

  const gapMonth = Math.floor(gapDay / 12);
  if (gapMonth < 12) return `${gapMonth}달 전`;

  return '몇 년 전';
};

export const getIssueCount = (
  list: IssueDataProps[] | undefined,
  str: 'OPEN' | 'CLOSE'
): number => {
  if (!list) return 0;
  else return list?.filter((el) => el.status === str).length;
};

export const getMilestoneCount = (
  list: MilestoneDataProps[] | undefined,
  str: 'OPEN' | 'CLOSE'
): number => {
  if (!list) return 0;
  else return list?.filter((el) => el.milestoneInfo.status === str).length;
};

export const getDate = (date: string | null): string => {
  return date ? date.split('T')[0] : '';
};

export const getProgressRate = (open: number, close: number): number => {
  if (open === 0 && close === 0) return 0;
  return Math.floor((open + close) / open) * 100;
};

export const getValueInJson = (
  data: AssigneeProps[] | LabelProps[] | MilestoneProps[],
  key: string
): string[] | number[] => {
  const value = data.map((ele: any) => ele[key]);
  return value;
};
