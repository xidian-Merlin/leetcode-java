import java.util.ArrayList;
import java.util.List;

/**
 * Created by a123 on 2017/10/11.
 */
public class LongestSubString {
    public static void main(String[] args){
       System.out.println(new Solution3().lengthOfLongestSubstring("pwwkew"));
    }
}


class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int temLength = 0;
        //List 泛型只能是引用类型
        List result = new ArrayList();
        for (int i =0 ; i< s.length();i++) {
            if (!result.contains(s.charAt(i))){
                temLength++;
                result.add(s.charAt(i));
            }else{
                int index = i - (result.size()-1-result.indexOf(s.charAt(i)));
                i = index-1;
                result.clear();
                temLength = 0;
            }
            if(temLength > maxLength){
                maxLength = temLength;
            }

        }
        return maxLength;
    }


}