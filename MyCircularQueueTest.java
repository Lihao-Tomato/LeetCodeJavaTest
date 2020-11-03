/**
 * Created with IntelliJ IDEA.
 * Description:设计一个循环队列
 * OJ链接：https://leetcode-cn.com/problems/design-circular-queue/
 */

class MyCircularQueue {

    public int[] elem;
    public int front;
    public int rear;
    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        this.elem = new int[k + 1];
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        //1、判断是否为满的
        if (isFull()) {
            return false;
        }
        //2、rear -->
        this.elem[this.rear] = value;
        this.rear = (this.rear + 1) % this.elem.length;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        //1、是否为空   front和rear相遇的时候
        if (isEmpty()) {
            return false;
        }
        this.front = (this.front + 1) % this.elem.length;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return this.elem[this.front];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int index = this.rear == 0 ? this.elem.length - 1 : this.rear - 1;
        return this.elem[index];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (this.rear + 1) % this.elem.length == this.front;
    }
}

public class MyCircularQueueTest {
    public static void main(String[] args) {
        System.out.println("循环队列...");
    }
}
