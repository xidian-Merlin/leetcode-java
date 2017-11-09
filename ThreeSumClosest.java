import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by a123 on 2017/10/19.
 */
public class ThreeSumClosest {
    public static void main(String[] args){
        System.out.print(new Solution16().threeSumClosest(new int[] {-1,2,1,-4},1));
    }
}

class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length <= 3 ){
            int returnNum = 0;
            for(int num: nums) {
                returnNum += num;
            }
            return  returnNum;
        }
        Arrays.sort(nums);
        int temFit = (int) Double.POSITIVE_INFINITY;
        List numList = new ArrayList();

        for(int i = 0; i < nums.length - 2; i++){

            int tem = target - nums[i];
            //利用空间换时间
            if (!numList.contains(tem)) numList.add(tem);
            else continue;
            for(int leftIndex = i + 1, rightIndex = nums.length - 1 ;leftIndex < rightIndex; ){
                if(nums[leftIndex] + nums[rightIndex] == tem) {
                    return target;
                }else if(nums[leftIndex] + nums[rightIndex] < tem){
                    if( Math.abs(tem - (nums[leftIndex] + nums[rightIndex])) < Math.abs(temFit)) {
                        temFit = tem -nums[leftIndex] - nums[rightIndex];
                    }
                    leftIndex ++;
                }else if(nums[leftIndex] + nums[rightIndex] > tem){
                    if( Math.abs(tem - (nums[leftIndex] + nums[rightIndex])) < Math.abs(temFit)) {
                        temFit = tem - nums[leftIndex] - nums[rightIndex];
                    }
                    rightIndex --;
                }


            }
        }
        return target - temFit;
    }
}
