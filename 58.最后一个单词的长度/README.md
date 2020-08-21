# 58. 最后一个单词的长度
问题描述
----
> 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
>
> 如果不存在最后一个单词，请返回 0 。
>
> 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。


问题示例
----
> 输入: "Hello World"
> 
> 输出: 5

自我题解
----
### 🦄split()

**`split()`** 根据`" "`分割符对字符串进行分割，不用考虑首尾`" "`空字符的情况。

最后一个单词的长度就是字符串分割后形成的字符串数组最后一位元素的长度。

### 🦄🧚‍ lastIndexOf()

*🤣看不上别人家的答案*

**`lastIndexOf()`** 为查找最后一位字符在字符串的位置。

1. 使用字符串修剪方法`trim()`去除前后的" "空字符串，避免影响接下来的结果;

2. `lastIndexOf()==-1`判断字符串内是否存在空字符串" ",
   * 没有则直接返回s.length()。
   * 如果有，则返回`s.length()-s.lastIndexOf(" ")-1`，即最后一个单词的长度.




代码1
----
```java
class Solution {
    public int lengthOfLastWord(String s) {
        String arr[] = s.split(" ");
        return arr.length-1 >= 0?arr[arr.length-1].length():0;
    }
}
```

代码2
----
```java
class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if(s.lastIndexOf(" ")==-1){
            return s.length();
        }
        return s.length()-s.lastIndexOf(" ")-1;
    }
}
```

### 炫耀一下

![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/58.png)

