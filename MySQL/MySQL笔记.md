# 1.初识MySQL

JavaEE：企业级Java开发 Web

前端（页面：展示：数据）

后台 （连接点：连接数据库JDBC,连接前端（控制视图跳转，给前端传递数据））

数据库（存数据，Txt,Excel,Word）

>只会写代码，学好数据库，基本混饭吃：
>操作系统，数据结构与算法！当一个不错的程序猿！
>离散数学，数字电路，体系结构，编译原理。+实战经验，优秀程序猿

## 1.1为什么学数据库

1、岗位需求

2、现在的世界，大数据时代，得数据者得天下

3、被迫需求：存数据

4、数据库是所有软件体系中最核心的存在 DBA
## 1.2 什么是数据库

数据库：(DB,DataBase)

概念:数据仓库，软件，安装在操作系统之（windows,Linux。mac）上的！SQL,可以存储大量的数据，500万!

作用:存储数据，管理数据 Excel
## 1.3 数据库分类

关系型数据库：(SQL)

MySQL, Oracle, sql Server, DB2, SQLite
通过表和表之间，行和列之间的关系进行数据的存储
非关系型数据库：(NoSQL) Not Only SQL

Redis, MongDB
非关系型数据库，对象存储，通过对象自身的属性来决定。
**DBMS(数据库管理系统) **

数据库的管理软件，科学有效的管理我们的数据，维护和获取
MySQL ，数据管理系统！

## 1.4 MySQL简介

MySQL是一个关系型数据库管理系统

前世： 瑞典MySQL AB 公司

今身： 属于 Oracle 旗下产品

MySQL是最好的 RDBMS (Relational Database Management System，关系数据库管理系统) 应用软件之一。

开源的数据库软件

体积小，速度快，总体拥有成本低，招人成本比较低。

中小型网站，或者大型网站，集群

官网: https://dev.mysql.com/downloads/mysql/

# 2.操作数据库
## 2.1 操作数据库

创建数据库

```sql
CREATE DATABASE IF NOT EXISTS student;
```

删除数据库

```sql
DROP DATABASE student;
```

使用数据库

```sql
USE student;
```

## 2.2 数据库的列类型

> 数值

+ tinyint 十分小的数据 1个字节
+ smallint 较小的数据 2个字节
+ mediumint 中等大小 3个字节
+ ==int 标准的整数 4个字节（常用）==
+ bigint 较大的数据 8个字节
+ float 浮点数 4个字节
+ double 浮点数 8个字节 （精度问题）
+ decimal 字符串形式的浮点数,金融计算的时候，一般用decimal

> 字符串

- char 字符串固定大小 0-255
- ==**varchar 可变字符串 0-65535**（常用）==
- tinytext 微型文本 2^8-1
- ==**text 文本串 2^16-1** (保存大文本)==

> 时间日期

- date yyyy-MM-dd,日期格式
- time HH:mm-ss 时间格式
- **datetime YYYY-MM-DD HH:mm:ss 最常用的时间格式**
- **timestamp 时间戳 1970.1.1到现在的毫秒数**
- year 年份表示

> null

- 没有值，未知
- ==注意，不要使用null进行运算，结果为null==

## 2.3 数据库的字段属性（重点）

==Unsigned：==

>无符号的整数
>声明了该列不能声明为负数

==zerofill==

0填充的

10的长度 1 – 0000000001 不足位数用0 填充

==自增：==

通常理解为自增，自动在上一条记录的基础上+1,通常用来设计唯一的主键 index,必须是整数

类似可以自定义设置主键自增的起始值和步长

==非空 NULL not Null==

假设设置为 not null，如何不给他赋值，就会报错

NULL 如果不填写，默认为NULL

==默认：==

设置默认的值！

## 2.4 创建数据库表

```sql
--目标:创建一个schoo1数据库
--创建学生表(列,字段)使用SQL 创建
--学号int   登录密码varchar(20)   姓名,性别varchar(2)  出生日期(datatime)  家庭住址，emai1
--注意点使用英文()，表的名称和字段尽量使用括起来

-- AUTO_ INCREMENT 自增
-- COMMENT 属性注释
-- DEFAULT 默认值

--字符串使用单引号括起来!

--所有的语句后面加，(英文的)，最后一个不用加

-- PRIMARY KEY 主键，一般一个表只有一个唯一的主键!
CREATE DATABASE school
CREATE TABLE IF NOT EXISTS `student` (
`id` INT(4) NOT NULL AUTO_INCREMENT COMMENT '学号',
`name` VARCHAR(30) NOT NULL DEFAULT '匿名' COMMENT '姓名',
`pwd` VARCHAR(20) NOT NULL DEFAULT '123456' COMMENT '密码',
`sex` VARCHAR(2) NOT NULL DEFAULT '男' COMMENT '性别',
`birthday` DATETIME DEFAULT NULL COMMENT '出生日期',
`address` VARCHAR(100) DEFAULT NULL COMMENT '家庭住址',
`email` VARCHAR(50) DEFAULT NULL COMMENT '邮箱',
PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8


-- 查看建立数据库的语句
SHOW CREATE DATABASE SCHOOL
DESC STUDENT --显示表的结构
```

## 2.5数据表的类型

|              | MYISM  |       INNODB       |
| :----------: | :----: | :----------------: |
|   事务支持   | 不支持 |        支持        |
|  数据行锁定  | 不支持 |        支持        |
|   外键约束   | 不支持 |        支持        |
|   全文索引   |  支持  |       不支持       |
| 表空间的大小 |  较小  | 较大，约为2倍MYISM |



>设置数据库的字符集编码

```sql
charset=utf8
```

不设置的话，会是mysql默认的字符集编码-（不支持中文）
## 2.6 修改删除表

> 修改

-- 修改表名 ALTER TABLE 旧表面 AS 新表名


```sql
-- 修改表名 ALTER TABLE 旧表面 AS 新表名
ALTER TABLE student RENAME AS student1
-- 增加表的字段 ALTER TABLE 表名 ADD 字段名 列属性
ALTER TABLE student1 ADD age INT(11)
-- 修改表的字段（重命名，修改约束）
ALTER TABLE student1 MODIFY age VARCHAR(11)  -- 修改约束
ALTER TABLE student1 CHANGE age age1 INT(1)  -- 字段重命名,也可修改约束

-- 删除表的字段
ALTER TABLE student1 DROP age1

```

> 删除

```sql
DROP TABLE IF EXISTS `student1`
```

**所有的创建和删除操作尽量加上判断，以免报错**

==注意点：==

+ `` 字段名，使用这个包裹
+ 注释 – /**/
+ sql 关键字大小写不敏感，建议写小写
+ 所有的符号全部用英文

