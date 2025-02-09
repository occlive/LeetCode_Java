# 167. 两数之和 II - 输入有序数组
问题描述
----
> 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
>
> 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
>
> 说明:
> * 返回的下标值（index1 和 index2）不是从零开始的。
> * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。

问题示例
----
> 输入: numbers = [2, 7, 11, 15], target = 9
>
> 输出: [1,2]
>
> 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。


自我题解
----
### 🦄双指针

定义两个变量作为排序数组的下标充当指针。

分别指向排数数组的头和尾。

* 如果两个下标值相加的结果大于目标值，尾指针减一。

* 如果两个下标值相加的结果小于目标值，头指针加一。

### 🧚‍ 暂无其他题解

🤣看不上人家的答案


代码1
----
```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0,j=numbers.length-1;
        int[] arr= new int[2];
        while(i < j){
            if(numbers[i] + numbers[j] == target){
                arr[0] = i+1;
                arr[1] = j+1;
                return arr;
            }
            
            if(numbers[i] + numbers[j] > target){
                j--;
            }else{
                i++;
            }
        }
        return arr;
    }
}
```

### 炫耀一下

![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/167.png)


