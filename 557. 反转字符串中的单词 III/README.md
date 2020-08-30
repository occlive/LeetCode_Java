# 509. 斐波那契数
问题描述
----
> 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
>
> F(0) = 0,   F(1) = 1
>
> F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
> 
> 给定 N，计算 F(N)。
>
>0 ≤ N ≤ 30.

问题示例
----
> 输入：2
> 
> 输出：1
>
> 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.

自我题解
----
### 🦄递归

**递归**是解决斐波那契数思路最简单的解法。

通过递归计算`N-1`和`N-2`的和得到`N`的数；与斐波那契数的定义一致。

注意递归的过程中` N >1`的条件，N 不能小于0。

*递归会重复计算某些值。*

### 🧚‍ 自底向上记忆化

通过从底部开始算斐波那契数，

`F(N)=F(N-1)+F(N-2);`,

定义数组作为记忆体，记忆每个数的斐波那契数，

通过循环计算N的斐波那契数，

并通过数组进行返回。

### 🧚‍ 自顶向下记忆化

通过从顶部开始算斐波那契数，

`F(N)=F(N-1)+F(N-2);`,

由题知，0<= N <=30，只需将`Integer`数组长度记为31即可;

通过对方法的不断调用，完善数组并计算出 N 的斐波那契数。

### 🧚‍ 自底向上进行迭代

逻辑与自底向上记忆化相同，但不用数组进行记忆化，而是用三种变量进行不断交换计算。

* `now`作 N 的斐波那契变量
* `status1`作为 N-1 的斐波那契变量
* `status2`作为 N-2 的斐波那契变量

> now = status1 + status2;
>
> status2 = status1;
>
> status1 = now;
对该引用进行 N-2 次数的迭代。

### 🧚‍    公式法以及矩阵求幂
这两种方法有点恐怖，对线性代数以及Java方法包的公式过于严苛，等我技术好点再写
**这里留个坑**


代码1
----
```java
class Solution {
    public int fib(int N) {
        if(N>1){
            return fib(N-1)+fib(N-2);
        }
        
        return N;
    }
} 
```

代码2
----
```java
class Solution {
    public int fib(int N) {
        if(N<1){
            return N;
        }
        return memory(N);
    }
    public int memory(int N){
        //保存到N的斐波那契数
        int[] arr = new int[N+1];
        //arr[0] = 0;初始化赋值为0 
        arr[1] = 1;
        
        for(int i = 2;i<=N;i++){
            //公式
            arr[i]  =arr[i-1]+arr[i-2];
        }
        return arr[N];
    }
} 
```

代码3
----
```java
class Solution {
    //数字N:0-30
    Integer[] arr = new Integer[31];
    public int fib(int N) {
        if(N<=1){
            return N;
        }
        arr[0] = 0; 
        arr[1] = 1;
        return memory(N);
    }
    public int memory(int N){
        if(arr[N]!=null){
            return arr[N];
        }   
        arr[N] = memory(N-1)+memory(N-2);
        return arr[N];
    }
} 
```

代码4
----
```java
class Solution {
    public int fib(int N) {
        if(N<=0){
            return N;
        }
        if(N<=2){
            return 1;
        }
        int now = 0;
        int status1 = 1;//1的斐波那契数
        int status2 = 1;//2的斐波那契数
        for(int i = 3;i <= N;i++){
            now = status1 + status2;
            status2 = status1;
            status1 = now;
        }
        return now;   
    }
} 
```

### 运算能力

#### ✈自底向上记忆化


![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/509.png)

#### 🚀自顶向下记忆化(呜呼，起飞)


![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/509_1.png)


#### 🛴自底向上进行迭代


![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/509_2.png)





