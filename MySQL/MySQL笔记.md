# 1、初识

> 什么是数据库

数据库 ( **DataBase** , 简称**DB** )

**概念** : 长期存放在计算机内,有组织,可共享的大量数据的集合,是一个数据 "仓库"

**作用** : 保存,并能安全管理数据(如:增删改查等),减少冗余...

**数据库总览 :**

- 关系型数据库 ( SQL )

- - MySQL , Oracle , SQL Server , SQLite , DB2 , ...
	- 关系型数据库通过外键关联来建立表与表之间的关系

- 非关系型数据库 ( NOSQL )

- - Redis , MongoDB , ...
	- 非关系型数据库通常指数据以对象的形式存储在数据库中，而对象之间的关系通过每个对象自身的属性来决定

> 什么是DBMS

数据库管理系统 ( **D**ata**B**ase **M**anagement **S**ystem )

数据库管理软件 , 科学组织和存储数据 , 高效地获取和维护数据

> MySQL简介

**概念 :** 是现在**流行**的**开源**的,**免费**的 **关系型**数据库

**历史 :** 由瑞典MySQL AB 公司开发，目前属于 Oracle 旗下产品。

**特点 :** 

- 免费 , 开源数据库
- 小巧 , 功能齐全
- 使用便捷
- 可运行于Windows或Linux操作系统
- 可适用于中小型甚至大型网站应用

**官网 :** **https://www.mysql.com/**

> SQLyog

可手动操作,管理MySQL数据库的软件工具

特点 : 简洁 , 易用 , 图形化

> 连接数据库

打开MySQL命令窗口

- 在DOS命令行窗口进入 **安装目录\mysql\bin**
- 可设置环境变量，设置了环境变量，可以在任意目录打开！

**连接数据库语句 :** mysql -h 服务器主机地址 -u 用户名 -p 用户密码

注意 : -p后面不能加空格,否则会被当做密码的内容,导致登录失败 !

**几个基本的数据库操作命令 :**

```mysql
-- 所有语句都用;结尾
update user set password=password('123456')where user='root'; 修改密码
flush privileges; 刷新数据库
show databases; 显示所有数据库
use dbname；打开某个数据库
show tables; 显示数据库mysql中所有的表
describe user; 显示表mysql数据库中user表的列信息
create database name; 创建数据库
use databasename; 选择数据库

exit; 退出Mysql
? 命令关键词 : 寻求帮助
-- 表示单行注释
/* 
多行注释
*/
```

# 2、数据库操作

## 2.1 结构化查询语句分类

| 名称                | 解释                                         | 命令                    |
| ------------------- | -------------------------------------------- | ----------------------- |
| DDL（数据定义语言） | 定义和管理数据对象，如数据库、数据表等       | CREATE、DROP、ALTER     |
| DML（数据操作语言） | 用于操作数据库对象中所包含的语言             | INSERT、UPDATE、DELETE  |
| DQL（数据查询语言） | 用于查询数据库数据                           | SELECT                  |
| DCL（数据控制语言） | 用于管理数据库的语言，包括管理权限及数据更改 | GRANT、commit、rollback |

## 2.2 数据库操作

> 命令行操作数据库

**如果表名或字段名是一个特殊字符就要带``**

创建数据库 :  create database [if not exists] 数据库名;

删除数据库 : drop database [if exists] 数据库名;

查看数据库 : show databases;

使用数据库 : use 数据库名;

> 对比工具操作数据库

**学习方法：**

- 对照SQLyog工具自动生成的语句学习
- 固定语法中的单词需要记忆

## 2.3 创建数据表

属于DDL的一种，语法 :

```mysql
create table [if not exists] `表名`(
   '字段名1' 列类型 [属性][索引][注释],
   '字段名2' 列类型 [属性][索引][注释],
  #...
   '字段名n' 列类型 [属性][索引][注释]
)[表类型][表字符集][注释];
```

**说明 :** 反引号用于区别MySQL保留字与普通字符而引入的 (键盘esc下面的键).

## 2.4 数据值和列类型

列类型 : 规定数据库中该列存放的数据类型

> 数值类型

