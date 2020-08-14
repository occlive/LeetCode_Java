# 125. 验证回文串
问题描述
----
> 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
>
> 说明：本题中，我们将空字符串定义为有效的回文串。


问题示例
----
> 输入: "A man, a plan, a canal: Panama"
>
> 输出: true

> 输入: "race a car"
>
> 输出: false

自我题解
----
### 🦄双指针 ASCII

验证回文字符串，要求只需考虑数字或字母即可(**字母不区分大小写**)

|字符|ASCII范围|
|----|----|
|0-9|48~57|
|A-Z|65~90|
|a-z|97~122|

利用**双指针**，分别从字符串的前后获取字符进行**ASCII码**的比较，判断是否为回文字符串。

分别定义start、end作为字符串下标值，b1、b2作为是否进行判断的前提条件。

1. 对start下标字符进行判断
   * 如果非数字、字母，则start指向该字符的后一位字符
   * 如果是数字、字母，则start下标可进行判断
   * `b1 = true`
2. 对end下标字符进行判断
   * 如果非数字、字母，则end指向该字符的前一位字符
   * 如果是数字、字母，则end下标可进行判断
   * `b2 = true`
3. 如果b1、b2均满足条件，则对 start 、 end 下标指向的字符进行判断
   * 相同；则进行下一轮判断
   * 不同；返回`false`

直至`start >= end `为止，结束循环。


### 🧚‍ 其他题解

同样也是利用双指针，只不过利用方法分别独立
* 判断是否为数字或字母 
* 判断两字符是否相同

做题思路是一致的。


代码1
----
```java
class Solution {
    //A-Z  65-90
    //a-z  97-122
    //0-9  48-57
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;
        boolean b1 = false, b2= false;
        while(start < end){
            if((65<=s.charAt(start) && s.charAt(start)<=90)||
               (97<=s.charAt(start) && s.charAt(start)<=122)||
               (48<=s.charAt(start) && s.charAt(start)<=57)){
                
                b1 = true;
            }else{
                start++;
            }
            
            if((65<=s.charAt(end) && s.charAt(end)<=90)||
               (97<=s.charAt(end) && s.charAt(end)<=122)||
               (48<=s.charAt(end) && s.charAt(end)<=57)){
                
                b2 = true;
            }else{
                end--;
            }
            
            if(b1 == true && b2 == true){
                
                if(s.charAt(start)==s.charAt(end) || 
                   (Math.abs((s.charAt(start)-s.charAt(end)))==32) &&
                  s.charAt(start)>=65 && 
                  s.charAt(end)>=65){
                
                }else{
                    return false;
                }
                
                start++;
                end--;
                b1 = false;
                b2 = false;
            }
        }
        return true;

    }
}
```

代码2
----
```java
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        
        int n = s.length();
        int i = 0, j = n - 1;
        while (i <= j) {
            while (i <= j && !validChar(s.charAt(i))) {
                i++;
            }
            while (i <= j && !validChar(s.charAt(j))) {
                j--;
            }
            if (i <= j) {
                if (!compare(s.charAt(i), s.charAt(j))) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            } 
        }
        return true;
    }
    
    private boolean validChar(char x) {
        return ('Z' - x >= 0 && 'Z' - x <= 25) || ('z' - x >= 0 && 'z' - x <= 25) 
            || ('9' - x >= 0 && '9' - x <= 9);
    }
    
    private boolean compare(char x, char y) {
        int gap = 'Z' - 'z';
        return (x == y || (!('9' - x >= 0 && '9' - x <= 9) && (x - y == gap || y - x == gap)));
    }
}
```

### 炫耀一下

![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/125.png)


