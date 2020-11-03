import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * OJ链接：https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106
 * 解题思路：新建一个栈，将数组A压入栈中，当栈顶元素等于数组B时，就将其出栈，当循环结束时，判断栈是否为空，若为空则返回true.
 */
public class IsPopOrder {
    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,2,1};
        System.out.println(isPopOrder(pushA, popA));
    }

    public static boolean isPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0 || popA.length == 0 || popA.length != pushA.length){
            return false;
        }
        Stack<Integer> stack = new Stack<>(); //辅助栈
        int popAIndex = 0;    //标记popA数组下标
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.empty() && stack.peek() == popA[popAIndex]){ //相等则栈顶元素出栈，popA数组下标往后移一位，直到不相等或栈为空
                stack.pop();
                popAIndex++;
            }
        }
        System.out.println(stack);
        return stack.empty();
    }
}
