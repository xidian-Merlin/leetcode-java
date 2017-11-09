/**
 * Created by a123 on 2017/10/16.
 */
public class Int2Roman {
    public static void main(String[] args){
        System.out.println(new Solution12().intToRoman(190));
    }
}

class Solution12 {
    public String intToRoman(int num) {
        String[][] roman = {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}
        };
        int digit = 0;
        String ret = new String();
        while(num != 0){
            int remain = num % 10;
            ret = roman[digit][remain] + ret;
            num = num / 10;
            digit++;
        }

        return ret;

    }
}
