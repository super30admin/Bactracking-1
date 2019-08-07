//
// Created by shazm on 8/5/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> retVec;
        if(candidates.empty()){return retVec;}
        sort(candidates.begin(),candidates.end());
        vector<int> path;
        dfs(retVec, candidates, path, target, 0);
        return retVec;
    }

private:
    void dfs(vector<vector<int>>& retVec, vector<int> candidates, vector<int>& path, int target, int index){
        if(target == 0){
            retVec.push_back(path);
            return;
        }

        for(int x = index; x<candidates.size(); x++){
            if(candidates[x]>target){
                break;
            }

            path.push_back(candidates[x]);
            dfs(retVec, candidates, path, target-candidates[x], x);
            path.pop_back();
        }
    }
};