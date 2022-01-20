//Time Complexity O(n)
// Space Complexity O(h) height of the recursion tree
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
using namespace std;





class Solution {
public:
    vector<vector<int> > result;
    vector<vector<int> > combinationSum(vector<int>& candidates, int target) {
        vector<int> path;
        helper(candidates,target,0, path);
        return result;
    }
    
    void helper(vector<int>& candidates,int target,int index,vector<int>& path)
    {
        if(target<0)
        {
            return;
        }
        if(target==0)
        {
            result.push_back(path);
            return;
        }
        for(int i=index;i<candidates.size();i++)
        {
            path.push_back(candidates[i]);
            helper(candidates,target-candidates[i],i,path);
            path.pop_back();
        }
    }
};