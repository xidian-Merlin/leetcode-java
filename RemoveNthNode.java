/**
 * Created by a123 on 2017/10/27.
 */
public class RemoveNthNode {
}

class ListNode1 {
    int val;
    ListNode next;
    ListNode1(int x){
        val = x;
    }
}

class Solution19 {
        public static ListNode removeNthFromEnd(ListNode head, int n) {
                     if(head == null || head.next == null)
                             return null;

                    ListNode faster = head;
                     ListNode slower = head;

                    for(int i = 0; i<n; i++)
                             faster = faster.next;

                     if(faster == null){
                             head = head.next;
                             return head;
                         }

                    while(faster.next != null){
                             slower = slower.next;
                            faster = faster.next;
                         }

                     slower.next = slower.next.next;
                     return head;

                     }
    }

