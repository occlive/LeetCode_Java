# 28. 实现 strStr()
问题描述
----
> 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
> 
> 如果不存在，则返回  -1。

问题示例
----
> 输入: haystack = "hello", needle = "ll"
> 
> 输出: 2

> 输入: haystack = "aaaaa", needle = "bba"
>
> 输出: -1

自我题解
----
### 🦄indexOf()
该问题需要实现的功能和Java语言中String的`indexOf()`方法功能相同。

如果追求机智完美的话，可以自己实现一下`indexOf()`方法






代码
----
```java
class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);

    }
}
```

### 炫耀一下

![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/28.png)

