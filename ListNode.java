/**
 * Created by a123 on 2017/10/10.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

}

class test {
    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;

        l4.next = l5;
        l5.next = l6;

        ListNode result = new Solution().addTwoNumbers(l1,l4);
        while(result != null){
            System.out.println(result.val);
            result = result.next;
        }

    }
}


class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //创建头指针
        ListNode dummyHead = new ListNode(0);
        if(l1 == null && l2 == null){
            return dummyHead;
        }
        int sum = 0, carry = 0;
        //创建指向头指针的索引
        ListNode curr = dummyHead;
        while(l1!=null || l2!=null){
            //避免空指针异常
            int num1 = l1 == null? 0 : l1.val;
            int num2 = l2 == null? 0 : l2.val;
            sum = num1 + num2 + carry;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            carry = sum / 10;
            l1 = l1 == null? null : l1.next;
            l2 = l2 == null? null : l2.next;
        }
        //判断最终位的进位
        if(carry!=0){
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
