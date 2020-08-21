# 283. 移动零
问题描述
----
> 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

问题示例
----
> 输入: [0,1,0,3,12]
>
> 输出: [1,3,12,0,0]
> 
> *必须在原数组上操作，不能拷贝额外的数组。*

自我题解
----
### 🦄双指针

利用**双指针**，声明定义0指针zero，下标指针index。

1. #### 移动非0元素
   在下标指针`index`小于数组长度的条件下操作
   * 如果`index!=0 && zero ==0 && zero < index`，将给`zero`指针位置赋值为`index`指针元素，同时index++，zero++。
   * 如果`zero`指针元素不等于0，则zero++。
   * 如果`index`指针元素等于0，则index++。
   * 如果`zero > index`的同时`index`小于数组长度，不符合非零元素在前的条件，`index = zero+1;`
2. #### 0元素后移
   * 在`index`大于数组长度的条件下，进行0元素后移的操作
   * `zero`指针的元素赋值为0，zero++


### 🧚‍ 暴力破解

**暴力破解**比**双指针**逻辑简单，也属于双指针算法。

声明一个计数变量i

对数组进行循环，如果值不为0，则赋值给nums[i]，同时计数变量i加一。

数组循环完后，遍历从计数i到数组长度数组，值均赋值为0.


代码1
----
```java
class Solution {
    public void moveZeroes(int[] nums) {
        int zero = 0;
        int index = 0;
        
        while(zero < nums.length){
            if(index < nums.length){
                if(zero < index && nums[zero]==0 && nums[index]!=0){
                    nums[zero] = nums[index];
                    nums[index] = 0;
                    zero++;
                    index++;
                }else if(nums[zero]!=0){
                    zero++;
                }else if(nums[index]==0){
                    index++;
                } 
            }else{
                nums[zero++] = 0;
            }
            
            if(index < zero){
                if(zero < nums.length-1){
                    index = zero+1;
                }else{
                    break;
                }
                
            }
        }
        
        
    }
}
```

代码2
----
```java
class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for(int j = 0;j < nums.length;j++){
            if(nums[j]!=0){
                nums[i] = nums[j];
                i++;
            }
        }
        for(int j = i;j<nums.length;j++){
            nums[j]=0;
        }
    }
}
```

### 炫耀一下

![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/283.png)