# 3. MySQL数据管理

## 3.1 外键（了解）

> 方法一 创建表的时候，增加约束（麻烦，比较复杂）

```sql
use school;
CREATE TABLE `grade`(
`gradeid` INT(10) NOT NULL AUTO_INCREMENT COMMENT '年级id',
`gradename` VARCHAR(50) NOT NULL COMMENT '年级名称',
PRIMARY KEY (`gradeid`)
);
-- 学生表的 gradeid 字段 要去引用年级表的gradeid
-- 定义外键KEY
-- 给这个外键添加约束（执行引用） references 引用
CREATE TABLE IF NOT EXISTS `student` (
`id` INT(4) NOT NULL AUTO_INCREMENT COMMENT '学号',
`name` VARCHAR(30) NOT NULL DEFAULT '匿名' COMMENT '姓名',
`pwd` VARCHAR(20) NOT NULL DEFAULT '123456' COMMENT '密码',
`sex` VARCHAR(2) NOT NULL DEFAULT '男' COMMENT '性别',
`birthday` DATETIME DEFAULT NULL COMMENT '出生日期',
`gradeid` INT(10) NOT NULL COMMENT '学生年级',
`address` VARCHAR(100) DEFAULT NULL COMMENT '家庭住址',
`email` VARCHAR(50) DEFAULT NULL COMMENT '邮箱',
PRIMARY KEY (`id`),
FOREIGN KEY (`gradeid`) REFERENCES `grade` (gradeid)
)ENGINE=INNODB DEFAULT CHARSET=utf8

```

**删除有外键关系的表的时候，必须先删除引用的表（从表），再删除被引用的表（主表）**

>方式二： 创建表成功后添加外键

```sql
CREATE TABLE `grade`(
`gradeid` INT(10) NOT NULL AUTO_INCREMENT COMMENT '年级id',
`gradename` VARCHAR(50) NOT NULL COMMENT '年级名称',
PRIMARY KEY (`gradeid`)
)ENGINE=INNODB DEFAULT CHARSET=utf8

-- 学生表的 gradeid 字段 要去引用年级表的gradeid
-- 定义外键KEY
-- 给这个外键添加约束（执行引用） references 引用
CREATE TABLE IF NOT EXISTS `student` (
`id` INT(4) NOT NULL AUTO_INCREMENT COMMENT '学号',
`name` VARCHAR(30) NOT NULL DEFAULT '匿名' COMMENT '姓名',
`pwd` VARCHAR(20) NOT NULL DEFAULT '123456' COMMENT '密码',
`sex` VARCHAR(2) NOT NULL DEFAULT '男' COMMENT '性别',
`birthday` DATETIME DEFAULT NULL COMMENT '出生日期',
`gradeid` INT(10) NOT NULL COMMENT '学生年级',
`address` VARCHAR(100) DEFAULT NULL COMMENT '家庭住址',
`email` VARCHAR(50) DEFAULT NULL COMMENT '邮箱',
PRIMARY KEY (`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8

-- 创建表的时候没有外键关系
ALTER TABLE `student` ADD CONSTRAINT `FK_gradeid` FOREIGN KEY (`gradeid`) REFERENCES `grade`(`gradeid`);

-- ALTER TABLE`表`  ADD CONSTRAINT 约束名 FOREIGN KEY（作为外键的列） 引用到哪个表的哪个字段
```

**以上的操作都是物理外键，数据库级别外键，不建议使用。（避免数据库过多造成困扰）**

==最佳实践==

- 数据库就是单纯的表，只用来存数据，只有行（数据）和列（字段）
- 我们想使用多张表的数据，想使用外键（程序去实现）

## 3.2 DML语言（全部记住）

**数据库意义**：数据存储，数据管理

**DML语言**：数据操作语言

- insert
- update
- delete

## 3.3 插入

> insert

```sql
-- 插入语句（添加）
-- insert into 表名（[字段一], [字段二]）values('值1'),('值2')

INSERT INTO `grade` (`gradename`) VALUES('大四')

-- 一般写插入语句，我们一定要数据和字段一一对应。
-- 插入多个字段
INSERT INTO `grade`(`gradename`) VALUES ('大二'),('大一');
--gradeid无默认值 要插入这个数据
INSERT INTO `student`(`id`,`name`,`pwd`,`sex`,`gradeid`) VALUES (1,'张三','aaaaa','男',1)
```

**语法：**`-- insert into 表名（[字段一], [字段二]）values(‘值1’),(‘值2’)`

==注意事项：==

1. 字段和字段之间用逗号分开
2. 字段可以省略，但是后面的值必须一一对应
3. 可以同时插入多条数据，VALUES后面的值需要使用，隔开即可`values('值1'),('值2')`

## 3.4 修改

> update

```sql
-- 修改学员名字

UPDATE `student` SET `name`='aaa' WHERE id =1;
-- 不指定条件的情况下，会改动所有表
UPDATE `student` SET `name`='bbb'
-- 语法；
-- UPDATE 表名 set column_name = value,[column_name = value,...] where [条件]

```

>条件：where 子句 运算符 id 等于 某个值，大于某个值，在某个区间内修改
> 操作符返回布尔值

| 操作符      | 含义                   | 范围      | 结果  |
| ----------- | ---------------------- | --------- | ----- |
| =           | 等于                   | 5=6       | false |
| != <>       | 不等于                 | 5!=6      | true  |
| >           | 大于                   |           |       |
| <           | 小于                   |           |       |
| >=          |                        |           |       |
| <=          |                        |           |       |
| between and | 在某个范围内，闭合区间 |           |       |
| and         | &&                     | 5>1and1>2 | false |
| or          | \|\|                   | 5>1or1>2  | true  |

==注意：==

- column_name 是数据库的列，带上``
- 条件，是筛选的条件，如果没有指定，则会修改所有的列
- value 是一个具体的值，也可以是一个变量
- 多个设置的属性之间，使用英文逗号隔开

```sql
UPDATE `student` SET `birthday`=CURRENT_TIME where `name`='bbb' AND SEX = '男'
```

## 3.5 删除

>delete

==语法：==`delete from 表名 [where 条件]`

```sql
-- 删除数据 (避免这样写)
DELETE FROM `student`
-- 删除指定
DELETE FROM `student` where id= 1
```

> TRUNCATE

==作用：完全清空一个数据库，表的结构和索引不会变==

==相同点： 都能删除数据，都不会删除表结构==

==不同：==

- ==TRUNCATE 重新设置自增列 计数器会归零==
- ==TRUNCATE 不会影响事务==

```sql
-- 测试delete 和 truncate 区别
CREATE TABLE `test`(
`id` INT(4) NOT NULL AUTO_INCREMENT,
`coll` VARCHAR(20) NOT NULL,
PRIMARY KEY (`id`)
)

