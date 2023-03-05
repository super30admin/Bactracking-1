class Solution {
public:
    vector<vector<int>> res;
    void helper(vector<int>& candidates, int amount, int i, vector<int>& path){
        //base case
        if(amount == 0)
        {res.push_back(path);
            return;}

        if(amount < 0 || i == candidates.size())
            return;
        //don't choose case
        helper(candidates, amount, i+1, path);
        //choose case
        path.push_back(candidates[i]);
        helper(candidates, amount - candidates[i], i, path);
        //backtracking
        path.pop_back();
    }

    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        if(candidates.size()==0){
            return res;
        }
        vector<int> path;
        helper(candidates,target,0, path);
        return res;
    }
};