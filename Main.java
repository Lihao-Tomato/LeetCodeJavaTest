import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * Description:删数
 *          有一个数组a[N]顺序存放0~N-1，要求每隔两个数删掉一个数，到末尾时循环至开头继续进行，
 *          求最后一个被删掉的数的原始下标位置。
 *          以8个数(N=7)为例:｛0，1，2，3，4，5，6，7｝，0->1->2(删除)->3->4->5(删除)->6->7->0(删除),如此循环直到最后一个数被删除。
 * OJ链接：https://www.nowcoder.com/questionTerminal/f9533a71aada4f35867008be22be5b6e
 * 解题思路：创建一个循环链表，然后每隔两个数开始删
 */

class Node{
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}

public class Main{

    public static Node head = null;
    public static Node last = null;

    public static void createLoopList(int n){
        head = new Node(0);
        Node cur = head;
        for (int i = 1; i < n; i++) {
            Node node = new Node(i);
            cur.next = node;
            cur = node;
        }
        last = cur;
        cur.next = head;
    }

    public static void removeNode(){
        Node cur = head;
        Node prev = cur.next;
        cur = cur.next.next;
        while (size() > 1){
            if(cur == head){
                last.next = head.next;
                head = head.next;
            } else if (cur == last){
                prev.next = head;
                last = prev;
            } else {
                prev.next = cur.next;
            }
            prev = cur.next.next;
            cur = cur.next.next.next;
        }
    }

//    public static void display(){
//        Node cur = head;
//        while (cur != last){
//            System.out.print(cur.val+" ");
//            cur = cur.next;
//        }
//        System.out.print(cur.val+" ");
//        cur = cur.next;
//    }

    public static int size(){
        Node cur = head;
        int size = 0;
        while (cur != last){
            size++;
            cur = cur.next;
        }
        return size+1;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        createLoopList(n);
        removeNode();
        System.out.println(head.val);
    }
}