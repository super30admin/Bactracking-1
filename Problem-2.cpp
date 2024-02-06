// Time Complexity : O(4^n) where m - take case and n - not take case.

// Space Complexity : O(N) - recursion stack space

// Did this code successfully run on Leetcode : YES

// Appoarch: Recursion + Backtracking - 2 levels of recursion - one for generating nums 
// and one more for operators.

#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
 vector<string> result;
    //calc = prev calculated value
    void helper(string num,int pivot,int target,string path,long calc,long tail){
        // base
        if(pivot == num.length()){
            if(calc == target){
                result.push_back(path);
            }
            return;
        }
        // logic
        for(int i=pivot;i<num.length();i++){
           string currStr = num.substr(pivot,i-pivot+1);
           if (currStr.length() > 1 && currStr[0] == '0') {
                continue;
            }
           long curr = stol(currStr);
            if(pivot == 0){
                helper(num,i+1,target,currStr,curr,curr);
            }
            else{
                // +
                helper(num,i+1,target,path + '+' + currStr, calc+curr,curr);
                // -
                helper(num,i+1,target,path + '-' + currStr, calc-curr,-curr);
                // *
                helper(num,i+1,target,path + '*' + currStr, calc-tail+tail*curr,tail*curr);
            }
        }
    }
    vector<string> addOperators(string num, int target) {
        helper(num,0,target,"",0,0);
        return result;
    }
};