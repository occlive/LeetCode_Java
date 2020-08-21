# 66. 加一
问题描述
----
> 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
>
> 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
>
> 你可以假设除了整数 0 之外，这个整数不会以零开头。

问题示例
----
> 输入: [1,2,3]
>
> 输出: [1,2,4]
>
> 解释: 输入数组表示数字 123。

自我题解
----
### 🦄 递归
由题知，数组非空且非负数；0不开头(整数0除外)。

我们先将数组最后一位元素加一，然后对其调用递归函数`MoreTen`进行判断：

* 该元素等于10
   * 该元素非首元素
     1. 该元素置0
     2. 前一位元素+1
     3. **继续调用`MoreTen`函数**
   * 该元素为首元素
     1. 该元素置0
     2. 新数组在原数组的基础上，长度+1
     3. 数组首元素置1
     4. 返回新数组
* 该元素小于10
   * 直接返回原数组



### 🧚‍ 暴力破解

按不同情况进行区分，
1. 如果数组最后一位元素小于9
   * 最后一位元素+1并返回原数组
2. 如果数组最后一位元素等于9
   * 最后一位元素+1，对数组从后往前进行遍历
     * 如果遍历到的元素==10，则将该元素置0，且前一位元素+1.
   * 遍历完成后，判断首元素是否为10
     * 为10，数组长度加1，首元素置1，返回新的数组
     * 不为10，返回改变的原数组


代码1
----
```java
class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length-1]+=1;   
        digits = MoreTen(digits,digits.length-1);
        return digits;
    }
    public int[] MoreTen(int[] nums,int index){
        if(index > 0 && nums[index] == 10){
            nums[index] = 0;
            nums[index-1] +=1;
            nums = MoreTen(nums,index-1);
        }else if(index == 0 && nums[index] == 10){
            nums[index] = 0;
            nums = new int[nums.length+1];
            nums[0] = 1;
        } 
        return nums;
    }
}
```

代码2
----
```java
class Solution {
    public int[] plusOne(int[] digits) {
        if(digits[0]==0){
            digits[0] = 1;
            return digits;
        }
        int index = digits.length-1;
        if(digits[index]==9){
            
            digits[index]++;
            while(digits[index]==10 && index != 0){
                digits[index]=0;
                index--;
                digits[index]++;
            }
            
        }else{
            digits[digits.length-1]  =digits[digits.length-1] + 1;
        }
        if(digits[0]==10){
            digits = new int[digits.length+1];
            digits[0] = 1;
        }
        return digits;
        
    }
}
```

### 炫耀一下


![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/66.png)

