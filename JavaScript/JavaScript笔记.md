# 1、快速入门

## 1.1 引入js

1、内部标签

```html
<script>
    //………
</script>
```

2、外部引入

abs.js

```js
//……
```

test.html

```html
<script src="abc.js"></script>
```

测试代码

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!--script标签内，写JavaScript代码-->
    <!--<script>
            alert("hello world");
        </script>-->

    <!--外部引入-->
    <!--注意：script标签必须成对出现-->
    <script src="js/qj.js"/>
    </script>
    <!--不用显示定义type，也默认就是JavaScript-->
    <script type="text/javascript">

    </script>
</head>
<body>

<!--这里也可以存放-->
</body>
</html>
```

## 1.2 基本语法入门

浏览器必备调试须知

![屏幕截图 2023-09-09 125530](https://raw.githubusercontent.com/cute-karl/studyimage/main/%E5%B1%8F%E5%B9%95%E6%88%AA%E5%9B%BE%202023-09-09%20125530.png)

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script>
        //1. 定义变量    变量类型 变量名 = 变量值;
        var num = 1;
        var name = "mouse";
        //alert();
        //2. 条件控制
        if (2 > 1) {
            alert("true")
        }
        //console.log(score) 在浏览器的控制台打印变量！
        /*
        * 多行注释
        * */
    </script>
</head>
<body>

</body>
</html>
```

## 1.3 数据类型

数值、文本、图形、音频、视频



==变量==

```js
var a = 1;
```





==number==

js不区分小数和整数

```javascript
123//整数
123.1//浮点数
1.123e3//科学计数法
-99//负数
NaN//not a number
Infinity//表示无限大
```

==字符串==

‘abc’    “abc”

‘\n’

==布尔值==

true  ,  false

==逻辑运算==

```
&&	两个都为真，结果为真

||	一个为真，结果为真

!	真即假，假即真
```

==比较运算符==

```
=
==	等于(类型不一样，值一样，也会判断为true)
===	绝对等于(类型和值都一样，才会判断为true)
```

这是一个JS的缺陷，坚持不要使用==比较

须知：

+ NaN===NaN，这个与所有的数值都不相等，包括自己
+ 只能通过isNaN(NaN)来判断这个数是否是NaN



浮点数问题：

```
console.log((1/3) === (1-2/3))
```

尽量避免使用浮点数进行运算，存在精度问题！

```
Math.abs(1/3-(1-2/3))<0.00000001
```



==null和undefined==

+ null 空
+ undefined 未定义



==数组==

Java的数值必须是相同类型的对象，JS中不需要这样

```js
//保证代码的可读性，尽量使用[]
var arr = [1,2,'hello',null,true]

new Array(1,12,3,4,4,5,'hello')
```

取数组下标：如果越界了，就会

```
undefined
```



==对象==

对象是大括号，数组是中括号

每个属性之间使用逗号隔开，最后一个不需要添加

```js
var person = {
    name: "laoba",
    age: 18,
    tags: ['js','java','web','...']
}
```

取对象的值

```bash
person.name
> "laoba"
person.age
> 3
```

## 2.4 严格检查模式

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
<!--
前提：IDEA需要设置支持ES6语法
'use strict'; 严格检查模式，预防JavaScript的随意性导致产生的一些问题
必须写在JavaScript的第一行
局部变量建议都使用let取定义
-->
    <script>
        'use strict'
        let i = 1;
    </script>
</head>
<body>

</body>
</html>
```

# 2、数据类型

## 2.1 字符串

1.正常字符串我们使用单引号，双引号

2.注意转义字符 \

```js
\'
\n
\t
\u#### Unicode字符
\x41 ASCLL字符
```

3.多行字符串编写

```js
//使用``
var msg = 
    `hello
    world
    你好呀
    `
