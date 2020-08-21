# 14. 最长公共前缀
问题描述
----
> 编写一个函数来查找字符串数组中的最长公共前缀。
>
> 如果不存在公共前缀，返回空字符串`""`。

问题示例
----
> 输入: ["flower","flow","flight"]
> 
> 输出: "fl"


自我题解
----
### 🦄substring

`String`的各种方法非常好用(*策策的赞扬*✨)，本题中只需要字符串截取`substring()`和字符串字符获取`charAt()`,

将字符串数组第一元素赋值给`String`,再用强for循环遍历字符串数组;

依照**最短长度**以及**字符相等**的条件进行字符判断

最后获得该字符串数组的最长公共前缀。


### 🧚‍ 暂无其他题解

看不上人家的答案😅


代码
---- 
```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        String str = "";
        if(strs.length!=0){
            str =strs[0];
        }
        for(String s:strs){
            int len = str.length()>s.length()?s.length():str.length();
            str = str.substring(0,len);
            for(int i=0;i<len;i++){
                if(str.charAt(i)!=s.charAt(i)){
                    str = str.substring(0,i);

                    break;
                }
            }
        }
        return str;

    }
}
```

### 炫耀一下

![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/14.png)
