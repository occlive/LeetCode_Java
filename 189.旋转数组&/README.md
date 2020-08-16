# 189. 旋转数组
问题描述
----
> 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

*要求使用空间复杂度为 O(1) 的 原地 算法。*

问题示例
----
> 输入: [1,2,3,4,5,6,7] 和 k = 3
>
> 输出: [5,6,7,1,2,3,4]
>
> 解释:
>
> 向右旋转 1 步: [7,1,2,3,4,5,6]
>
> 向右旋转 2 步: [6,7,1,2,3,4,5]
>
> 向右旋转 3 步: [5,6,7,1,2,3,4]

自我题解
----
### 🦄暴力破解

通过多次循环实现旋转，每次循环向右移动一位。

### 🦄双数组

通过复制一个相同的数组，对原数组的值进行移动。

通过for循环依次对原数组的范围进行复制
* 修改数组的前半部分；0到k-1
* 修改数组的后半部分；k到length-1

### 🦄System.array()

和**双数组**实现原理一样，不过利用的是`System.arraycopy()`数组赋值方法;

`System.arraycopy(arr1,start1,arr2,start2,len)`
> arr1:参照数组
> 
> start1：参照数组开始的下标
>
> arr2:赋值数组
>
> start2:赋值数组开始的下标
>
> len:赋值的长度

### 🧚‍ 反转
*在原数组上进行操作*

定义一个反转数组的方法，参数分别为`reverse(数组,开始,结束)`;

1. 先对整个数组进行**反转**
2. 再对数组范围为 0到k-1 进行**反转**
3. 再对数组范围为 k到length 进行**反转**

数组向右平移k位即是：将整个数组**反转**后，再对以k为分界线的两部分数组范围**反转**。


代码1
----
```java
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        for(int i=0;i<k;i++){
            int mid = nums[nums.length-1];
            for(int index = nums.length-1;index > 0;index--){
                nums[index] = nums[index-1]; 
            }
            nums[0] = mid;
        }
    }
}
```

代码2
----
```java
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int[] arr = Arrays.copyOf(nums,nums.length);
        for(int i=0;i<k;i++){
            nums[i] = arr[nums.length-k+i];
        }   
        for(int i=k;i<nums.length;i++){
            nums[i] = arr[i-k];
        }   
    }
}
```

代码3
----
```java
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        int[] arr = new int[nums.length];
        arr = Arrays.copyOf(nums,nums.length);
        System.arraycopy(arr,nums.length-k,nums,0,k);
        System.arraycopy(arr,0,nums,k,nums.length-k);  
    }
}
```

代码4
----
```java
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
```

### 炫耀一下

![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/189.png)


![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/189_1.png)