```

4.模板字符串

```js
//使用``
let name = "qinjiang";
let msg = `你好呀，${name}`
```

5.字符串

```
str.length
```

6.字符串的可变性，不可变

![](https://raw.githubusercontent.com/cute-karl/studyimage/main/image-20230909144649933.png)

7.大小写转换

```js
//注意，这里是方法，不是属性了
student.toUpperCase();
student.toLowerCase();
```

8.获取指定下标

```
student.indexOf('t');
```

9.截取

```js
student.substring(1); //从第一个字符串截取到最后一个字符串
student.substring(1,3) //第一到第三
```

## 2.2 数组

**Array可以包含任意的数据类型**

```js
var arr = [1,2,3,4,5,6]; //通过下标取值和赋值
arr[0];
arr[0] = 1;
```

1.长度

```js
arr.length
```

注意：假如给arr.length赋值，数组大小就会发生变化，如果赋值过小，元素就会丢失

2.indexOf，通过下标索引

```js
arr.indexOf(2)
1
```

字符串的‘’1‘’和数字1是不同的

3.slice()截取Array的一部分，返回一个新数组，类似于String中的substring

4.push，pop

```js
push:插入到尾部
pop:弹出尾部的一个元素
```

5.unshift()，shift()头部

```
unshift:插入到头部
shift:弹出头部的一个元素
```

6.排序sort()

7.元素反转

```js
reverse()
```

8.concat()

```js
(3)["3","B","A"]
arr.concat([1,2,3])
(6)["C","B","A",1,2,3]
arr
(3)["c","B","A"]
```

注意：concat()并没有修改数组，只是会返回一个新的数组

9.连接符join

打印拼接数组，使用特定的字符串连接

```js
(3)["C","B","A"]
arr.join('-')
"C-B-A"
```

10.多维数组

## 2.3 对象

若干个键值对

```js
var 对象名 = {
    属性名:属性值,
    属性名:属性值,
    属性名:属性值
}

var person = {
    name: "laoba",
    age: 18,
    email: "114514@qq.com"
    score: 0
}
```

1.对象赋值

```js
person.name = "laoba";
```

2.使用一个不存在的对象属性，不会报错！ undefined

3.动态的删减属性

```js
delete person.name
```

4.动态的添加，直接给新的属性添加值即可

```js
person.haha = "haha"
```

5.判断属性是否在这个对象中！ xxx in xxx

```js
'age' in person
true
//继承
'toString' in person
true
```

6.判断一个属性是否是这个对象自身拥有的hasOwnProperty()

```js
person.hasOwnProperty('age');
true
person.hasOwnProperty('toString');
false
```

## 2.4 流程控制

if判断

while循环

for循环

forEach循环

> ES5,1引入

```js
var arr = [100, 2, 3, 4, 5, 6, 7];

        arr.forEach(function(element) {
            // 在这里对每个元素执行操作
            console.log(element); // 例如，输出每个元素的值
        });
```

for…in

```js
var arr = [100, 2, 3, 4, 5, 6, 7];

        for(var num in arr) {
            console.log(num);
        }
//输出属性而不是值
```



## 2.5 Map和Set

> ES6的新特性

**Map:**

```js
//ES6 Map
//学生的成绩，学生的名字
// var names = ["tom", "jack", "haha"];
// var scores = [100, 90, 80];

