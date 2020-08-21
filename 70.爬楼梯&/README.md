# 70. 爬楼梯
问题描述
----
> 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
>
> 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
>
> 注意：给定 n 是一个正整数。


问题示例
----
> 输入： 2
>
> 输出： 2
>
> 解释： 有两种方法可以爬到楼顶。
>
> 1.  1 阶 + 1 阶
>
> 2.  2 阶

自我题解
----
### 🦄动态规划

由题目知，爬n层楼梯符合函数`f(n) = f(n-1)+f(n-2)`。

和[**斐波那契数**][a]理论上一样，

对于该题，暴力破解的**递归**会超时,只能考虑其他算法。

利用动态规划，第N层的方法数为第N-1和N-2的爬楼梯方法数之和.

用三种变量进行不断交换计算。

> now = status1 + status2;
>
> status2 = status1;
>
> status1 = now; 

[a]:https://github.com/occlive/LeetCode_Java/tree/master/509.%E6%96%90%E6%B3%A2%E9%82%A3%E5%A5%91%E6%95%B0

### 🧚‍ 暂无其他题解

🤣看不上人家的答案


代码1
----
```java
class Solution {
    public int climbStairs(int n) {
        int result = 0;
        int status = 2;
        int status2 = 3;
        if(n<=3){
            return n;
        }
        for(int i = 3;i<n;i++){
            result = status+status2;
            status = status2;
            status2 = result;
        }
        return result;    
    }
}
```

### 炫耀一下

![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/70.png)


