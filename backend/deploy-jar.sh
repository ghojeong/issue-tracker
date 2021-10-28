# 출처: https://www.notion.so/cc778488e5524e1999a1bcf0c19f0006

KEY_PATH=/Users/g/LightsailDefaultKeyPair-ap-northeast-2.pem
SERVER_PATH=ubuntu@issue-cracker.pyro-squad.com
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
