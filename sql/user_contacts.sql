CREATE TABLE `user_contacts` (
  `contact_id` INT (11) NOT NULL, 
  `user_id` int(11) NOT NULL,
  `cname` varchar(45) NOT NULL,
  `cemail` varchar(45) NOT NULL,
  PRIMARY KEY (`contact_id`),
  FOREIGN KEY (user_id) REFERENCES users(user_id)
);