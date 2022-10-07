package com.Sundeep;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NumberPadRealLifePhoneNUmPad {
    static String[] char_map = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void main(String[] args) {
        String digits = "23";
        System.out.println(letterCombinationsRec(digits));
//        System.out.println('5' - '1');

    }
//Using iterations
    public static List<String> letterCombinations(String digits) {
        LinkedList<String> output = new LinkedList<>();
        //it will act as queue also
        if(digits.length() == 0)
            return output;
        output.add("");

        //for looping through the digits
        for(int i=0;i<digits.length();i++){
            int indexForChar_map = digits.charAt(i) - '0';
            while(output.peek().length() == i){
                String permutation = output.remove();
                for(char ch : char_map[indexForChar_map].toCharArray()){
                    output.add(permutation+ch);
                }
            }
        }
        return output;
    }

    //Using Recursion

    public static List<String> letterCombinationsRec(String digits){
        //Base case
        //If string is empty return empty list
        if(digits.length() == 0){
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }

        //Splitting the string in two parts
        //1. taking only 1st character
        //2. taking the substring from 2nd character
        char ch = digits.charAt(0);
        String remaining = digits.substring(1);

        //Recursive leap of faith
        List<String> remain = letterCombinationsRec(remaining);
        List<String> ans = new ArrayList<>();

        //Check the code for ch from mapping
        String codeForch = char_map[ch - '0'];
        for(int i=0;i<codeForch.length();i++){
            char c = codeForch.charAt(i);
            //taking the character from this string and adding it to all strings inside remain list
            for(String rstr: remain){
                ans.add(c+rstr);
            }
        }
        return ans;
    }
//    String[] letters={"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static List<String> letterCombinationsRecursion2(String digits) {
        List<String> ans= new ArrayList<>();

        if(digits==null || digits.length()==0)
            return ans;

        helper(digits, ans, "", 0);
        return ans;
    }

    private static void helper(String dig, List<String>ans, String cur, int index){
        //base case
        if(index==dig.length()){
            ans.add(cur);
            return;
        }
        //convert 1st character to integer
        int idx= dig.charAt(index) - '0';
        String curletters= char_map[idx]; //get the respective mapping

        for(int i=0;i<curletters.length();i++){
            String newCur= cur+ curletters.charAt(i);
            helper(dig, ans, newCur, index+1);
        }
    }
}
