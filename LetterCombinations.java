import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by a123 on 2017/10/20.
 */
public class LetterCombinations {
    public static void main(String[] args){
        System.out.println(new Solution17_2().letterCombinations("12324"));
    }
}

class Solution17 {
    private String getString(int number){
        switch (number){
            case '2':return "abc";
            case '3':return "def";
            case '4':return "ghi";
            case '5':return "jkl";
            case '6':return "mno";
            case '7':return "pqrs";
            case '8':return "tuv";
            case '9':return "wxyz";
            default:return null;
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<>();
        int length = digits.length();
        String[] strings = new String[length];

        if(length<=0)
            return res;
        for(int i = 0; i<length; i++){
            strings[i] = getString(digits.charAt(i));
        }
        for(int row = 0;row<strings[0].length();row++){
            res.add(new String(new char[]{strings[0].charAt(row)}));
        }
        for(int col = 1;col<length;col++){
            int size = res.size();
            for(int i = 0;i<size;i++){
                String tmp = res.get(0);
                String next = strings[col];
                res.remove(0);
                for(int j = 0;j<next.length();j++)
                    res.add(tmp+next.charAt(j));
            }
        }
        return res;
    }
}


class Solution17_2 {
    public List<String> letterCombinations(String digits) {
        List<String> res =new ArrayList<>();

        if(digits.length()==0){
            return res;
        }

        String[] mapping = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        return helper(digits,0,mapping);
    }
    private List<String> helper(String digits,int start, String[] str){
        List<String> res = new ArrayList<>();
        if(start == digits.length()){
            res.add(""); //不然返回的就是空，就不会把自己加进去了！！
            return res;
        }

        int num = digits.charAt(start) - '0';
        List<String> tmp = helper(digits,start+1,str);

        for(String ss : tmp){
            for(int j=0; j< str[num].length(); j++){
                String s = str[num].charAt(j)+ss;
                res.add(s);
            }
        }
        return res;
    }
}