INSERT INTO `test`(`coll`) VALUES('1'),('2'),('3')

DELETE FROM `test` -- 删除后不会影响自增

TRUNCATE TABLE `test` -- 自增会归零
```

# 4. DQL查询数据（最重点）

## 4.1DQL

(**Data Query Language**) :数据查询语言

所有的查询操作都用它 Select

简单的查询，复杂的查询它都能做

==数据库中最核心的语言==

==使用频率最高的语言==

==注意 : [ ] 括号代表可选的 , { }括号代表必选得==

```sql
create database if not exists `school`;
-- 创建一个school数据库
use `school`;-- 创建学生表
drop table if exists `student`;
create table `student`(
	`studentno` int(4) not null comment '学号',
    `loginpwd` varchar(20) default null,
    `studentname` varchar(20) default null comment '学生姓名',
    `sex` tinyint(1) default null comment '性别，0或1',
    `gradeid` int(11) default null comment '年级编号',
    `phone` varchar(50) not null comment '联系电话，允许为空',
    `address` varchar(255) not null comment '地址，允许为空',
    `borndate` datetime default null comment '出生时间',
    `email` varchar (50) not null comment '邮箱账号允许为空',
    `identitycard` varchar(18) default null comment '身份证号',
    primary key (`studentno`),
    unique key `identitycard`(`identitycard`),
    key `email` (`email`)
)engine=myisam default charset=utf8;

-- 创建年级表
drop table if exists `grade`;
create table `grade`(
	`gradeid` int(11) not null auto_increment comment '年级编号',
  `gradename` varchar(50) not null comment '年级名称',
    primary key (`gradeid`)
) engine=innodb auto_increment = 6 default charset = utf8;

-- 创建科目表
drop table if exists `subject`;
create table `subject`(
	`subjectno`int(11) not null auto_increment comment '课程编号',
    `subjectname` varchar(50) default null comment '课程名称',
    `classhour` int(4) default null comment '学时',
    `gradeid` int(4) default null comment '年级编号',
    primary key (`subjectno`)
)engine = innodb auto_increment = 19 default charset = utf8;

-- 创建成绩表
drop table if exists `result`;
create table `result`(
	`studentno` int(4) not null comment '学号',
    `subjectno` int(4) not null comment '课程编号',
    `examdate` datetime not null comment '考试日期',
    `studentresult` int (4) not null comment '考试成绩',
    key `subjectno` (`subjectno`)
)engine = innodb default charset = utf8;

-- 插入学生数据 其余自行添加 这里只添加了2行
insert into `student` (`studentno`,`loginpwd`,`studentname`,`sex`,`gradeid`,`phone`,`address`,`borndate`,`email`,`identitycard`)
values(1000,'123456','张伟',0,2,'13800001234','北京朝阳','1980-1-1','text123@qq.com','123456198001011234'),
(1001,'123456','赵强',1,3,'13800002222','广东深圳','1990-1-1','text111@qq.com','123456199001011233');

-- 插入成绩数据  这里仅插入了一组，其余自行添加
insert into `result`(`studentno`,`subjectno`,`examdate`,`studentresult`)
values(1000,1,'2013-11-11 16:00:00',85),
(1000,2,'2013-11-12 16:00:00',70),
(1000,3,'2013-11-11 09:00:00',68),
(1000,4,'2013-11-13 16:00:00',98),
(1000,5,'2013-11-14 16:00:00',58);

-- 插入年级数据
insert into `grade` (`gradeid`,`gradename`) values(1,'大一'),(2,'大二'),(3,'大三'),(4,'大四'),(5,'预科班');
insert into `subject`(`subjectno`,`subjectname`,`classhour`,`gradeid`)values
(1,'高等数学-1',110,1),
(2,'高等数学-2',110,2),
(3,'高等数学-3',100,3),
(4,'高等数学-4',130,4),
(5,'C语言-1',110,1),
(6,'C语言-2',110,2),
(7,'C语言-3',100,3),
(8,'C语言-4',130,4),
(9,'Java程序设计-1',110,1),
(10,'Java程序设计-2',110,2),
(11,'Java程序设计-3',100,3),
(12,'Java程序设计-4',130,4),
(13,'数据库结构-1',110,1),
(14,'数据库结构-2',110,2),
(15,'数据库结构-3',100,3),
(16,'数据库结构-4',130,4),
(17,'C#基础',130,1);
```

## 4.2 指定查询字段

```sql
-- 查询所有学生
select * from student;

-- 查询指定字段
select `studentno`, `studentname` from student;

-- 给结果取名字 字段或表名
select `studentno` as '学号', `studentname` as '名字' from student as s;

-- 函数 Concat(a, b)
select concat('姓名：', studentname) as 新名字 from student;
```

==语法：== `SELECT 字段 ... FROM 表`

有时候，列名字不是那么见名知意。我们起别名 AS `字段名 AS 别名 表名 AS 别名`

```sql
-- 查询所有学生
select * from student;

-- 查询指定字段
select `studentno`, `studentname` from student;

-- 给结果取名字 字段或表名
select `studentno` as '学号', `studentname` as '名字' from student as s;

-- 函数 Concat(a, b)
select concat('姓名：', studentname) as 新名字 from student;

-- 查询同学
select * from result;

select `studentno` from result;

select distinct `studentno` from result;

select version(); -- 版本

select 100*3 as 计算结果；

select @@auto_increment_increment;  --步长

-- 学院考试成绩 + 1
SELECT `studentno` , `studentresult` + 1 as '提分后' from result;
```

> 数据库中的表达式： 文本值，列，Null , 函数，计算表达式，系统变量…

`select 表达式 from 表`

## 4.3 where 条件子句

作用：检索数据中符合条件的值， 结果为布尔值

> 逻辑运算符

| 运算符  |      语法      |  结果  |
| :-----: | :------------: | :----: |
| and &&  | a and b a && b | 逻辑与 |
| or \|\| | a or b a \|\|b | 逻辑或 |
|  not !  |    not a !a    | 逻辑非 |

```sql
-- 查询成绩在95~100之间
select studentno,studentresult from result 
where studentresult >= 95 && studentresult <= 100;

select studentno,studentresult from result 
where studentresult >= 95 and studentresult <= 100;

-- 模糊查询 （区间）
select studentno,studentresult from result 
where studentresult between 95 and 100;

select studentno,studentresult from result 
where studentno != 1000;

