// Time Complexity : O(2^(m+n)) where m - take case and n - not take case.

// Space Complexity : O(N) - recursion stack space

// Did this code successfully run on Leetcode : YES

// Appoarch: Recursion + Backtracking - using pick and not pick concept.

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    void helper(vector<int>& cand, int target, int idx, vector<int>& path, vector<vector<int>>& result){ 
        if(target == 0){
            result.push_back(path);
            return;
        }
        if(target < 0 || idx == cand.size()) return;
        // notTake
        helper(cand,target,idx+1,path,result);
        // adding cand to take path
        path.push_back(cand[idx]);
        // take
        helper(cand,target-cand[idx],idx,path,result);
        // backtracking
        path.pop_back();
    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> result;
        vector<int> path;
        helper(candidates,target,0,path,result);
        return result;
    }
};