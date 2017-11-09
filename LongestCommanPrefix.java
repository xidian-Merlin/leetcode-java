/**
 * Created by a123 on 2017/10/16.
 */
public class LongestCommanPrefix {
    public static void main(String[] args){
        System.out.println(new Solution14().longestCommonPrefix(new String[]{}));
    }
}


class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return  "";
        for (String str : strs) {
            if (str == null || str == "") return "";
        }
        new String("fdf").indexOf('f');
        StringBuilder sb = new StringBuilder();
       try {
           for (int index = 0; ; index++) {
               for (int i = 0; i < strs.length; i++) {
                   if (strs[i].charAt(index) != strs[0].charAt(index)) {
                       return sb.toString();
                   }
               }
               sb.append(strs[0].charAt(index));
           }
       }catch ( StringIndexOutOfBoundsException e){
           return sb.toString();
       }

    }
}