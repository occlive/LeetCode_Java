# 119. 杨辉三角 II
问题描述
----
> 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
> 
> 在杨辉三角中，每个数是它左上方和右上方的数的和。


问题示例
----
> 输入: 3
>
> 输出: [1,3,3,1]

自我题解
----
### 🦄递归

求杨辉三角单个行的`List`，且行数是从0开始的。

利用递归获取上一行杨辉三角行`List`的情况，对当前杨辉三角行`List`进行补充完善。

### 🧚‍ 暂无其他题解

🤣看不上人家的答案


代码1
----
```java
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if(rowIndex==0){
            return list;   
        }
        List<Integer> l = getRow(rowIndex-1);        
        for(int i=1;i<l.size();i++){
            list.add(l.get(i-1)+l.get(i));
        }
        list.add(1);
        return list;
    }
}
```