var map = new Map([['tom',100], ['jack',90], ['haha', 80]]);
var name = map.get('tom');  // 通过key获得value
map.set('admin', 123456);	// 新增或修改
map.delete("tom")	// 删除
```

**Set:**无序不重复的集合

```js
set.add(2);	// 添加
set.delete(1);	// 删除
console.log(set.has(3));	// 是否包含某个元素
```



## 2.6 iterator

> es6 新特性

作业：使用iterator来遍历迭代我们Map,Set！

```js
// 通过for of / for in 下标
var arr = [3, 4, 5];
for (var x of arr) {
    console.log(x)
}
```

遍历map

```js
var map = new Map([["tom", 100], ["jack", 90], ["haha", 80]]);
for(let x of map) {
   console.log(x)
}
```

遍历set

```/js
var set = new Set([5, 6, 7]);
for(let x of set) {
   console.log(x)
}
```

# 3、函数

## 3.1 定义函数

> 定义方式一

绝对值函数

```js
function abs(x){
    if(x>=0){
        return x;
    }else{
        return -x;
    }
}
```

一旦执行到return代表函数结束，就返回结果

如果没有执行return，函数执行完也会返回结果，结果就是undefined



> 定义方式二

```js
var abs = function(){
    if(x>=0){
        return x;
    }else{
        return -x;
    }
}
```

function(x){……}这是一个匿名函数，但是可以把结果赋值给abs，通过abs就可以调用函数

方式一和方式二等价



> 调用函数

```js
abs(10)		// 10
abs(-10)	//10
```

参数问题：JavaScript可以传任意个参数，也可以不传递参数~

参数进来是否存在的问题？

假设不存在参数，如何规避？

```js
var abs = function(x){
            // 手动抛出异常来判断
            if(typeof x !=='number') {
                throw 'Not a Number';
            }
            if(x>=0){
                return x;
            }else{
                return -x;
            }
        }
```



> arguments

`arguments`是一个js免费赠送的关键字；

代表传递进来的所有的参数，是一个数组！

```js
var abs = function(x){
            console.log("x=>"+x);
            for(var i = 0; i<arguments.length; i++) {
                console.log(arguments[i]);
            }
            if(x>=0){
                return x;
            }else{
                return -x;
            }
        }
```



问题：arguments包含所有的参数，我们有时候想使用多余的参数来进行附加操作。需要排除已有参数~



> rest

以前：

```js
if(arguments.length>2) {
                for(var i = 2; i < arguments.length; i++) {
                    //......
                }
            }
```



ES6引入的新特性，获取除了已经定义的参数之外的所有参数~

```js
function aaa(a,b,...rest) {
    console.log("a=>"+a);
    console.log("b=>"+b);
    console.log(rest);
}
```

## 3.2 变量的作用域

在javascript中，var定义变量实际是有作用域的。

假设在函数体中声明，则在函数体外不可以使用~（非要想实现的话，后面可以研究以下`闭包`）

```js
function qj() {
    var x = 1;
    x = x + 1;
}

x = x + 2; // Uncaught ReferenceError: x is not defined
```

如果两个函数使用了相同的变量名，只要在函数内部，就不冲突

```js
function qj() {
    var x = 1;
    x = x + 1;
}

fuction qj2() {
    var x = 'A';
    x = x + 1;
}
```

```
内部函数可以访问外部函数的成员，反之则不行
```

```js
function qj(){
    var x = 1;
    
    // 内部函数可以访问外部函数的成员，反之则不行
	function qj2() {
        var y = x + 1; // 2
    }
    
    var z = y + 1; // Uncaught ReferenceError: y is not defined
}
```

假设，内部函数变量和外部函数的变量，重名

```js
function qj() {
    var x = 1;
    function qj2() {
        var x = 'A';
        console.log('inner'+x); // outer1
    }
    console.log('outer'+x); // innerA
    qj2()
}

qj()
```

假如在JavaScript中 函数查找变量从自身函数开始~，由“内”向“外”查找.假设外部存在这个同名的函数变量，则内部函数会屏蔽外部函数的变量。



> 提升变量的作用域

```js
function qj() {
    var x = "x" + y;
    console.log(x);
    var y = 'y';
}
```

结果：undefined

说明：js执行引擎，自动提升了y的声明，但是不会提升变量y的赋值

```js
function qj2() {
    var y;
    
    var x = "x" + y;
    console.log(x);
    y = 'y';
}
```

这个是在JavaScript建立之初就存在的特性。养成规范：所有变量定义都放在函数的头顶，不要乱放，便于代码维护。

```js
function qj2() {
	var x = 1,
        y = x + 1,
        z,i,a; //undefined
    
    // 之后随意用
}
```



> 全局函数

```js
//全局变量
x = 1;

