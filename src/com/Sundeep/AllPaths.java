package com.Sundeep;

import java.util.ArrayList;
import java.util.Arrays;

public class AllPaths {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        int[][] path = new int[maze.length][maze[0].length];
       // System.out.println(allPaths("",maze,0,0));
        allPathswithSteps("",maze,0,0,path,1);
    }

    //What if you can go  in any directions
    static ArrayList<String> allPaths(String p, boolean[][] maze, int r, int c){
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
        //If I am considering this path then make it false for below recurison calls having this call as parent
        maze[r][c] = false;

        //If either r == 1 then we cant go further down so only go right
        if(r < maze.length-1){
            ans.addAll(allPaths(p+'D',maze,r+1,c));
        }
        if(c < maze[0].length-1){
            ans.addAll(allPaths(p+'R',maze,r,c+1));
        }
        if(r>0){
            ans.addAll(allPaths(p+'U',maze,r-1,c));
        }
        if(c>0){
            ans.addAll(allPaths(p+'L',maze,r,c-1));
        }
        //After going through all these paths convert the false paths back to original
        //so there will be no prob for them in calculating paths
        maze[r][c] = true;
        return ans;
    }
        //What if you want to print the path inmatrix also
    static void allPathswithSteps(String p, boolean[][] maze, int r, int c,int[][] path, int step){
        //Base if both row and col == 1
        if(r==maze.length-1 && c==maze[0].length-1){
            path[r][c] = step; //As this last step is also a step
            for(int[] arr: path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if(!maze[r][c]) {
            return;
        }

        //If I am considering this path then make it false for below recurison calls having this call as parent
        maze[r][c] = false;
        path[r][c] = step;

        //If either r == 1 then we cant go further down so only go right
        if(r < maze.length-1){
            allPathswithSteps(p+'D',maze,r+1,c,path,step+1);
        }
        if(c < maze[0].length-1){
            allPathswithSteps(p+'R',maze,r,c+1,path,step+1);
        }
        if(r>0){
            allPathswithSteps(p+'U',maze,r-1,c,path,step+1);
        }
        if(c>0){
            allPathswithSteps(p+'L',maze,r,c-1,path,step+1);
        }
        //After going through all these paths convert the false paths back to original
        //so there will be no prob for them in calculating paths
        maze[r][c] = true;
        path[r][c] = 0;
    }
}
