/**
 * Created by a123 on 2017/11/7.
 */
public class RemoveElement {
}

class Solution27 {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val){
                nums[count] = nums[i];
            }
        }
        return count;
    }


}