| 类型      | 说明               | 取值范围                                                     | 存储需求 |
| --------- | ------------------ | ------------------------------------------------------------ | -------- |
| tinyint   | 非常小的数据       | 有符值：-2<sup>7</sup>~2<sup>7</sup>-1<br/>无符号值：0 ~ 2<sup>8</sup>-1 | 1字节    |
| smallint  | 较小的数据         | 有符值：-2<sup>15</sup>~2<sup>15</sup>-1<br/>无符号值：0 ~ 2<sup>16</sup>-1 | 2字节    |
| mediumint | 中等大小的数据     | 有符值：-2<sup>23</sup>~2<sup>23</sup>-1<br/>无符号值：0 ~ 2<sup>24</sup>-1 | 3字节    |
| **int**   | 标准整数           | 有符值：-2<sup>31</sup>~2<sup>31</sup>-1<br/>无符号值：0 ~ 2<sup>32</sup>-1 | 4字节    |
| bigint    | 较大的整数         | 有符值：-2<sup>63</sup>~2<sup>63</sup>-1<br/>无符号值：0 ~ 2<sup>64</sup>-1 | 8字节    |
| float     | 单精度浮点数       | ±1.1754351e-38                                               | 4字节    |
| double    | 双精度浮点数       | ±2.2250738585072014e-308                                     | 8字节    |
| decimal   | 字符串形式的浮点数 | decimal(m, d)                                                | ..字节   |

> 字符串类型

| 类型               | 说明                                            | 最大长度             |
| ------------------ | ----------------------------------------------- | -------------------- |
| char[ (M) ]        | 固定长字符串，检索快但费空间，<br>0 <= M <= 255 | 0~255                |
| **varchar[ (M) ]** | 可变字符串<br>0 <= M <= 65535                   | 0~65535              |
| tinytext           | 微型文本串                                      | 2<sup>8</sup>-1字节  |
| text               | 文本串                                          | 2<sup>16</sup>-1字节 |

> 日期和时间型数值类型

| 类型      | 说明                           | 取值范围                                   |
| --------- | ------------------------------ | ------------------------------------------ |
| DATE      | YYYY-MM–DD，日期格式           | 1000-01-01~9999-12-31                      |
| TIME      | hh:mm:ss，时间格式             | -838:59:59~838:59:59                       |
| DATETIME  | YY-MM-DD hh:mm:ss              | 1000-01-01 00:00:00 至 9999-12-31 23:59:59 |
| TIMESTAMP | YYYYMMDDhhmmss格式表示的时间戳 | 197010101000000~2037年的某个时刻           |
| YEAR      | YYYY格式的年份值               | 1901~2155                                  |



> NULL

- 理解为 "没有值" 或 "未知值"
- 不要用NULL进行算术运算 , 结果仍为NULL

## 2.5 数据字段属性

**UnSigned**

- 无符号的
- 声明该数据列不允许负数 .

**ZEROFILL**

- 0填充的
- 不足位数的用0来填充 , 如int(3),5则为005

**Auto_InCrement(自增)**

- 自动增长的 , 每添加一条数据 , 自动在上一个记录数上加 1(默认)

- 通常用于设置**主键**~ index , 且为整数类型

- 可定义起始值和步长

- - 当前表设置步长(AUTO_INCREMENT=100) : 只影响当前表
	- SET @@auto_increment_increment=5 ; 影响所有使用自增的表(全局)

**NULL 和 NOT NULL(非空)**

- 默认为NULL , 即没有插入该列的数值
- 如果设置为NOT NULL , 则该列必须有值

**DEFAULT(默认)**

- 默认的
- 用于设置默认值
- 例如,性别字段,默认为"男" , 否则为 "女" ; 若无指定该列的值 , 则默认值为"男"的值

