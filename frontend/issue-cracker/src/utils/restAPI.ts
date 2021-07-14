export const getPost = async (
  path: string,
  token: string | null,
  body: any
): Promise<string | void> => {
  return await fetch(path, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      Authorization: `Bearer ${token}`,
    },
    body: JSON.stringify(body),
  })
    .then((res) => console.log('SUCCESS', res))
    .then((error) => console.error(error));
};

export const getPut = async (
  path: string,
  token: string | null,
  body: any
): Promise<string | void> => {
  return await fetch(path, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json',
      Authorization: `Bearer ${token}`,
    },
    body: JSON.stringify(body),
  })
    .then((res) => console.log('SUCCESS', res))
    .then((error) => console.error(error));
};

export const getDelete = async (
  path: string,
  token: string | null
): Promise<string | void> => {
  return await fetch(path, {
    method: 'DELETE',
    headers: {
      'Content-Type': 'application/json',
      Authorization: `Bearer ${token}`,
    },
  })
    .then((res) => console.log('SUCCESS', res))
    .then((error) => console.error(error));
};
