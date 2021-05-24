/*

Intuition: We have to exhaust all possible combinations. 
For each number we have 2 choices. Either we can pick it or not. ( Pattern 1 - Cases Pattern) 

We can also start with an empty path and built it from there. ( Pattern 2 - For loop Pattern)

//////////////////////////////////////////////
Time and space complexity is same for both patterns
Time Complexity: O(2^(m+n))
Space Complexity: O(m+n)
//////////////////////////////////////////////
*/
//Backtrack solution using pattern 1 ( Cases pattern)
class Solution {
public:
    vector <vector<int>> result;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> partialResult;
        if ( candidates.size() == 0 ) return result;
        helper(candidates, target, 0, partialResult);
        return result;
    }
    void helper(vector<int> candidates, int target, int index, vector<int> partialResult){
    
        //Base
        if (target == 0){
            //vector<int> newPartialResult;
            result.push_back(partialResult);
            return;
        }
        
        if ( target < 0 or index == candidates.size() ) return;
        
        //Logic
        helper(candidates, target, index + 1, partialResult);
        
        //Action
        partialResult.push_back(candidates[index]);
        
        helper(candidates, target - candidates[index] , index,partialResult );
        
        //Backtrack
        partialResult.pop_back();
    
    
    
    }
};

//Without Backtracking Pattern 1: (Cases Pattern)
class Solution {
public:
    vector <vector<int>> result;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> partialResult;
        if ( candidates.size() == 0 ) return result;
        helper(candidates, target, 0, partialResult);
        return result;
    }
    void helper(vector<int> candidates, int target, int index, vector<int> partialResult){
    
        //Base
        if (target == 0){
            //vector<int> newPartialResult;
            result.push_back(partialResult);
            return;
        }
        
        if ( target < 0 or index == candidates.size() ) return;
        
        //Logic
        helper(candidates, target, index + 1, partialResult);
        
        //Action
        vector<int> newPartialResult(partialResult);
        newPartialResult.push_back(candidates[index]);
        
        helper(candidates, target - candidates[index] , index,newPartialResult );

    }
};


//Pattern 2: For loop with backtarcking
class Solution {
public:
    vector <vector<int>> result;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> partialResult;
        if ( candidates.size() == 0 ) return result;
        helper(candidates, target, 0, partialResult);
        return result;
    }
    void helper(vector<int> candidates, int target, int index, vector<int> partialResult){
    
        if (target == 0){
            result.push_back(partialResult);
            return;
        }
        if ( target < 0) return;
        for ( int k = index; k < candidates.size(); k++){
            partialResult.push_back(candidates[k]);
            helper(candidates, target - candidates[k], k , partialResult);
            partialResult.pop_back();

        }
        
    }
};

//Pattern 2: For loop without backtarcking

class Solution {
public:
    vector <vector<int>> result;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> partialResult;
        if ( candidates.size() == 0 ) return result;
        helper(candidates, target, 0, partialResult);
        return result;
    }
    void helper(vector<int> candidates, int target, int index, vector<int> partialResult){
    
        if (target == 0){
            result.push_back(partialResult);
            return;
        }
        if ( target < 0) return;
        for ( int k = index; k < candidates.size(); k++){
            vector<int> newPartialResult(partialResult);
            newPartialResult.push_back(candidates[k]);
            helper(candidates, target - candidates[k], k , newPartialResult);

        }
        
    }
};