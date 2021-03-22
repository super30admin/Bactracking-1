TC: N^(target/smallest ele in candidates) where N is the total no of candidates
SC : (target/smallest ele in candidates)




class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>>result;
        vector<int>temp;
        backtrack(result,candidates,temp,target,0);
        return result;
    }
    void backtrack(vector<vector<int>>&result,vector<int>& candidates,vector<int>&temp_list,int remain,int start){
        if(remain < 0)return;
        if(remain == 0)result.push_back(temp_list);
        for(int i = start; i < candidates.size();i++){
            temp_list.push_back(candidates[i]);
            backtrack(result,candidates,temp_list,remain-candidates[i],i);
            temp_list.pop_back();
        }
        
    }
};