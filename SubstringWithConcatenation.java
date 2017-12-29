import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by a123 on 2017/11/8.
 */
public class SubstringWithConcatenation {
    public static void main(String[] args){
        try(
                InputStreamReader reader = new InputStreamReader(System.in);

                BufferedReader br = new BufferedReader(reader)){

        }catch ( IOException ioe){

        }
    }
}

class Solution30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> tmp = new HashMap<String, Integer>();
        int sLength = s.length();
        int wordsNum = words.length;
        int wordsLength = words[0].length();
        int j;

        if (sLength < wordsNum || wordsNum == 0)
            return list;
        for (int i = 0; i < wordsNum; i++) {
            if (map.containsKey(words[i]))
                map.put(words[i], map.get(words[i]) + 1);
            else
                map.put(words[i], 1);
        }
        for (int i = 0; i <= sLength - wordsNum * wordsLength; i++) {
            tmp.clear();
            for (j = 0; j < wordsNum; j++) {
                String word = s.substring(i + j * wordsLength, i + j
                        * wordsLength + wordsLength);
                if (!map.containsKey(word))
                    break;
                if (tmp.containsKey(word))
                    tmp.put(word, tmp.get(word) + 1);
                else
                    tmp.put(word, 1);
                if (tmp.get(word) > map.get(word))
                    break;
            }
            if (j == wordsNum)
                list.add(i);
        }
        return list;
    }
}