function f() {
    console.log(x);
}
f();
console.log(x);
```

全局对象window

```js
var x = 'xxx';
alert(x);
alert(window.x); // 默认所有的全局变量，都会自动绑定在window对象下
```

alert()这个函数本身也是一个`window`变量

```js
var x = 'xxx';

window.alert(x);

var old_alert = window.alert;

//ole_alert(x);

window.alert = function() {
    
};
// 发现 alert()失败了
window.alert(123);

//回复
window.alert = old_alert;
window.alert(456);
```

JavaScript实际上只有一个全局作用域，任何变量（函数也可以视为变量），假设没有在函数作用范围内找到，就会向外查找，如果在全局作用域都没有找到，报错`RefrenceError`



> 规范

由于我们所有的全局变量都会绑定到我们的window上。如果不同的js文件，使用了相同的全局变量，冲突~->如何能够减少冲突?

```js
//唯一全局变量
var KuangApp = {};

//定义全局变量
KuangApp.name = 'kuangshen';
KuangApp.add = function(a,b) {
    return a + b;
}
```

把自己的代码全部放入自己定义的唯一空间名字中，降低全局命名冲突的问题~

jQuery



> 局部作用域 let

```js
function aaa() {
    for(var i = 0; i < 100; i++) {
        console.log(i);
    }
    console.log(i+1); //问题？ i 出了这个作用于还可以使用
}
```

ES6 let 关键字，解决局部作用域冲突问题！

```js
function aaa() {
    for (let i = 0; i < 100, i++) {
        console.log(i);
    }
    console.log(i+1); // Uncaught ReferenceError: i is not defind
}
```

建议大家都是用`let`去定义局部作用域的变量;



> 常量const

在ES6之前，怎么定义常量：只有用全部大写字母命名的变量就是常量;建议不要修改这样的值

```js
	var PI = '3.14';

	console.log(PI);
	PI = '213'; //可以改变这个值
	console.log(PI);
```

在ES6引入了常量关键字`const`

```js;
	const PI = '3.14'; // 只读变量
	console.log(PI);
	PI = '123'; // TypeError: Assignment to constant variable.
	console.log(PI);
```



## 3.3 方法

> 定义方法

发放就是把函数放在对象的里面，对象只有两个东西：属性和方法2.1 全局环境

1) 全局环境就是在<script></script>里面，这里的this始终指向的是window对象。


```js
<script>
    console.log(this); // 全局环境，即window对象下，this -> window 
</script>
```

2. 局部环境
	严格模式下，函数中的this为undefined；
	1）在全局作用域下直接调用函数，this指向window

```js
function fun() {
 	console.log(this);
}
fun(); // fun() 实际上是window.fun(), 所以this -> window
```

​		2）对象函数调用，哪个对象调用就指向哪个对象

```js
var obj1 = {
    a: 1,
    fun1: function() {
        console.log(this);
    },
    obj2: {
    	fun2: function() {
    		console.log(this);
    	}
    }
}
obj1.fun1(); // fun1由obj调用，所以this -> obj1
obj1.obj2.fun2(); // fun2由obj2调用，所以this -> obj2
```



> apply

在js中可以控制this的指向

```js
function getAge() {
            //今年 - 出生的年
            var now = new Date().getFullYear();
            return now-this.birth;
        }
        var kuangshen = {
            name: '老八',
            birth: 2000,
            age: getAge()
        }
        getAge.apply(kuangshen, []);// this指向了kuangshen，参数为空
```



# 4、内部对象

> 标准对象

## 4.1 Date

**基本使用**

```js
var now = new Date();
        now.getFullYear();  // 年
        now.getMonth(); // 月 0~11
        now.getDay();   // 星期
        now.getDate()   // 日
        now.getHours(); // 时
        now.getMinutes();   // 分
        now.getSeconds();   // 秒

        now.getTime();   // 时间戳 全世界统一 1970 1.1 0:00:00 毫秒数

        console.log(new Date(1694345157886)); // 时间戳转为标准时间
