package com.Sundeep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class generate_balanced_parenthesis {
    public static void main(String[] args) {
        ArrayList<String> ans = new ArrayList<>();
        int n = 3;
        generateParenthesis(n,0,0,"",ans);
        System.out.println(ans);
        System.out.println(AllParenthesis(n));

    }
    public static void generateParenthesis(int n, int open, int close, String s, ArrayList<String> ans) {
        if (open == n && close == n) {
            ans.add(s);
            return;
        }
        if (open < n) {
            generateParenthesis(n, open + 1, close, s + "{", ans);
        }

        if (close < open) {
            generateParenthesis(n, open, close + 1, s + "}", ans);
        }
    }
    public static List<String> AllParenthesis(int n)
    {
        if(n <= 0)
            return null;
        List<String> ans = new ArrayList<>();
        Parenthesis(n,0,0,new String() ,  ans);
        return ans;

    }
    public static void Parenthesis(int n, int open, int close, String s, List<String> ans){
        if(open == n && close == n){
            ans.add(s);
            return;
        }
        if(open < n){
            Parenthesis(n,open+1,close,s+'(',ans);
        }
        if(close < open)
            Parenthesis(n,open,close+1,s+')',ans);
    }
}
