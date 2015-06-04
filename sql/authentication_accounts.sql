CREATE TABLE `authentication_accounts` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `config` varchar(100) NOT NULL,
  PRIMARY KEY (`user_id`,`password`,`username`,`config`)