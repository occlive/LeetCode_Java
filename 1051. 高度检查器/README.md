# 1051. 高度检查器
问题描述
----
> 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
>
> 请你返回能让所有学生以 非递减 高度排列的最小必要移动人数。
>
> 注意，当一组学生被选中时，他们之间可以以任何可能的方式重新排序，而未被选中的学生应该保持不动。

问题示例
----
> 输入：heights = [1,1,4,2,1,3]
>
> 输出：3 

自我题解
----
### 🦄 暴力破解

由题知，返回能让所有学生以 非递减 高度排列的最小必要移动人数，就是返回数组中与排序数组不同的元素个数。

通过`Arrays.sort()`对数组进行排序，

循环遍历原数组与排序数组，同一下标元素不同则元素个数加一。


### 🧚‍ 桶排序

返回数组中与排序数组不同的元素个数。

声明1-100个桶，遍历数组，对桶中放入元素次数。

遍历桶排序数组，将元素一个个取出；

从桶中取出元素时，元素的排列顺序就是非递减的，然后与heights中的元素比较，如果不同，计算器就加1。

代码1
----
```java
class Solution {
    public int heightChecker(int[] heights) {
        int[] arr = new int[heights.length];
        System.arraycopy(heights,0,arr,0,heights.length);
        Arrays.sort(arr);
        int count = 0;
        for(int i=0;i<heights.length;i++){
            
            if(arr[i]!=heights[i]){
                count++;
            }
        }
        
        return count;
    }
}
```

代码2
----
```java
class Solution {
    public int heightChecker(int[] heights) {
        int[] arr = new int[101];
        for (int height : heights) {
            arr[height]++;
        }
        int count = 0;
        for (int i = 1, j = 0; i < arr.length; i++) {
            while (arr[i]-- > 0) {
                if (heights[j++] != i) count++;
            }
        }
        return count;
    }
}
```

