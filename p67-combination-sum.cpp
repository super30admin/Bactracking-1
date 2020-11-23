// Using BackTracking
// Time complexity is O(n^m) exponential time complexity where n = #elements in the array and m is the target value
// Space complexity is O(m)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
public:
    vector<vector<int>> res;
    int targ;
    void helper(vector<int> candidates, int sum, vector<int>& temp, int index) {
        //base
        if(sum > targ) return;
        //logic
        if(sum == targ) {
            res.push_back(temp);
            return;
        }
        for(int i = index; i < candidates.size(); i++) {
            //action
            temp.push_back(candidates[i]);
            //recurse
            helper(candidates, sum+candidates[i], temp, i);
            //backtrack
            temp.pop_back();
        }
    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        if(candidates.size() == 0) return {};
        targ = target;
        vector<int> temp;
        helper(candidates, 0, temp, 0);
        return res;
    }
};

class Solution {
public:
    vector<vector<int>> res;
    void helper(vector<int>& candidates, int target, int sum, vector<int>& temp, int index) {
        //base
        if(index == candidates.size() || sum > target) return;
        //logic
        if(sum == target) {
            res.push_back(temp);
            return;
        }
        
        temp.push_back(candidates[index]);
        helper(candidates, target, sum+candidates[index], temp, index);
        temp.pop_back();
        helper(candidates, target, sum, temp, index+1);
    }
    
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        if(candidates.size() == 0) return {};
        vector<int> temp;
        helper(candidates, target, 0, temp, 0);
        return res;
    }
};

// Recursion
class Solution {
public:
    vector<vector<int>> res;
    void helper(vector<int>& candidates, int target, int sum, vector<int> temp, int index) {
        //base
        if(index == candidates.size() || sum > target) return;
        
        //logic
        if(sum == target) {
            res.push_back(temp);
            return;
        }
        // Don't choose
        helper(candidates, target, sum, temp, index+1);
        temp.push_back(candidates[index]);
        // Choose
        helper(candidates, target, sum+candidates[index], temp, index);
    }
    
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        if(candidates.size() == 0) return {};
        vector<int> temp;
        helper(candidates, target, 0, temp, 0);
        return res;
    }
};
