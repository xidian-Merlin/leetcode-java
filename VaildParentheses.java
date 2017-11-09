import java.util.Stack;

/**
 * Created by a123 on 2017/10/28.
 */
public class VaildParentheses {
    public static void main(String[] args){
        System.out.print(new Solution20().isValid("([)]"));
    }
}

class Solution20 {
    public boolean isValid(String s) {
        if(s == null) return false;
        Stack<Character> ss = new Stack();
        for(int i = 0; i < s.length(); i++){

            switch (s.charAt(i)){
                case ')':
                    if (ss.empty()) return false;
                    if(ss.peek() != '('){
                        return false;
                    }else { ss.pop();}
                    break;
                case ']':
                    if (ss.empty()) return false;
                    if(ss.peek() != '['){
                        return  false;
                    }else{
                        ss.pop();
                    }
                    break;
                case '}':
                    if (ss.empty()) return false;
                    if(ss.peek() != '{'){
                        return  false;
                    }else{
                        ss.pop();
                    }
                    break;
                default:
                    ss.push(s.charAt(i));

            }

        }
        return ss.empty();
    }
}
