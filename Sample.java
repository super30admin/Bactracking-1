// Time Complexity : Exponential
// Space Complexity : Not sure
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function(candidates, target) {
    
    
    //Solution 1: Recursion
//     let res=[];

//     //null case 
//     if(candidates===null || candidates.length===0) return res;
    
//     helper(candidates,0,target,0,[]);
//     return res;
    
//     function helper(candidates, currSum, target, index, path){
//         //base
//         if(currSum===target) {
//             res.push(path);
//             return;
//         }
//         if(currSum>target || index===candidates.length) return;
        
        
//         //logic
        
//         //case1 choose
       
//        let newList = [].concat(path)
//        newList.push(candidates[index]);
//         helper(candidates, currSum+candidates[index], target, index, newList);
        
//         // case2 no choose
//         helper(candidates,currSum,target, index+1, path);
//     }
    
    
    
    // Solution 2: BackTracking
    
//         let res=[];

//     //null case 
//     if(candidates===null || candidates.length===0) return res;
    
//     helper(candidates,0,target,0,[]);
//     return res;
    
//     function helper(candidates, currSum, target, index, path){
//         //base
//         if(currSum===target) {
//             res.push([].concat(path));
//             return;
//         }
//         if(currSum>target || index===candidates.length) return;
        
        
//         //logic
        
        
//        //action
//          // case2 no choose
//        helper(candidates,currSum,target, index+1, path);
//        path.push(candidates[index]);
//         //recursion
//         //case1 choose
//         helper(candidates, currSum+candidates[index], target, index, path);
//          //backtracking
//     path.pop()
       
//     }
   
   // Solution 3: Using for loop recursion
    
            let res=[];

    //null case 
    if(candidates===null || candidates.length===0) return res;
    
    helper(candidates,target,0,[]);
    return res;
    
    function helper(candidates,target, index, path){
        //base
if(target<0) return;
        if(target===0){
            res.push([].concat(path))
        }
        
        
        //logic
        
        for(let i=index;i<candidates.length;i++){
            //action
            path.push(candidates[i]);
            
            //recurse
            helper(candidates,target-candidates[i],i,path )
            
                 //backtracking
    path.pop()
        }
     
 
       
    }
};