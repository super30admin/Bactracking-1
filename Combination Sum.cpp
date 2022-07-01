//Time Complexity- O(n^(T/m+n))
//Space Complexity- O(T/m)

class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        
        vector<vector<int>> ans;
        vector<int> temp;
        FindCombination(candidates,ans,temp,target,0);
        return ans;
    }
    
    void FindCombination(vector<int> candidates,vector<vector<int>>&ans,vector<int> temp,int target,int index){
        
        if(index==candidates.size()){
            return;
        }
        
        if(target==0){
            ans.push_back(temp);
            return;
        }
        
        if(candidates[index]<=target){
            temp.push_back(candidates[index]);
            FindCombination(candidates,ans,temp,target-candidates[index],index);
            temp.pop_back();
        }
        FindCombination(candidates,ans,temp,target,index+1);
        return;
    }
};