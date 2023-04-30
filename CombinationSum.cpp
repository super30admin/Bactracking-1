// Time Complexity - O(2^(target/min + length)) 
// Space Complexity - O(2^(target/min + length)) - Is this correct?
// Problems Faced - No!
// It runs on leetcode.
class Solution {
    vector<vector<int>> answer;
    private:
    void helper(vector<int>& candidates, int target, int i, vector<int> path){
        //base
        if(target == 0){
            answer.push_back(path);
            return;
        }
        if(i >= candidates.size() || target < 0)
            return;
        //logic
        //no choose
        vector<int> pathCopy(path);
        helper(candidates, target, i+1, pathCopy);
        
        //choose
        //path.push_back(candidates[i]);
        vector<int> pathCopy2(path);
        pathCopy2.push_back(candidates[i]);
        helper(candidates, target-candidates[i], i, pathCopy2);
    }
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        
        if(candidates.size() == 0)
            return answer;
        vector<int> path;
        helper(candidates, target, 0, path);
        return answer;
    }
};


// Backtracking approach
// Time Complexity - O(2^(target/min + length)) 
// Space Complexity - O(2^(target/min + length)) - Is this correct?
// Problems Faced - No!
// It runs on leetcode.
class Solution {
    vector<vector<int>> answer;
    private:
    void helper(vector<int>& candidates, int target, int i, vector<int> path){
        //base
        if(target == 0){
            //vector<int> pathCopy(path);
            answer.push_back(path);
            return;
        }
        if(i >= candidates.size() || target < 0)
            return;
        
        //logic
        
        //no choose
        //vector<int> pathCopy(path);
        helper(candidates, target, i+1, path);
        
        //choose
        //action
        path.push_back(candidates[i]);
        //vector<int> pathCopy2(path);
        //pathCopy2.push_back(candidates[i]);
        helper(candidates, target-candidates[i], i, path);
        
        
        
        
        //backtracking
        path.pop_back();
        
    }
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        
        if(candidates.size() == 0)
            return answer;
        vector<int> path;
        helper(candidates, target, 0, path);
        return answer;
    }
};

// Approach 3 - For-loop based recursion - Passing 'path' vector by reference.
// Time Complexity - O(2^(target/min + length)) 
// Space Complexity - O(2^(target/min + length)) - Is this correct?
// Problems Faced - No!
// It runs on leetcode.
class Solution {
    vector<vector<int>> answer;
    private:
    void helper(vector<int>& candidates, int index, vector<int>& path, int target){
        // base
        if(target == 0){
            answer.push_back(path);
            return;
        }       
        if(target < 0)
            return;
        // logic
        for(int i = index; i < candidates.size(); i++){
            // action
            path.push_back(candidates[i]);
            
            // recurse
            helper(candidates, i, path, target - candidates[i]);
            
            // backtrack
            path.pop_back();
        }
    }
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> p;
        helper(candidates, 0, p, target);
        return answer;
    }
};


