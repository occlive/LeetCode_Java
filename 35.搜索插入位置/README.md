# 35. 搜索插入位置
问题描述
----
> 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
> 
> 你可以假设数组中无重复元素。


问题示例
----
> 输入: [1,3,5,6], 5
>
> 输出: 2

> 输入: [1,3,5,6], 2
>
> 输出: 1

> 输入: [1,3,5,6], 0
>
> 输出: 0

自我题解
----
### 🦄暴力破解

已知数组为**排序**数组，只需要将target插入数组中，使得数组还为**排序数组**。

我们可以暴力破解，通过for循环遍历该数组，找到其适合的下标位置。


### 🦄二分查找法
在排序数组中，**二分查找法**可以快速的查找到想要的值的下标。
 
首先声明初始化start、end和mid变量,作为二分法的前提条件;

1. mid变量作为start和end的中间变量，`mid=(start+end)/2`，

2. 如果排序数组对应mid下标的元素值与target值相同，则直接返回mid;

3. 如果元素值比target值大，则`end = mid-1;`缩小一半的查找范围;

4. 如果元素值比target值小，则`start = mid+1;`缩小一半的查找范围;

重复以上步骤，直到 `start > end`。

以上为二分查找法，如果查找不到target值，则需要将target插入到排序数组中,

经过以上步骤，mid下标对应的排序数组元素属于target值的邻元素(左或右),

通过对比排序数组对应mid下标的元素值与target的大小，可以判断target插入的位置: 

* `nums[mid]>target`
  * target在nums[mid]之前
  * 返回mid

* `nums[mid]<target`
  * target在nums[mid]之后
  * 返回mid+1



### 🧚‍ 暂无其他题解

🤣看不上人家的答案


代码1
----
```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=target){
                return i;
            }
                
        }
        return nums.length;
        
    }
}
```

代码2
----
```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        
        int start = 0;
        int end = nums.length-1;
        int mid=0;
        if(end==-1){
            return 0;
        }
        while(start <= end){
            mid = (start+end)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                start = mid+1;
            }else if(nums[mid]>target){
                end = mid-1;
            }
        }
        
        return nums[mid] < target?mid+1:mid;
        
    }
}
```

### 炫耀一下

![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/35.png)


![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/35_1.png)

