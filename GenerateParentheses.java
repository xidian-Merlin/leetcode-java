import java.util.ArrayList;
import java.util.List;

/**
 * Created by a123 on 2017/10/29.
 */
public class GenerateParentheses {
    public static void main(String[] args){
        System.out.println(new Solution22().generateParenthesis(3));
    }
}

class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        dfs(result, "", n, 0, 0);
        return  result;


    }

    public void dfs(List<String> result, String temp, int n, int left, int right){

        if (right == n) {
            result.add(temp);
            return ;
        }

        if(left < n) dfs(result, temp + '(', n,left + 1, right);
        if(right < left) dfs(result, temp + ')', n, left, right + 1 );
    }
}
