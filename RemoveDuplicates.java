/**
 * Created by a123 on 2017/11/6.
 */
public class RemoveDuplicates{
    public static void main(String[] args){
       System.out.print(new Solution26().removeDuplicates(new int[]{1,1,1,2,3,4,5,5,6,7}));

    }
}


class Solution26 {
    public int removeDuplicates(int[] nums) {
        if(nums == null) return  0;
        if(nums.length < 2){
            return nums.length;
        }
        int index = 0;
        int next = 1;

        while(next < nums.length){
            if(nums[next] == nums[index]){
                next++;
            }else {
                index++;
                nums[index] = nums[next];
                next++;
            }
        }
        return ++index;
    }
}