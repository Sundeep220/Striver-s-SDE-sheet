package com.Sundeep;

import java.util.ArrayList;

public class mazeProblem {
    public static void main(String[] args) {
       // System.out.println(pathCount(3,3));
        //System.out.println(pathsDiagonally("",3,3));
       //System.out.println(paths("",3,3));
        boolean[][] maze = {
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        System.out.println(pathswithObstacles("",maze,0,0));
    }

    //To count the total unique paths for mze to reach end
    //1. You can go either right or down at a time

    static int pathCount(int r, int c){
        if(r==1 || c==1)
            return 1;
        return pathCount(r-1,c)+pathCount(r,c-1);
    }

    //To print the paths
    static ArrayList<String> paths(String p,int r,int c){
        //Base if both row and col == 1
        if(r==1 && c==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        //If either r == 1 then we cant go further down so only go right
        if(r > 1){
            ans.addAll(paths(p+'D',r-1,c));
        }
        if(c > 1){
            ans.addAll(paths(p+'R',r,c-1));
        }
        return ans;
    }

    //If with right and down, you can also go diagonally then,
    static ArrayList<String> pathsDiagonally(String p,int r,int c){
        //Base if both row and col == 1
        if(r==1 && c==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans = new ArrayList<>();
        //For going diagonally both r and c > 1
        if(r>1 && c > 1){
            ans.addAll(pathsDiagonally(p+'D',r-1,c-1));
        }
        //If r == 1 then we cant go further down so only go right
        if(r > 1){
            ans.addAll(pathsDiagonally(p+'V',r-1,c));
        }
        //If c == 1 then we cant go further right so only go right
        if(c > 1){
            ans.addAll(pathsDiagonally(p+'H',r,c-1));
        }

        return ans;
    }
    //maze with restrictions
    static ArrayList<String> pathswithObstacles(String p,boolean[][] maze,int r,int c){
        //Base if both row and col == 1
        if(r==maze.length-1 && c==maze[0].length-1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();
        if(!maze[r][c]) {
            return ans;
        }
        //If either r == 1 then we cant go further down so only go right
        if(r < maze.length-1){
            ans.addAll(pathswithObstacles(p+'D',maze,r+1,c));
        }
        if(c < maze[0].length-1){
            ans.addAll(pathswithObstacles(p+'R',maze,r,c+1));
        }
        return ans;
    }
}
