CREATE TABLE if NOT EXISTS `admin`(
  `id` INT AUTO_INCREMENT COMMENT 'admin_id',
  `username` varchar(30) NOT NULL,
  `nickname` varchar(30) NOT NULL ,
  `password` varchar(20) NOT NULL ,
  `age` INT NULL ,
  `phone` VARCHAR(20) NOT NULL ,
  `gender` VARCHAR(5) NULL ,
  `email` varchar(50) NOT NULL ,
  `login_time` VARCHAR(20) NULL,
  `last_login_time` VARCHAR(20) NULL ,
  `create_time` VARCHAR(20) NULL,
  PRIMARY KEY (`id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT into `admin`(username, nickname, password, age, phone, gender, email)
VALUES
  ('challenging', 'emm', 'MTIzNDU2', 12, '13637283821', '男', '992871471@qq.com'),
  ('challafd', 'shitdfd', '123456', 21, '13637283821', '女', '13233221@qq.com');

