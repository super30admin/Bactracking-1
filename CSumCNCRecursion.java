//Time Complexity: O(2^n), 2 recursive calls for every index till n
//Space Complexity: O(2^n), at each call a new ArrayList is created.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class CSumCNCRecursion {
    List<List<Integer>> result ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        int index = 0;
        helper(candidates, target, index, new ArrayList<>());
        return result;
    }

    public void helper(int[] candidates, int target, int index, List<Integer> path){


// choose/ Not choose approach with recursion
         if(target < 0 || index == candidates.length)  return;
         if(target == 0) {
             result.add(path);
             return;
         }

         //Not choose
         helper(candidates, target, index+1, new ArrayList<>(path));

         //Choose
         path.add(candidates[index]);
         helper(candidates, target-candidates[index], index, new ArrayList<>(path));

    }
}