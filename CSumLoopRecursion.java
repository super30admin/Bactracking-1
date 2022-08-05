//Time Complexity: O(2^n), 2 recursive calls for every index till n
//Space Complexity: O(2^n), at each call a new ArrayList is created.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class CSumLoopRecursion {
    List<List<Integer>> result ;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        int index = 0;
        helper(candidates, target, index, new ArrayList<>());
        return result;
    }

    public void helper(int[] candidates, int target, int index, List<Integer> path){

    // For Loop, Recursive approach
         if(target < 0)  return;
         if(target == 0) {
             result.add(path);
             return;
         }

         for(int i=index; i<candidates.length; i++) {
             ArrayList<Integer> newList = new ArrayList<>(path);
             newList.add(candidates[i]);
             helper(candidates, target-candidates[i], i, newList);
         }

    }
}