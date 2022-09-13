package com.Sundeep;

public class grid_unique_paths {
    public int uniquePaths(int m, int n) {
        //Using Combinatric i.e permutations annd combinations
        // as for mxn matrix total number of paths from start to end are m-1 + n-1 = m+n-2
        // for unique paths it is equal= m+n-2Cm-1 or m+n-2Cn-1 as nCr = nCn-r
        int totalpaths = m + n - 2;
        int r = m-1;
        double res = 1;
        for(int i=1;i<=r;i++){
            res = res * (totalpaths - r +i)/i;
        }
        return (int)res;
    }
}
