//Time Complexity: O(2^n), 2 recursive calls for every index till n
//Space Complexity: O(n), Recursion Stack Space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class CSumCNCBacktrack {
    List<List<Integer>> result ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        int index = 0;
        helper(candidates, target, index, new ArrayList<>());
        return result;
    }

    public void helper(int[] candidates, int target, int index, List<Integer> path){

//  Choose/Not Choose approach, with backtracking
         if(index == candidates.length || target < 0) return;

         if(target == 0) {
             result.add(new ArrayList<>(path));
             return;
         }

         //0: do not choose case
         helper(candidates, target, index+1, path);

         //1: choose case
         //action
         path.add(candidates[index]);
         //recursion
         helper(candidates, target-candidates[index], index, path);
         //backtrack
         path.remove(path.size()-1);


    }
}