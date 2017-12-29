import java.io.FileReader;

/**
 * Created by a123 on 2017/12/11.
 */
public class SearchInRotatedSortedArray33 {
    public static void main(String[] args){


        FileReader data  = new FileReader("temp.txt");

        System.out.println(new Solution33().search(new int[]{4,5,6,7,8,1,2,3},8));
    }
}



class Solution33 {
    public int search(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return -1;


        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int  mid = (low + high)/2;
            if (target < nums[mid]) {
                if (nums[mid] < nums[high])  //right side is sorted
                    high = mid - 1;
                else {
                    if (target < nums[low])
                        low = mid + 1;
                    else
                        high = mid - 1;
                }
            }else if(target > nums[mid]){
                if(nums[low] < nums[mid])
                    low = mid + 1;
                else {
                    if (target > nums[high])
                        high = mid - 1;
                    else
                        low = mid + 1;
                }

            }else
                return mid;

        }
        return -1;
    }

}