```



## 4.2 JSON

> json是什么

早期，所有数据传输习惯使用XML文件

+ JSON是一种轻量级的数据交换格式。
+ 简洁和清晰的层次结构使得 JSON 成为理想的数据交换语言。 
+ 易于人阅读和编写，同时也易于机器解析和生成，并有效地提升网络传输效率。number,string…



在JavaScript一切皆为对象，任何JS支持的类型都可以用JSON来表示：

格式：

+ 对象都用{}
+ 数组都用[]
+ 所有键值对都是用 key:value

JSON和JS对象的转化

```js
var user = {
            name: "qinjiang",
            age: 3,
            sex: '男'
        }

        // 对象转化为json字符串
        var jsonUser = JSON.stringify(user);

        //json 字符串转化为对象 参数为json字符串
        JSON.parse('{"name":"qinjiang","age":3,"sex":"男"}');
```

区别

```js
var obj = {a: 'hello', b: 'hellob'};
var json = '{"a":"hello", "b":"hellob"}'
```



## 4.3 Ajax

+ 原生的js写法 xhr异步请求
+ JQuey封装好的方法 $(“#name”).ajax(“”)
+ axios 请求



# 5、面向对象编程

## 5.1 什么是面向对象

JavaScript、Java、C#…面向对象：JavaScript有些区别

类：模板

对象：具体的实例

在JavaScript这个需要大家换一下思维方式

原型：

```js
var student = {
            name:"未知",
            age: 3,
            run: function() {
                console.log(this.name + "run......");
            }
        }

        var xiaoming = {
            name: "xiaoming"
        };
		//原型对象
        xiaoming.__proto__ = student;
```

```js
function Student(name) {
            this.name = name;
        }

        // 给student新增一个方法
        Student.prototype.hello = function () {
            alert("Hello");
        }
```



> class 继承

`class`关键字，是在ES6引入的

1、定义一个类，属性，方法

```js
        //ES6 之后======================================
        //定义一个学生的类
        class Student{
            //构造器
            constructor(name) {
                this.name = name;
            }
            //定义方法
            hello(){
                alert("hello");
            }
        }

        
        var xiaoming = new Student("xiaoming");
        var xiaohong = new Student("xiaohong");
		xiaoming.hello();
```

2、继承

```js
//定义一个学生的类
        class Student{
            //构造器
            constructor(name) {
                this.name = name;
            }
            //定义方法
            hello(){
                alert("hello");
            }
        }
        class XiaoStudent extends Student{
            constructor(name,grade) {
                super(name);
                this.grade = grade;
            }
            myGrade(){
                alert("我是一名小学生");
            }
        }

        var xiaoming = new Student("xiaoming");
        var xiaohong = new XiaoStudent("xiaohong",1);
```

本质：查看对象原型



> 原型链

__ proto __:



# 6. 操作BOM对象（重点）

> 浏览器介绍

JS和浏览器的关系？

JS诞生就是为了能够让他在浏览器中运行。



BOM：浏览器对象模型

+ IE 6-11
+ Chrome
+ Safari
+ FireFox



三方

+ QQ浏览器
+ 360浏览器



> window

window 代表浏览器窗口

```js
window.alert(1)
undefined
window.innerHeight
381
window.innerWidth
1225
window.outerHeight
752
window.outerWidth
1280
```



>Navigator（不建议使用）

Navigator，封装了浏览器的信息

```js
navigator.appName
'Netscape'
navigator.appVersion
'5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42'
navigator.userAgent
'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/113.0.0.0 Safari/537.36 Edg/113.0.1774.42'
navigator.platform
'Win32'
```

大多数时候，我们不会使用`navigator`对象，因为会被人为修改

不建议使用这些属性来判断和编写代码



> screen

代表屏幕尺寸

```js
screen.width
1280px
screen.height
800px
```



> location（重要）

location 代表当前页面的URL信息

```js
host: "www.baidu.com" //主机
href: "https://www.baidu.com/" //当前指向未知
protocol: "https:"	//协议
reload: ƒ reload()	//重新加载
location.assign('https://www.jd.com/') //设置新的地址
```



> document（内容：DOM）

代表当前的页面，HTML DOM文档树

```js
document.title
'京东(JD.COM)-正品低价、品质保障、配送及时、轻松购物！'
document.title='八嘎雅鹿'
'八嘎雅鹿'
```

获取具体的文档数节点

```js
<dl id="app">
    <dt>Java</dt>
    <dd>JavaSe</dd>
    <dd>JavaEe</dd>
