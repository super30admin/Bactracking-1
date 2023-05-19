// Time Complexity : O(2^n)
// Space Complexity : O(n) for recurrsive stack.
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

// we need to process all possible solutions, so we should do exhaustive approach.
// we also need to store the path chosen , so we use backtracking.

// we can do it in two ways, one is normal recurrsive approach and second one is for loop based recurrsive approach.

// for loop based recurrsion

class Solution {
public:
    vector<vector<int>>result;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        if(candidates.empty() || candidates.size()==0) return {};
        vector<int>v;
        f(candidates,target,v,0);
        return result;
    }
    void f(vector<int>& candidates, int target, vector<int>&v,int index)
    {
        //base
        if(target<0) return;
        if(target==0){
            result.push_back(v);
            return;
        }
        //logic
        for(int i = index;i<candidates.size();i++)
        {
            v.push_back(candidates[i]);
            f(candidates, target-candidates[i], v,i);
            v.pop_back();
        }
    }

};

//pick or dont pick type recurrsion

class Solution {
public:
    vector<vector<int>>result;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        if(candidates.empty() || candidates.size()==0) return {};
        vector<int>v;
        f(candidates,target,v,0);
        return result;
    }
    void f(vector<int>& candidates, int target, vector<int>&v,int index)
    {
        if(target<0 || index==candidates.size()) return;
        if(target==0){
            result.push_back(v);
            return;
        }
        f(candidates, target, v,index+1);
        v.push_back(candidates[index]);
        f(candidates, target - candidates[index], v, index);
        v.pop_back();
    }
};