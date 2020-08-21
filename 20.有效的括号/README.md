# 20. 有效的括号
问题描述
----
> 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
>
> 有效字符串需满足：
>
> 1. 左括号必须用相同类型的右括号闭合。
> 2. 左括号必须以正确的顺序闭合。
> 3. 注意空字符串可被认为是有效字符串。


问题示例
----
> 输入: "([)]"
> 
> 输出: false

自我题解
----
### 🦄 `replace()` 实现栈功能

循环并进行操作：
* `replace("()","")` 去除`()`
* `replace("[]","")` 去除`[]`
* `replace("{}","")` 去除`{}`
并对处理的字符串进行判断：
* 如果长度没发生变化，则判断长度是否为0
  * 0，则属于有效的括号。`ture`
  * 不为0，则属于无效的括号。`false`

### 🧚‍ 栈 与 `HashMap`

奇数长度必为*无效括号*

首先将括号装入HashMap中，参数顺序按照
* `map.put(key,value);`
* `map.put(')','(');`
* `map.put(']','[');`
* `map.put('}','{');`

定义一个栈类变量`LinkedList`,并对字符串中的字符进行循环操作：
* 如果字符==map中的key值(右括号)
  * 如果栈为空 或 栈最后一个元素 != map对应字符的value值(左括号)。该字符串属于无效的括号，返回`false`。
  * 如果栈不空，且栈最后一个元素 == map对应字符的value值(左括号)。弹出栈中的字符。
* 如果字符!=map中的key值(右括号),将该字符推入栈中。
  
基本思路：遍历字符串，将左括号放入栈中；对右括号进行判断，两个相同的括号消去。如果栈为空，则属于有效字符。
特殊情况：
1. 栈为空，且字符串遍历到右括号。  右括号太多
2. 栈不为空，但字符串遍历完。      左括号太多
3. map左括号与栈中的左括号不一致。 左右括号不能匹配

### 🧚‍ 字符数组实现栈

奇数长度必为*无效括号*。

定义一个字符数组，对字符串进行循环。
* 左括号，插入字符数组。
* 右括号，进行判断
  * 如果字符数组为空 或 **字符数组**对应的值(**左括号**)与**右括号** 不匹配，属于无效括号，返回`false`。
  * 反之继续循环。
  
 最后，如果字符数组(栈)为空，则属于有效括号，返回`true`




代码1
----
```java
class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        if(len%2!=0){
            return false;
        }
        while(true){
            s = s.replace("()","");
            s = s.replace("[]","");
            s = s.replace("{}","");
            
            if(len == s.length()||len==0 ){
                break;
            }
            len = s.length();
        }
        return len==0?true:false;
    }
}
```

代码2
----
```java
class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
```


代码3
----
```java
class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        
		      if( (len&1) == 1 ) return false;//长度为奇数，必false。
		
        char[] stack = new char[len/2+1];
        
        int point = 0;
        
        for(int i =0; i < len; i++){
            char c = s.charAt(i);
            if(c=='(' || c=='[' || c=='{') stack[point++] = c;
            else{
            	   point--;
                if (point <0 || !(stack[point] == '(' && c==')' || stack[point] == '[' && c==']' || stack[point] == '{' && c=='}')) 
                return false;
            }
        }
        return point == 0;
    }
}
```

### 炫耀一下


![](https://cdn.jsdelivr.net/gh/occlive/ImageStore//javabase/20.png)