</dl>
<script>
    var dl = document.getElementById('app');
</script>
```

获取cookie

```js
document.cookie
'BIDUPSID=6E520CDF230F650CA331F527D8205FFB; PSTM=1693908274; BAIDUID=6E520CDF230F650C80C0294DBD1A5AA1:FG=1; BD_UPN=12314753; BAIDUID_BFESS=6E520CDF230F650C80C0294DBD1A5AA1:FG=1; ............................................."'
```

劫持cookie的原理

www.taobao.com

```html
<script src="aa.js"></script>
<!--恶意人员：获取你的cookie上传他的服务器-->
```

服务器端可以设置cookie：httpOnly



> history（不建议使用）

代表浏览器的历史记录

```js
history.back() //后退
history.forward() //前进
```



# 7、操作DOM对象（重点）

DOM：文档对象模型

> 核心

浏览器网页就是一个Dom树形结构！

+ 更新：更新Dom节点
+ 遍历dom结点：得到Dom结点
+ 删除：删除一个Dom节点
+ 添加：添加一个新的节点

要操作一个Dom节点，就必须要先获得这个Dom节点

> 获得dom节点

```js
//对应CSS选择器
    var h1 = document.getElementsByTagName('h1');
    var p1 = document.getElementById('p1');
    var p2 = document.getElementsByClassName('p2');
    var father = document.getElementsByClassName('p2');
    var childrens = father.children;//获取父节点下的所有子节点
    //father.firstChild
    //father.lastChild
```

这是原生代码，之后我们尽量都是用jQuery();



> 更新节点

```js
<div id="id1">

</div>
<script>
    var id1 = document.getElementById('id1');
</script>
```

操作文本

+ `id1,innerText='456'`修改文本的值
+ `id1.innerHTML='<strong>123</strong>'`可以解析HTML标签

操作js

```js
id1.style.color = 'yellow'; // 属性使用 字符串 包裹
id1.style.fontSize='200px'; // - 转 驼峰命名
......
```



> 删除节点

删除节点的步骤：先获取父节点，再通过父节点删除自己

```js
<div id="father">
    <h1>标题一</h1>
    <p id="p1">p1</p>
    <p class="p2">p2</p>
</div>
<script>
var self = document.getElementById('p1');
var father = p1.parentElement;
father.removeChild(self);

father.removeChild(father.children[0])
father.removeChild(father.children[1])
father.removeChild(father.children[2])
</script>
```

注意：删除多个节点的时候，children是在时刻变化的



> 插入节点

我们获得了某个Dom节点，假设这个dom节点是空的，我们通过innerHTML就可以增加一个元素了，但是这个DOM节点已经存在元素了，我们就不能这么干了，会产生覆盖

追加

```js
<p id="js">JavaScript</p>
<div id="list">
    <p id="se">JavaSE</p>
    <p id="ee">JavaEE</p>
    <p id="me">JavaME</p>
</div>

<script>
    var js = document.getElementById('js');
    var list = document.getElementById('list');
	list.qppendChild(js);//追加到后面
</script>
```



> 创建一个新的标签，实现插入

```js
<script>
    var js = document.getElementById('js');
    var list = document.getElementById('list');
    //通过JS 创建一个新的节点
    var newP= document.createElement('p');//创建一个p标签
    newP.id = 'newP';
    newP.innerText = 'Hello,Kuangshen';
    // 创建一个标签节点
    var myScript = document.createElement('script');
    myScript.setAttribute('type', 'text/javascript');
    // 可以创建一个Style标签
    var myStyle = document.createElement('style');  // 创建了一个空style标签
    myStyle.setAttribute('type', 'text/javascript');
    myStyle.innerHTML = 'body{background-color: chartreuse;}';  // 设置标签的内容

    document.getElementsByTagNameNS('head')[0].appendChild(myStyle);
