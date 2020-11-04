import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Description:请你仅使用两个栈实现先入先出队列。队列应当支持一般队列的支持的所有操作（push、pop、peek、empty）：
 * 实现 MyQueue 类：
 *              void push(int x) 将元素 x 推到队列的末尾
 *              int pop() 从队列的开头移除并返回元素
 *              int peek() 返回队列开头的元素
 *              boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * OJ链接：https://leetcode-cn.com/problems/implement-queue-using-stacks
 * 解题思路：https://blog.csdn.net/qq_43609802/article/details/109491137
 */

class MyQueue {

    private Stack<Integer> s1;
    private Stack<Integer> s2;
    /** Initialize your data structure here. */
    public MyQueue() {
        s1 = new Stack<>(); //入栈
        s2 = new Stack<>(); //出栈
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (s2.empty()){
            while (!s1.empty()){
                s2.push(s1.pop());
            }
        }
        if (!s2.empty()){
            return s2.pop();
        }
        return -1;  //两个栈都为空
    }

    /** Get the front element. */
    public int peek() {
        if (s2.empty()){
            while (!s1.empty()){
                s2.push(s1.pop());
            }
        }
        if (!s2.empty()){
            return s2.peek();
        }
        return -1;  //两个栈都为空
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.empty() && s2.empty();
    }
}

public class MyQueueTest {
    public static void main(String[] args) {
        System.out.println("用栈实现队列");
    }
}
