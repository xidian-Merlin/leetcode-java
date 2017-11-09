/**
 * Created by a123 on 2017/11/5.
 */
public class SwapNodesInPairs {
}


class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode p1 = fakeHead;
        ListNode p2 = head;

        while(p2 != null && p2.next != null){
            ListNode nextStart = p2.next.next;
            p1.next = p2.next;
            p2.next.next = p2;
            p2.next = nextStart;

            p1 = p2;
            p2 = p2.next;

        }
         return  fakeHead;
    }
}