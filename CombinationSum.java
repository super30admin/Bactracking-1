import java.util.ArrayList;
import java.util.List;

//Time complexity- Exponential
//Space Complexity- O(n)
//Successfully ran on leetcode

class Solution {
 List<List<Integer>> result;
 public List<List<Integer>> combinationSum(int[] candidates, int target) {
     result= new ArrayList<>();
     if(candidates== null || candidates.length==0) return result;
     
     helper(candidates, target, 0, new ArrayList<>());
     return result;
     
 }
 
 private void helper(int[] candidates, int target, int index, List<Integer> path){
     
     //base
     if(target<0 || index== candidates.length) return;
     if(target== 0){
         result.add(new ArrayList<>(path));
         return;
     }
         
     //logic
     //0 case or not choose case
     helper(candidates, target, index + 1, path);
     
     //1 case or choose case
     
     //action
     path.add(candidates[index]);
     
     //recursion
     helper(candidates, target- candidates[index], index, path);
     
     //backtracking
     path.remove(path.size()-1);
 }
}