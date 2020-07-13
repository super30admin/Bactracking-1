class Solution {
public:    
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> tmp;
        vector<vector<int>> result;
        backtrack(result,candidates,tmp,target,0,0);
        return result;
    }
    void backtrack(vector<vector<int>>& result,vector<int>& candidates,vector<int>& temp,int targ,int sum,int index){
        if(sum==targ){
            vector<int> vect2(temp); 
            result.push_back(vect2);
        }
        if(sum>targ) return;
        
        for(int i=index; i<candidates.size(); i++){
            //action
            temp.push_back(candidates[i]);
            //recure
            backtrack(result,candidates,temp,targ,sum+candidates[i],i);
            //backtrack
            temp.pop_back();
        }
    }
};