//package simple;
//
///**
// * @Author: Kevin
// * @Date: 2021/9/26 22:08
// * @Description: 给你两个非空 的链表，表示两个非负的整数。它们每位数字都是按照逆的方式存储的，并且每个节点只能存储一位数字。
// * 请你将两个数相加，并以相同形式返回一个表示和的链表。
// * 你可以假设除了数字 0 之外，这两个数都不会以 0开头。
// * <p>
// * 输入：l1 = [2,4,3], l2 = [5,6,4]
// * 输出：[7,0,8]
// * 解释：342 + 465 = 807.
// * <p>
// * 示例 2：
// * 输入：l1 = [0], l2 = [0]
// * 输出：[0]
// * <p>
// * 示例 3：
// * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
// * 输出：[8,9,9,9,0,0,0,1]
// * <p>
// * 提示：
// * 每个链表中的节点数在范围 [1, 100] 内
// * 0 <= Node.val <= 9
// * 题目数据保证列表表示的数字不含前导零
// */
//class AddTwoNumbers_2 {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode head=l1;
//        int[] arr=new int[]{};
//        int index=0;
//        while (head.next!=null){
//            arr[index]=head.val;
//            index++;
//            head=head.next;
//        }
//
//    }
//}
//
//
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {}
//    ListNode(int val) {
//        this.val = val;
//    }
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}
