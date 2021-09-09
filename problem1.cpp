//Time Complexity - O(exponential)
//Space Complexity - O(N)
class Solution {
public:
    vector<vector<int>>result;
    void helper(vector<int>&candidates, int target, int idx, vector<int>&path)     {
        if(target==0){
            result.push_back(path);
            return;
        }
        if(idx==candidates.size()||target<0){
            return;
        }
        helper(candidates,target,idx+1,path);
        path.push_back(candidates[idx]);
        helper(candidates,target-candidates[idx],idx,path);
        path.pop_back();
    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int>path;
        helper(candidates,target,0,path);
        return result;
    }
};