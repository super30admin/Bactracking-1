// Time Complexity : O(2^n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//39. Combination Sum
//https://leetcode.com/problems/combination-sum/

class Solution {
    // ITERATION*******************
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if (candidates == null)
            return result;
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int i, List<Integer> list) {
        // base
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (target < 0 || i >= candidates.length)
            return;

        // logic
        for (int k = i; k < candidates.length; k++) { // if k = 0, we will get all combinations and not just the unique
                                                      // combinations of candiates [2,2,3], [2,3,2], [3,2,2]
            list.add(candidates[k]);
            helper(candidates, target - candidates[k], k, new ArrayList<>(list));
            list.remove(list.size() - 1);
        }
    }

}



/*
class Solution {
    //BACKTRACKING*******************
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if(candidates == null) return result;
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }
    
     private void helper(int[] candidates, int target, int i, List<Integer> list){
        //base
        if(target == 0) {result.add(new ArrayList<>(list)); return;}
        if(candidates == null || target < 0 || i >= candidates.length) return;
        
        //logic
        //no choose
        helper(candidates, target, i+1, list);
        
        //choose
        list.add(candidates[i]); //int k = 0; while(k<list.size()){System.out.print(list.get(k) + " "); k++;} System.out.println(" ");
        helper(candidates, target - candidates[i], i, list);
        list.remove(list.size()-1);
        
    }
}
*/

/*
class Solution {
    //RECURSION***************************
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result = new ArrayList<>();
        if(candidates == null) return result;
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }
    
    private void helper(int[] candidates, int target, int i, List<Integer> list){
        //base
        if(target == 0) {result.add(new ArrayList<>(list)); return;}
        if(candidates == null || target < 0 || i >= candidates.length) return;
        
        //logic
        //no choose
        helper(candidates, target, i+1, new ArrayList<>(list));
        
        //choose
        list.add(candidates[i]); //int k = 0; while(k<list.size()){System.out.print(list.get(k) + " "); k++;} System.out.println(" ");
        helper(candidates, target - candidates[i], i, new ArrayList<>(list));
    }
}
*/
