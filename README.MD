# MySQL 쿼리문

```use 생성
create user 'spring'@'%' identified by 'bitc5600';
GRANT ALL PRIVILEGES ON *.* TO 'spring'@'%';
create database spring;
use spring;
```

```테이블 생성
CREATE TABLE user(
   id int auto_increment primary key,
    username varchar(100) unique not null,
    password varchar(100) not null,
    email varchar(100),
    profile varchar(200),
    role varchar(20),
    createDate timestamp
) engine=InnoDB default charset=utf8;

CREATE TABLE post(
   id int auto_increment primary key,
    title varchar(100) not null,
    content longtext,
    userId int,
    createDate timestamp,
    foreign key (userId) references user (id) on delete set null
) engine=InnoDB default charset=utf8;

CREATE TABLE comment(
   id int auto_increment primary key,
    userId int,
    postId int,
    content varchar(300) not null,
    createDate timestamp,
    foreign key (userId) references user (id) on delete set null,
    foreign key (postId) references post (id) on delete cascade
) engine=InnoDB default charset=utf8;
```