```mysql
-- 目标 : 创建一个school数据库
-- 创建学生表(列,字段)
-- 学号int 登录密码varchar(20) 姓名,性别varchar(2),出生日期(datatime),家庭住址,email
-- 创建表之前 , 一定要先选择数据库

CREATE TABLE IF NOT EXISTS `student` (
    id INT(4) NOT NULL AUTO_INCREMENT COMMENT '学号',
    name VARCHAR(30) NOT NULL DEFAULT '匿名' COMMENT '姓名',
    pwd VARCHAR(20) NOT NULL DEFAULT '123456' COMMENT '密码',
    sex VARCHAR(2) NOT NULL DEFAULT '男' COMMENT '性别',
    birthday DATETIME DEFAULT NULL COMMENT '生日',
    address VARCHAR(100) DEFAULT NULL COMMENT '地址',
    email VARCHAR(50) DEFAULT NULL COMMENT '邮箱',
    PRIMARY KEY (id)
) ENGINE=INNODB DEFAULT CHARSET=utf8;


-- 查看数据库的定义
SHOW CREATE DATABASE school;
-- 查看数据表的定义
SHOW CREATE TABLE student;
-- 显示表结构
DESC student;  -- 设置严格检查模式(不能容错了)SET sql_mode='STRICT_TRANS_TABLES';
```

## 2.6 数据表的类型

> 设置数据表的类型

```mysql
CREATE TABLE 表名(
   -- 省略一些代码
   -- Mysql注释
   -- 1. # 单行注释
   -- 2. /*...*/ 多行注释
)ENGINE = MyISAM (or InnoDB)

-- 查看mysql所支持的引擎类型 (表类型)
SHOW ENGINES;
```

MySQL的数据表的类型 : **MyISAM** , **InnoDB** , HEAP , BOB , CSV等...

常见的 MyISAM 与 InnoDB 类型：

| 名称       | MyISAM | InnoDB      |
| ---------- | ------ | ----------- |
| 事物处理   | 不支持 | 支持        |
| 数据行锁定 | 不支持 | 支持        |
| 外键约束   | 不支持 | 支持        |
| 全文索引   | 支持   | 不支持      |
| 表空间大小 | 较小   | 较大，约2倍 |

经验 ( 适用场合 )  :

- 适用 MyISAM : 节约空间及相应速度
- 适用 InnoDB : 安全性 , 事务处理及多用户操作数据表

> 数据表的存储位置

- MySQL数据表以文件方式存放在磁盘中

- - 包括表文件 , 数据文件 , 以及数据库的选项文件
	- 位置 : Mysql安装目录\data\下存放数据表 . 目录名对应数据库名 , 该目录下文件名对应数据表 .

- 注意 :

- - \* . frm -- 表结构定义文件
	- \* . MYD -- 数据文件 ( data )
	- \* . MYI -- 索引文件 ( index )
	- InnoDB类型数据表只有一个 *.frm文件 , 以及上一级目录的ibdata1文件

- ```
	innodb.frm
	```

- - MyISAM类型数据表对应三个文件 :

- ```
	myisam.frm
	myisam.MYD
	myisam.MYI
	```

> 设置数据表字符集

我们可为数据库,数据表,数据列设定不同的字符集，设定方法 :

- 创建时通过命令来设置 , 如 : CREATE TABLE 表名()CHARSET = utf8;
- 如无设定 , 则根据MySQL数据库配置文件 my.ini 中的参数设定

## 2.7 修改数据库

> 修改表 ( ALTER TABLE )

修改表名 :ALTER TABLE 旧表名 RENAME AS 新表名

添加字段 : ALTER TABLE 表名 ADD字段名 列属性[属性]

修改字段 :

- ALTER TABLE 表名 MODIFY 字段名 列类型[属性]
- ALTER TABLE 表名 CHANGE 旧字段名 新字段名 列属性[属性]

删除字段 :  ALTER TABLE 表名 DROP 字段名

> 删除数据表

语法：DROP TABLE [IF EXISTS] 表名

- IF EXISTS为可选 , 判断是否存在该数据表
- 如删除不存在的数据表会抛出错误

> 其他

```mysql
1. 可用反引号（`）为标识符（库名、表名、字段名、索引、别名）包裹，以避免与关键字重名！中文也可以作为标识符！

2. 每个库目录存在一个保存当前数据库的选项文件db.opt。

3. 注释：
  单行注释 # 注释内容
  多行注释 /* 注释内容 */
  单行注释 -- 注释内容       (标准SQL注释风格，要求双破折号后加一空格符（空格、TAB、换行等）)
   
4. 模式通配符：
  _   任意单个字符
  %   任意多个字符，甚至包括零字符
  单引号需要进行转义 \'
   
5. CMD命令行内的语句结束符可以为 ";", "\G", "\g"，仅影响显示结果。其他地方还是用分号结束。delimiter 可修改当前对话的语句结束符。

