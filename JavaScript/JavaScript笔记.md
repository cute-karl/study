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

# 2、 数据类型

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

