# 9. 回文数
问题描述
----
> 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

问题示例
----
> 输入: 121

> 输出: true

> 输入: -121

> 输出: false

> 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

> 输入: 10

> 输出: false

> 解释: 从右向左读, 为 01 。因此它不是一个回文数。


自我题解
----
### 🦄StringBuffer
数组中的两个元素相加为目标值，返回两个元素的数组。

首先我们能想到最简单的办法就是**暴力破解**

从数组第一个元素开始，与数组其他元素进行相加，结果与目标值匹配

相同则记录数组，不同则继续之前操作。

### 🧚‍Map.containsKey()
依次将数组的[值]与[下标]放入map中，

在放入过程中进行判断，如果map中**包含**key值为[target-当前数组值]

答案即为：[通过map的get方法获取key值下标，当前下标]

如果没有则继续添加数值，直至数值全部加入map。

代码1
----
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int ans[] = new int[2];
        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(nums[i]+nums[j]==target && i != j){
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
        
    }
}
```

代码2
----
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numsMap = new HashMap<>();
        for (int i = 0;i <= nums.length -1;i++){
            if(numsMap.containsKey(target - nums[i]))
                return new int[] {numsMap.get(target - nums[i]),i};
            else
                numsMap.put(nums[i],i);
        }
        return null;
    }
}
```
