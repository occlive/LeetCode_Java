# 1.两数之和

问题描述
----
> 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

问题示例
----
> 给定 nums = [2, 7, 11, 15], target = 9

> 因为 nums[0] + nums[1] = 2 + 7 = 9

> 所以返回 [0, 1]

自我题解
----
### 🦄暴力破解
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
