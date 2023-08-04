class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
            vector<vector<int>> ans; 

            vector<int> initial = {};
            sumNext(candidates, target, 0, 0, ans, initial);

            return ans; 
    }

    void sumNext(vector<int>& candidates, int target, int currentSum, int startIndex, vector<vector<int>>& ans, vector<int>& currentNumbers) {
        if(currentSum == target) {
            ans.push_back(currentNumbers);
            return;
        } 

        if(currentSum > target) return; 

        for(int i = startIndex; i < candidates.size(); i++) {
            int nextCurrentSum = currentSum + candidates[i];
            currentNumbers.push_back(candidates[i]);
            sumNext(candidates, target, nextCurrentSum, i, ans, currentNumbers);
            currentNumbers.pop_back(); 
        }

        return; 
    }
};