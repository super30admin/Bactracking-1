// Time Complexity : O(n*n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning


#include<bits/stdc++.h>

class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> path;
        backtracking(candidates, target, 0 , path);
        
        return result;
    }
    
    vector<vector<int>> result;
    
    void backtracking(vector<int> candidates, int target, int index, vector<int>& path){
        
        if(target <0){
            return;
        }else if ( target == 0){
            result.push_back(path);
        }else if ( index >= candidates.size()){
            return;
        }
        
        
        for ( int i = index; i < candidates.size(); i ++){
            
            path.push_back(candidates[i]);
            
            
            // recursion
            backtracking(candidates, target - candidates[i], i, path );
            
            path.pop_back();
        }
    }
};