# 69. x 的平方根
问题描述
----
> 实现 int sqrt(int x) 函数。
>
> 计算并返回 x 的平方根，其中 x 是非负整数。
>
> 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

问题示例
----
> 输入: 8
>
> 输出: 2
> 说明: 8 的平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。

自我题解
----
### 🦄Math.sqrt()

利用Java特有的`Math`工具类的`sqrt()`求平方根方法。

只需将`double`类型转为`int`类型即可

### 🧚‍ 二分查找
平方根的性质： `k² ≤ x`的最大值

通过**二分法**，从0-x为范围进行查找

由于有小数的存在，我们只需找到`k² ≤ x` k的最大值。


代码1
----
```java
class Solution {
    public int mySqrt(int x) {
        
        
        return (int)Math.sqrt(x);
        
    }
}
```

代码2
----
```java
class Solution {
    public int mySqrt(int x) {
        int start = 0;
        int end = x;
        int result  = 0;
        while(start<=end){
            int mid = (start+end)/2;
            if((long)mid*mid <= x){
                start = mid+1;
                result = mid;
            }else{
                end = mid - 1;   
            }   
        }
        return result;
        
    }
}
```

### 炫耀一下

![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/69.png)


