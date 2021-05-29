// Time Complexity :O(2^n) where n in the number of nodes(Exponential) 
// Space Complexity : O(m) where m is the space used in the call stack 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    vector<vector<int>> result;
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        backtrack(candidates, target, 0, {});
        return result;
    }
    void backtrack(vector<int>& candidates, int target, int index,vector<int> path){
        //base
        if(target == 0){
            result.push_back(path);
            return;
        }
        if(target < 0) return;
        //logic
        for(int i = index; i< candidates.size(); i++){
            path.push_back(candidates[i]);
            backtrack(candidates, target - candidates[i], i,path);
            path.pop_back();
        }
    }
};