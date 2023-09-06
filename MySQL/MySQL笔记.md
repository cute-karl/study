# 初识

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

# 数据库操作

## 结构化查询语句分类

| 名称                | 解释                                         | 命令                    |
| ------------------- | -------------------------------------------- | ----------------------- |
| DDL（数据定义语言） | 定义和管理数据对象，如数据库、数据表等       | CREATE、DROP、ALTER     |
| DML（数据操作语言） | 用于操作数据库对象中所包含的语言             | INSERT、UPDATE、DELETE  |
| DQL（数据查询语言） | 用于查询数据库数据                           | SELECT                  |
| DCL（数据控制语言） | 用于管理数据库的语言，包括管理权限及数据更改 | GRANT、commit、rollback |

## 数据库操作

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

## 创建数据表

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

## 数据值和列类型

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

## 数据字段属性

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

## 数据表的类型

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

## 修改数据库

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