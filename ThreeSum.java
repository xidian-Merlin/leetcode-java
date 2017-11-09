import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by a123 on 2017/10/16.
 */
public class ThreeSum {
}

//这道题可以考虑先排序

class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //使用一个List保存中间计算结果
        List count = new ArrayList();
        for(int i = 0;i < nums.length - 2; i++){
            for(int j = i + 1;j < nums.length; j++){
                if (count.contains(nums[i] + nums[j])) continue;
                if (exist(0 - nums[i] - nums[j],nums,i,j)){

                   List<Integer> list =  new ArrayList<>();
                   list.add(new Integer(nums[i]));
                   list.add(new Integer(nums[j]));
                   list.add(new Integer(-nums[i]-nums[j]));
                   Collections.sort(list);

                   if(!result.contains(list)) result.add(list);
                }else count.add(nums[i] + nums[j]);
            }
        }
        return result;
    }


    public boolean exist(int num,int[] nums,int i, int j){
        for (int m = 0; m < nums.length; m++){
            if (num == nums[m] && m != i && m != j) return true;
        }
        return false;
    }
}