//Time Complexity : O(2^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
public:
    void backtrack(vector<int>& candidates, vector<int> temp, int target,vector<vector<int>>& res, int idx, int currSum){
        if(currSum>target) return;
        
         if(currSum==target){
             res.push_back(temp);
            return;
        }
        
        for(int i=idx; i<candidates.size(); i++){
            //action
            temp.push_back(candidates[i]);
            //recurse
            backtrack(candidates, temp, target, res, i, candidates[i]+currSum);
           //backtrack
            temp.pop_back();
        }
        
    }
    
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> res;
        if(candidates.size()==0) return res;
        vector<int> temp;
        backtrack(candidates, temp,target,res, 0,0);
        return res;
    }
};