/**
 * Created by a123 on 2017/10/11.
 */
public class PalindromicSubstring {
    public static void main(String[] args){
        System.out.println(new Solution5().longestPalindrome("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
    }

}

//使用动态规划来解决
class Solution5 {
    int resultI = 0;
    int resultJ = 0;
    int maxLength = 0;
    public String longestPalindrome(String s) {
        if (s.length() == 0){
            return  "";
        }
        int[][] result = new int[s.length()][s.length()];
        for (int i =0;i<s.length();i++){
            for (int j=i;j<s.length();j++){
                result[i][j] = compare(i,j,s,result);
                if (result[i][j] ==1) {

                   if( maxLength < j-i+1) {

                       maxLength = j - i + 1;
                       resultI = i;
                       resultJ = j;
                   }
                }
            }
        }
        String resultS  = s.substring(resultI,resultJ+1);//截取第i个字符到第j-1个字符，所以+1；
        return  resultS;

    }
    public int compare(int i ,int j,String s,int[][] result) {
        if (result[i][j] != 0){
            return result[i][j];
        }
        if (i == j) {
            return 1;
        }
        if (j-i == 1){
            if (s.charAt(i) == s.charAt(j)){
                return 1;
            }else return -1;
        }
        if (j-i >1){
            if (s.charAt(i) == s.charAt(j) && compare(i+1,j-1,s,result) == 1){
                return 1;
            }else return -1;

        }
        return 0;
    }
}