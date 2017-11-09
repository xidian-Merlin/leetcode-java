/**
 * Created by a123 on 2017/10/16.
 */
public class ContainerWithMostWater {
    public static void main(String[] args){
        System.out.println(new Solution11().maxArea(new int[] {1, 1}));
    }
}

class Solution11 {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int MostWater = 0;
        int temWater;

        for (; left != right;){
            if(height[left] > height[right]){
                temWater = (right - left)*height[right];
                right--;
            }else{
                temWater = (right - left)*height[left];
                left++;
            }

            if(temWater > MostWater) MostWater = temWater;
        }
        return MostWater;
    }

}
