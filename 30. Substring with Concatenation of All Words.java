
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//barfoothefoobarman
//0        9
//foobar    

//wordgoodgoodgoodbestword
//
//"word","good","best","word"  

//asbarfoofoobarthefoobarman
//        8  11 14
//"bar","foo","the"
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
       if(s.isEmpty() || words.length == 0) return new ArrayList<Integer>();

        List<Integer> res = new ArrayList<>();
        Map<String, Integer> count =  new HashMap<>();
        int n = s.length();
        int m = words.length;
        int k = words[0].length();

        for(String word : words) count.put(word, count.getOrDefault(word, 0) + 1);

        for(int offset = 0; offset < k; ++offset){
            Map<String, Integer> seen = new HashMap<>();
            int matched = 0;
            int l = offset;

            for(int r = offset; r <= n - k; r += k){
                String word = s.substring(r, r + k);
                if(count.containsKey(word)){
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    ++matched;

                    while(seen.get(word) > count.get(word)){
                        String leftWord = s.substring(l, l + k);
                        seen.put(leftWord,  seen.get(leftWord) - 1);
                        --matched;
                        l += k;
                    }

                    if(matched == m){
                        res.add(l);
                    }
                } else{
                    seen.clear();
                    matched = 0;
                    l = r + k;
                }
            }

        }

        return res;
    }
}