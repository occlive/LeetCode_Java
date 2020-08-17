# 485. 最大连续1的个数
问题描述
----
> 给定一个二进制数组， 计算其中最大连续1的个数。

问题示例
----
> 输入: [1,1,0,1,1,1]
>
> 输出: 3
>
> 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.

自我题解
----
### 🦄暴力破解

利用循环遍历数组，计算数组种连续的1的个数`num`，并用`max`纪录num的最大值。

### 🧚‍ 暂无其他题解

🚫

代码1
----
```java
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int num = 0,max = 0;
        for(int i:nums){
            if(i==1){
                num++;
            }else{
                max = num>max?num:max;
                num=0;
            }   
        }
        return max<num?num:max;
    }
}
```

算法性能
----

![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/485_1.png)



