if [ -z `lsof -t -i tcp:8080` ]
then
    echo "@@@@ Tomcat is Dead @@@@"
    java -jar ~/issuetracker.jar >> spring-log.txt 2>&1 &
else
    echo "@@@@ Tomcat is Alive @@@@"
fi
