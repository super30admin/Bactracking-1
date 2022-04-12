// Time Complexity : O(n3^n) where n is num length
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes, but when submitting one input is not working.
// Any problem you faced while coding this : Yes, input (Input : "3456237490" 9191) is not working and I am not able to figure out what is wrong in the code. Other inputs seems to be working.

/**
 * @param {string} num
 * @param {number} target
 * @return {string[]}
 */
let result;
var helper = function(num, index, calc, tail, path, target) {
    //base
    if(index === num.length) {
        if(calc === target) {
            result.push(path);
        }
        return;
    }
    
    //logic
    for(let i = index; i < num.length; i++) {
        //preceding zero
        if(num.charAt(index) == '0' && index != i) continue; 
        let curr = Number(num.substring(index, i+1));
        if(index === 0) {
            //action
            helper(num, i + 1, curr, curr, path + curr, target)
        } else {
            //+
            helper(num, i + 1, calc + curr, curr, path + "+" + curr, target)
            //-
            helper(num, i + 1, calc - curr, curr, path + "-" + curr, target)
            //*
            helper(num, i + 1, calc - tail + tail * curr, tail * curr, path + "*" + curr, target)
        }  
    }
}

var addOperators = function(num, target) {
    result = [];
    if(num === null || num.length === 0) return result;
    helper(num, 0, 0, 0, "", target);
    return result;
};