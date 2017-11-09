/**
 * Created by a123 on 2017/11/7.
 */
public class ImplementStrStr {
    public static void main(String[] args){
        System.out.println( new Solution28().strStr("",""));
    }
}

class Solution28 {
    public int strStr(String haystack, String needle) {
        if(haystack==null || needle==null)
            return 0;

        if(needle.length() == 0)
            return 0;

        if(haystack == needle) return 0;
         if( !haystack.contains(needle)) return  -1;
         else {
             StringBuilder sb = new StringBuilder();
             for(int i = 0; i < haystack.length(); i++){
                 sb.append(haystack.charAt(i));
                 if(sb.toString().contains(needle)){
                     return  i - needle.length() + 1;

                 }
             }
         }
         return  -1;
    }
}