class Solution {
public:
    vector<vector<int>> res;
    void helper(vector<int>& candidates, int amount, int pivot, vector<int>& path){
        //base case
        if(amount == 0)
        {res.push_back(path);
            return;}
        if(amount< 0){
            return;
        }
        for(int i=pivot; i< candidates.size();i++){
            path.push_back(candidates[i]);
            helper(candidates, amount - candidates[i], i, path);
            path.pop_back();
        }
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