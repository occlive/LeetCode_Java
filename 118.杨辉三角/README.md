# 118. 杨辉三角
问题描述
----
> 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
> 
> 在杨辉三角中，每个数是它左上方和右上方的数的和。


问题示例
----
> 输入: 5
>
> 输出:
```java
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
```

自我题解
----
### 🦄暴力破解

杨辉三角是从高中便开始学习的数学知识，在杨辉三角中，每个数是它左上方和右上方的数的和。

我们根据这种规律，通过获取上一个`List`来对当前`List`进行完善。

不断进行迭代。

### 🧚‍ 暂无其他题解

🤣看不上人家的答案


代码1
----
```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        if(numRows==0){
            return list;
        }      
        for(int i=0;i<numRows;i++){
            List<Integer> l = new ArrayList<>();
            l.add(1);
            if(i>0){
                List<Integer> pixl = list.get(i-1);
                for(int j=1;j<pixl.size();j++){
                    l.add(pixl.get(j)+pixl.get(j-1));
                }
                l.add(1);
            }
            list.add(l);
        }
        return list;
    }
}
```


