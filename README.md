# MySQL 테이블
```
CREATE TABLE account(
	id int auto_increment primary key,
    username varchar(100) unique not null,
    accountNumber varchar(100) not null,
    money int
) engine=InnoDB default charset=utf8;
```
