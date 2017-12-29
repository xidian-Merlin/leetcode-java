import java.util.Arrays;

/**
 * Created by a123 on 2017/12/12.
 */
public class SearchForARange {
    public static void main(String[] args){
        System.out.println(Arrays.toString(new Solution34().searchRange(new int[]{1,2,3,4,4,4,5,5,5,9},4)) );
    }
}

class Node {
     int value;
    public Node(int value){
        this.value = value;
    }
    Node next = null;

}

class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return  new int[]{-1,-1};

        Node left = new Node(0);
        Node right = new Node(nums.length - 1);

        for (int i = 0; i < nums.length; i++){
            if(nums[left.value] == target){
                break;
            }else {
                left.next = new Node(i + 1);
                left = left.next;

            }
        }

        for(int j = nums.length - 1; j > 0; j--){
            if(nums[right.value] == target){
                break;
            }else {
                right.next = new Node(j - 1);
                right = right.next;
            }
        }


        int[] a = new int[] {left.value,right.value};
        if(left.value <= nums.length -1)
        return a;
        else  return new int[] {-1,-1};

    }

}
class Solution34_2 {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];

        int lo = searchStart(nums, target);
        int hi = searchStart(nums, target + 1) - 1;

        if (lo == nums.length || nums[lo] != target)
            return new int[]{-1, -1};

        result[0] = lo;
        result[1] = hi;

        return result;
    }

    public int searchStart(int[] nums, int target) {
        int lo = 0, hi = nums.length, mid;
        while (lo < hi) {
            mid = (lo + hi)/2;
            if (nums[mid] < target) {
                lo = mid + 1;
            }
            else {
                hi = mid;
            }
        }
        return lo;
    }
}