package com.Sundeep;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PowerSetofString {
    public static void main(String[] args) {
//        subSeq("","abc");
        System.out.println(SubSeq("","abc"));
    }

    public static void subSeq(String p ,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subSeq(p+ch,up.substring(1));
        subSeq(p,up.substring(1));
    }
    //Using ArrayList
    public static ArrayList SubSeq(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = SubSeq(p+ch,up.substring(1));
        ArrayList<String> right = SubSeq(p,up.substring(1));

        left.addAll(right);
        return left;
    }
}
