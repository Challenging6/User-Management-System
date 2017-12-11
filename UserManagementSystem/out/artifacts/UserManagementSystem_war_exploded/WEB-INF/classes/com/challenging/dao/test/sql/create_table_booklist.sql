CREATE TABLE IF NOT EXISTS booklist (
  `id` INT AUTO_INCREMENT,
  `userid` INT NOT NULL ,
  `bookid` INT NOT NULL ,
  `isbn` VARCHAR(60) NOT NULL ,
  `title` varchar(30) NOT NULL,
  `author` VARCHAR(20) NOT NULL,
  `category` VARCHAR(20) NOT NULL ,
  PRIMARY KEY (`id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT into `booklist`(userid,title, bookid, isbn,author,category)VALUES
  (1, 'java教程', 2, '6633123213',	 'challenging',	'coding')
