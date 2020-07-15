// Time Complexity : O(2^n)
// Space Complexity : O(m+n) //m:being number of candidates , n being the target//Stack space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//1. The approach is to check each combination of the recursion and see whether it matches the traget or not.
//2. Action is to add element to target and to the array.
//3. Recursion is recurse in all possible directions
//4. Backtracking removes the changes done at that level.

class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
      //edge case
        if(target==0 || candidates.size()==0) return result;
        vector<int> combination_till_now;
        backtrack(candidates, target, 0, 0, combination_till_now);
        return result;
    }
    
    void backtrack(vector<int>& candidates, int target, int index, int curr_sum, vector<int> &combination_till_now){
        //return condition
        if(curr_sum > target){
            return;
        }
        if(curr_sum == target){
            result.push_back(combination_till_now);
            return;
        }
        //logic
        for(int i=index;i<candidates.size(); i++){
            //action
            curr_sum = curr_sum + candidates[i];
            combination_till_now.push_back(candidates[i]);
            //recurse
            backtrack(candidates, target, i, curr_sum, combination_till_now);
            //backtrack
            curr_sum = curr_sum - candidates[i];
            combination_till_now.pop_back();
        }
    }
};
