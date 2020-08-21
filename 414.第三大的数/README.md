# 414. 第三大的数
问题描述
----
> 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。

问题示例
----
> 输入: [3, 2, 1]
>
> 输出: 1
>
> 解释: 第三大的数是 1.

> 输入: [2, 2, 3, 1]
>
> 输出: 1
>
>解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。存在两个值为2的数，它们都排第二。

自我题解
----
### 🦄Arrays.sort()
*Java永远的神。———策策*
首先用`Arrays.sort()`对数组进行排序，

对排序后的数组从后开始遍历

对数组的值进行计数，如果值次数大于(中间变量进行判断)三次，则返回该值

如果循环完成后，次数小于三次，则返回最大值(数组最后一位元素)

### 🧚‍ 暴力破解

声明定义三个变量，初始化为类型最小值`Long.MIN_VALUE`，分别代表该数组的<kbd>第一大</kbd>、<kbd>第二大</kbd>以及<kbd>第三大元素</kbd>。

通过`for`循环遍历数组，并进行如下判断
* 如果元素大于<kbd>第一大变量</kbd>
  * 将<kbd>第二大变量</kbd>值赋值给<kbd>第三大变量</kbd>
  * 将<kbd>第一大变量</kbd>值赋值给第二大变量</kbd>
  * 将元素值赋值给<kbd>第一大变量</kbd>
* 如果元素小于<kbd>第一大变量</kbd>，大于<kbd>第二大变量</kbd>
  * 将第二大变量值赋值给<kbd>第三大变量</kbd>
  * 将元素值赋值给<kbd>第二大变量</kbd>
* 如果元素小于<kbd>第二大变量</kbd>，大于<kbd>第三大变量</kbd>
  * 将元素值赋值给<kbd>第三大变量</kbd>
  
结束循环后，判断<kbd>第三大变量</kbd>是否值为类型最小值`Long.MIN_VALUE`或是否为第二大值
* 是，数组不存在第三大的值。返回<kbd>第三大变量</kbd>。
* 不是，存在第三大的值。返回<kbd>第一大变量</kbd>。

代码1
----
```java
class Solution {
    public int thirdMax(int[] nums) {
        //排序
        Arrays.sort(nums);
        
        int num=1,ans=0,now=nums[nums.length-1];
        for(int i = nums.length-2; i >= 0;i--){
            if(nums[i]<now){
                num++;
                now=nums[i];
            }
            if(num==3){
                ans = nums[i];
                return ans;
            }
        }
        
        return nums[nums.length-1];
        
        
    }
}
```

代码2
----
```java
class Solution {
    public int thirdMax(int[] nums) {
       long first=Long.MIN_VALUE,second=Long.MIN_VALUE,third=Long.MIN_VALUE;
		for(long num:nums){
			if(num>first){
				third=second;
				second=first;
				first=num;
			}else if(num>second&&num<first){
				third=second;
				second=num;
			}else if(num>third&&num<second){
				third=num;
			}
		}
		return (third==Long.MIN_VALUE||third==second)?(int)first:(int)third;
    }
}
``` 
