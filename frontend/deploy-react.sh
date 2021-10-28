KEY_PATH=/Users/g/LightsailDefaultKeyPair-ap-northeast-2.pem
EC2_PATH=ubuntu@issue-cracker.pyro-squad.com
BUILD_PATH=./issue-cracker/build
NGINX_PATH=/var/www/html
ZIP_FILE=webfront.tar.gz

rm $ZIP_FILE
tar -zcvf $ZIP_FILE $BUILD_PATH

ssh -i $KEY_PATH $EC2_PATH "sudo rm -rf $NGINX_PATH/*"

# 파일 전송을 위해서는 705 권한을 $EC2_PATH:$NGINX_PATH 에 부여해야 한다.
scp -i $KEY_PATH $ZIP_FILE $EC2_PATH:$NGINX_PATH

ssh -i $KEY_PATH $EC2_PATH "sudo tar -zxvf $NGINX_PATH/$ZIP_FILE -C $NGINX_PATH --strip 3"

ssh -i $KEY_PATH $EC2_PATH "sudo service nginx restart"