select studentno,studentresult from result 
where not studentno = 1000;
```

> 模糊查询：比较运算符

|   运算符    |        语法        |               描述               |
| :---------: | :----------------: | :------------------------------: |
|   is null   |     a is null      |        a为null，结果为真         |
| is not null |   a is not null    |       a不为null，结果为真        |
|   between   | a between b and c  |      a在b和c之间，结果为真       |
|    like     |      a like b      |  sql匹配，如果a匹配b，结果为真   |
|     in      | a in(a1,a2,a3,…..) | 如果a在(a1,a2,a3…)之间，结果为真 |

```sql
-- like

-- 模糊查询 %（代表0到任意个字符）_一个字符 不能用等号 like
-- 姓张的
select studentno, studentname from student where studentname like '张%';

-- 张 名字只有一个字
select studentno, studentname from student 
where studentname like '张_';

-- 查询名字中有三的 %三%
select studentno, studentname from student 
where studentname like '%三%';

-- in
-- 查询 1001 1002 1003号学员
select studentno, studentname from student 
where studentno in (1001,1002,1003);

select studentno, studentname from student 
where address in ('%深圳%','北京');

select studentno, studentname from student 
where borndate is not null;
```

## 4.4 联表查询

>join 对比

![](https://raw.githubusercontent.com/cute-karl/studyimage/main/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202023-09-10%20110021.png)

![](https://raw.githubusercontent.com/cute-karl/studyimage/main/d4td8mva.bmp)

|    操作    |                     描述                     |
| :--------: | :------------------------------------------: |
| inner join |       如果表中至少有一个匹配，就返回行       |
| left join  | 即使左表中没有匹配，也会从左表中返回所有的值 |
| right join | 即使右表中没有匹配，也会从右表中返回所有的值 |

```sql
-- 联表查询

-- 查询参加了考试的同学（学号，姓名，科目编号，分数）
select * from student;
select * from  result;

/*
1. 分析需求，分析查询的字段来自哪些表
2.确定使用哪种连接查询？7种
确定交叉点（这两个表中哪个数据是相同的）
判断的条件： 学生表中 studentNo = 成绩表中 studentNo 
*/

-- join on(条件判断) 连接查询
-- where 等值查询

-- inner join

select s.studentno, studentname, subjectno, studentresult 
from student as s 
inner join result as r
on s.studentno = r.studentno

-- right join
select s.studentno, studentname, subjectno, studentresult 
from student s 
right join result r
on s.studentno = r.studentno

-- left join
select s.studentno, studentname, subjectno, studentresult 
from student s 
left join result r
on s.studentno = r.studentno

-- 查询缺考的同学
select s.studentno, studentname, subjectno, studentresult 
from student s 
left join result r
on s.studentno = r.studentno
where studentresult is null

-- 思考题(查询了参加考试的同学信息：学号 姓名 科目 分数)

/*
1. 分析需求，分析查询的字段来自哪些表 student result subject
2.确定使用哪种连接查询？7种
确定交叉点（这两个表中哪个数据是相同的）
判断的条件： 学生表中 studentNo = 成绩表中 studentNo 
*/

select s.studentno,studentname,subjectname,studentresult
from student s 
right join result r
on r.studentno = s.studentno
inner join `subject` sub on r.subjectno = sub.subjectno

-- 查询学员所属的年级（学号，姓名，年级）
select studentno,studentname,gradename
from student s
inner join grade g
on s.gradeid = g.gradeid

-- 查询参加c语言-2考试的同学信息 学号 姓名 科目名 分数
select s.studentno,studentname,subjectname,studentresult
from student s
inner join result r
on s.studentno = r.studentno
inner join subject sub
on r.subjectno = sub.subjectno
where sub.subjectname = 'C语言-2'

-- 我要查询哪些数据 select ....
-- 从哪几个表中查 from 表 xxx join 连接的表 on 交叉条件
-- 假设存在一中多张表查询，先查询两章表，然后再慢慢增加

-- from a left join b   左为准
-- from a right join b	右为准
```

> 自连接

```sql
CREATE TABLE `category`(
 `categoryid` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主题id',
 `pid` INT(10) NOT NULL COMMENT '父id',
 `categoryname` VARCHAR(50) NOT NULL COMMENT '主题名字',
PRIMARY KEY (`categoryid`) 
 ) ENGINE=INNODB  AUTO_INCREMENT=9 DEFAULT CHARSET=utf8; 

INSERT INTO `category` (`categoryid`, `pid`, `categoryname`) 
VALUES ('2','1','信息技术'),
('3','1','软件开发'),
('5','1','美术设计'),
('4','3','数据库'),
('8','2','办公信息'),
('6','3','web开发'),
('7','5','ps技术');
```

==自己的表跟自己的表连接，核心：一张表拆为两张一样的表==

父类

| categoryid | categoryname |
| :--------: | :----------: |
|     2      |   信息技术   |
|     3      |   软件开发   |
|     5      |   美术设计   |

子类

| pid  | categoryid | categoryname |
| :--: | :--------: | :----------: |
|  3   |     4      |    数据库    |
|  2   |     8      |   办公信息   |
|  3   |     6      |   web开发    |
|  5   |     7      |   美术设计   |

操作：查询父类对应子类关系

|   父类   |   子类   |
| :------: | :------: |
| 信息技术 | 办公信息 |
| 软件开发 |  数据库  |
| 软件开发 | web开发  |
| 美术设计 |  ps技术  |

```sql
-- 查询父子信息
select a.categoryname as '父栏目',b.categoryname as '子栏目'
from category a, category b
where a.categoryid = b.pid
```

## 4.5 分页和排序

> 排序

```sql
--  排序 升序asc 降序 desc 
-- order by 通过哪个字段排序 顺序
select s.studentno,studentname,subjectname,studentresult
from student s
inner join result r
on s.studentno = r.studentno
inner join subject sub
on r.subjectno = sub.subjectno
where sub.subjectname = 'C语言-2'
order by studentresult asc
```

> 分页

```sql
-- 为什么要分页
-- 缓解数据库压力，给人的体验更好
-- 分页，每页显示五条数据

-- 语法： limit 当前页，页面的大小
-- limit 0,5 1-5
-- limit 1,5 1-5
-- limit 6,5
SELECT s.`StudentNo`,`StudentName`,`SubjectName`,`StudentResult`
FROM student s
INNER JOIN `result` r
ON s.`StudentNo`=r.`StudentNo`
INNER JOIN `subject` sub
ON r.`subjectNo`=sub.`subjectNo`
WHERE subjectName='数据结构-1'
ORDER BY StudentResult ASC
LIMIT 0,5

