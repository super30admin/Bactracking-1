/**
 * Time Complexity:
 * The time complexity will be O(2^(m+n)/2) for backtrack solution
 */

/**
 * Space Complexity:
 * It depends on th lowest element in the candidate vector. 
 * O(T/L) where T is the target and L is the lowest element in the candidate vector
 */

/**
 * Approach:
 * The first intution is the choose and not choose case and using recursion. But in that case time complexity 
 * will be exponention and exactly will be O(2^(m+n)) hwere n is the length 
 * of the array. To optimize it further we use for loop based recursion and in that we observe two cases.
 * First with making a new array everytime for path.
 * Second, with backtracking.
 * 
 * The algo remains the same for both cases. The only differnece is how we are handling the unwanted 
 * elements in the path we choose to get our desired target.
 * 
 * We choose a pivot called index. For that index we keep on recursing until we hit 0 for target
 * or target is lesser than 0. Then the recursion goes one step back and the index is incrementd and
 * recursion goes again for the next elements. 
 * 
 * Using this technique we have only one advantage that nodes are being reduced to half.
 * 
 */

//The code ran perfectly on leetcode


// for loop based recursion
class Solution {
    vector<vector<int>> result;
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        
        helper(candidates, 0, {}, target);
        return result;
        
    }
    private:
    void helper(vector<int>& candidates, int index, vector<int> path, int target){
        //base
        if(target==0){
            result.push_back(vector<int> (path));
        }
        if(target <0 || index == candidates.size()) return;
        
        for(int i = index; i <candidates.size(); i++){
            //action
            vector<int> buff{path};
            buff.push_back(candidates[i]);
            //recurse
            helper(candidates, i, buff, target - candidates[i]);
        }
    }
};

//backtrack with for loop annd recursion
class Solution {
    vector<vector<int>> result;
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        
        helper(candidates, 0, {}, target);
        return result;
        
    }
    private:
    void helper(vector<int>& candidates, int index, vector<int> path, int target){
        //base
        if(target==0){
            result.push_back(vector<int> (path));
        }
        if(target <0 || index == candidates.size()) return;
        
        for(int i = index; i <candidates.size(); i++){
            //action
            // vector<int> buff{path};
            path.push_back(candidates[i]);
            //recurse
            helper(candidates, i, path, target - candidates[i]);
            path.pop_back();
        }
    }
};