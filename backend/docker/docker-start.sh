PYRO_DB=`docker ps -aq --filter ancestor=pyrodb:1.0`
ADMINER=`docker ps -aq --filter ancestor=adminer`
REDIS=`docker ps -aq --filter ancestor=redis`

docker stop $PYRO_DB
docker rm $PYRO_DB

docker stop $ADMINER
docker rm $ADMINER

docker stop $REDIS
docker rm $REDIS

docker rmi pyrodb:1.0

docker-compose up --build -d
