/**
 * Created by a123 on 2017/10/13.
 */
public class PalindromeNuber {
    public static void main(String[] args){
        System.out.print(new Solution9().isPalindrome(-2147447412));
    }
}

class Solution9 {
    public boolean isPalindrome(int x) {
        if(x == -Math.pow(2,31)) return  false;
        if (x<0) return  false;
        if (x<10) return  true;
        String sb = (new Integer(x).toString());
        int count = sb.length();
        int i =0;
        for (i = 0; i<count; i++){
            if(sb.charAt(i) != sb.charAt(sb.length()-1-i)) break;
        }
        if (i != count) return false;
        return true;
    }
}
