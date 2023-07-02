// Time Complexity : O(2^n+m)
// Space Complexity : O(2^n+m)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> result;
        vector<int> path;
        helper(candidates, 0, target, path, result);
        return result;
    }
private:
    void helper(vector<int>& candidates, int idx, int target, vector<int>& path, vector<vector<int>>& result){
        //base
        if(idx == candidates.size() || target < 0) return;
        if(target == 0){
            result.push_back(path);
            return;
        }
        //logic
        //not choose
        helper(candidates, idx + 1, target, path, result);

        //choose
        //action
        path.push_back(candidates[idx]);
        //recurse
        helper(candidates, idx, target - candidates[idx], path, result);
        //backtrack
        path.pop_back();
    }
};