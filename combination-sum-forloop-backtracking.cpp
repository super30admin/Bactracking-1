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
        helper(candidates, 0, target, {}, result);
        return result;
    }
private:
    void helper(vector<int>& candidates, int pivot, int target, vector<int>&& path, vector<vector<int>>& result){
        //base
        if(target < 0 || candidates.size() == 0) return;
        if(target == 0){
            result.push_back(path);
            return;
        }
        //logic
        for(int i = pivot; i < candidates.size(); i++){
        //action
            // for exhaustive
            // vector<int> li(path);
            // li.push_back(candidates[i]);
            // for backtracking
            path.push_back(candidates[i]);
        //recurse
            helper(candidates, i, target - candidates[i], move(path), result);
        //backtrack
            path.pop_back();
        }
    }
};