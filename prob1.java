// Time Complexity : O(2^(N)) as at every candidate, either choose or don't choose
// Space Complexity : O(N) as we maintain one arraylist for result
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Explain your approach: 
// for loop based backtracking, add an element index onwards, subtract from target, including index, and check, 
// if target == 0 add the list to result, else return 

import java.util.*;
public class prob1 {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null || candidates.length == 0) return result;
        helper(candidates, 0, target, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int index, int target, List<Integer> path){
        // base
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 || index == candidates.length) return;

        //action - recurse - backtrack
        for(int i = index; i < candidates.length; i++){
            path.add(candidates[i]);
            helper(candidates, i, target - candidates[i], path);
            path.remove(path.size() - 1);
        }


    }
}



// Simple Recursion, Time: O()

// public class prob1 {
//     List<List<Integer>> result;
//     public List<List<Integer>> combinationSum(int[] candidates, int target) {
//         result = new ArrayList<>();
//         if(candidates == null || candidates.length == 0) return result;
//         helper(candidates, 0, target,new ArrayList<>());
//         return result;
//     }

//     private void helper(int[] candidates, int index, int target, List<Integer> path){
//         //base
//         if(target == 0){
//             result.add(path);
//             return;
//         }
//         if(target < 0 || index == candidates.length) return;
        
//         // choose
//         path.add(candidates[index]);
//         helper(candidates, index, target - candidates[index], new ArrayList<>(path));
//         // not choose
//         path.remove(path.size() - 1);
//         helper(candidates, index + 1, target, new ArrayList<>(path));
        
        
//     }
    
// }