-- 第一页 limit 0,5
-- 第二页 limit 5,5
-- 第三页 limit 10,5
-- 第N页 limit pagesize*（n-1）,pagesize
-- pagesize
-- [pagesize*（n-1）,pagesize]
-- n 当前页
-- 【数据总数/页面大小=总页数】
```

语法 `limit(查询起始下标，pagesize)`

```sql
select s.studentno,studentname,subjectname,studentresult
from student s
inner join result r
on s.studentno = r.studentno
inner join subject sub
on r.subjectno = sub.subjectno
where subjectname = '高等数学-1' and studentresult >= 80
order by studentresult desc
limit 0,10
```

## 4.6 子查询

where (这个值是计算出来的)
本质：==在where语句中嵌套一个子查询语句==

```sql
/*============== 子查询 ================
什么是子查询?
   在查询语句中的WHERE条件子句中,又嵌套了另一个查询语句
   嵌套查询可由多个子查询组成,求解的方式是由里及外;
   子查询返回的结果一般都是集合,故而建议使用IN关键字;
*/

-- 查询 数据库结构-1 的所有考试结果(学号,科目编号,成绩),并且成绩降序排列
-- 方法一:使用连接查询
SELECT studentno,r.subjectno,StudentResult
FROM result r
INNER JOIN `subject` sub
ON r.`SubjectNo`=sub.`SubjectNo`
WHERE subjectname = '数据库结构-1'
ORDER BY studentresult DESC;

-- 方法二:使用子查询(执行顺序:由里及外)
SELECT studentno,subjectno,StudentResult
FROM result
WHERE subjectno=(
   SELECT subjectno FROM `subject`
   WHERE subjectname = '数据库结构-1'
)
ORDER BY studentresult DESC;

-- 查询课程为 高等数学-2 且分数不小于80分的学生的学号和姓名
-- 方法一:使用连接查询
SELECT s.studentno,studentname
FROM student s
INNER JOIN result r
ON s.`StudentNo` = r.`StudentNo`
INNER JOIN `subject` sub
ON sub.`SubjectNo` = r.`SubjectNo`
WHERE subjectname = '高等数学-2' AND StudentResult>=80

-- 方法二:使用连接查询+子查询
-- 分数不小于80分的学生的学号和姓名
SELECT r.studentno,studentname FROM student s
INNER JOIN result r ON s.`StudentNo`=r.`StudentNo`
WHERE StudentResult>=80

-- 在上面SQL基础上,添加需求:课程为 高等数学-2
SELECT r.studentno,studentname FROM student s
INNER JOIN result r ON s.`StudentNo`=r.`StudentNo`
WHERE StudentResult>=80 AND subjectno=(
   SELECT subjectno FROM `subject`
   WHERE subjectname = '高等数学-2'
)

-- 方法三:使用子查询
-- 分步写简单sql语句,然后将其嵌套起来
SELECT studentno,studentname FROM student WHERE studentno IN(
   SELECT studentno FROM result WHERE StudentResult>=80 AND subjectno=(
       SELECT subjectno FROM `subject` WHERE subjectname = '高等数学-2'
  )
)
```

## 4.7 分组和过滤

```sql
 -- 查询不同课程的平均分,最高分,最低分
 -- 前提:根据不同的课程进行分组
 
 SELECT subjectname,AVG(studentresult) AS 平均分,MAX(StudentResult) AS 最高分,MIN(StudentResult) AS 最低分
 FROM result AS r
 INNER JOIN `subject` AS s
 ON r.subjectno = s.subjectno
 GROUP BY r.subjectno
 HAVING 平均分>80;
 
 /*
 where写在group by前面.
 要是放在分组后面的筛选
 要使用HAVING..
 因为having是从前面筛选的字段再筛选，而where是从数据表中的>字段直接进行的筛选的
 */	
```

## 4.8 select 小结

>SELECT语法

```sql
SELECT [ALL | DISTINCT]
{* | table.* | [table.field1[as alias1][,table.field2[as alias2]][,...]]}
FROM table_name [as table_alias]
  [left | right | inner join table_name2]  -- 联合查询
  [WHERE ...]  -- 指定结果需满足的条件
  [GROUP BY ...]  -- 指定结果按照哪几个字段来分组
  [HAVING]  -- 过滤分组的记录必须满足的次要条件
  [ORDER BY ...]  -- 指定查询记录按一个或多个条件排序
  [LIMIT {[offset,]row_count | row_countOFFSET offset}];
   -- 指定查询的记录从哪条至哪条
```

# 5. MySQL函数

官网：https://dev.mysql.com/doc/refman/8.0/en/built-in-function-reference.html

## 5.1 常用函数

```sql
-- 数学运算

SELECT ABS(-8) -- 绝对值
SELECT CEILING(9.4) -- 向上取整
SELECT FLOOR(9.4)  -- 向下取整
SELECT RAND() -- 返回0-1随机数
SELECT SIGN(-10) -- 判断一个数的符号 0-0 负数返回-1 正数返回1

-- 字符串函数
SELECT CHAR_LENGTH('2323232') -- 返回字符串长度
SELECT CONCAT('我','233') -- 拼接字符串
SELECT INSERT('java',1,2,'cccc') -- 从某个位置开始替换某个长度
SELECT UPPER('abc') 
SELECT LOWER('ABC')
SELECT REPLACE('坚持就能成功','坚持','努力')

-- 查询姓 周 的同学 ，改成邹
SELECT REPLACE(studentname,'周','邹') FROM student
WHERE studentname LIKE '周%'

-- 时间跟日期函数（记住）
SELECT CURRENT_DATE() -- 获取当前日期
SELECT CURDATE() -- 获取当前日期
SELECT NOW() -- 获取当前日期
SELECT LOCATIME()  -- 本地时间
SELECT SYSDATE()  -- 系统时间

SELECT YEAR(NOW())
SELECT MONTH(NOW())
SELECT DAY(NOW())
SELECT HOUR(NOW())
SELECT MINUTE(NOW())
SELECT SECOND(NOW())

