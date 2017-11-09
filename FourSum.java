import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by a123 on 2017/10/20.
 */
public class FourSum {
    public static void main(String[] args){
        System.out.println(new Solution18().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }

}


class Solution18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i < nums.length - 3; i++){
            int target3 = target - nums[i];
            //three sums;
            for(int j = i+1; j < nums.length - 2; j++) {
                int target2 = target3 - nums[j];
                    int left = j+1;
                    int right = nums.length - 1;
                    while (left < right){
                        if(nums[left] + nums[right] < target2){
                            left ++;
                            continue;
                        }
                        if(nums[left] + nums[right] > target2){
                            right --;
                            continue;
                        }
                        if(nums[left] + nums[right] == target2) {
                            List<Integer> temp = new ArrayList<>();
                            temp.add(new Integer(nums[i]));
                            temp.add(new Integer(nums[j]));
                            temp.add(new Integer(nums[left]));
                            temp.add(new Integer(nums[right]));
                            if(!result.contains(temp)) {
                                result.add(temp);
                            }
                            left++;
                            right--;
                        }
                }
            }
        }
        return  result;

    }
}