import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *             push(x) —— 将元素 x 推入栈中。
 *             pop() —— 删除栈顶的元素。
 *             top() —— 获取栈顶元素。
 *             getMin() —— 检索栈中的最小元素。
 * OJ链接：https://leetcode-cn.com/problems/min-stack
 */

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();//入
        minStack = new Stack<>();//出
    }

    public void push(int x) {
        //1、stack是一定需要放元素的
        //2、最小栈当中 是否存放数据   x<= 最小栈的栈顶元素
        stack.push(x);
        if (minStack.empty()){
            minStack.push(x);
            return;
        }
        if (x <= minStack.peek()){
            minStack.push(x);
        }
    }

    public void pop() {
        //1、stack是一定需要弹出元素的
        //2、最小栈当中 是否弹出数据    x  ==  最小栈的栈顶元素
        int tmp = stack.pop();
        if (tmp == minStack.peek()){
            minStack.pop();
        }
    }

    public int top() {
        //跟最小栈没有关系
        return stack.peek();
    }

    public int getMin() {
        //每次返回最小栈的栈顶元素
        return minStack.peek();
    }
}

public class MinStackTest {
    public static void main(String[] args) {
        System.out.println("最小栈");
    }
}
