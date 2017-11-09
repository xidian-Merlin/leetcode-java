import java.util.Arrays;

/**
 * Created by a123 on 2017/10/9.
 */
public class Two_Sum {
    public static void main(String[] args){
        Two_Sum count = new Two_Sum();
        int[] a = {3,2,4};
        int[]b = count.twoSum(a,6);
        System.out.println(Arrays.toString(b));
    }

    public int[] twoSum(int[] nums, int target) {
        int i = nums.length;
        for (i = 0;i< nums.length;i++){
            int j = i+1;
            int flag = 0;
            while(nums[i] + nums[j] != target){
                j++;
                if (j == nums.length){
                    flag = 1;
                    break;
                }
            }
            if(flag ==0) {
                if (nums[i] + nums[j] == target) {
                    int[] a = {i, j};
                    return a;
                }
            }
        }
        return null;
    }
}
