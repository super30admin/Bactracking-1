//Time complexity = O(n^target) n = len(candidates) 
//Space = O(target)
class Solution {
public:
    vector<vector<int>> ret;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> combination;
        
        findCombination(candidates,target,combination,0);
        return ret;
    }
    
    void findCombination(vector<int>& candidates, int target, vector<int> combination, int start){
        if(target<0) return;
        if(target == 0){
            ret.push_back(combination);
            return;
        }
        
        
        for(int i = start;i<candidates.size();i++){
            combination.push_back(candidates[i]);
            findCombination(candidates, target-candidates[i],combination,i);
            combination.pop_back();
        }
        
    }
};