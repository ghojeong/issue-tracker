# Back End

## 프로젝트 실행법

### Docker Desktop 을 꼬옥! 미리 실행한다.

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
