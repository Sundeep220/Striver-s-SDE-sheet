package com.Sundeep;

import java.util.ArrayList;

public class permutationsofString {
    public static void main(String[] args) {
       // permutation("","abc");
        ArrayList<String> res = permutationwithList("","bbbb");
        System.out.println(res);
    }

    public static void permutation(String p, String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        for(int i=0;i<= p.length();i++){
            String first = p.substring(0,i);
            String second = p.substring(i,p.length());
            permutation(first+ch+second,up.substring(1));
        }
    }

    //Using ArrayList
    public static ArrayList<String> permutationwithList(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        char ch = up.charAt(0);
        for(int i=0;i<= p.length();i++){
            String first = p.substring(0,i);
            String second = p.substring(i,p.length());
            ans.addAll(permutationwithList(first+ch+second,up.substring(1)));
        }
        return ans;
    }
}
