// ## Problem1 
// Combination Sum (https://leetcode.com/problems/combination-sum/)

let res;
let targ;
var combinationSum = function(candidates, target) {
    res = [];
    targ = target;
    if(!candidates || candidates.length === 0) return res;
    backtrack(candidates,[],0,0);
    return res;
}

function backtrack(candidates,temp,sum,index) {
    //base
    if(sum == targ) res.push([temp]);
    if(sum > targ) return;
    //logic
    for(let i=index;i<candidates.length;i++){
        //action
        temp.push(candidates[i]);
        //recurse
        backtrack(candidates,temp, sum + candidates[i],i);
        //backtrack
        temp.pop();
    }   
};