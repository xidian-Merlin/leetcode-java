/**
 * Created by a123 on 2017/10/31.
 */
public class MergeKSortedLists {
    public static void main(String[] args){
       // System.out.println(new Solution23().mergeKLists());
    }
}

class Solution23 {

    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length < 1) return null;
        if (lists.length == 1) return  lists[0];
      return sort(lists, 0, lists.length - 1);



    }

    public ListNode sort(ListNode[] lists, int low, int high){
        ListNode result = new ListNode(0);

        int mid = (low + high) / 2;

        if(low < high) {
            //左边排序
            ListNode left = sort(lists, low, mid);
            //右边排序
            ListNode right =  sort(lists, mid + 1, high);

            //左右归并
           result =  mergeTwo(left, right);
        }else{
            if (lists[low] == null)
            {
                    result = null;}
            else result = lists[low];
        }
        return  result;
    }
    public ListNode mergeTwo(ListNode l1, ListNode l2){

        if(l1==null) return l2;
        if(l2==null) return l1;

        ListNode head = new ListNode(0);
        ListNode p = head;
        while(l1 != null || l2 != null){
            if(l1 != null && l2 != null){
                if(l1.val < l2.val){
                    p.next = l1;
                    l1 = l1.next;
                }else {
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;
            }
            else if(l1 != null){
                p.next = l1;
                break;
            }
            else if(l2 != null){
                p.next = l2;
                break;
            }
        }
        return head.next;
    }

    }
