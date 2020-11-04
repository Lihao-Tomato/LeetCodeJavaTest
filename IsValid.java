import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *             有效字符串需满足：
 *             左括号必须用相同类型的右括号闭合。
 *             左括号必须以正确的顺序闭合。
 *             注意空字符串可被认为是有效字符串
 * OJ链接：https://leetcode-cn.com/problems/valid-parentheses
 * 解题思路：需要一个栈。用来存放左括号，然后进行匹配操作，但是需要考虑好各种情况
 *         1、遇到左括号就入栈
 *         2、遇到右括号，看一下栈顶元素的括号是否和当前右括号匹配---->匹配：出栈  不匹配：右括号匹配错误
 *         3、直到整个字符串遍历完成
 *         4、遍历完成后需要判断栈是否为空，栈不为空--->左括号多，为空--->返回true
 */
public class IsValid {
    public static void main(String[] args) {
        System.out.println(isValid("([)])"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                stack.push(Character.valueOf(s.charAt(i)));
            } else {
                if (stack.empty()){    //右括号比左括号多的情况，栈为空
                    return false;
                } else {
                    char chLeft = stack.peek().charValue(); //左括号
                    char chRight = s.charAt(i); //右括号
                    if ((chLeft == '(' && chRight == ')') || (chLeft == '[' && chRight == ']') || (chLeft == '{' && chRight == '}')) {
                        stack.pop();    //匹配则出栈
                    } else {
                        break;  //不匹配直接跳出
                    }
                }
            }
        }
        return stack.empty();
    }
    
    //更好的解题思路
    public boolean isValid1(String s) {
        if(s.length()%2!=0){
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            //遇到左括号则将它对应的右括号入栈
            if(c=='{'){
                stack.push('}');
            } else if (c=='['){
                stack.push(']');
            } else if (c=='('){
                stack.push(')');
            } else if(stack.isEmpty() || c!=stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
