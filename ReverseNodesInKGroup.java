/**
 * Created by a123 on 2017/11/5.
 */
public class ReverseNodesInKGroup {
    public static void main(String[] args){
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);

        a1.next = a2;
        a2.next = a3;

        System.out.println(new Solution25().reverseKGroup(a1,3));
    }
}


class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;
        ListNode p1 = fakeHead;
        ListNode p2 = head;

        ListNode temp = head;

        for (int i = 0; i < k - 1; i++) {
            if (temp == null) break;
            temp = temp.next;
        }
        ListNode p3 = temp;

        while (p2 != null && p3 != null ) {

            ListNode nextStart = p3.next;

            p1.next = p3;

            temp = p2;
            for(int i = 1; i < k; i++) {
                for (int j = 1; j < k - i; j++) {
                    temp = temp.next;
                }
                p3.next = temp;
                p3 = p3.next;
                temp = p2;
            }
            p1 = p2;
            p2.next = nextStart;
            p2 = p2.next;

             temp = p2;

            for (int i = 0; i < k - 1; i++) {
                if (temp == null) break;
                temp = temp.next;
            }
            p3 = temp;
        }
        return  fakeHead.next;
    }
}