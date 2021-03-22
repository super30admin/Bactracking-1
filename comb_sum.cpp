//TC: O(n ^ (t/k)) where n is number of candidates, t is the target, k is the smallest value among candidates

//SC: O(t/k) where t is the target, k is the smallest value among candidates since this is the largest the recursion stack can grow to.

class Solution {
public:
    vector<vector<int>> result;

    void backtrack(vector<int>&candidates, vector<int> combinations, int target, int startIndex){
        
        if(target == 0){
            result.push_back(combinations);
        }
        else if(target < 0){
            return;
        }
        
        
        for(int i=startIndex; i<candidates.size(); i++){
            
            combinations.push_back(candidates[i]);
            backtrack(candidates, combinations, target - candidates[i], i);
            combinations.pop_back();
            
        }
        
        return;
        
        
        
    }
    
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        
        sort(candidates.begin(), candidates.end());
        
        vector<int> combinations;
        int startIndex = 0;      
        
        backtrack(candidates, combinations, target, startIndex);
        
        return result;
        
    }
};