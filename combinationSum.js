// Time Complexity : O(T/m+n) where T is taget, m is smallest candidate, n no. of candidates
// Space Complexity : O(T/m+n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */

//Bruteforce 0-1 recursion solution
let result;
var helper = function(candidates, target, index, path){
    //base case
    if(target === 0) {
        result.push(path);
        return;
    }
    if(target < 0 || index === candidates.length) return;

    //logic
    //no choose
    helper(candidates, target, index + 1, [...path]);
    //choose
    path.push(candidates[index]);
    helper(candidates, target - candidates[index], index, path); 
}

var combinationSum = function(candidates, target) {
    result = [];
    helper(candidates, target, 0, []);
    return result;
};

//Backtrack 0-1 recursion solution
/*
let result;
var helper = function(candidates, target, index, path){
    //base case
    if(target === 0) {
        result.push([...path]);
        return;
    }
    if(target < 0 || index === candidates.length) return;

    //no choose
    helper(candidates, target, index + 1, path);
    
    //choose
    path.push(candidates[index]);
    helper(candidates, target - candidates[index], index, path);
    
    //backtrack
    path.pop();
}

var combinationSum = function(candidates, target) {
    result = [];
    helper(candidates, target, 0, []);
    return result;
};
*/


//Backtrack for loop based recursion solution
/*
let result;
var helper = function(candidates, target, index, path){
    //base case
    if(target === 0) result.push([...path]);
    if(target < 0) return;
    
    // action
    for(let i = index; i < candidates.length; i++) {
        //action
        path.push(candidates[i]);
        
        //recusrion
        helper(candidates, target - candidates[i], i, path);
    
        //backtracking
        path.pop();
    }
    
}

var combinationSum = function(candidates, target) {
    result = [];
    helper(candidates, target, 0, []);
    return result;
};
*/