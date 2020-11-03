import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:根据 逆波兰表示法，求表达式的值。有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * OJ链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
 */

public class EvalRPNDemo {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        int num1,num2;  //参与运算的数
        for (String str : tokens) {
            switch (str){
                case "+":
                    num1 = numStack.pop();
                    num2 = numStack.pop();
                    numStack.push(num2 + num1); //计算后入栈
                    break;
                case "-":
                    num1 = numStack.pop();
                    num2 = numStack.pop();
                    numStack.push(num2 - num1); //计算后入栈
                    break;
                case "*":
                    num1 = numStack.pop();
                    num2 = numStack.pop();
                    numStack.push(num2 * num1); //计算后入栈
                    break;
                case "/":
                    num1 = numStack.pop();
                    num2 = numStack.pop();
                    numStack.push(num2 / num1); //计算后入栈
                    break;
                default:
                    numStack.push(Integer.valueOf(str)); //不是运算符直接压入栈
                    break;
            }
        }
        return numStack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
        int result = evalRPN(tokens);
        System.out.println(result);
    }
}
