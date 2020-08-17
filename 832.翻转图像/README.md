# 832. 翻转图像
问题描述
----
> 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
>
> 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
>
> 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。


问题示例
----
> 输入: [[1,1,0],[1,0,1],[0,0,0]]
>
> 输出: [[1,0,0],[0,1,0],[1,1,1]]
>
> 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
>
> 1 <= A.length = A[0].length <= 20
>
> 0 <= A[i][j] <= 1
自我题解
----
### 🦄暴力破解

定义一个新的二维数组，将原数组的值翻转赋值给新数组，

再将新的二维数组进行反转。

### 🧚‍ 原地翻转

与暴力破解相同，不过是直接在原数组上进行操作。

代码1
----
```java
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int len = A[0].length-1;
        int[][] arr = new int[A.length][A[0].length];
        
        //翻转
        for(int i=0;i<A.length;i++){
            for(int j = 0;j<A[i].length;j++){
                arr[i][len-j] = A[i][j];
            }
        }
        //反转
        for(int i=0;i<A.length;i++){
            for(int j = 0;j<A[i].length;j++){
                arr[i][len-j] = arr[i][len-j]==0?1:0;
            }
        }
        return arr;
    }
}
```

代码2
----
```java
class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        int C = A[0].length;
        for (int[] row: A)
            for (int i = 0; i < (C + 1) / 2; ++i) {
                int tmp = row[i] ^ 1;
                row[i] = row[C - 1 - i] ^ 1;
                row[C - 1 - i] = tmp;
            }

        return A;
    }
}

```

炫耀一下
----


![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/832.png)


![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/832_1.png)

