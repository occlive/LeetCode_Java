# 557. 反转字符串中的单词 III

问题描述
----
> 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

问题示例
----
> 输入："Let's take LeetCode contest"
>
> 输出："s'teL ekat edoCteeL tsetnoc"

自我题解
----
### 🦄StringBuffer

思路很简单：
1. 利用`String.split()`拆分字符串，获得字符串数组
2. 利用循环遍历字符串数组，并对`String`字符串强转为`StringBuffer`
3. 用`Stringbuffer.reverse()`对字符串数组进行反转并添加到结果字符串中。
4. 返回结果字符串。

### 🧚‍ 暴力破解

1. 新建一个字符数组，将字符串通过`toCahrArray()`转为字符数组
2. 以`' '`为间隔进行分组，遍历参数字符数组，找到第i组
3. 将第i组的字符数组以倒序的方式赋值给新字符数组
4. 不断进行循环，知道第i组为最后一组
5. 返回新字符数组的`String`类型


代码1
----
```java
class Solution {
    public String reverseWords(String s) {
        String result = "";
        String arr[] = s.split(" ");
        int len = arr.length;
        for(int i=0;i<len;i++){
            if(i<len-1){
                result+=new StringBuffer(arr[i]).reverse().toString()+" ";   
            }else{
                result += new StringBuffer(arr[len-1]).reverse().toString();
            }
        }
        return result;
    }
}
```

代码2
----
```java
class Solution {
    public String reverseWords(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        char[] res = new char[len];
        int left = 0, right = 0, mem = 0;
        int ptr = 0;
        while (left < len && right < len) {
            while (right < len && chars[right] != ' ') {
                right++;
            }
            for (int i = right - 1; i >= left; i--) {
                res[ptr++] = chars[i];
            }
            if (ptr < len - 1) res[ptr++] = ' ';
            left = right + 1;
            right++;
        }
        return String.valueOf(res);
    }
}
```







