# 7.整数反转

问题描述
----
> 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转

问题示例
----
> 输入: 123
>
> 输出: 321

> 输入: -123
>
> 输出: -321

> 输入: 120
>
> 输出: 21

自我题解
----
### 🦄StringBuffer
对于反转，我能第一想到的就是`StringBuffer`的字符反转方法`reverse();`

将`int`类型转为`StringBuffer`,用`reverse()`进行反转，

再将`StringBuffer`转为`int`。

同时还需要考虑
* **符号**
* **后置零**
* **32位限制**


### 🧚‍ 数学
将int类型值取余10，获得最后一位数并x10，

然后对int类型值除以10，再重复之前的操作。

优势：
* 此操作**符号**没有改变
* **零**自动消除，不用考虑
* 使用`double`类型(8字节)将结果保存，转为`int`类型(4字节)通过值判等
   * 不等则超过32位限制，结果为0
   * 相等则未超过32位限制，结果为被转换的`int`类型值


代码1
----
```java
class Solution {
    public int reverse(int x) {
		//32位
		if(x<=-2147483648) {
			return 0;
		}
		boolean b = false;
		// 去符号
		if (x < 0) {
			b = true;
			x= -x;
		}else if(x==0) {
			return 0;
		}
		
		String str = x + "";
		

		// 去零
		while (str.lastIndexOf("0") == str.length() - 1) {
			str = str.substring(0, str.length() - 1);
		}

		StringBuffer sb = new StringBuffer(str);
		sb.reverse();
	

		long l = Long.parseLong(sb.toString());
		//32位
		if(l>2147483647) {
			return 0;
		}
		int result = (int)l;
		result = b ? -result : result;
		
		return result;

	}
}
```

代码2
----
```java
class Solution {
    public int reverse(int x) {
        double n=0;
        while(x!=0){
            n=n*10+x%10;
            x=x/10;
        }
        return (int)n==n?(int)n:0;
    }
}
```
 
