/*
This example uses for loop based recursion to solve the problem. At each step, we either take an element from the
candidates, or go to the next element based on how far we are from the target and how many elements we have already
taken.

Did this code run on leetcode: Yes
*/
class Solution {
    List<List<Integer>> result;
    //Time Complexity: O(2^(target/min) + n) target/min dominates at target>>>min element, n dominates at min element > target & n >>> target
    //Space Complexity: O(target/min)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        result = new ArrayList<>();
        
        helper(candidates, target, 0, new ArrayList<>());
        
        return result;
    }
    
    private void helper(int[] candidates, int target, int index, List<Integer> path)
    {   
        if(target == 0)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        //Target out of bounds
        if(target < 0)
            return;
        
        for(int i = index; i < candidates.length; i++)
        {   
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], i, path);
            
            path.remove(path.size() - 1);
        }
    }
}