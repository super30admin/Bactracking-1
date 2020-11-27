var combinationSum = function(candidates, target) {
    let temp = [];
    let res = [];
    backtrack(0, target);
    return res

    function backtrack(i , target){
        if(target == 0) return res.push(temp.slice());
        if(target < 0) return 
        if(i == candidates.length) return 
        temp.push(candidates[i]);
        backtrack(i, target - candidates[i])
        temp.pop();
        backtrack(i + 1, target)
    }
}




// var combinationSum = function(candidates, target) {
//     let result = [];
//     if(candidates == null || candidates.length == 0) return result;

//     helper(candidates, target, 0, [], 0);
//     return result;

//     function helper(candidates, target, sum, temp, i){
//         //base case
//         if(sum > target || i > candidates.length) return 
//         if(sum == target){
//             result.push(temp)
//             return
//         }
//         //dont choose
//         helper(candidates, target, sum, new Array(temp), i + 1)
//         //choose
//         result.push(temp);
//         helper(candidates, target, sum + candidates[i], new Array(temp), i)
//     }
// };

// var combinationSum = function(candidates, target) {
//     let result = [] 
//     if(candidates == null || candidates.length == 0) return result;

//     backtrack(candidates, target, 0, [], 0);
//     return result

//     function  backtrack(candidates, target, sum, temp = [], index){
//         //base case
//         if(sum == target){
//             result.push(new Array(temp));
//             return
//         }
//         if(sum > target){
//             return
//         }
//         //logic
//         for(let i = index; i < candidates.length; i++){
//             temp.push(candidates[i]);
//             helper(candidates, target, sum + candidates[i], temp, i)
//             temp.pop(temp.length - 1)
//         }
//     }
// }