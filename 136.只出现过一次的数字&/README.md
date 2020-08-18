# 136. 只出现一次的数字
问题描述
----
> 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。


问题示例
----
> 输入: [2,2,1]
>
> 输出: 1

自我题解
----
### 🦄排序 暴力破解

利用`Arrays.sort()`将数组排序，

循环(步为2)判断该元素与下一元素是否相等。

相等则继续循环，不等则返回该数组元素。


### 🦄HashMap

将数组元素和数组元素出现的次数存入`HashMap`中，

`HashMap(值,次数)`

再通过循环map返回的key值集合`Set`，

查找数组次数为 1 的情况，并返回HashMap对应的值。

```java
//map.keySet();将key值集合作为set返回

//for(i:map.keySet()){}
//i 为Key值，值
//map.get(i); 为Value值，次数
```


### 🧚‍ 异或

由于题目为数字，可以利用**位运算**的**异或**

* 任何数和 00 做异或运算，结果仍然是原来的数。
  * `a ⊕ 0 = a;`
* 任何数和其自身做异或运算，结果是 0。
  * `a ⊕ a = 0;`
* 异或运算满足交换律和结合律
  * `a ⊕ b ⊕ a = a ⊕ a ⊕b;`
  * `a ⊕ a ⊕b = 0 ⊕ b;`
  * `0 ⊕ b = b;`

通过对数组进行异或，元素出现两次则异或为0，最后的结果必定为只出现一次的数。





代码1
----
```java
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for(int i= 0;i<nums.length;i+=2){
            if(i+1>nums.length-1 || nums[i]!=nums[i+1]){
                result = nums[i];
                break;
            }
        }
        
        return result;
    }
}
```

代码2
----
```java
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int num = 0;
        
        for(Integer i:nums){
            Integer value = map.get(i);
            num = value==null?1:2;
            map.put(i,num);
        }
        
        for(Integer i:map.keySet()){
            if(map.get(i)==1){
                return i;
            }
        }
        return -1;
        
    }
}
```

代码3
----
```java
class Solution {
    public int singleNumber(int[] nums) {
        //不使用额外空间
        int result = 0;
        for(int i:nums){
            result^=i;
        }
        
        return result;
        
    }
}
```

### 炫耀一下

异或

![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/136.png)


HashMap

![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/136_1.png)


