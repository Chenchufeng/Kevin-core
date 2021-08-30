package algorithm.reverselist;

import lombok.val;

/**
 * @Author: Kevin
 * @Date: 2021/8/30 21:22
 * @Description:  反转链表
 */
public class ReverseList {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    //迭代
    public static ListNode iterate(ListNode head){
        ListNode next,prev=null;
        ListNode curr=head;

        while (curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }


    public static void main(String[] args) {
        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode prev = iterate(node1);
        System.out.println(prev);
    }

}