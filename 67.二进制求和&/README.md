# 67. 二进制求和
问题描述
----
> 给你两个二进制字符串，返回它们的和（用二进制表示）。
>
> 输入为 非空 字符串且只包含数字 `1` 和 `0`。


问题示例
----
> 输入: a = "11", b = "1"
>
> 输出: "100"

> 输入: a = "1010", b = "1011"
>
> 输出: "10101"

自我题解
----
### 🦄暴力破解

首先对两个字符串进行二者中**最短、等长**的循环（从末尾），

利用`boolean`型变量pix作为是否**进一**的依据；

其次判断两个字符串中是否存在一个较长的未访问全部的字符串，

有则进行单个字符串的循环。

最后再判断是否**进一**。

### 🧚‍ StringBuilder.reverse() 
和暴力破解类似，不过顺序不一样

利用`StringBuilder.reverse()`反转字符串，让二进制从字符串首开始。

同时利用**二进制**的原理，逢2进1。

以及字符串`append()`链接方法。


代码1
----
```java
class Solution {
    public String addBinary(String a, String b) {
        String result = "";
        int len1 = a.length()-1;
        int len2 = b.length()-1;
        boolean pix = false;
        
        while(len1>=0 && len2 >= 0){
            if(a.charAt(len1)=='0' && b.charAt(len2)=='0'){
                result =pix?"1" + result:"0" + result;
                pix = false;
  
            }else if((a.charAt(len1)=='1' && b.charAt(len2)=='0') || 
                     (a.charAt(len1)=='0' && b.charAt(len2)=='1') ){
                result = pix?"0" + result:"1" + result;
                
            }else if(a.charAt(len1)=='1' && b.charAt(len2)=='1'){
                result = pix?"1" + result:"0" + result;
        
                pix = true;
            }
            len1--;
            len2--;
        }
        
        if(len1>=0){
            while(len1>=0){
                if(a.charAt(len1)=='0'){
                    result = pix?"1"+result:"0"+result;
                    pix = false;
                }else{
                    result = pix?"0"+result:"1"+result;
                    
                }
                
                len1--;
            }
        }else if(len2 >= 0){
            while(len2>=0){
                if(b.charAt(len2)=='0'){
                    result = pix?"1"+result:"0"+result;
                    pix = false;
                }else{
                    result = pix?"0"+result:"1"+result;
                   
                }
                
                len2--;
            }
        }
        
        result = pix?"1"+result:result;
        
        return result;
        
    }
}
```

代码2
----
```java
class Solution {
    public String addBinary(String a, String b) {
        int aLen = a.length();
        String a1 = new StringBuilder(a).reverse().toString();
        String b1 = new StringBuilder(b).reverse().toString();
        int bLen = b.length();
        int max = Math.max(aLen, bLen);
        StringBuilder sb = new StringBuilder();
        int pre = 0;
        for(int i = 0; i < max; i++){
            int sum = pre;
            sum += (i < aLen ? a1.charAt(i) - '0':0);
            sum += (i < bLen ? b1.charAt(i) - '0':0);
            sb.append(sum % 2);
            pre=sum / 2;
        }
        if(pre == 1) sb.append('1');
        return sb.reverse().toString();
    }
}
```
