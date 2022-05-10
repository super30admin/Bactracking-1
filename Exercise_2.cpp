// Time Complexity                              :  O(4^N). Since at each step we have 4 options.
// Space Complexity                             :  O(2*N). O(N) due to the recursion stack and O(N) due to creating a string in each recursion.
// Did this code successfully run on Leetcode   :  Yes
// Any problem you faced while coding this      :  No

#include <bits/stdc++.h> 
using namespace std;  

// https://leetcode.com/problems/expression-add-operators/solution/

class Solution {
private:
    int n;
    vector<string> ans;
public:
    vector<string> addOperators(string num, int target) {
        n = num.size();
        dfs("", num, target, 0, 0, 0);
        return ans;
    }
    
    // recursion
    void dfs(string expr, string num, int target, int idx, long val, long tail) {
        if(idx == n) {
            if(val == target) {
                ans.push_back(expr);
                return;
            }
        }
        
        int len = 1;
        for(int i=idx;i<n;i++) {
            if(i != idx and num[idx] == '0') continue;
            string str = num.substr(idx, len++);
            long curr = stol(str);
            if(idx == 0) {
                dfs(expr + str, num, target, i+1, curr, curr);
            } else {
                // +
                dfs(expr + '+' + str, num, target, i+1, (val - tail) + (tail + curr), curr);
                // -
                dfs(expr + '-' + str, num, target, i+1, (val - tail) + (tail - curr), -curr);
                // *
                dfs(expr + '*' + str, num, target, i+1, (val - tail) + (tail * curr), (tail*curr));
            }
        }
        
    }
};