</script>
```



> insert

```js
var ee = document.getElementById('ee');
    var js = document.getElementById('js')
    var list = document.getElementById('list')
    // 要包含的节点，insertBefore(newNode,targetNode)
    ee.insertBefore(js,ee);//把ee放在js前面
```



# 8、操作表单（验证）

用JavaScript操作表单和操作DOM是类似的，因为表单本身也是DOM树。

不过表单的输入框、下拉框等可以接收用户输入。所以用JavaScript来操作表单，可以获得用户输入的内容，或者对一个输入框设置新的内容。

HTML表单的输入控件主要有以下几种：

文本框，对应的< input type="text" >,用于输入文本；

口令框，对应的< input type="password" >,用于输入口令；

单选框，对应的< input type="radio" >用于选择一项

复选框，对应的< input type="checkbox" >,用于选择多项；

下拉框，对应的< select >,用于选择一项。

隐藏文本，对应的< input type="hidden" >,用户不可见，但表单提交时会把隐藏文本发送到服务器。

获取值：如果我们获得了一个< input >节点的引用，就可以直接调用value获得对应的用户输入值。

```js
　　//<input type="text" id="email">
        var input = document.getElementById('email');
        input.value;//'用户输入的值'
```

这种方式可以应用于text、password、hidden以及select。但是，对于单选框和复选框，value属性返回的永远是HTML预设的值。而我们需要获得的实际是用户是否“勾上了”选项，所以应该用checked判断。

```js
 //<label><input type="radio" name="weekday" id="monday" value="1">Money</label>
        //<label><input type="radio" name="weekday" id="tues" value="1">Money</label>
        var mon = document.getElementById('monday');
        var tue = document.getElementById('tuesday');
        mon.value;//'1'
        tue.value;//'2'
        mon.checked;//true或者false
        tue.checked;//true或者false
```

**设置值**

设置值和获取值类似，对于text、password、hidden以及select，直接设置value就可以：

```js
//<input type="text" id="email">
        var input = document.getElementById('email');
        input.value='test@example.com';//文本框内容已更新
```

 对于单选框和复选框，设置checked为true或者false即可。

HTML5控件

HTML5新增了大量标准控件，常用的包括date、datetime、datetime-local、color等，它们都使用< input >标签：

< input type="date" value="2017-10-28" >

```js
<input type="datetime-local" value="2015-07-01T02:03:04">
```

```js
<input type="color" value="#ff0000">
```

不支持HTML5的浏览器无法识别新的控件，会把它们当做type="text"来显示。支持HTML5的浏览器将获得格式化的字符串。例如，type="date"类型的input的value将保证是一个有效的YYYY-MM-DD格式的日期，或者空字符串。

 

提交表单

最后，JavaScript可以通过两种方式来处理表单的提交（AJAX方式在后面章节介绍）。

方式一是通过< form >元素的submit()方法提交一个表单，例如，响应一个< button >的click事件，在JavaScript代码中提交表单。

```js
<form action="" method="get" accept-charset="utf-8" id="test-form">
        <input type="text" name="test">
        <button type="button" onclick="doSubmitForm()">Submit</button>
    </form>

　　　　function doSubmitForm(){
            var form = document.getElementsById('test-form');
            //可以在此修改form的input
            //提交form
            form.submit();
        }
```

这种方式的缺点是扰乱了浏览器对form的正常提交。浏览器默认点击<button  type="submit">时提交表单，或者用户在最后一个输入框按回车键。因此，第二种方式是响应<form>本身的onsubmit事件，在提交form时作修改：

```js
　<form action="" method="get" accept-charset="utf-8" id="test-form">
        <input type="text" name="test">
        <button type="submit">Submit</button>
    </form>

