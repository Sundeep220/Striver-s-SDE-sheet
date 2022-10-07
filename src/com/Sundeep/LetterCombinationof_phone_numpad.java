package com.Sundeep;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class LetterCombinationof_phone_numpad {
    public static void main(String[] args) {
        System.out.println(pad("","12"));
    }

    static ArrayList<String> pad(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        int digit = up.charAt(0) - '0'; //this gives the ascii value for digit pressed
        for(int i = (digit-1)*3; i < digit * 3 ; i++){
            char ch = (char)('a' + i);
            ans.addAll(pad(p+ch,up.substring(1)));
        }
        return ans;
    }
}
