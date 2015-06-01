CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `age` varchar(45) NOT NULL,
  `gender` varchar(45) NOT NULL,
   FOREIGN KEY (user_id) REFERENCES users(user_id)
);