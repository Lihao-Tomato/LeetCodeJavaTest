package LinkList;

public class TestMySingleList {
    public static void main(String[] args) {
        MySingleList list1 = new MySingleList();
        list1.addLast(1);
        list1.addLast(12);
        list1.addLast(3);
        list1.display();
        MySingleList list2 = new MySingleList();
        list2.addLast(5);
        list2.addLast(7);
        list2.addLast(9);
        list2.display();

        //合并两个有序链表
        System.out.println("=========合并两个有序链表==========");
        MySingleList mySingleList = new MySingleList();
        MySingleList newList = new MySingleList();
        newList.mergeTwoLists(list1,list2);
        newList.display();

        //链表分割
        MySingleList list = new MySingleList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(3);
        list.addLast(4);
        list.addLast(4);
        list.addLast(5);
        list.addLast(5);
        System.out.println("=========链表分割==========");
        list1.display();
        Node newHead = mySingleList.partition(list1.head,7);
        mySingleList.display(newHead);

        //删除该链表中重复的结点
        System.out.println("=========删除该链表中重复的结点==========");
        list.display();
        Node head = list.deleteDuplication(list.head);
        mySingleList.display(head);

        //链表的回文结构
        System.out.println("=========链表的回文结构==========");
        MySingleList list3 = new MySingleList();
        list3.addLast(1);
        list3.addLast(2);
        list3.addLast(3);
        list3.addLast(3);
        list3.addLast(2);
        list3.addLast(1);
        System.out.println(list.chkPalindrome(list3.head));

        //判断链表是否有环
        MySingleList list4 = new MySingleList();
        list4.addLast(1);
        list4.addLast(2);
        list4.addLast(3);
        list4.addLast(4);
        list4.addLast(5);
        System.out.println("=========判断链表是否有环==========");
        System.out.println(list4.hasCycle(list4.head));

        //找到链表环的入口
        System.out.println("=========找到链表环的入口==========");
        System.out.println(list4.deleteDuplication(list4.head).data);
    }
}
