/**
 * Created by a123 on 2017/10/12.
 */
public class ReverseInteger {
    public static void main(String[] args){
        System.out.println(new Solution7().reverse(-1294967295));
    }
}

class Solution7 {
    public int reverse(int x) {
            System.out.println(Integer.MAX_VALUE + "   " + Integer.MIN_VALUE);
            boolean flag = x>=0?true:false;
            Integer input = new Integer(Math.abs(x));
            String inputString = input.toString();
            StringBuilder sb = new StringBuilder();
            for (int i = (inputString.length()-1);i >= 0;i--){
                sb.append(inputString.charAt(i));
            }
            String inputString1 =  sb.toString();
            try{
                input = new Integer(inputString1);
                if (input.intValue() > (Math.pow(2,32)-1)) return 0;
            }catch (Exception e ){
                return 0;
            }

            int result =  input.intValue();
            if (Math.abs(result) > (Math.pow(2,32)-1))
            return 0;
            else {
                if (flag == true) return  result;
                else return  0-result;
            }

    }
}
