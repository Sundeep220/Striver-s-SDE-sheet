package com.Sundeep;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitions {
    public static void main(String[] args) {
        System.out.println(partition("aabbccdd"));
    }

//    Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
//    Input: s = "aab"
//    Output: [["a","a","b"],["aa","b"]]
//    A palindrome string is a string that reads the same backward as forward.\
    public static List<List<String>> partition(String s) {
            List<List<String>> ans = new ArrayList<>();
            findPartitions(0,s,new ArrayList<>(),ans);
            return ans;
    }

    private static void findPartitions(int ind,String s, ArrayList<String> paths, List<List<String>> ans) {
        if(ind == s.length()){
            ans.add(new ArrayList<>(paths));
            return;
        }

        //check for all possible partittions (atmost s.length() parttions are possible)
        for(int i=ind;i<s.length();i++){
            if(isPalindrome(s,ind,i)){
                //If the substtring is palindrome then add it to the current parttions answer
                paths.add(s.substring(ind,i+1));
                findPartitions(i+1,s,paths,ans);
                //after this recursion call backtrack
                paths.remove(paths.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

}
