package leetcode;

/*

给出两个非空的链表用来表示两个非负的整数.其中,它们各自的位数是按照逆序的方式存储的,
并且它们的每个节点只能存储一位数字.
如果,我们将这两个数相加起来,则会返回一个新的链表来表示它们的和.

您可以假设除了数字0之外,这两个数都不会以0开头.

示例：
输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

 */



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


public class AddingTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        int carry = 0;
        while (true){
            if(l1!=null&&l2!=null){
                int sum = l1.val + l2.val + carry;
                if (sum>9) {
                    result = new ListNode(sum-10);
                    carry = 1;
                }
                else {
                    result = new ListNode(sum);
                    carry = 0;
                }
                l1 = l1.next;
                l2 = l2.next;
            }
            else if(l1!=null||l2!=null){
                if (l1 != null) {
                    result = new ListNode(l1.val+carry);
                    carry = 0;
                    l1 = l1.next;
                }
                else {
                    result = new ListNode(l2.val+carry);
                    carry = 0;
                    l2 = l2.next;
                }
            }
            else{
                break;
            }
            System.out.print(result.val+"->");
            result = result.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);


        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = AddingTwoNumbers.addTwoNumbers(l1, l2);
//        while (result!=null){
//            System.out.print(result.val+"->");
//            result = result.next;
//        }
    }
}
