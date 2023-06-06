    // TC:O(2^N)
    // SC:O(2^N)
// The given solution implements a backtracking algorithm to find all combinations of elements from the given 'candidates' vector that sum up to the 'target' 
// value. It uses a recursive helper function to explore different combinations.

// The algorithm starts with an empty 'ans' vector and iterates through the 'candidates' vector using a for loop.
//  For each candidate, it adds the candidate to the 'ans' vector, recursively calls the helper function with the updated target value, and then removes the candidate from the 'ans' vector (backtracks) before moving on to the next candidate.

// The base cases of the recursion are when the target becomes zero, indicating that a valid combination is found,
//  or when the target becomes negative, indicating that the current combination exceeds the target sum.
class Solution {
public:
    vector<vector<int>>results;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int>ans;
        helper(candidates,target,0,ans);  
        return results;
    }

    // for loop based recursion 
//  2 3 6 7                                7           0          {}


    void helper(vector<int>&candidates, int target, int idx, vector<int>&ans)
    {
           if(target <0)
           return;

           if(target==0)
           {
               results.push_back(ans);
               return;
           }

           for(int i=idx; i<candidates.size();i++)
           {
            // action
            ans.push_back(candidates[i]);
            // recurse
            helper(candidates,target-candidates[i],i,ans);
            // backtrack 
            ans.pop_back();
           }       
    }
                
};