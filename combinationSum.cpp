class Solution {
    vector<vector<int>> result;

public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> dummypath;
        helper(candidates,0,target, dummypath);

        return result;
    }

    private:
    int helper(vector<int>& candidates, int i, int target,vector<int> path )
    {
        //base
        if(target<0 || i == candidates.size())
        {
            return 0;
        }

        if(target == 0)
        {
            result.push_back(path);
            return path.size();
        }
    
        // choose
        path.push_back(candidates[i]);
        helper(candidates,i,target-candidates[i],path);
        path.pop_back();

        //dont choose
        helper(candidates,i+1,target,path);

        return 0;
    }
};