　　　　function checkForm(){
            var form = document.getElementsById('test-form');
            //可以在此修改form的input
            //提交form
            return true;
        }
```

要return true来告诉浏览器继续提交，如果return false，浏览器将不会继续提交form，这种情况通常对应用户输入有误，提示用户错误信息后终止提交form。

在检查和修改< inpu t>时，要充分利用< input type="hidden" >来传递数据。

例如，很多登录表单希望用户输入用户名和口令，但是安全考虑，提交表单时不传输明文口令，而是口令的MD5.普通JavaScript开发人员会直接修改< input >:

```js
<form id="login-form">
        <input type="text" id="username" name="username">
        <input type="password" id="password" name="password">
        <button type="submit">Submit</button>
    </form>

　　　　function checkForm(){
            var pwd = document.getElementsById('password');
            //把用户输入的明文变为MD5
            pwd.value=toMD5(pwd.value);
            //继续下一步:
            return true;
        }
```

这个做法看上去没啥问题，但是用户输入了口令提交时，口令框的显示会突然从几个*变成32个*（因为MD5有32个字符）

要是不想改变用户的输入，可以利用< input type="hidden" >实现：

```js
<form id="login-form" method="post" onsubmit="return checkForm()">
        <input type="text" id="username" name="username">
        <input type="password" id="input-password">
        <input type="hidden" name="password" id="md5-password">
        <button type="submit">Submit</button>
    </form>

　　　　function checkForm(){
            var input_pwd = document.getElementById("input-password");
            var md5_pwd = document.getElementsById('md5-password');
            //把用户输入的明文变为MD5
            md5_pwd.value = toMD5(input_pwd.value);
            //继续下一步:
            return true;
        }
```

注意到id为md5-password的< input >标记了name="password"，而用户输入的id为input-password的< input >没有name属性。没有name属性的< input >的数据不会被提交。



# 9、jQuery

jQuery库，里面存在大量的js函数

> 获取jQuery

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
	<!--cdn引入-->
    <script src="jquery-3.7.1.js"></script>
</head>
<body>
<!--

公式: $(selector).action()

-->
<a href="#" id="test-jquery">点我</a>
<script>
    //选择器就是css的选择器
    $('#test-jquery').click(function () {
        alert('Hello,jQuery');
    })
</script>
</body>
</html>
```



> 选择器

```js
 //原生js,选择器少,麻烦不好记
    //标签
    document.getElementsByTagName();
    //id
    document.getElementById();
    //类
    document.getElementsByClassName();

    //jQuery    css 中的选择器它全部都能用
    $('p').click() //标签选择器
    $('#id1').click() //id选择器
    $('.class').click() //类选择器
```

文档工具站：http://jquery.cuishifeng.cn/



> 事件

鼠标事件，键盘事件，其他事件

```js
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
  <script src="jquery-3.7.1.js"></script>
    <style>
        #divMove{
            width: 500px;
            height: 500px;
            border: 1px solid red;
        }
    </style>
</head>
<body>

<!--要求:获取鼠标当前的坐标-->
mouse : <span id="mouseMove"></span>
<div id="divMove">
  在这里移动鼠标试试
</div>

<script>
<!--当网页元素加载完毕之后,响应事件-->
$(function () {
    $('#divMove').mousemove(function (e){
        $('#mouseMove').text('x:'+e.pageX+'y:'+e.pageY);
    })
});
</script>

</body>
</html>
```



> 操作DOM

节点文本操作

```js
$('#test-ul li[name=python]').text(); // 获得值
$('#test-ul li[name=python]').text('非空'); // 设置值
$('#test-ul').html(); // 获得值
$('#test-ul').html('非空'); // 设置值
```

css的操作

```js
$('#test-ul li[name=python]').css({"color","red"},...)
```

元素的显示和隐藏：本质`display=none;`

```js
$('#test-ul li[name=python]').show()
$('#test-ul li[name=python]').hide()
```

娱乐测试

```js
$(window).width()
$(window).height()
```



