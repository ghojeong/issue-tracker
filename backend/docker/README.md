# 도커 관련 설명

## MySQL 도커 실행법

```sh
cd ./backend/docker

sh ./docker-clear.sh

docker build --tag pyrodb:1.0 ./Dockerfile.pyrodb

docker run -d -p 12345:3306 --name=pyrodb pyrodb:1.0

mysql -h localhost -P 12345 -D pyrodb --protocol=tcp -u pyro -p
# 비밀번호: pyro1234
```

## Redis 실행법

```sh
brew install redis

redis-cli -h localhost -p 15552 -a 'redis1234'

keys *

get key_one

mget key_one key_two
```
