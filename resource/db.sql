CREATE DATABASE IF NOT EXISTS MAINDB default charset utf8 COLLATE utf8_general_ci;

use MAINDB;

drop table if exists CUSTOMER;
create table CUSTOMER
(
   uid                 int not null auto_increment,
   username           varchar(50),
   address            varchar(500),
   tel                varchar(100),
   email              varchar(200),
   memo               varchar(200),
   registerDate       timestamp,
   primary key (uid),
   unique index(username)
)
charset=utf8 ENGINE=InnoDB;

TRUNCATE TABLE CUSTOMER;
INSERT INTO CUSTOMER( username, address,tel,email,memo,registerDate) VALUES( 'tomcat1','sss','1399999','abc@163.com','memo',CURRENT_TIMESTAMP);
INSERT INTO CUSTOMER( username, address,tel,email,memo,registerDate) VALUES( 'tomcat2','sss','1399999','abc@163.com','memo',CURRENT_TIMESTAMP);
INSERT INTO CUSTOMER( username, address,tel,email,memo,registerDate) VALUES( 'tomcat3','sss','1399999','abc@163.com','memo',CURRENT_TIMESTAMP);
INSERT INTO CUSTOMER( username, address,tel,email,memo,registerDate) VALUES( 'tomcat4','sss','1399999','abc@163.com','memo',CURRENT_TIMESTAMP);
INSERT INTO CUSTOMER( username, address,tel,email,memo,registerDate) VALUES( 'tomcat5','sss','1399999','abc@163.com','memo',CURRENT_TIMESTAMP);
INSERT INTO CUSTOMER( username, address,tel,email,memo,registerDate) VALUES( 'tomcat6','sss','1399999','abc@163.com','memo',CURRENT_TIMESTAMP);
INSERT INTO CUSTOMER( username, address,tel,email,memo,registerDate) VALUES( 'tomcat7','sss','1399999','abc@163.com','memo',CURRENT_TIMESTAMP);



drop table if exists DISH;
create table DISH
(
   did                 int not null auto_increment,
   dishname           varchar(50),
   price              DECIMAL(5,2),
   primary key (did),
   unique index(dishname)
)
charset=utf8 ENGINE=InnoDB;

INSERT INTO dish( dishname, price) VALUES( '排骨',20.00);
INSERT INTO dish( dishname, price) VALUES( '鲤鱼',30.00);
INSERT INTO dish( dishname, price) VALUES( '鲜虾',40.00);
INSERT INTO dish( dishname, price) VALUES( '红烧肉',25.00);
INSERT INTO dish( dishname, price) VALUES( '面条',10.00);
INSERT INTO dish( dishname, price) VALUES( '饺子',20.00);


drop table if exists CUSTOMER_DISH;
create table CUSTOMER_DISH
(
   userId          int(5),
   dishId          int(5)
)
charset=utf8 ENGINE=InnoDB;

INSERT INTO  CUSTOMER_DISH( userId, dishId) VALUES( 1, 2);
INSERT INTO  CUSTOMER_DISH( userId, dishId) VALUES( 1, 4);
INSERT INTO  CUSTOMER_DISH( userId, dishId) VALUES( 1, 6);

INSERT INTO  CUSTOMER_DISH( userId, dishId) VALUES( 2, 2);
INSERT INTO  CUSTOMER_DISH( userId, dishId) VALUES( 2, 3);
INSERT INTO  CUSTOMER_DISH( userId, dishId) VALUES( 2, 4);


INSERT INTO  CUSTOMER_DISH( userId, dishId) VALUES( 3, 1);
INSERT INTO  CUSTOMER_DISH( userId, dishId) VALUES( 3, 2);
INSERT INTO  CUSTOMER_DISH( userId, dishId) VALUES( 3, 4);
INSERT INTO  CUSTOMER_DISH( userId, dishId) VALUES( 3, 5);



