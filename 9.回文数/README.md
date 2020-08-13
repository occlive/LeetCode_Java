# 9. 回文数
问题描述
----
> 判断一个整数是否是回文数。
>
> 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

问题示例
----
> 输入: 121
>
> 输出: true

> 输入: -121
>
> 输出: false
>
> 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

> 输入: 10
>
> 输出: false
>
> 解释: 从右向左读, 为 01 。因此它不是一个回文数。


自我题解
----
### 🦄StringBuffer
`StringBuffer`用习惯了(笑)，`reverse()`方法是真的好用。

直接翻转int值，再进行判等即可

翻转的时候需要考虑

1. **负数问题**
2. **int类型取值范围问题**


### 🧚‍ 数学
与数字反转一样，将值反转后进行判等

公式：
> i = 0;
>
> i = i*10 + x%10;
>
> x = x/10;

代码1
----
```java
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || x > 2147483647 || x < -2147483647) {
			return false;
		}
		StringBuffer sb = new StringBuffer(x + "");

		sb.reverse();

		long i = Long.parseLong(sb.toString());

		if (x == i) {
			return true;
		}

		return false;
    }
}
```

代码2
----
```java
class Solution {
    public boolean isPalindrome(int x) {
        if ((x%10 == 0 && x != 0) || x < 0){
            return false;
        }
        int temp = x;
        int res = 0;
        while(x > 0){
            res = res * 10 + x % 10;
            x /= 10;
            
        }
        return temp == res;
    }
}
```
