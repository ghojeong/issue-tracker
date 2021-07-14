./gradlew build -x test

TOMCAT_PROCESS=`lsof -t -i tcp:8080`

if [ -z "$TOMCAT_PROCESS" ]
then
    echo "@@@@ No Tomcat process"
else
    kill $TOMCAT_PROCESS
    echo "@@@@ Tomcat is killed"
fi

java -jar ./build/libs/issuetracker.jar >> spring-log.txt 2>&1 &

echo "@@@@ Tomcat is restarted"
