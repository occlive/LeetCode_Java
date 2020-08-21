# 121. 买卖股票的最佳时机
问题描述
----
> 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
>
> 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
>
> 注意：你不能在买入股票前卖出股票。

问题示例
----
> 输入: [7,1,5,3,6,4]
>
> 输出: 5
>
> 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。


自我题解
----
### 🦄暴力破解

计算股票最佳购买时机，即计算数组元素的最大差值(且减数下标<被减数下标)。

通过循环嵌套，计算每个元素与其他元素的减速情况，比较出差值最大的即可。

### 🧚‍ 动态规划

计算股票最佳购买时机，即计算数组元素的最大差值(且减数下标<被减数下标)。

我们通过**一次循环**进行判断：

1. 是否是当前最小值
2. 当前值减去当前最小值的差是否为最大


代码1
----
```java
class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        for(int i = 0;i<prices.length;i++){
            for(int j = i+1;j<prices.length;j++){
                result = (prices[j]-prices[i])>result?prices[j]-prices[i]:result;   
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
    public int maxProfit(int[] prices) {
        int max = 0;
        int minp = Integer.MAX_VALUE;
        for(int i = 0;i < prices.length;i++){
            if(prices[i] < minp){
                minp = prices[i];
            }else if(prices[i]-minp > max){
                max = prices[i]-minp;
            }
            
        }
        return max;
    }
}
```

炫耀一下
----

![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/121.png)

