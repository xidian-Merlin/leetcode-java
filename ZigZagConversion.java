/**
 * Created by a123 on 2017/10/12.
 */
public class ZigZagConversion {
    public static void main(String[] args){
        System.out.print(new Solution6().convert("AB",1));
    }
}


class Solution6 {
    public String convert(String s, int numRows) {
        if (s.length() <= numRows || numRows == 1) return  s;
            //计算有多少个小组
        int count = s.length()/(numRows*2 - 2);
        int left = s.length()%(numRows*2 - 2);

        StringBuilder sb = new StringBuilder();
        //第一行
        for (int i = 0; i<(count + (left>0? 1:0));i++){
            sb.append(s.charAt(i*(numRows*2 -2)));
        }
        //除去首尾行
        for (int row = 1; row < numRows-1; row++ ){
            int extra = 0;
            if (left - row >0) extra = 1;
            if (left > (numRows*2-2-row)) extra =2;
            for (int k = 0; k < count+((extra+1)/2); k++){
                sb.append(s.charAt(row + k*(numRows*2-2)));
                if (!(extra ==1 && k == count) ) {
                    sb.append((s.charAt(row + (k+1) * (numRows * 2 - 2) - row * 2)));
                }
            }
        }

        //尾行
        for (int i =0; i<(count + (left >= numRows?1:0)); i++){
            sb.append(s.charAt(numRows-1 + (numRows*2-2)*i));
        }
       return sb.toString();

    }

}