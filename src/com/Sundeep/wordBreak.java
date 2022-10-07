package com.Sundeep;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class wordBreak {
    public static void main(String[] args) {
        String s = "godisnowherenowhere";
        ArrayList<String> wordDict = new ArrayList<>(Arrays.asList("god","is","now", "no", "where", "here"));
       // System.out.println(wordBreak(s,wordDict));
        System.out.println(wordBreak2(s,"",wordDict));
    }

    //Using Dynamic Programming to find count of all the segmentations of the string that contains all the words in dictionary
    public static boolean wordBreak(String s, List<String> wordDict) {
            //Using dp
            int dp[] = new int[s.length()];
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j <= i; j++) {
                    String word2check = s.substring(j, i + 1);
                    if (wordDict.contains(word2check)) {
                        if (j > 0) {
                            dp[i] += dp[j - 1];
                        } else dp[i] += 1;
                    }
                }
            }
            return dp[s.length() - 1] > 0;
    }


    //Using backtraking to print all the sentences after segmenting the give string

    public static ArrayList<String> wordBreak2(String s,String res ,List<String> wordDict){
        if(s.length() == 0){
            ArrayList<String> list = new ArrayList<>();
            list.add(res);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();
        //checking for each substring
        for(int i=0;i<s.length();i++){
            String left = s.substring(0,i+1);
            if(wordDict.contains(left)){
                ans.addAll(wordBreak2(s.substring(i+1),res + left + " ",wordDict));
            }
        }

        return ans;
    }
}
