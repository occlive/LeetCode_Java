# 13. 罗马数字转整数
问题描述
----
> 罗马数字包含以下七种字符: `I`， `V`， `X`， `L`，`C`，`D` 和 `M`。
> 
> |字符|数值|
> |----|----|
> |`I`|1|
> |`V`|5|
> |`X`|10|
> |`L`|50|
> |`C`|100|
> |`D`|500|
> |`M`|1000|
> 
> 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
>
> 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 `IIII`，而是 `IV`。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 `IX`。这个特殊的规则只适用于以下六种情况：
>
> * `I` 可以放在 V (5) 和 `X` (10) 的左边，来表示 4 和 9。
> * `X` 可以放在 L (50) 和 `C` (100) 的左边，来表示 40 和 90。
> * `C` 可以放在 D (500) 和 `M` (1000) 的左边，来表示 400 和 900




问题示例
----
> 输入: "III"
>
> 输出: 3

> 输入: "LVIII"
>
> 输出: 58
>
> 解释: L = 50, V= 5, III = 3.

> 输入: "MCMXCIV"
>
> 输出: 1994
>
> 解释: M = 1000, CM = 900, XC = 90, IV = 4.

自我题解
----
### 🦄暴力破解
从字符串下标0开始进行字符判断，

如果判断为  `V`， `L`，`D` 和 `M`，加法运算，

如果判断为`I`、`X`、`C`，先判断其是否属于六种特殊情况，
* 是，减法运算
* 否，加法运算

### 🧚‍ 暂无其他题解


代码1
----
```java
class Solution {
    public int romanToInt(String s) {
        int result = 0;
        for(int i = 0;i < s.length();i++){
            switch(s.charAt(i)){
                case 'M':
                    result+=1000;
                    break;
                case 'D':
                    result+=500;
                    break;
                case 'C':
                    if(((i+1) < s.length()) && s.charAt(i+1)=='M'){
                        result += 900;
                        i++;
                    }else if(((i+1)<s.length()) &&s.charAt(i+1)=='D'){
                        result += 400;
                        i++;
                    }else{
                        result+=100;
                    }
                    break;
                case 'L':
                    result+=50;
                    break;
                case 'X':
                    if(((i+1)<s.length()) &&s.charAt(i+1)=='C'){
                        result += 90;
                        i++;
                    }else if(((i+1)<s.length()) &&s.charAt(i+1)=='L'){
                        result += 40;
                        i++;
                    }else{
                        result+=10;
                    }
                    break;
                case 'V':
                    result+=5;
                    break;
                case 'I':
                    if(((i+1)<s.length()) &&s.charAt(i+1)=='X'){
                        result += 9;
                        i++;
                    }else if(((i+1)<s.length()) &&s.charAt(i+1)=='V'){
                        result += 4;
                        i++;
                    }else{
                        result+=1;
                    }
                    break;
            }
        }
        
        return result;
    }
}
```


### 炫耀一下

![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/13.png)
