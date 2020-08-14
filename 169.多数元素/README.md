# 169. 多数元素
问题描述
----
> 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于` ⌊ n/2 ⌋ `的元素。
>
> 你可以假设数组是非空的，并且给定的数组总是存在多数元素。

问题示例
----
> 输入: [3,2,3]
>
> 输出: 3

> 输入: [2,2,1,1,1,2,2]
>
> 输出: 2

自我题解
----
### 🦄Arrays.sort()
由题目可知，数组的多数元素在数组的出现次数最少为`n/2`，

我们通过`Arrays.sort()`对数组进行排序后，

处于排序数组中间的必为多数元素。


### 🧚‍ 摩尔投票法

*摩尔投票法：每次从序列里选择两个不相同的数字删除掉（或称为“抵消”），最后剩下一个数字或几个相同的数字，就是出现次数大于总数一半的那个。*

由题目可知，数组的多数元素在数组的出现次数最少为`n/2`，多数元素的个数是数组中最大的。

我们可以通过摩尔投票法，通过对数组进行遍历：

1. 针对指定的数组元素开始计数,对数组遍历的数进行判断:
   * 相同，计数加一
   * 不同，计数减一
2. 直到减到小于0为止，换另一个数组元素继续之前的数组遍历;
3. 数组遍历完成后，返回的指定元素值即为多数元素。

通俗点讲就是游戏内多个阵营火拼，以1V1为前提，人多的阵营必定赢。

代码1
----
```java
class Solution {
    public int majorityElement(int[] nums) {
        
        
        Arrays.sort(nums);
        return nums[nums.length/2];
        
    }
}
```

代码2
----
```java
class Solution {
    public int majorityElement(int[] nums) {
		      return majorityElement(nums, 0);
    }
	   public int majorityElement(int[] nums, int start) {
		      int count = 0;
				    int m = nums[start];
				    for(int i = start; i < nums.length; i++) {
					       if(nums[i] == m) {
					      	    count++;
				        }else {
				      		    count--;
				        }
				        if(count < 0) {
				      		    return majorityElement(nums, i);
				        }
			     }
			      	  return m;
			 }
}
```

### 炫耀一下

![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/169.png)


![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/169_1.png)