-- 系统
SELECT SYSTEM_USER()
SELECT USER()
SELECT VERSION()
```

## 5.2 聚合函数（常用）

| 函数名称 |  描述  |
| :------: | :----: |
| COUNT()  |  计数  |
|  SUM()   |  求和  |
|  AVG()   | 平均值 |
|  MAX()   | 最大值 |
|  MIN()   | 最小值 |

```sql
-- 聚合函数
 /*COUNT:非空的*/
 SELECT COUNT(studentname) FROM student;
 SELECT COUNT(*) FROM student;
 SELECT COUNT(1) FROM student;  /*推荐*/
 
 -- 从含义上讲，count(1) 与 count(*) 都表示对全部数据行的查询。
 -- count(字段) 会统计该字段在表中出现的次数，忽略字段为null 的情况。即不统计字段
 为null 的记录。
 -- count(*) 包括了所有的列，相当于行数，在统计结果的时候，包含字段为null 的记录；
 -- count(1) 用1代表代码行，在统计结果的时候，包含字段为null 的记录 。
 /*
 很多人认为count(1)执行的效率会比count(*)高，原因是count(*)会存在全表扫描，
 而count(1)可以针对一个字段进行查询。其实不然，count(1)和count(*)都会对全表进行扫描，
 统计所有记录的条数，包括那些为null的记录，因此，它们的效率可以说是相差无几。而
 count(字段)则与前两者不同，它会统计该字段不为null的记录条数。
 
 下面它们之间的一些对比：
 
 1）在表没有主键时，count(1)比count(*)快
 2）有主键时，主键作为计算条件，count(主键)效率最高；
 3）若表格只有一个字段，则count(*)效率较高。
 */
 
 SELECT SUM(StudentResult) AS 总和 FROM result;
 SELECT AVG(StudentResult) AS 平均分 FROM result;
 SELECT MAX(StudentResult) AS 最高分 FROM result;
 SELECT MIN(StudentResult) AS 最低分 FROM result;
