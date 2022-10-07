package com.Sundeep;

public class Strem {
    public static void main(String[] args) {
        //System.out.println(skipwithoutVar("baccadd"));
        System.out.println(skipString("bbappleddec"));
    }

    static void skip(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if(ch == 'a'){
            skip(p,up.substring(1));
        }
        else{
            skip(p+ch,up.substring(1));
        }
    }

    static String skipwithoutVar(String up){
        if(up.isEmpty()){
            return "";
        }
        char ch = up.charAt(0);
        if(ch == 'a'){
            return skipwithoutVar(up.substring(1));
        }
        else{
            return ch + skipwithoutVar(up.substring(1));
        }
    }

    //If you want to skip this entire substring
    static String skipString(String up){
        if(up.isEmpty())
            return "";

        //Check if the current string starts with this string
        if(up.startsWith("apple")){
            return skipString(up.substring(5));
        }
        return up.charAt(0) + skipString(up.substring(1));
    }
}
