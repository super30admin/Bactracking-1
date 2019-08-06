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
            }
        }
};