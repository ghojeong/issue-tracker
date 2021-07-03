ALTER DATABASE `pyrodb` DEFAULT CHARACTER SET = utf8mb4;

DROP DATABASE pyrodb;
CREATE DATABASE IF NOT EXISTS pyrodb CHARACTER SET utf8mb4;
USE pyrodb;

DROP TABLE IF EXISTS `pyrodb`.`user`;
CREATE TABLE `pyrodb`.`user`
(
    `id`              VARCHAR(50) NOT NULL PRIMARY KEY,
    `name`            VARCHAR(50),
    `avatarUrl` VARCHAR(300)
);

DROP TABLE IF EXISTS `pyrodb`.`email`;
CREATE TABLE `pyrodb`.`email`
(
    `email`  VARCHAR(50)  NOT NULL PRIMARY KEY,
    `userId` VARCHAR(300) NOT NULL,
    FOREIGN KEY (`userId`) REFERENCES `pyrodb`.`user` (`id`)
);

DROP TABLE IF EXISTS `pyrodb`.`status`;
CREATE TABLE `pyrodb`.`status`
(
    `id` VARCHAR(50) NOT NULL PRIMARY KEY
);

DROP TABLE IF EXISTS `pyrodb`.`milestone`;
CREATE TABLE `pyrodb`.`milestone`
(
    `id`          INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `title`       VARCHAR(50) NOT NULL,
    `description` VARCHAR(300),
    `statusId`    VARCHAR(50)  NOT NULL,
    `dueDate`     TIMESTAMP,
    FOREIGN KEY (`statusId`) REFERENCES `pyrodb`.`status` (`id`)
);

DROP TABLE IF EXISTS `pyrodb`.`issue`;
CREATE TABLE `pyrodb`.`issue`
(
    `id`          INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `title`       VARCHAR(50)  NOT NULL,
    `content`     VARCHAR(300),
    `writerId`    VARCHAR(300) NOT NULL,
    `statusId`    VARCHAR(50)  NOT NULL,
    `milestoneId` INT,
    `createdDate`     TIMESTAMP,
    FOREIGN KEY (`writerId`) REFERENCES `pyrodb`.`user` (`id`),
    FOREIGN KEY (`statusId`) REFERENCES `pyrodb`.`status` (`id`),
    FOREIGN KEY (`milestoneId`) REFERENCES `pyrodb`.`milestone` (`id`)
);

DROP TABLE IF EXISTS `pyrodb`.`assignee`;
CREATE TABLE `pyrodb`.`assignee`
(
    `issueId` INT NOT NULL,
    `userId` VARCHAR(50) NOT NULL,
    FOREIGN KEY (`issueId`) REFERENCES `pyrodb`.`issue` (`id`),
    FOREIGN KEY (`userId`) REFERENCES `pyrodb`.`user` (`id`),
    PRIMARY KEY (`issueId`, `userId`)
);

DROP TABLE IF EXISTS `pyrodb`.`comment`;
CREATE TABLE `pyrodb`.`comment`
(
    `id`       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `content`  VARCHAR(300) NOT NULL,
    `dateTime` TIMESTAMP,
    `writerId` VARCHAR(300) NOT NULL,
    `issueId`  INT,
    FOREIGN KEY (`writerId`) REFERENCES `pyrodb`.`user` (`id`),
    FOREIGN KEY (`issueId`) REFERENCES `pyrodb`.`issue` (`id`)
);

DROP TABLE IF EXISTS `pyrodb`.`label`;
CREATE TABLE `pyrodb`.`label`
(
    `id`              INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `title`           VARCHAR(50) NOT NULL,
    `description`     VARCHAR(300),
    `backgroundColor` VARCHAR(8),
    `textColor`       VARCHAR(8)
);

DROP TABLE IF EXISTS `pyrodb`.`issueLabel`;
CREATE TABLE `pyrodb`.`issueLabel`
(
    `issueId` INT NOT NULL,
    `labelId` INT NOT NULL,
    FOREIGN KEY (`issueId`) REFERENCES `pyrodb`.`issue` (`id`),
    FOREIGN KEY (`labelId`) REFERENCES `pyrodb`.`label` (`id`),
    PRIMARY KEY (`issueId`, `labelId`)
);
