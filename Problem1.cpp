// Time Complexity :O(2^N)
// Space Complexity : O(N) Call stack size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Combination Sum 

#include<vector>
#include<iostream>
using namespace std;

class Solution {
    vector<vector<int>> result;
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        
        if(candidates.empty() || target == 0)
            return {};
        
        vector<int> path;
        
        // recurse
        backtrack(candidates, target, 0, path);
        return result;
    }
    
    void backtrack(vector<int> candidates, int target, int index, vector<int>& path){
        
        // base 
        if(target == 0){
            result.push_back(path);
            return;
        }
        
        if(index >= candidates.size() || target < 0)
            return;
        
        // not choose
        backtrack(candidates, target, index + 1, path);
        
        // choose
        path.push_back(candidates[index]);
        backtrack(candidates, target - candidates[index], index, path);
        // backtrack
        path.pop_back();
    }
};