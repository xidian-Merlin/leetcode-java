/**
 * Created by a123 on 2017/10/15.
 */
public class Roman2Integer {

    public static void main(String[] args){
        System.out.println(new Solution13().romanToInt("IMDC"));
    }
}


class Solution13 {
    public int romanToInt(String s) {
        int ret = char2Int(s.charAt(0));
        for (int i = 1; i < s.length(); i++){
            if(char2Int(s.charAt(i -1)) >= char2Int(s.charAt(i))){
                ret = ret +char2Int(s.charAt(i));
            }
            else{
                ret = ret + char2Int(s.charAt(i)) - 2*char2Int(s.charAt(i-1));
            }
        }
        return ret;
    }

    public int char2Int(char ch){
        switch (ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;

        }
        return 0;
    }
}


