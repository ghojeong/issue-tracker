# Back End

## 프로젝트 실행법

### Docker Desktop 을 꼬옥! 미리 실행한다.

### 환경변수를 설정한다.

```sh
export GITHUB_CLIENT_ID="613d2f8134285ef8a4f6"
export GITHUB_CLIENT_SECRET="fa3da7c96b59ed8436bd2d4eb716f42db1ec5d6e"
export GITHUB_IOS_CLIENT_ID="6cd127b711edc7a10a5c"
export GITHUB_IOS_CLIENT_SECRET="3dc13a8fb7474e085ec63c3b928d2bdf20f64a89"
export GITHUB_WEB_CLIENT_ID="2a42dd1b1e2aad1238e9"
export GITHUB_WEB_CLIENT_SECRET="c34678e8b0aaca11d7c2f53dfc46993bc0a29748"
export SPRING_DATASOURCE_URL="jdbc:mysql://localhost:12345/pyrodb?autoReconnect=true&useUnicode=true&characterEncoding=UTF8&serverTimeZone=Asia/Seoul"
export SPRING_DATASOURCE_USERNAME="pyro"
export SPRING_DATASOURCE_PASSWORD="pyro1234"
export SPRING_REDIS_HOST="localhost"
export SPRING_REDIS_PORT="15552"
export SPRING_REDIS_PASSWORD="redis1234"
```

### backend/start.sh 스크립트를 실행한다.

backend 디렉토리로 이동해서, start.sh 를 실행한다.

```
cd ./backend
sh ./start.sh
```

## 배포하는 법

depoloy.sh 를 실행한다.

### Nginx 설정하는 법

[출처: Dong 의 블로그](https://velog.io/@d-h-k/NGINX)

```sh
sudo apt update && sudo apt upgrade - y && sudo apt clean
sudo apt install nginx -y
sudo service nginx restart

sudo echo "server {
    listen 80;
    listen [::]:80;
    server_name baseball.pyro-squad.com;
    location / {
        proxy_pass http://localhost:8080;
        proxy_set_header X-Real-IP $remote_addr;
        proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
        proxy_set_header Host $http_host;
    }
}" >> /etc/nginx/sites-available/test.conf

sudo ln -s /etc/nginx/sites-available/test.conf /etc/nginx/sites-enabled
sudo rm /etc/nginx/sites-enabled/default
sudo service nginx reload
sudo service nginx restart
```
