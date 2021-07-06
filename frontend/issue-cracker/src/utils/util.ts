import { IssueDataProps } from './types/IssueDataType';
import { MilestoneDataProps } from './types/milestoneDataType';

export const getIssue = (
  list: IssueDataProps[],
  str: string
): IssueDataProps[] => list.filter((el) => el.status === str);

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

export const getIssueCount = (list: IssueDataProps[], str: string): number =>
  list.filter((el) => el.status === str).length;

export const getMilestoneCount = (
  list: MilestoneDataProps[],
  str: 'OPEN' | 'CLOSE'
): number => list.filter((el) => el.milestoneInfo.status === str).length;

export const getDate = (date: string | null): string => {
  if (!date) return '';
  return date.split('T')[0];
};

export const getProgressRate = (open: number, close: number): number => {
  if (open === 0 && close === 0) return 0;
  return Math.floor((open + close) / open) * 100;
};
