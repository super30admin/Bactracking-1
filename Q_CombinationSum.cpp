

// ## Problem1 
// Combination Sum (https://leetcode.com/problems/combination-sum/

//  Approach: Recursive

//similar to coin change problem

// # So if we solve this problem using recursion then at every point we need to check for two answers/paths:
// # 1) Will choosing the candidate will lead to a solution
// # 2) Will not choosing the candidate and moving ahead will lead to solution

//add our current nos to a list and if it sums up to target, add it to result


// # Time complexity: Exponential 
// # Space complexity: O(n * n);


//recursion
class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        
        if(candidates.size()==0){
            return result;
        }
        
        vector<int> curr;
        helper( candidates, target, 0, 0, curr);
        return result;
        
    }
    
    void helper( vector<int> candidates, int target, int index, int currsum, vector<int> currResult){
        //base
        if( index >= candidates.size() || currsum > target){
            return ;
        }
        
        if( currsum == target){
            result.push_back(currResult);
            return;
        }
        
        //recursion
        
        //dont
        helper(candidates, target, index+1, currsum , currResult);
        
        //choose
        currResult.push_back( candidates[index]);
        helper(candidates, target , index,  currsum+ candidates[index],  currResult);
        
            
    }
};

//  Approach: Backtracking 

// # Now the backtracking approach comes with little changes but it makes a big difference in space complexity. 
// In the recurssive apporach we are maintaining/passing a different list(copy list) for each choice we make which shoots up the space complexity. 

// # With backtracking we can avoid that. We can just use the same list(reference to list) again and again, which will make the space complexity capped at certain limit.

// # To achieve this we what needs to happen is whenever we encounter a base condition we need to backtrack and then consider another choice. 



//backtracking solution
class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        
        if(candidates.size()==0){
            return result;
        }
        
        vector<int> curr;
        helper( candidates, target, 0, 0, curr);
        return result;
        
    }
    
    void helper( vector<int> candidates, int target, int index, int currsum, vector<int> currResult){
        
        //base
        if(currsum > target){
            return;
        }
        if(currsum ==target){
            result.push_back(currResult);
            return;
        }
        
        
        for(int i=index; i< candidates.size() ; i++){
            currResult.push_back(candidates[i]);
            helper( candidates, target, i, currsum + candidates[i], currResult);
            currResult.pop_back(); //backtrack
        }

            
    }
};