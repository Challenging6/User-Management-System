CREATE TABLE IF NOT EXISTS book (
  `bookId` INT AUTO_INCREMENT,
  `title` varchar(30) NOT NULL,
  `isbn` varchar(50) NOT NULL ,
  `author` varchar(20) NOT NULL ,
  `storeAmount` INT NULL ,
  `category` VARCHAR(20) NOT NULL ,
  `lendingAmount` INT NULL,
  PRIMARY KEY(`bookId`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT INTO book(title, isbn, author, storeAmount, category, lendingAmount) VALUES
  ('sring mvc', '42314321413214', 'challenging', 10, 'java', 2)