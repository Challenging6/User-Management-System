CREATE TABLE if NOT EXISTS `customer`(
  `id`              INT AUTO_INCREMENT ,
  `username`        varchar(30) NOT NULL,
  `nickname`        varchar(30) NOT NULL ,
  `password`        varchar(20) NOT NULL ,
  `age`             INT         NULL ,
  `phone`           VARCHAR(20) NOT NULL ,
  `gender`          VARCHAR(5)  NULL ,
  `email`           varchar(50) NOT NULL ,
  `login_time`      DATE        NULL,
  `last_login_time` DATE        NULL ,
  `create_time`     DATE        NULL,
  PRIMARY KEY (`id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8;

INSERT into `customer`(username, nickname, password, age,
                       phone, gender, email)
VALUES
  ('challenging', 'shit', 'MTIzNDU2', 12, '13637283821', '男', '992871471@qq.com'),
  ('chall', 'shitd', '123456', 21, '13637283821', '女', '13233221@qq.com');

