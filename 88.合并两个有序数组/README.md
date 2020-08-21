# 88. 合并两个有序数组
问题描述
----
> 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
>
> * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
> * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素.

问题示例
----
> 输入:
>
> nums1 = [1,2,3,0,0,0], m = 3
>
> nums2 = [2,5,6],       n = 3
>
> 输出: [1,2,2,3,5,6]


自我题解
----
### 🦄暴力破解

由题知，nums1数组的长度足够长。

所以我们只需要将nums2的元素放到nums1数组中，

再通过`Arrays.sort()`方法对nums1进行排序即可。

### 🦄🧚‍ 双指针 从小到大  

创建一个长度与nums1元素长度m相同的**新数组**arr，并将nums1的元素放到新数组arr中。

利用**双指针**指向新数组arr和nums2数组的下标为0的元素，

从头开始对比nums2和arr数组中的元素大小，大的则放到nums1数组中。

### 🧚‍ 双指针 从大到小

不用创建新数组，直接将nums1**原数组**后多余的长度作为操作空间。

利用**双指针**指向新数组arr和nums2数组的下标为m、n的元素，

从尾部开始对比nums2和arr数组中的元素大小，大的则放到nums1数组中。


代码1
----
```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = 0;
        for(int i=m;i<n+m;i++){
            nums1[i] = nums2[index++];
        }
        Arrays.sort(nums1);
    }
}
```

代码2
----
```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = 0;
        int index2 = 0;
        int[] arr = Arrays.copyOf(nums1,m);
        
        int i = 0;
        while(index<m || index2<n){
            if(index<m && index2 < n){
                nums1[i++] = arr[index]<=nums2[index2]?arr[index++]:nums2[index2++];
            }else if(index<m && index2 >=n){
                System.arraycopy(arr,index,nums1,i,m-index);
                break;
            }else{
                 System.arraycopy(nums2,index2,nums1,i,n-index2);
                break;
            }
        }   
    }
}
```

代码3
----
```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m-1;
        int index2 = n-1;
        int i = m+n-1;
        
        while(index>=0 || index2>=0){
            if(index>=0 && index2>=0){
                nums1[i--] = nums1[index]>=nums2[index2]?nums1[index--]:nums2[index2--];
            }else if(index2<0){
                break;
            }else if(index<0){
                System.arraycopy(nums2,0,nums1,0,index2+1);
                break;
            }
        }   
    }
}
```

### 炫耀一下

双指针1

![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/88.png)

双指针2

![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/88_2.png)


