import { useEffect, useState } from 'react';

const useFetch = (url: string, deps: any[]): any => {
  const [response, setResponse] = useState(null);

  const fetchData = async () => {
    const res = await fetch(url);
    const data = await res.json();

    if (data.statusCode >= 400 || data.body === null)
      throw new Error('Fetch Error');
    return setResponse(data);
  };

  useEffect(() => {
    fetchData();
  }, deps);

  return response;
};

export default useFetch;
