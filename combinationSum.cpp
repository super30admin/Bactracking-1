//time complexity:O(exponential)
//space complexity:O()
//executed on leetcode: yes
//approach:using backtracking
//any issues faced? yes

class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>>res;
        if(candidates.size()==0)
            return res;
        vector<int>comb;
        dfs(res,0,comb,candidates,target);
        return res;
    }
    void dfs(vector<vector<int>>&res, int index, vector<int>&comb, vector<int>& candidates, int target){
        if(target<0)
            return;
        else if(target==0)
        {
            res.push_back(comb);
            return;
        }
        for(int i=index; i<candidates.size(); i++)
        {
            comb.push_back(candidates[i]);
            dfs(res,i,comb,candidates,target-candidates[i]);
            comb.pop_back();
        }
    }
};