# 출처: https://www.notion.so/cc778488e5524e1999a1bcf0c19f0006

KEY_PATH=/Users/g/ssh-key-2021-07-01.key
SERVER_PATH=ubuntu@132.226.22.147
JAR_FILE=issuetracker.jar

cd ./server
./gradlew build -x test

# scp 명령어로 jar 파일 전송
ssh -i $KEY_PATH $SERVER_PATH "rm -rf ~/$JAR_FILE"
scp -i $KEY_PATH ./build/libs/$JAR_FILE $SERVER_PATH:~

# 백그라운드로 BE server 배포
TOMCAT_PROCESS=$(ssh -i $KEY_PATH $SERVER_PATH "lsof -t -i tcp:8080")
ssh -i $KEY_PATH $SERVER_PATH "kill -9 $TOMCAT_PROCESS"
ssh -i $KEY_PATH $SERVER_PATH "java -jar ~/$JAR_FILE >> spring-log.txt 2>&1 &"