```

## 5.3 数据库级别的MD5加密（扩展）

>MD5简介

MD5即Message-Digest Algorithm 5（信息-摘要算法5），用于确保信息传输完整一致。是计算机广泛使用的杂凑算法之一（又译摘要算法、哈希算法），主流编程语言普遍已有MD5实现。将数据（如汉字）运算为另一固定长度值，是杂凑算法的基础原理，MD5的前身有MD2、MD3和MD4

>实现数据加密

**新建一个表 testmd5**

```sql
CREATE TABLE `testmd5` (
 `id` INT(4) NOT NULL,
 `name` VARCHAR(20) NOT NULL,
 `pwd` VARCHAR(50) NOT NULL,
 PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8

-- 插入一些数据
INSERT INTO testmd5 VALUES(1,'kuangshen','123456'),(2,'qinjiang','456789')

-- 如果我们要对pwd这一列数据进行加密，语法是：
update testmd5 set pwd = md5(pwd);

-- 如果单独对某个用户(如kuangshen)的密码加密：
INSERT INTO testmd5 VALUES(3,'kuangshen2','123456')
update testmd5 set pwd = md5(pwd) where name = 'kuangshen2';

-- 插入新的数据自动加密
INSERT INTO testmd5 VALUES(4,'kuangshen3',md5('123456'));

-- 查询登录用户信息（md5对比使用，查看用户输入加密后的密码进行比对）
SELECT * FROM testmd5 WHERE `name`='kuangshen' AND pwd=MD5('123456');

```

## 5.4 小结

```sql
-- ================ 内置函数 ================
 -- 数值函数
 abs(x)            -- 绝对值 abs(-10.9) = 10
 format(x, d)    -- 格式化千分位数值 format(1234567.456, 2) = 1,234,567.46
 ceil(x)            -- 向上取整 ceil(10.1) = 11
 floor(x)        -- 向下取整 floor (10.1) = 10
 round(x)        -- 四舍五入去整
 mod(m, n)        -- m%n m mod n 求余 10%3=1
 pi()            -- 获得圆周率
 pow(m, n)        -- m^n
 sqrt(x)            -- 算术平方根
 rand()            -- 随机数
 truncate(x, d)    -- 截取d位小数
 
 -- 时间日期函数
 now(), current_timestamp();     -- 当前日期时间
 current_date();                    -- 当前日期
 current_time();                    -- 当前时间
 date('yyyy-mm-dd hh:ii:ss');    -- 获取日期部分
 time('yyyy-mm-dd hh:ii:ss');    -- 获取时间部分
 date_format('yyyy-mm-dd hh:ii:ss', '%d %y %a %d %m %b %j');    -- 格式化时间
 unix_timestamp();                -- 获得unix时间戳
 from_unixtime();                -- 从时间戳获得时间
 
 -- 字符串函数
 length(string)            -- string长度，字节
 char_length(string)        -- string的字符个数
 substring(str, position [,length])        -- 从str的position开始,取length个字符
 replace(str ,search_str ,replace_str)    -- 在str中用replace_str替换search_str
 instr(string ,substring)    -- 返回substring首次在string中出现的位置
 concat(string [,...])    -- 连接字串
 charset(str)            -- 返回字串字符集
 lcase(string)            -- 转换成小写
 left(string, length)    -- 从string2中的左边起取length个字符
 load_file(file_name)    -- 从文件读取内容
 locate(substring, string [,start_position])    -- 同instr,但可指定开始位置
 lpad(string, length, pad)    -- 重复用pad加在string开头,直到字串长度为length
 ltrim(string)            -- 去除前端空格
 repeat(string, count)    -- 重复count次
 rpad(string, length, pad)    --在str后用pad补充,直到长度为length
 rtrim(string)            -- 去除后端空格
 strcmp(string1 ,string2)    -- 逐字符比较两字串大小
 
 -- 聚合函数
 count()
 sum();
 max();
 min();
 avg();
 group_concat()
 
 -- 其他常用函数
 md5();
 default();

```

# 6. 事务

## 6.1 什么是事务

- 事务就是将一组SQL语句放在同一批次内去执行
- 如果一个SQL语句出错,则该批次内的所有SQL都将被取消执行
- MySQL事务处理只支持InnoDB和BDB数据表类型

---

SQL执行， A给B转账 A 1000–> 200 B 200
 SQL 执行， B收到A的钱 A 800 — B 400
 将一组SQL放在一个批次中执行

---

>事务原则 ： ACID原则 原子性，一致性，隔离性，持久性 （脏读，幻读…）

==原子性（Atomicity）==

要么都成功，要么都失败,不能只发生一个

==一致性（Consistency）==

事务前后的数据完整性要保持一致

==持久性（Durability）==

事务没有提交，恢复到原状（宕机），事务一旦提交就不可逆转，被持久化到数据库中

==隔离性（Isolation）==

事务产生多并发时，互不干扰	

>隔离产生的问题

==脏读：==

指一个事务读取了另外一个事务未提交的数据。

==不可重复读：==

在一个事务内读取表中的某一行数据，多次读取结果不同。（这个不一定是错误，只是某些场合不对）

==虚读(幻读)==

是指在一个事务内读取到了别的事务插入的数据，导致前后读取不一致。
 （一般是行影响，多了一行）

>执行事务

```sql
-- mysql 自动开启事务提交
SET autocommit=0 -- 关闭
SET autocommit=1 -- 开启（默认的）

-- 手动处理事务
SET autocommit =0 -- 关闭自动提交

-- 事务开启

START TRANSACTION -- 标记一个事务的开始，从这个之后的SQP都在同一个事务内

INSERT XX
INSERT XX

-- 提交 ： 持久化(成功)
COMMIT 
-- 回滚：  回到原来的样子（失败）
ROLLBACK
-- 事务结束
SET autocommit = 1 -- 开启自动提交
-- 了解
SAVEPOINT 保存点名称 -- 设置一个事务的保存点
ROLLBACK TO SAVEPOINT 保存点名 -- 回滚到保存点
RELEASE SAVEPOINT 保存点 -- 删除保存点
```

>测试

```sql
/*
课堂测试题目

A在线买一款价格为500元商品,网上银行转账.
A的银行卡余额为2000,然后给商家B支付500.
商家B一开始的银行卡余额为10000

创建数据库shop和创建表account并插入2条数据
*/

CREATE DATABASE `shop`CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `shop`;

CREATE TABLE `account` (
`id` INT(11) NOT NULL AUTO_INCREMENT,
`name` VARCHAR(32) NOT NULL,
`cash` DECIMAL(9,2) NOT NULL,
PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8

INSERT INTO account (`name`,`cash`)
VALUES('A',2000.00),('B',10000.00)

-- 转账实现
SET autocommit = 0; -- 关闭自动提交
START TRANSACTION;  -- 开始一个事务,标记事务的起始点
UPDATE account SET cash=cash-500 WHERE `name`='A';
UPDATE account SET cash=cash+500 WHERE `name`='B';
COMMIT; -- 提交事务
# rollback; --回滚
SET autocommit = 1; -- 恢复自动提交
```

# 7. 索引

>MySQL索引的建立对于MySQL的高效运行是很重要的，索引可以大大提高MySQL的检索速度。

>索引的作用

- 提高查询速度
- 确保数据的唯一性
- 可以加速表和表之间的连接 , 实现表与表之间的参照完整性
- 使用分组和排序子句进行数据检索时 , 可以显著减少分组和排序的时间
- 全文检索字段进行搜索优化.

## 7.1 索引的分类

>在一个表中，主键索引只能有一个，唯一索引可以有多个

+ 主键索引 （PRIMARY KEY）
	+ 唯一的标识，主键不可重复，只能有一个列作为主键

+ 唯一索引 （UNIQUE KEY）
	+ 避免重复的列出现，唯一索引可以重复，多个列都可以标识唯一索引

+ 常规索引（KEY/INDEX）
	+ 默认的，index,key关键字来设置

+ 全文索引（FULLTEXT）
	+ 在特点的数据库引擎下才有，MyISAM
	+ 快速定位数据

```sql
/*
#方法一：创建表时
  　　CREATE TABLE 表名 (
               字段名1 数据类型 [完整性约束条件…],
               字段名2 数据类型 [完整性约束条件…],
               [UNIQUE | FULLTEXT | SPATIAL ]   INDEX | KEY
               [索引名] (字段名[(长度)] [ASC |DESC])
               );


#方法二：CREATE在已存在的表上创建索引
       CREATE [UNIQUE | FULLTEXT | SPATIAL ] INDEX 索引名
                    ON 表名 (字段名[(长度)] [ASC |DESC]) ;


#方法三：ALTER TABLE在已存在的表上创建索引
       ALTER TABLE 表名 ADD [UNIQUE | FULLTEXT | SPATIAL ] INDEX
                            索引名 (字段名[(长度)] [ASC |DESC]) ;
                           
                           
#删除索引：DROP INDEX 索引名 ON 表名字;
#删除主键索引: ALTER TABLE 表名 DROP PRIMARY KEY;


#显示索引信息: SHOW INDEX FROM student;
*/

/*增加全文索引*/
ALTER TABLE `school`.`student` ADD FULLTEXT INDEX `studentname` (`StudentName`);

/*EXPLAIN : 分析SQL语句执行性能*/
EXPLAIN SELECT * FROM student WHERE studentno='1000';

/*使用全文索引*/
-- 全文搜索通过 MATCH() 函数完成。
-- 搜索字符串作为 against() 的参数被给定。搜索以忽略字母大小写的方式执行。对于表中的每个记录行，MATCH() 返回一个相关性值。即，在搜索字符串与记录行在 MATCH() 列表中指定的列的文本之间的相似性尺度。
EXPLAIN SELECT *FROM student WHERE MATCH(studentname) AGAINST('love');

/*
开始之前，先说一下全文索引的版本、存储引擎、数据类型的支持情况

MySQL 5.6 以前的版本，只有 MyISAM 存储引擎支持全文索引；
MySQL 5.6 及以后的版本，MyISAM 和 InnoDB 存储引擎均支持全文索引;
只有字段的数据类型为 char、varchar、text 及其系列才可以建全文索引。
测试或使用全文索引时，要先看一下自己的 MySQL 版本、存储引擎和数据类型是否支持全文索引。
*/

```

## 7.3 测试索引

```sql
CREATE TABLE `app_user` (
`id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
`name` VARCHAR(50) DEFAULT '',
`email` VARCHAR(50) NOT NULL,
`phone` VARCHAR(20) DEFAULT '',
`gender` TINYINT(4) UNSIGNED DEFAULT '0',
`password` VARCHAR(100) NOT NULL DEFAULT '',
`age` TINYINT(4) DEFAULT NULL,
`create_time` DATETIME DEFAULT CURRENT_TIMESTAMP,
`update_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8

-- 插入100万数据
DELIMITER $$ --  写函数之前必写
CREATE FUNCTION mock_data()
RETURNS INT 
BEGIN
DECLARE num INT DEFAULT 1000000;
DECLARE i INT DEFAULT 0;

WHILE i<num DO
-- 插入语句
INSERT INTO app_user(`name`,`email`,`phone`,`gender`,`password`,`age`)
VALUE(CONCAT('用户',i),'534240118@qq.com',FLOOR (CONCAT('18',RAND()*9999999)),FLOOR (RAND()*2),
UUID(),FLOOR (RAND()*100));

SET i = i+1;
END WHILE;
RETURN i;


END;

INSERT INTO app_user(`name`,`email`,`phone`,`gender`,`password`,`age`)
VALUE(CONCAT('用户',i),'534240118@qq.com',FLOOR (CONCAT('18',RAND()*9999999)),FLOOR (RAND()*2),
UUID(),FLOOR (RAND()*100))


SELECT mock_data();

SELECT * FROM app_user WHERE `name`='用户9999' -- 接近半秒

EXPLAIN SELECT * FROM app_user WHERE `name`='用户9999'  -- 查询99999条记录

-- id _ 表名_字段名
-- create index on 字段
CREATE INDEX id_app_user_name ON app_user(`name`); -- 0.001 s
EXPLAIN SELECT * FROM app_user WHERE `name`='用户9999'  -- 查询一条记录
```

索引在小数据的时候，用处不大，但是在大数据的时候，区别十分明显

## 7.3 索引原则

- 索引不是越多越好
- 不要对经常变动的数据加索引
- 小数据量的表不需要加索引
- 索引一般加在常用来查询的字段上

# 8. 权限管理和备份

## 8.1 用户管理

>Navicat可视化管理

>SQL命令操作

用户表：mysql.user

本质：对这张表进行，增删改查	

```sql
-- 创建用户  CREATE USER 用户名 IDENTIFIED BY '密码'
CREATE USER sanjin IDENTIFIED BY '123456'

-- 修改密码（修改当前密码）
SET PASSWORD = PASSWORD('111111')


-- 修改密码（修改指定用户密码）

SET PASSWORD FOR sanjin = PASSWORD('111111')


-- 重命名  rename user 原名字 to 新名字
RENAME USER sanjin TO sanjin2

-- 用户授权   ALL PRIVILEGES 全部的权限   库，表
-- ALL PRIVILEGES 除了给别人授权，其他都能干
GRANT ALL PRIVILEGES ON *.* TO sanjin2

-- 查询权限
SHOW GRANTS FOR sanjin2  -- 查看指定用户的权限
SHOW GRANTS FOR root@localhost


-- 撤销权限 REVOKE 哪些权限，在哪个库撤销，给谁撤销
REVOKE ALL PRIVILEGES ON *.* FROM sanjin2

-- 删除用户
DROP USER sanjin2

```

## 8.2 MySQL备份

为什么备份：

- 保证重要数据不丢失
- 数据转移

MySQL数据库备份的方式

- 直接拷贝物理文件
- 数据库管理工具- 在想要导出的表或者库中，右键选择备份和导出
- 直接拷贝数据库文件和相关配置文件

**mysqldump客户端**

作用 :

- 转储数据库
- 搜集数据库进行备份
- 将数据转移到另一个SQL服务器,不一定是MySQL服务器

```sql
-- 导出
1. 导出一张表 -- mysqldump -uroot -p123456 school student >D:/a.sql
　　mysqldump -u用户名 -p密码 库名 表名 > 文件名(D:/a.sql)
2. 导出多张表 -- mysqldump -uroot -p123456 school student result >D:/a.sql
　　mysqldump -u用户名 -p密码 库名 表1 表2 表3 > 文件名(D:/a.sql)
3. 导出所有表 -- mysqldump -uroot -p123456 school >D:/a.sql
　　mysqldump -u用户名 -p密码 库名 > 文件名(D:/a.sql)
4. 导出一个库 -- mysqldump -uroot -p123456 -B school >D:/a.sql
　　mysqldump -u用户名 -p密码 -B 库名 > 文件名(D:/a.sql)

可以-w携带备份条件

-- 导入
1. 在登录mysql的情况下：-- source D:/a.sql
　　source 备份文件
2. 在不登录的情况下
　　mysql -u用户名 -p密码 库名 < 备份文件
```

# 9. 规范数据库设计

## 9.1 为什么需要数据库设计

==当数据库比较复杂时我们需要设计数据库==

**糟糕的数据库设计 :**

- 数据冗余,存储空间浪费
- 数据更新和插入的异常
- 程序性能差

**良好的数据库设计 :**

- 节省数据的存储空间
- 能够保证数据的完整性
- 方便进行数据库应用系统的开发

**软件项目开发周期中数据库设计 :**

- 需求分析阶段: 分析客户的业务和数据处理需求
- 概要设计阶段:设计数据库的E-R模型图 , 确认需求信息的正确和完整.

**设计数据库步骤**

+ 收集信息
+ 与该系统有关人员进行交流 , 座谈 , 充分了解用户需求 , 理解数据库需要完成的任务.
+ 标识实体[Entity]
+ 标识数据库要管理的关键对象或实体,实体一般是名词
+ 标识每个实体需要存储的详细信息[Attribute]
+ 标识实体之间的关系[Relationship]

## 9.2 三大范式

**问题 : 为什么需要数据规范化?**

不合规范的表设计会导致的问题：

- 信息重复
- 更新异常
- 插入异常
- 无法正确表示信息
- 删除异常
- 丢失有效信息

>三大范式

**第一范式 (1st NF)**

第一范式的目标是确保每列的原子性,如果每列都是不可再分的最小数据单元,则满足第一范式

**第二范式(2nd NF)**

第二范式（2NF）是在第一范式（1NF）的基础上建立起来的，即满足第二范式（2NF）必须先满足第一范式（1NF）。

第二范式要求每个表只描述一件事情

**第三范式(3rd NF)**

如果一个关系满足第二范式,并且除了主键以外的其他列都不传递依赖于主键列,则满足第三范式.

第三范式需要确保数据表中的每一列数据都和主键直接相关，而不能间接相关。

**规范化和性能的关系**

为满足某种商业目标 , 数据库性能比规范化数据库更重要

在数据规范化的同时 , 要综合考虑数据库的性能

通过在给定的表中添加额外的字段,以大量减少需要从中搜索信息所需的时间

通过在给定的表中插入计算列,以方便查询

# 10. JDBC（重点）

## 10.1 数据库驱动

驱动：声卡，显卡，数据库

![](https://raw.githubusercontent.com/cute-karl/studyimage/main/20230913170536.png)

我们的程序会通过数据库驱动，和数据库打交道！

## 10.2 JDBC

SUN 公司为了简化开发人员的（对数据库的统一）操作，提供了一个(Java操作数据库的)规范，JDBC

这些规范的实现由具体的厂商去做

对于开发人员来说，我们只需要掌握JDBC的接口操作即可

![](https://raw.githubusercontent.com/cute-karl/studyimage/main/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202023-09-13%20170708.png)

java.sql

javax.sql

还需要导入数据库驱动包

## 10.3 第一个JDBC程序

>创建测试数据库

```sql
CREATE DATABASE jdbcStudy CHARACTER SET utf8 COLLATE utf8_general_ci;

USE jdbcStudy;

CREATE TABLE `users`(
id INT PRIMARY KEY,
NAME VARCHAR(40),
PASSWORD VARCHAR(40),
email VARCHAR(60),
birthday DATE
);

INSERT INTO `users`(id,NAME,PASSWORD,email,birthday)
VALUES(1,'zhansan','123456','zs@sina.com','1980-12-04'),
(2,'lisi','123456','lisi@sina.com','1981-12-04'),
(3,'wangwu','123456','wangwu@sina.com','1979-12-04')

```

1.创建一个普通项目或maven项目

2.导入数据库驱动

- 普通项目
	