6. SQL对大小写不敏感 （关键字）

7. 清除已有语句：\c
```

# 3、MySQL数据管理

## 3.1 外键(了解)

> 方式一、在创建表的时候，增加约束（麻烦、复杂）

```mysql
CREATE TABLE `grade` (
`gradeid` INT(10) NOT NULL AUTO_INCREMENT COMMENT '年级id',
`gradename` VARCHAR(50) NOT NULL COMMENT '年级名称',
PRIMARY KEY(`gradeid`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

-- 学生的gradeid字段 要去引用年级表的gradeid
-- 定义外键key
-- 给这个外键添加约束（执行引用） references 引用
CREATE TABLE IF NOT EXISTS `student`(
`id` INT(4) NOT NULL AUTO_INCREMENT COMMENT '学号',
`name` VARCHAR(30) NOT NULL DEFAULT '匿名' COMMENT '名字',
`pwd` VARCHAR(20) NOT NULL DEFAULT '123456' COMMENT '密码',
`sex` VARCHAR(2) NOT NULL DEFAULT '男' COMMENT '性别',
`birthday` DATETIME DEFAULT NULL COMMENT '生日',
`gradeid` INT(10) NOT NULL COMMENT '学生的年级',
`address` VARCHAR(100) DEFAULT NULL COMMENT '地址',
`email` VARCHAR(50) DEFAULT NULL COMMENT '邮箱',
PRIMARY KEY(`id`),
KEY `FK_gradeid` (`gradeid`),
CONSTRAINT `FK_gradeid` FOREIGN KEY (`gradeid`) REFERENCES `grade`(`gradeid`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;
```



删除有外键关系的表的时候，必须要先删除引用别人的表（从表），再删除被引用的表（主表）



> 方式二：创建表成功后，添加外键约束

```mysql
`gradename` VARCHAR(50) NOT NULL COMMENT '年级名称',
PRIMARY KEY(`gradeid`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;


-- 学生的gradeid字段 要去引用年级表的gradeid
-- 定义外键key
-- 给这个外键添加约束（执行引用） references 引用
CREATE TABLE IF NOT EXISTS `student`(
`id` INT(4) NOT NULL AUTO_INCREMENT COMMENT '学号',
`name` VARCHAR(30) NOT NULL DEFAULT '匿名' COMMENT '名字',
`pwd` VARCHAR(20) NOT NULL DEFAULT '123456' COMMENT '密码',
`sex` VARCHAR(2) NOT NULL DEFAULT '男' COMMENT '性别',
`birthday` DATETIME DEFAULT NULL COMMENT '生日',
`gradeid` INT(10) NOT NULL COMMENT '学生的年级',
`address` VARCHAR(100) DEFAULT NULL COMMENT '地址',
`email` VARCHAR(50) DEFAULT NULL COMMENT '邮箱',
PRIMARY KEY(`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;

ALTER TABLE `student`
ADD CONSTRAINT `FK_gradeid` FOREIGN KEY(`gradeid`) REFERENCES `grade`(`gradeid`);

-- ALTER TABLE 表 ADD CONSTRAINT 约束名 FOREIGN KEY(作为外键的列) REFERENCES 那个表(哪个字段)
```

以上的操作都是物理外键，数据库级别的外键，我们不建议使用！（避免数据库过多造成困扰，这里了解即可）



==最佳实践==

+ 数据库就是单纯的表，只用来存数据，只有行（数据）和列（字段）
+ 我们想使用多张表的数据，想使用外键（程序去实现）

## 3.2 DML语言(全部记住)

**数据库意义：**数据存储，数据管理

DML语言：数据操作语言

+ Insert
+ update
+ delete

## 3.3 添加

> insert



```mysql
-- 插入语句（添加）--
-- insert into 表名([字段名1，字段名2，字段名3])values('值1,值2...'),('值1,值2...'),('值1,值2....'),...)
INSERT INTO `grade`(`gradename`)VALUES('大四')

-- 由于主键自增我们可以省略（如果不写表的字段，他就会一一匹配）
INSERT INTO `grade`VALUES('大三')

-- 一般写插入语句，我们一定要数据和字段一一兑现!

-- 插入多个字段
INSERT INTO `grade`(`gradename`) VALUES('大二'),('大一')


INSERT INTO `student`(`name`) VALUES ('张三')

INSERT INTO `student`(`name`,`pwd`,`sex`) VALUES ('张三','aaaaaa','男')

INSERT INTO `student`(`name`,`pwd`,`sex`) 
VALUES ('李四','aaaaaa','男'),('王五','aaaaaa','男')
```

语法：`-- insert into 表名([字段名1，字段名2，字段名3])values('值1,值2...'),('值1,值2...'),...)`

注意事项：

​	1.字段和字段之间用英文逗号隔开

​	2.字段是可以省略的，但是后面的值必须要一一对应，不能少

​	3.可以同时插入多条数据，VALUES后面的值，需要使用逗号隔开即可`VALUES(),(),...`

## 3.4 修改

> update 修改谁（条件） set 原来的值=新值

```mysql
-- 修改学员的名字，带了简介
UPDATE `student` SET `name`='狂神' WHERE id <= 2;

-- 不指定条件的情况下，会改动所有表！
UPDATE `student` SET `name`='长江7号'

-- 修改多个属性，逗号隔开
UPDATE `student` SET `name`='浩二',`email`='114514@qq.com' WHERE id=1;

-- 通过多个条件定位数据
UPDATE `student` SET `name`='虎哥' WHERE `name`='老八' AND sex='女'
```

条件：where子句 运算符 id等于某个值，大于某个值，在某个区间内修改…

操作符会返回布尔值

|   操作符    | 意义         | 范围        | 结果  |
| :---------: | ------------ | ----------- | ----- |
|      =      | 等于         | 5=6         | false |
|   <>或!=    | 不等于       | 5<>6        | true  |
|      >      |              |             |       |
|      <      |              |             |       |
|     >=      |              |             |       |
|     <=      |              |             |       |
| between…and | 在某个范围内 |             |       |
|     AND     | 我和你 &&    | 5>1 and 1>2 | false |
|     OR      | 我或你 \|\|  | 5>1 or 1>2  | true  |

语法：`update 表名 set colnum_name = value,[colnum_name = value] where [条件]`

注意：

+ colnum_name 是数据库的列，尽量带上``
+ 条件，筛选的条件，如果没有指定，则会修改所有的列
+ value，是一个具体的值，也可以是一个变量
	+ `UPDATE `student` SET `birthday`=CURRENT_TIME WHERE `name`='虎哥' AND sex='女'`

## 3.5 删除

> delete

语法：`delete from 表名 [where 条件]`

```mysql
-- 删除数据
DELETE FROM `student` WHERE id = 1;

-- 全部删除
DELETE FROM `student`;
```

> truncate

作用：完全清空一个数据库表，表的结构和索引约束不会变

```mysql
-- 清空 student 表
TRUNCATE `student`
```

>truncate和dalete的区别

+ 相同点：都能删除数据，都不会删除表结构
+ 不同点：
	+ truncate 重新设置 自增列 计数器会归零
	+ truncate 不会影响事务

了解即可：delete删除的问题，重启数据库，现象

+ innoDB 自增列会从1开始(存在内存中的，断电即失)
+ MyISAM 继续从上一个自增量开始(存在文件中的，不会丢失)

# 4、DQL查询数据(最重点)

## 4.1 DQL

(Data Query LANGUAGE:数据查询语言)

+ 所有的查询操作都用它 Select
+ 简单的查询，复杂的查询它都能做
+ ==数据库中最核心的语言，最重要的语句==
+ 使用频率最高的语句

## 4.2 指定查询字段

```sql
-- 查询全部的学生	select 字符按 from 表
SELECT * FROM student

-- 查询指定字段
SELECT `StudentNo`,`StudentName` FROM student

-- 别名，给结果起一个名字   AS	可以给字段起别名，也可以给表名起别名
SELECT `StudentNo` AS 学号,`StudentName` AS 学生姓名 FROM student AS s

-- 函数 concat(a,b) 拼接
SELECT CONCAT('姓名：',StudentName) AS 新名字 FROM student
```

语法：`SELECT 字段1,... FROM 表`

>有的时候，列名字不是那么见名知意。我们起别名 AS：字段名 AS 别名 表名 AS 别名