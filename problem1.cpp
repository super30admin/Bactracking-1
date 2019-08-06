//Time complexity: O(2^n) --> For candidate array of size N, we eventually check if it is part of combination that sums up to target {YES or NO}
//Space complexity: O(n) --> Ommitting the result array (which is O(n^2)) we create a combination array to check if each element is part of combination sum
//Accepted in Leetcode: Yes

//Approach:

/* 
Example:
candidate -> [2, 3, 5, 7] target -> 7

1. Here, we create a backTrack method that subtracts every candidate element from target recursively until either target is 0 or less than element itself
2. When target is 0 or less than element, we check for the next candidate until the end of the candidate array
*/

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Solution{

    public:

        vector<vector<int>> combinationSum(vector<int> &candidates, int target) 
        {
            sort(candidates.begin(), candidates.end());
            vector<int>combinations;
            vector<vector<int>>result;

            backTrack(candidates, target, result, combinations, 0);
            return result;
        }

        void backTrack(vector<int> &candidates, int target, vector<vector<int>>&result, vector<int>&combinations, int begin)
        {
            if(!target)
            {
                result.push_back(combinations);
                return;
            }

            int i = begin;

            while(i < candidates[i] && target >= candidates[i])
            {
                combinations.push_back(candidates[i]);
                backTrack(candidates, target - candidates[i], result, combinations, i);
                combinations.pop_back();
                i++;
            }
        }
};