# 27. 移除元素
问题描述
----
> 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
> 
> 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
> 
> 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。


问题示例
----
> 给定 nums = [3,2,2,3], val = 3,
> 
> 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

*你不需要考虑数组中超出新长度后面的元素。*


自我题解
----
### 🦄双指针(双下标)

由于题目有**O(1) 额外空间**的限制条件，我们无法创建新的数组空间去操作；

同时必须在**原数组**上进行修改，我们可以通过数组的下标进行操作；

顺序**可以改变**，不用考虑数组顺序问题极大简化。

首先声明初始化 一个下标index(值为0),

for循环遍历数组，如果数组元素与val不同：
1. 将数组下标为index的值替换为 当前数组元素nums[i];
2. 下标index加一;
重复以上操作

### 🧚‍ 暂无其他题解

🤣看不上人家的答案


代码
----
```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i]!=val){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
```

### 炫耀一下

![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/27.png)

