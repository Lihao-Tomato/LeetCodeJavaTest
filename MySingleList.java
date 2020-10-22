package LinkList;

public class MySingleList {
    public Node head;

    //判断链表是否为空
    public boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        node.next = this.head;
        this.head = node;
    }

    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        if (this.isEmpty()) {
            this.head = node;
            return;
        }
        Node cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    //打印链表
    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //打印链表
    public void display(Node newHead) {
        Node cur = newHead;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //清空链表
    public void clear() {
        this.head = null;
    }

    //合并两个有序链表
    public void mergeTwoLists(MySingleList list1, MySingleList list2) {
        Node cur1 = list1.head;
        Node cur2 = list2.head;
        Node newNode = new Node(-1);
        Node cur3 = newNode;
        while (cur1 != null && cur2 != null) {
            if (cur1.data >= cur2.data) {
                cur3.next = cur2;
                cur2 = cur2.next;
            } else {
                cur3.next = cur1;
                cur1 = cur1.next;
            }
            cur3 = cur3.next;
        }
        if (cur1 == null){
            cur3.next = cur2;
        } else {
            cur3.next = cur1;
        }
        this.head = newNode.next;
    }

    //链表分割
    public Node partition(Node pHead, int x) {
        Node cur = pHead; //原来链表
        Node bs = null; //小于x的段
        Node be = null;
        Node as = null; //大于x的段
        Node ae = null;

        while (cur != null) {
            if (cur.data < x) {
                if (bs == null) {
                    bs = cur;
                    be = cur;
                } else {
                    be.next = cur;
                    be = be.next;
                }
            } else {
                if (as == null) {
                    as = cur;
                    ae = cur;
                } else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        /**
         * 把前后段代码连起来
         * 1.两个段内，可能有一个是空的
         *   如果as不等于空,ae.next = null;
         * 2.都有数据：
         *   be.next = as;
         */
        if (bs == null) {
            return as;
        }
        if (as == null) {
            return bs;
        }
        be.next = as;
        ae.next = null;
        return bs;
    }

    //删除该链表中重复的结点
    public Node deleteDuplication(Node pHead) {
        Node newHead = new Node(-1);
        Node tmp = newHead;
        Node cur = pHead;
        while (cur != null) {
            if (cur.next != null && cur.data == cur.next.data) {    ////两个判断条件的顺序不能反写
                while (cur.next != null && cur.data == cur.next.data) {
                    cur = cur.next;
                }
                cur = cur.next;
            } else {
                tmp.next = cur;
                tmp = tmp.next;
                cur = cur.next;
            }
        }
        tmp.next = null;
        return newHead.next;
    }

    //链表的回文结构
    public boolean chkPalindrome(Node A) {
        if (A == null) {
            return false;
        }
        // 只有一个结点
        if (A.next == null) {
            return true;
        }
        Node fast = A;
        Node slow = A;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //slow就是中间位置。开始进行第2步
        //2、进行反转
        Node cur = slow.next;
        while (cur != null) {
            Node curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //3、开始判断
        Node left = A;
        while (left != slow) {
            if (A.data != slow.data) {
                return false;
            }
            if (left.next == slow) {
                return true; //偶数情况下
            }
            left = left.next;
            slow = slow.next;
        }
        return true;
    }

    //判断链表是否有环
    public boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    //找到链表环的入口，没有则返回null
    public Node detectCycle(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    //找到两个单链表相交的起始节点
    public Node getIntersectionNode(Node headA, Node headB) {
        if(headA==null || headB==null){
            return null;
        }
        Node curA = headA;
        Node curB = headB;
        while(curA != curB){    //不相交就是null==null
            if(curA != null){
                curA = curA.next;
            } else {
                curA = headB;
            }
            if(curB != null){
                curB = curB.next;
            } else {
                curB = headA;
            }
        }
        return curB;
    }
}
