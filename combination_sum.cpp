// Time Complexity : O(2^n)
// Space Complexity :  O(2^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this

class Solution {
private:
    vector<vector<int>> comb;
    
    void combination_rec(vector<int> &candidates, int target, int idx, vector<int> arr)
    {
        if(target - accumulate(arr.begin(), arr.end(), 0) == 0)
        {
            comb.push_back(arr);
            return;
        }
        
        if(target - accumulate(arr.begin(), arr.end(), 0) < 0)
            return;
        
        arr.push_back(candidates[idx]);
        
        for(int j = idx; j < candidates.size(); j++)
        {
            combination_rec(candidates, target, j, arr);
        }
    }
    
public:    
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        
        vector<int> empty_set;
        
        for(int i = 0; i < candidates.size(); i++)
        {
            combination_rec(candidates, target, i, empty_set);
        }
        
        return comb;
    }
};