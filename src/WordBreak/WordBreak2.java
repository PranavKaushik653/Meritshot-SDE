package WordBreak;

import java.util.*;

public class WordBreak2 {
    static Map<Integer, List<String>> memo = new HashMap<>();
    static Set<String> dict;
    static String s;

    static List<String> dfs(int index) {
        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        List<String> res = new ArrayList<>();

        if (index == s.length()) {
            res.add(""); // base case
            return res;
        }

        for (String word : dict) {
            if (s.startsWith(word, index)) {
                List<String> sub = dfs(index + word.length());
                for (String sentence : sub) {
                    if (sentence.isEmpty())
                        res.add(word);
                    else
                        res.add(word + " " + sentence);
                }
            }
        }

        memo.put(index, res);
        return res;
    }

    static List<String> wordBreak(String str, List<String> wordDict) {
        s = str;
        dict = new HashSet<>(wordDict);
        memo.clear();
        return dfs(0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine().trim();
        String[] words = sc.nextLine().trim().split(" ");

        List<String> res = wordBreak(s, Arrays.asList(words));
        System.out.println(res);
    }
}
