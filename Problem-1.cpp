/*
Time Complexity = Exponential
Space Complexity = Exponential
*/
class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> path;
        helper(candidates, 0, target, path);
        return result;
    }
    void helper(vector<int>& candidates, int index, int target, vector<int> path)
    {
        //base
        if(index==candidates.size())
            return ;
        if(target<0)
            return;
        if(target==0)
        {
            result.push_back(path);
            return;
        }
            
        //logic
        //do not choose
        helper(candidates, index+1, target, path);
        
        //choose
        path.push_back(candidates[index]);
        helper(candidates, index, target-candidates[index], path);
    }
};
