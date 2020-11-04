/**
 * Created with IntelliJ IDEA.
 * Description:设计实现双端队列。
 * 你的实现需要支持以下操作：
 *              MyCircularDeque(k)：构造函数,双端队列的大小为k。
 *              insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
 *              insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
 *              deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
 *              deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
 *              getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
 *              getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
 *              isEmpty()：检查双端队列是否为空。
 *              isFull()：检查双端队列是否满了。
 * OJ链接：https://leetcode-cn.com/problems/design-circular-deque
 * 解题思路：和循环队列一样的设计，只不过是多了队首操作而已
 */

class MyCircularDeque {
    private final int[] elem;
    private int front;
    private int rear;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        elem = new int[k+1];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (this.isFull()){
            return false;
        }
        // front前一个位置
        this.elem[(this.front+this.elem.length-1)%this.elem.length] = value;
        this.front = (this.front+this.elem.length-1)%this.elem.length;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (this.isFull()){
            return false;
        }
        this.elem[this.rear] = value;
        this.rear = (this.rear+1)%this.elem.length;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (this.isEmpty()){
            return false;
        }
        this.front = (this.front+1)%this.elem.length;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (this.isEmpty()){
            return false;
        }
        this.rear = (this.rear+this.elem.length-1)%this.elem.length;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (this.isEmpty()){
            return -1;
        }
        return this.elem[this.front];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (this.isEmpty()){
            return -1;
        }
        return this.elem[(this.rear+this.elem.length-1)%this.elem.length];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return this.rear == this.front;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (this.rear+1)%this.elem.length == this.front;
    }
}

public class MyCircularDequeTest {
    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        System.out.println(myCircularDeque.insertLast(1));
        System.out.println(myCircularDeque.insertLast(2));
        System.out.println(myCircularDeque.insertLast(3));
        System.out.println("");
    }
}
